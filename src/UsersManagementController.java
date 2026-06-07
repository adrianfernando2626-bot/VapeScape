/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Angelica S. Fernando
 */
public class UsersManagementController implements Initializable {

    @FXML
    private Button addButt;
    @FXML
    private Button deleteButt;
    @FXML
    private Button searchButt;
    @FXML
    private Button updateButt;
    @FXML
    private TextField txtLname;
    @FXML
    private TextField txtMname;
    @FXML
    private TextField txtAge;
    @FXML
    private TableView<Users> Table;
    @FXML
    private TableColumn<Users, String> tbID;
    @FXML
    private TableColumn<Users, String> tbFname;
    @FXML
    private TableColumn<Users, String> tbLname;
    @FXML
    private TableColumn<Users, String> tbMname;
    @FXML
    private TableColumn<Users, String> tbPhone;
    @FXML
    private TableColumn<Users, String> tbAge;
    @FXML
    private TableColumn<Users, String> tbRole;
    @FXML
    private TableColumn<Users, String> tbEmail;
    @FXML
    private TableColumn<Users, String> tbUsername;
    @FXML
    private TableColumn<Users, String> tbPassword;
    @FXML
    private TableColumn<Users, String> tbCpassword;
    @FXML
    private TableColumn<Users, String> tbStatus;
    @FXML
    private TableColumn<Users, String> tbAddress;
    @FXML
    private TextField txtSearch;
    @FXML
    private TextField txtFname;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtRole;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtCpassword;
    @FXML
    private ComboBox<String> comStatus;
    @FXML
    private TextField txtUsername;
    private String[] status = {"Active", "Inactive"};

    int index, id;
    Connection con = null;
    PreparedStatement pst = null;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mycon();
        table();
        comStatus.getItems().addAll(status);
    }

    public void mycon() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login1", "root", "");

        } catch (ClassNotFoundException ex) {

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void table() {
        mycon();
        ObservableList<Users> Userss = FXCollections.observableArrayList();
        try {
            pst = con.prepareStatement("SELECT id, fname, lname, mname, phone, bday, role, eadd, user_name, pass, cpass, status, address FROM user");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {

                    Users users = new Users();
                    users.setId(rs.getString("id"));
                    users.setFirstname(rs.getString("fname"));
                    users.setLastname(rs.getString("lname"));
                    users.setMiddlename(rs.getString("mname"));
                    users.setPhone(rs.getString("phone"));
                    users.setBirthdate(rs.getString("bday"));
                    users.setRole(rs.getString("role"));
                    users.setEmail(rs.getString("eadd"));
                    users.setUsername(rs.getString("user_name"));
                    users.setPassword(rs.getString("pass"));
                    users.setConfirmPassword(rs.getString("cpass"));
                    users.setStatus(rs.getString("status"));
                    users.setAddress(rs.getString("address"));
                    Userss.add(users);
                }

            }

            Table.setItems(Userss);

            tbID.setCellValueFactory(f -> f.getValue().IdProperty());
            tbUsername.setCellValueFactory(f -> f.getValue().UsernameProperty());
            tbFname.setCellValueFactory(f -> f.getValue().FirstnameProperty());
            tbLname.setCellValueFactory(f -> f.getValue().LastnameProperty());
            tbMname.setCellValueFactory(f -> f.getValue().MiddlenameProperty());
            tbPhone.setCellValueFactory(f -> f.getValue().PhoneProperty());
            tbAge.setCellValueFactory(f -> f.getValue().BirthdateProperty());
            tbRole.setCellValueFactory(f -> f.getValue().RoleProperty());
            tbEmail.setCellValueFactory(f -> f.getValue().EmailProperty());
            tbPassword.setCellValueFactory(f -> f.getValue().PasswordProperty());
            tbCpassword.setCellValueFactory(f -> f.getValue().ConfirmPasswordProperty());
            tbStatus.setCellValueFactory(f -> f.getValue().StatusProperty());
            tbAddress.setCellValueFactory(f -> f.getValue().AddressProperty());

        } catch (SQLException e) {

        }

        Table.setRowFactory(tv -> {
            TableRow<Users> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    index = Table.getSelectionModel().getSelectedIndex();

                    id = Integer.parseInt(String.valueOf(Table.getItems().get(index).getId()));
                    txtUsername.setText(Table.getItems().get(index).getUsername());
                    txtFname.setText(Table.getItems().get(index).getFirstname());
                    txtLname.setText(Table.getItems().get(index).getLastName());
                    txtMname.setText(Table.getItems().get(index).getMiddleName());
                    txtAge.setText(Table.getItems().get(index).getBirthdate());
                    txtEmail.setText(Table.getItems().get(index).getEmail());
                    txtPhone.setText(Table.getItems().get(index).getPhone());
                    txtPassword.setText(Table.getItems().get(index).getPassword());
                    txtCpassword.setText(Table.getItems().get(index).getConfirmPassword());
                    comStatus.setValue(Table.getItems().get(index).getStatus());
                    txtRole.setText(Table.getItems().get(index).getRole());
                    txtAddress.setText(Table.getItems().get(index).getAddress());

                }
            });
            return myRow;
        });
        FilteredList<Users> filteredData = new FilteredList<>(Userss, b -> true);
        
        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(productSearchModel ->{
                
                if(newValue.isEmpty() || newValue.isBlank()||newValue == null){
                    return true;
                }
                
            String searchKeyword = newValue.toLowerCase();
            
            if(productSearchModel.getBirthdate().toLowerCase().indexOf(searchKeyword)> - 1){
                return true;
            }
            else if (productSearchModel.getId().toLowerCase().indexOf(searchKeyword)> - 1){
                return true;
            }
            else if (productSearchModel.getAddress().toLowerCase().indexOf(searchKeyword)> - 1){
                return true;
            }else if (productSearchModel.getUsername().toLowerCase().indexOf(searchKeyword)> - 1){
                return true;
            }else if (productSearchModel.getFirstname().toLowerCase().indexOf(searchKeyword)> - 1){
                return true;
            }else if (productSearchModel.getLastName().toLowerCase().indexOf(searchKeyword)> - 1){
                return true;
            }else if (productSearchModel.getMiddleName().toLowerCase().indexOf(searchKeyword)> - 1){
                return true;
            }else if (productSearchModel.getPhone().toLowerCase().indexOf(searchKeyword)> - 1){
                return true;
            }else if (productSearchModel.getRole().toLowerCase().indexOf(searchKeyword)> - 1){
                return true;
            }else if (productSearchModel.getEmail().toLowerCase().indexOf(searchKeyword)> - 1){
                return true;
            }else if (productSearchModel.getPassword().toLowerCase().indexOf(searchKeyword)> - 1){
                return true;
            }else if (productSearchModel.getConfirmPassword().toLowerCase().indexOf(searchKeyword)> - 1){
                return true;
            }else if (productSearchModel.getStatus().toLowerCase().indexOf(searchKeyword)> - 1){
                return true;
            }else{
                return false;
            }
            });
            
        });
        
        SortedList<Users> sortedData = new SortedList<>(filteredData);
        
        sortedData.comparatorProperty().bind(Table.comparatorProperty());
        
        Table.setItems(sortedData);

    }

    @FXML
    private void deleteButtClicked(ActionEvent event) {

        index = Table.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(Table.getItems().get(index).getId()));
        
        try {

            pst = Databaseconnect.mycon().prepareStatement("DELETE FROM user WHERE id=?");
            pst.setInt(1, id);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AdminProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");
        alert.setHeaderText("User");
        alert.setContentText("You've deleted the Account");
        alert.show();

        table();

        txtUsername.setText("");
        txtFname.setText("");
        txtLname.setText("");
        txtMname.setText("");
        txtAge.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
        txtPassword.setText("");
        txtCpassword.setText("");
        comStatus.setValue("");
        txtRole.setText("");
        txtUsername.requestFocus();
    }



    @FXML
    private void updateButtClicked(ActionEvent event) {

        index = Table.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(Table.getItems().get(index).getId()));
       
        
        try {

            pst = Databaseconnect.mycon().prepareStatement("UPDATE user set status=? WHERE id=?");
            pst.setString(1, comStatus.getValue());
            pst.setInt(2, id);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AdminProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");
        alert.setHeaderText("User");
        alert.setContentText("You've Updated the Account");
        alert.show();

        table();

        txtUsername.setText("");
        txtFname.setText("");
        txtLname.setText("");
        txtMname.setText("");
        txtAge.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
        txtPassword.setText("");
        txtCpassword.setText("");
        comStatus.setValue("");
        txtRole.setText("");
        txtAddress.setText("");
        txtUsername.requestFocus();

    }
    
    @FXML
    private void ProductButtClicked(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("AdminProduct.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();

    }

     @FXML
    private void OrderButtClicked(MouseEvent event)throws Exception{
        
        Parent root = FXMLLoader.load(getClass().getResource("HistoryManagement.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
        

    }

    @FXML
    private void HomeClick(MouseEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
      @FXML
    private void GotoExit(ActionEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("MainFXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
