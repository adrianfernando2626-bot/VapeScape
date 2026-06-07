
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainFXMLController implements Initializable {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @FXML
    private TextField tfFirstname;
    @FXML
    private TextField tfLastname;
    @FXML
    private FontAwesomeIcon Eyeclose;
    @FXML
    private Button cancel;
        @FXML
    private FontAwesomeIcon Eyeopen;
    
    @FXML
    private TextField txtpass2;
    @FXML
    private Label label1;
    @FXML
    private ChoiceBox<String> checkbox;
    private String[] role = {"Customer", "Administrator"};
    private Stage stage;
    private Scene scene;
    private Parent root;
    

    public MainFXMLController() {

        con = Databaseconnect.mycon();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//////        // TODO
        checkbox.getItems().addAll(role);
        setPasswordShow();

    }
    public void setPasswordShow(){
       
    txtpass2.setVisible(false);

    Eyeopen.setVisible(false);
    }
    @FXML
    private void btnLoginClicked(ActionEvent event) throws IOException {

        String Usern = tfFirstname.getText();
        String Pass = tfLastname.getText();
        String roleua = checkbox.getValue();
        getData.username = tfFirstname.getText();
        
        try {

            String sql = " SELECT * FROM user WHERE user_name=? AND pass=? and role=?";
            pst = con.prepareStatement(sql);

            pst.setString(1, Usern);
            pst.setString(2, Pass);
            pst.setString(3, roleua);
           
            rs = pst.executeQuery();

            if (tfFirstname.getText().isEmpty() || tfLastname.getText().isEmpty()) {
                return;
            }
            if (rs.next()) {

                if (rs.getString("status").equals("Active")) {

                    if (roleua.equals("Customer")) {

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("Welcome Customer");
                        alert.show();

                           Parent root = FXMLLoader.load(getClass().getResource("newhomepage.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        
                        stage.setScene(scene);
                        stage.setFullScreen(true);
                        stage.show();
                        
                        
                    } else {

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("Welcome Admin");
                        alert.show();

                        Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.setFullScreen(true);
                        stage.show();
                    }
                } else if (rs.getString("status").equals("Inactive")) {
                    label1.setText("Your Account is Inactive");

                }
            } else {
                label1.setText("Invalid Username and Password");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AddtoCartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnClearClicked(ActionEvent event) {

        tfFirstname.setText("");
        tfLastname.setText("");

    }

    @FXML
    public void btnCancelClicked(ActionEvent event) {

        stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void btncreateAccount(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
        @FXML
    void btnshowpassword(MouseEvent event) {
        txtpass2.setVisible(true);
        Eyeopen.setVisible(true);
        Eyeclose.setVisible(false);
        tfLastname.setVisible(false);
        txtpass2.setText(tfLastname.getText());
        tfLastname.setText(txtpass2.getText());
    }
        @FXML
    void setHidepassword(MouseEvent event) {
        Eyeopen.setVisible(true);
        Eyeclose.setVisible(false);
        txtpass2.setVisible(true);
        tfLastname.setVisible(false);
        txtpass2.setText(tfLastname.getText());
        tfLastname.setText(txtpass2.getText());
    }
}
