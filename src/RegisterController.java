/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.Statement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Angelica S. Fernando
 */
public class RegisterController implements Initializable {

    @FXML
    private TextField jusername;
    @FXML
    private TextField jlname;
    @FXML

    private TextField jfname;
    @FXML
    private TextField txtpass1;

    @FXML
    private TextField txtpass11;
    @FXML
    private TextField jmname;
    @FXML
    private TextField jphone;
    @FXML
    private TextField jbirth;
    @FXML
    private TextField jeadd;
    @FXML
    private PasswordField jpass;
    @FXML
    private FontAwesomeIcon Eyeclose;

    @FXML
    private FontAwesomeIcon Eyeopen;

    @FXML
    private FontAwesomeIcon eyeclose2;

    @FXML
    private FontAwesomeIcon eyeclose1;
    @FXML
    private PasswordField jcpass;
    @FXML
    private CheckBox chkterms;
    @FXML
    private Button btnRegister;
    @FXML
    private Button btn;

    @FXML
    private ScrollPane terms;
    @FXML
    private Label chkTxt;
    @FXML
    private TextField txtAddress;
    @FXML
    private ChoiceBox<String> jua;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement psCheckUserExist = null;
    PreparedStatement pst = null;
    PreparedStatement pst1 = null;
    private String[] role = {"Customer", "Administrator"};
    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        jua.getItems().addAll(role);
        setpassword();
        anchor();
    }

    @FXML
    private void btnRegisterClicked(ActionEvent event) throws Exception {
        String username = jusername.getText();
        String firstname = jfname.getText();
        String lastName = jlname.getText();
        String middleName = jmname.getText();
        String birthdate = jbirth.getText();
        String email = jeadd.getText();
        String phone = jphone.getText();
        String password = jpass.getText();
        String confirmPassword = jcpass.getText();
        String address = txtAddress.getText();
        String role = jua.getValue();
        String status = "Active";

        if (jfname.getText().isBlank() || jlname.getText().isBlank() || jmname.getText().isBlank() || txtAddress.getText().isBlank() || jbirth.getText().isBlank() || jeadd.getText().isBlank() || jphone.getText().isBlank() || jusername.getText().isBlank() || jpass.getText().isBlank() || jcpass.getText().isBlank() || jua.getValue().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please Complete All the Requirements");
            alert.show();
            return;
        }

        if (!jcpass.getText().equals(jpass.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("The Confirm Password does not Match");
            alert.show();
            return;
        }
        int age = 18;
        if (jbirth.getText().equals(String.valueOf(age))) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("The Confirm Password does not Match");
            alert.show();
            return;
        }

        if (!chkterms.isSelected()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please Agree to the Terms and Condition");
            alert.show();
            return;
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login1", "root", "");
            pst1 = con.prepareStatement("Select * FROM user WHERE role=?");
            pst1.setString(1, role);
            ResultSet rs1 = pst1.executeQuery();
            if (rs1.isBeforeFirst()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("You cannot register as Administrator!");
                    alert.show();
            } else {
                psCheckUserExist = con.prepareStatement("Select * FROM user WHERE user_name=?");
                psCheckUserExist.setString(1, username);
                rs = psCheckUserExist.executeQuery();

                if (rs.isBeforeFirst()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("This Username is already taken!");
                    alert.show();
                } else {
                    try {
                        Statement s = Databaseconnect.mycon().createStatement();
                        s.executeUpdate(" INSERT INTO user (fname, lname, mname, phone, bday, role, eadd, user_name, pass, cpass, status, address)"
                                + " VALUES ('" + firstname + "','" + lastName + "','" + middleName + "','" + phone + "','" + birthdate + "','" + role + "','" + email + "','" + username + "','" + password + "','" + confirmPassword + "','" + status + "','" + address + "')");

                    } catch (SQLException ex) {
                        Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Your Registration is Successful");
                    alert.show();

                    Parent root = FXMLLoader.load(getClass().getResource("MainFXML.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setpassword() {
        eyeclose1.setVisible(false);
        txtpass11.setVisible(false);
        Eyeopen.setVisible(false);
        txtpass1.setVisible(false);
    }

    public void anchor() {
        terms.setVisible(false);
    }

    @FXML
    void btnClickedmouse(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("MainFXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();

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
    void btncloseeye(MouseEvent event) {
        eyeclose2.setVisible(true);
        eyeclose1.setVisible(false);
        txtpass11.setVisible(false);
        jcpass.setVisible(true);
        txtpass11.setText(jcpass.getText());
        jcpass.setText(txtpass11.getText());
    }

    @FXML
    void btnclosepass(MouseEvent event) {
        Eyeopen.setVisible(false);
        txtpass1.setVisible(false);
        jpass.setVisible(true);
        Eyeclose.setVisible(true);
        jpass.setText(txtpass1.getText());
        txtpass1.setText(jpass.getText());

    }

    @FXML
    void btnopenpass(MouseEvent event) {

        Eyeopen.setVisible(true);
        txtpass1.setVisible(true);
        jpass.setVisible(false);
        Eyeclose.setVisible(false);
        jpass.setText(txtpass1.getText());
        txtpass1.setText(jpass.getText());
    }

    @FXML
    void btnshowpass1(MouseEvent event) {
        eyeclose2.setVisible(false);
        eyeclose1.setVisible(true);
        txtpass11.setVisible(true);
        jcpass.setVisible(false);
        txtpass11.setText(jcpass.getText());
        jcpass.setText(txtpass11.getText());

    }

    @FXML
    void btngototermsandcondition(MouseEvent event) throws Exception {

        terms.setVisible(true);
        btn.setVisible(false);

    }

    @FXML
    void backtoregister(ActionEvent event) {
        btn.setVisible(true);
        chkterms.setSelected(true);
    }

    @FXML
    void backto(ActionEvent event) {
        terms.setVisible(false);
    }
}
