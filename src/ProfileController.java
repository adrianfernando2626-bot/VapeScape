/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Angelica S. Fernando
 */
public class ProfileController implements Initializable {

    @FXML
    private Label lblname;
    @FXML
    private TextField txtusername;
    @FXML
    private PasswordField txtpassword;
    @FXML
    private TextField txtcontacts;
    @FXML
    private TextField txtemail;
    @FXML
    private Button addimage;
    private Stage stage;
    private Scene scene;
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mycon();
        setitems();
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

    public void setitems() {
        try {
            pst = con.prepareStatement("SELECT * FROM user where user_name='" + getData.username + "'");
            rs = pst.executeQuery();
            if (rs.next()) {
                txtusername.setText(rs.getString("user_name"));
                txtpassword.setText(rs.getString("pass"));
                txtcontacts.setText(rs.getString("phone"));
                txtemail.setText(rs.getString("eadd"));
                lblname.setText(rs.getString("fname") + " " + rs.getString("lname"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void deleteaccount(MouseEvent event) throws IOException {
        try {
            pst = con.prepareStatement("DELETE FROM user where user_name=?");
            pst.setString(1, getData.username);
            pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("You have successfully deleted your Account");
            alert.show();
            Parent root = FXMLLoader.load(getClass().getResource("Transaction.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainFXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void gotohome(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("newhomepage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();

    }

    @FXML
    private void gotoHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("newhomepage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();

    }

    @FXML
    private void updatedetails(ActionEvent event) {
        try {
            PreparedStatement pst1 = con.prepareStatement("Select * FROM user WHERE user_name=?");
            pst1.setString(1, txtusername.getText());
            rs = pst1.executeQuery();
            if (rs.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("This Username is already taken!");
                alert.show();
            } else {
                pst = con.prepareStatement("UPDATE user set user_name=?, pass=?, eadd=?, phone=? where user_name=?");
                pst.setString(1, txtusername.getText());
                pst.setString(2, txtpassword.getText());
                pst.setString(3, txtemail.getText());
                pst.setString(4, txtcontacts.getText());
                pst.setString(5, getData.username);
                pst.executeUpdate();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("You have successfully Updated your Account");
                alert.show();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
