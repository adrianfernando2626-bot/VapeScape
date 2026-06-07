/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Angelica S. Fernando
 */
public class AdminProductController implements Initializable {

    @FXML
    private ImageView addEmployeeImage;
    private Image image;
    @FXML
    private AnchorPane main_form;
    @FXML
    private Button addButt;
    @FXML
    private Button deleteButt;
    @FXML
    private Button updateButt;
    @FXML
    private TextField productName;

    @FXML
    private TextField productPrize;
    @FXML
    private TextField txtSearch;

    @FXML
    private TableColumn<inventory, String> tbID;

    @FXML
    private TableColumn<inventory, String> tbProprice;

    @FXML
    private TableColumn<inventory, String> tbPronam;

    @FXML
    private TableColumn<inventory, String> tbProqua;

    @FXML
    private TableView<inventory> Table;

    @FXML
    private TextField productQua;
    private Stage stage;
    private Scene scene;
    private Parent root;
    int index, id;
    Connection con = null;
    PreparedStatement pst = null;

    private FileChooser filechooser;
    private File file;
    private FileInputStream fis;
    @FXML
    private Button addButt1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        mycon();
        table();
        InventorySelection();

    }


    @FXML
    private void addImage(ActionEvent event) {
        filechooser = new FileChooser();

        file = filechooser.showOpenDialog(main_form.getScene().getWindow());
        if (file != null) {

            getData.path = file.getAbsolutePath();

            image = new Image(file.toURI().toString(), 174, 167, false, true);
            addEmployeeImage.setImage(image);

        }
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

    @FXML
    private void addButtClicked(ActionEvent event) throws FileNotFoundException {

        String Productnam = productName.getText();
        String Productqua = productQua.getText();
        String Productprice = productPrize.getText();

        try {

            pst = Databaseconnect.mycon().prepareStatement("INSERT INTO inventory( pro_name, pro_quant, pro_price, image) VALUES(?, ?, ?, ?)");
            pst.setString(1, productName.getText());
            pst.setString(2, productQua.getText());
            pst.setString(3, productPrize.getText());
            String uri = getData.path;
            uri = uri.replace("\\", "\\\\");
            pst.setString(4, uri);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AdminProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");
        alert.setHeaderText("Inventory");
        alert.setContentText("You've added the Product");
        alert.show();

        table();
        addEmployeeImage.setImage(null);
        productName.setText("");
        productQua.setText("");
        productPrize.setText("");
        productName.requestFocus();

    }

    public void table() {

        mycon();
        ObservableList<inventory> Inventory = FXCollections.observableArrayList();
        try {
            pst = con.prepareStatement("SELECT * FROM inventory");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {
                    inventory inte = new inventory();
                    inte.setid(rs.getString("id"));
                    inte.setProname(rs.getString("pro_name"));
                    inte.setProqua(rs.getString("pro_quant"));
                    inte.setProprice(rs.getString("pro_price"));
                    inte.setImage(rs.getString("image"));

                    Inventory.add(inte);

                }
            }

            Table.setItems(Inventory);
            tbID.setCellValueFactory(f -> f.getValue().idProperty());
            tbPronam.setCellValueFactory(f -> f.getValue().PronameProperty());
            tbProqua.setCellValueFactory(f -> f.getValue().ProquaProperty());
            tbProprice.setCellValueFactory(f -> f.getValue().PropriceProperty());

        } catch (SQLException e) {

        }

        FilteredList<inventory> filteredData = new FilteredList<>(Inventory, b -> true);

        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(productSearchModel -> {

                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }

                String searchKeyword = newValue.toLowerCase();

                if (productSearchModel.getProname().toLowerCase().indexOf(searchKeyword) > - 1) {
                    return true;
                } else if (productSearchModel.getid().toLowerCase().indexOf(searchKeyword) > - 1) {
                    return true;
                } else if (productSearchModel.getProqua().toLowerCase().indexOf(searchKeyword) > - 1) {
                    return true;
                } else if (productSearchModel.getProprice().toLowerCase().indexOf(searchKeyword) > - 1) {
                    return true;
                } else {
                    return false;
                }
            });

        });

        SortedList<inventory> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(Table.comparatorProperty());

        Table.setItems(sortedData);

    }

    public void InventorySelection() {
        Table.setRowFactory(tv -> {
            TableRow<inventory> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    inventory inte = Table.getSelectionModel().getSelectedItem();
                    index = Table.getSelectionModel().getSelectedIndex();

                    id = Integer.parseInt(String.valueOf(Table.getItems().get(index).getid()));
                    productName.setText(Table.getItems().get(index).getProname());
                    productQua.setText(Table.getItems().get(index).getProqua());
                    productPrize.setText(Table.getItems().get(index).getProprice());

                    String uri = "file:" + inte.getImage();

                    image = new Image(uri, 174, 167, false, true);
                    addEmployeeImage.setImage(image);

                }
            });
            return myRow;
        });
    }

    @FXML
    private void deleteButtClicked(ActionEvent event) {

        try {

            pst = Databaseconnect.mycon().prepareStatement("DELETE FROM inventory WHERE pro_name=?");
            pst.setString(1, productName.getText());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AdminProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");
        alert.setHeaderText("Inventory");
        alert.setContentText("You've deleted the Product");
        alert.show();

        table();
        addEmployeeImage.setImage(null);
        productName.setText("");
        productQua.setText("");
        productPrize.setText("");
        productName.requestFocus();
    }

    @FXML
    private void updateButtClicked(ActionEvent event) {
        

        index = Table.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(Table.getItems().get(index).getid()));

        try {

            pst = Databaseconnect.mycon().prepareStatement("UPDATE inventory set pro_quant=? ,pro_price=?,pro_name=?, image=? WHERE id =?");
            pst.setString(1, productQua.getText());
            pst.setString(2, productPrize.getText());
            pst.setString(3, productName.getText());
            if(getData.path != null){
                       String uri = getData.path;
            uri = uri.replace("\\", "\\\\");
            pst.setString(4, uri); 
            }else{
                inventory inte = Table.getSelectionModel().getSelectedItem();
                String uri = inte.getImage();
                pst.setString(4, uri); 
            }

            pst.setInt(5, id);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AdminProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");
        alert.setHeaderText("Inventory");
        alert.setContentText("You've Updated the Product");
        alert.show();

        table();
        addEmployeeImage.setImage(null);
        productName.setText("");
        productQua.setText("");
        productPrize.setText("");
        productName.requestFocus();
    }

    @FXML
    private void HomeClick(ActionEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();

    }

    @FXML
    private void OrderButtClicked(ActionEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("HistoryManagement.fxml"));
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
