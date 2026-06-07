/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Angelica S. Fernando
 */
public class AdminController implements Initializable {

    @FXML
    private Label lblactiveacct;
    @FXML
    private Label lbltotalproducts;
    @FXML
    private Label lbltotalquantity;
        private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void gotousers(ActionEvent event)throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("UsersManagement.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void gotoproducts(ActionEvent event)throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("AdminProduct.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();

    }

    @FXML
    private void Gotoexit(ActionEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("MainFXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void gotoorder(ActionEvent event)throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("HistoryManagement.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();

    }
    @FXML
    private void gotoaccts(MouseEvent event)throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("UsersManagement.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();

    }

    @FXML
    private void gotooproduct(MouseEvent event)throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("AdminProduct.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
                stage.setFullScreen(true);
        stage.show();

    }

    @FXML
    private void gotoquantity(MouseEvent event)throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("AdminProduct.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();

    }
    
}
