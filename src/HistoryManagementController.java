/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
import javafx.scene.control.Button;
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
public class HistoryManagementController implements Initializable {

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
    private TableView<history> Table;
    @FXML
    private TableColumn<history, String> tbID;
    @FXML
    private TableColumn<history, String> tbFname;
    @FXML
    private TableColumn<history, String> tbLname;
    @FXML
    private TableColumn<history, String> tbMname;
    @FXML
    private TableColumn<history, String> tbPhone;
    @FXML
    private TableColumn<history, String> tbUsername;
    @FXML
    private TableColumn<history, String> tbAddress;
    @FXML
    private TableColumn<history, String> tbProduct;
    @FXML
    private TableColumn<history, String> tbPrice;
    @FXML
    private TableColumn<history, String> tbQuantity;
    @FXML
    private TextField txtSearch;
    @FXML
    private TextField productPrize;
    @FXML
    private TextField productName;
    @FXML
    private TextField productQua;
    @FXML
    private TextField txtFname;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtAddress;
    private Stage stage;
    private Scene scene;
    private Parent root;
    int index, id;
    Connection con = null;
    PreparedStatement pst = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        mycon();
        table();

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
        ObservableList<history> History = FXCollections.observableArrayList();
        try {
            pst = con.prepareStatement("SELECT id, fname, lname, mname, address, phone, username, productNam, productQuant, productPrice FROM history");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {

                    history historyName = new history();
                    historyName.setId(rs.getString("id"));
                    historyName.setFirstname(rs.getString("fname"));
                    historyName.setLastname(rs.getString("lname"));
                    historyName.setMiddlename(rs.getString("mname"));
                    historyName.setPhone(rs.getString("phone"));
                    historyName.setUsername(rs.getString("username"));
                    historyName.setAddress(rs.getString("address"));
                    historyName.setProname(rs.getString("productNam"));
                    historyName.setProqua(rs.getString("productQuant"));
                    historyName.setProprice(rs.getString("productPrice"));
                    History.add(historyName);

                }
                Table.setItems(History);

                tbID.setCellValueFactory(f -> f.getValue().IdProperty());
                tbUsername.setCellValueFactory(f -> f.getValue().UsernameProperty());
                tbFname.setCellValueFactory(f -> f.getValue().FirstnameProperty());
                tbLname.setCellValueFactory(f -> f.getValue().LastnameProperty());
                tbMname.setCellValueFactory(f -> f.getValue().MiddlenameProperty());
                tbAddress.setCellValueFactory(f -> f.getValue().AddressProperty());
                tbPhone.setCellValueFactory(f -> f.getValue().PhoneProperty());
                tbProduct.setCellValueFactory(f -> f.getValue().PronameProperty());
                tbPrice.setCellValueFactory(f -> f.getValue().ProquaProperty());
                tbQuantity.setCellValueFactory(f -> f.getValue().PropriceProperty());
            }
        } catch (SQLException e) {

        }

        Table.setRowFactory(tv -> {
            TableRow<history> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    index = Table.getSelectionModel().getSelectedIndex();

                    id = Integer.parseInt(String.valueOf(Table.getItems().get(index).getId()));
                    productName.setText(Table.getItems().get(index).getProname());
                    productQua.setText(Table.getItems().get(index).getProqua());
                    productPrize.setText(Table.getItems().get(index).getProprice());
                    txtUsername.setText(Table.getItems().get(index).getUsername());
                    txtFname.setText(Table.getItems().get(index).getFirstname());
                    txtLname.setText(Table.getItems().get(index).getLastName());
                    txtMname.setText(Table.getItems().get(index).getMiddleName());
                    txtPhone.setText(Table.getItems().get(index).getPhone());
                    txtAddress.setText(Table.getItems().get(index).getAddress());
                }
            });
            return myRow;
        });

        FilteredList<history> filteredData = new FilteredList<>(History, b -> true);

        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(productSearchModel -> {

                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }

                String searchKeyword = newValue.toLowerCase();

                if (productSearchModel.getProname().toLowerCase().indexOf(searchKeyword) > - 1) {
                    return true;
                } else if (productSearchModel.getId().toLowerCase().indexOf(searchKeyword) > - 1) {
                    return true;
                } else if (productSearchModel.getProqua().toLowerCase().indexOf(searchKeyword) > - 1) {
                    return true;
                } else if (productSearchModel.getProprice().toLowerCase().indexOf(searchKeyword) > - 1) {
                    return true;
                } else if (productSearchModel.getAddress().toLowerCase().indexOf(searchKeyword) > - 1) {
                    return true;
                } else if (productSearchModel.getUsername().toLowerCase().indexOf(searchKeyword) > - 1) {
                    return true;
                } else if (productSearchModel.getFirstname().toLowerCase().indexOf(searchKeyword) > - 1) {
                    return true;
                } else if (productSearchModel.getLastName().toLowerCase().indexOf(searchKeyword) > - 1) {
                    return true;
                } else if (productSearchModel.getMiddleName().toLowerCase().indexOf(searchKeyword) > - 1) {
                    return true;
                } else if (productSearchModel.getPhone().toLowerCase().indexOf(searchKeyword) > - 1) {
                    return true;
                } else {
                    return false;
                }
            });

        });

        SortedList<history> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(Table.comparatorProperty());

        Table.setItems(sortedData);

    }

    @FXML
    private void GotoExit(ActionEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("MainFXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


@FXML
private void ProductButtClicked(ActionEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("AdminProduct.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();

    }
    @FXML
private void HomepageClick(ActionEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();

    }

    @FXML
private void CustomersButtClicked(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("UsersManagement.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

}
