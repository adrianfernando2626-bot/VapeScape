/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Angelica S. Fernando
 */
public class NewhomepageController implements Initializable {
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
    private void gotoproduct(ActionEvent event)throws IOException{
                        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.setFullScreen(true);
                        stage.show();
    }

    @FXML
    private void gotoprofile(ActionEvent event) throws IOException{
                        Parent root = FXMLLoader.load(getClass().getResource("profile.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.setFullScreen(true);
                        stage.show();
    }


    @FXML
    private void gotocart(ActionEvent event)throws IOException{
                        Parent root = FXMLLoader.load(getClass().getResource("AddtoCart.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.setFullScreen(true);
                        stage.show();
    }

    @FXML
    private void gotolast(ActionEvent event)throws IOException{
                        Parent root = FXMLLoader.load(getClass().getResource("newhomepage4.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.setFullScreen(true);
                        stage.show();
    }


    @FXML
    private void gotonext(ActionEvent event)throws IOException{
                        Parent root = FXMLLoader.load(getClass().getResource("newhomepage2.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.setFullScreen(true);
                        stage.show();
    }


    @FXML
    private void shopnow(ActionEvent event)throws IOException{
                        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.setFullScreen(true);
                        stage.show();
    }

    
}
