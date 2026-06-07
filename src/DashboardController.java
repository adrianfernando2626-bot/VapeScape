/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Angelica S. Fernando
 */
public class DashboardController implements Initializable {

    @FXML
    private Label product8price;
    @FXML
    private Button buttaddtocart1;

    @FXML
    private Button buynowbutt1;
    @FXML
    private ImageView addimage1;
    @FXML
    private Image image;

    @FXML
    private ImageView addimage2;

    @FXML
    private ImageView addimage4;

    @FXML
    private ImageView addimage5;

    @FXML
    private ImageView addimage6;

    @FXML
    private ImageView addimage7;

    @FXML
    private ImageView addimage8;

    @FXML
    private ImageView addimage3;

    @FXML
    private Label product1name;

    @FXML
    private Label product1price;

    @FXML
    private Label product2name;

    @FXML
    private Label product2price;

    @FXML
    private Label product3name;

    @FXML
    private Label product3price;

    @FXML
    private Label product4name;

    @FXML
    private Label product4price;

    @FXML
    private Label product5name;

    @FXML
    private Label product5price;

    @FXML
    private Label product6name;

    @FXML
    private Label product6price;

    @FXML
    private Label product7name;

    @FXML
    private Label product7price;

    @FXML
    private Label product8name;
    Connection con = null;
    PreparedStatement pst = null;
    PreparedStatement pst1 = null;
    PreparedStatement pst2 = null;

    private Stage stage;
    @FXML
    private Label lblquantnum1;

    @FXML
    private Label lblquantnum2;

    @FXML
    private Label lblquantnum3;

    @FXML
    private Label lblquantnum4;

    @FXML
    private Label lblquantnum5;

    @FXML
    private Label lblquantnum6;

    @FXML
    private Label lblquantnum7;

    @FXML
    private Label lblquantnum8;
    private Scene scene;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mycon();
        cartnumber1 = getData.cartnumber;
        addimageproduct();
        setnum();

    }
    public static int cartnumber1;

    public void mycon() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login1", "root", "");

        } catch (ClassNotFoundException ex) {

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addimageproduct() {

        mycon();
        int num = 27;
        try {

            pst1 = con.prepareStatement("select * from inventory where id='" + num + "'");

            ResultSet rs = pst1.executeQuery();
            if (rs.next()) {
                product1price.setText(rs.getString("pro_price"));
                product1name.setText(rs.getString("pro_name"));
                String uri = "file:" + rs.getString("image");

                image = new Image(uri, 150, 150, false, true);
                addimage1.setImage(image);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        int num1 = 28;
        try {

            pst1 = con.prepareStatement("select * from inventory where id='" + num1 + "'");
            ResultSet rs = pst1.executeQuery();
            if (rs.next()) {
                product2price.setText(rs.getString("pro_price"));
                product2name.setText(rs.getString("pro_name"));
                String uri = "file:" + rs.getString("image");

                image = new Image(uri, 150, 150, false, true);
                addimage2.setImage(image);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        int num2 = 29;
        try {

            pst1 = con.prepareStatement("select * from inventory where id='" + num2 + "'");
            ResultSet rs = pst1.executeQuery();
            if (rs.next()) {
                product3price.setText(rs.getString("pro_price"));
                product3name.setText(rs.getString("pro_name"));
                String uri = "file:" + rs.getString("image");

                image = new Image(uri, 150, 150, false, true);
                addimage3.setImage(image);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        int num3 = 30;
        try {

            pst1 = con.prepareStatement("select * from inventory where id='" + num3 + "'");
            ResultSet rs = pst1.executeQuery();
            if (rs.next()) {
                product4price.setText(rs.getString("pro_price"));
                product4name.setText(rs.getString("pro_name"));
                String uri = "file:" + rs.getString("image");

                image = new Image(uri, 150, 150, false, true);
                addimage4.setImage(image);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        int num4 = 31;
        try {

            pst1 = con.prepareStatement("select * from inventory where id='" + num4 + "'");
            ResultSet rs = pst1.executeQuery();
            if (rs.next()) {
                product5price.setText(rs.getString("pro_price"));
                product5name.setText(rs.getString("pro_name"));

                String uri = "file:" + rs.getString("image");

                image = new Image(uri, 150, 150, false, true);
                addimage5.setImage(image);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        int num5 = 32;
        try {

            pst1 = con.prepareStatement("select * from inventory where id='" + num5 + "'");
            ResultSet rs = pst1.executeQuery();
            if (rs.next()) {
                product6price.setText(rs.getString("pro_price"));
                product6name.setText(rs.getString("pro_name"));
                String uri = "file:" + rs.getString("image");

                image = new Image(uri, 150, 150, false, true);
                addimage6.setImage(image);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        int num6 = 33;
        try {

            pst1 = con.prepareStatement("select * from inventory where id='" + num6 + "'");
            ResultSet rs = pst1.executeQuery();
            if (rs.next()) {
                product7price.setText(rs.getString("pro_price"));
                product7name.setText(rs.getString("pro_name"));
                String uri = "file:" + rs.getString("image");

                image = new Image(uri, 150, 150, false, true);
                addimage7.setImage(image);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        int num7 = 36;
        try {

            pst1 = con.prepareStatement("select * from inventory where id='" + num7 + "'");
            ResultSet rs = pst1.executeQuery();
            if (rs.next()) {
                product8price.setText(rs.getString("pro_price"));
                product8name.setText(rs.getString("pro_name"));
                String uri = "file:" + rs.getString("image");

                image = new Image(uri, 150, 150, false, true);
                addimage8.setImage(image);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void Buttoncart1(ActionEvent event) {
        int num1 = 27;

        if (getData.cartnumber != 8) {
            getData.cartnumber = getData.cartnumber + 1;

            String lblproprice = product1price.getText();
            String lblproname = product1name.getText();

            try {
                pst1 = con.prepareStatement("Select * from inventory where id='" + num1 + "'");
                ResultSet rs = pst1.executeQuery();

                if (rs.next()) {
                    pst = con.prepareStatement("Insert into cart(pro_name, pro_price, user, cartnumber, image)values(?,?,?,?,?)");
                    pst.setString(1, lblproname);
                    pst.setString(2, lblproprice);
                    pst.setString(3, getData.username);
                    pst.setInt(4, getData.cartnumber);
                    String uri = rs.getString("image");

                    pst.setString(5, uri);
                    pst.executeUpdate();
                }

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Test Connection");
                alert.setHeaderText("Inventory");
                alert.setContentText("You've added it  to the cart");
                alert.show();

            } catch (SQLException ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You cannot add more in the cart");
            alert.show();
        }
    }

    @FXML
    public void Buttoncart2(ActionEvent event) {
        int num1 = 28;

        if (getData.cartnumber != 8) {
            getData.cartnumber = getData.cartnumber + 1;

            String lblproprice = product2price.getText();
            String lblproname = product2name.getText();

            try {
                pst1 = con.prepareStatement("Select * from inventory where id='" + num1 + "'");
                ResultSet rs = pst1.executeQuery();

                if (rs.next()) {
                    pst = con.prepareStatement("Insert into cart(pro_name, pro_price, user, cartnumber, image)values(?,?,?,?,?)");
                    pst.setString(1, lblproname);
                    pst.setString(2, lblproprice);
                    pst.setString(3, getData.username);
                    pst.setInt(4, getData.cartnumber);
                    String uri = rs.getString("image");

                    pst.setString(5, uri);
                    pst.executeUpdate();
                }

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Test Connection");
                alert.setHeaderText("Inventory");
                alert.setContentText("You've added it  to the cart");
                alert.show();

            } catch (SQLException ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You cannot add more in the cart");
            alert.show();
        }
    }

    @FXML
    public void Buttoncart3(ActionEvent event) {
        int num1 = 29;

        if (getData.cartnumber != 8) {
            getData.cartnumber = getData.cartnumber + 1;

            String lblproprice = product3price.getText();
            String lblproname = product3name.getText();

            try {
                pst1 = con.prepareStatement("Select * from inventory where id='" + num1 + "'");
                ResultSet rs = pst1.executeQuery();

                if (rs.next()) {
                    pst = con.prepareStatement("Insert into cart(pro_name, pro_price, user, cartnumber, image)values(?,?,?,?,?)");
                    pst.setString(1, lblproname);
                    pst.setString(2, lblproprice);
                    pst.setString(3, getData.username);
                    pst.setInt(4, getData.cartnumber);
                    String uri = rs.getString("image");

                    pst.setString(5, uri);
                    pst.executeUpdate();
                }

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Test Connection");
                alert.setHeaderText("Inventory");
                alert.setContentText("You've added it  to the cart");
                alert.show();

            } catch (SQLException ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You cannot add more in the cart");
            alert.show();
        }
    }

    @FXML
    public void Buttoncart4(ActionEvent event) {
        int num1 = 30;

        if (getData.cartnumber != 8) {
            getData.cartnumber = getData.cartnumber + 1;

            String lblproprice = product4price.getText();
            String lblproname = product4name.getText();

            try {
                pst1 = con.prepareStatement("Select * from inventory where id='" + num1 + "'");
                ResultSet rs = pst1.executeQuery();

                if (rs.next()) {
                    pst = con.prepareStatement("Insert into cart(pro_name, pro_price, user, cartnumber, image)values(?,?,?,?,?)");
                    pst.setString(1, lblproname);
                    pst.setString(2, lblproprice);
                    pst.setString(3, getData.username);
                    pst.setInt(4, getData.cartnumber);
                    String uri = rs.getString("image");

                    pst.setString(5, uri);
                    pst.executeUpdate();
                }

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Test Connection");
                alert.setHeaderText("Inventory");
                alert.setContentText("You've added it  to the cart");
                alert.show();

            } catch (SQLException ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You cannot add more in the cart");
            alert.show();
        }
    }

    @FXML
    public void Buttoncart5(ActionEvent event) {
        int num1 = 31;

        if (getData.cartnumber != 8) {
            getData.cartnumber = getData.cartnumber + 1;

            String lblproprice = product5price.getText();
            String lblproname = product5name.getText();

            try {
                pst1 = con.prepareStatement("Select * from inventory where id='" + num1 + "'");
                ResultSet rs = pst1.executeQuery();

                if (rs.next()) {
                    pst = con.prepareStatement("Insert into cart(pro_name, pro_price, user, cartnumber, image)values(?,?,?,?,?)");
                    pst.setString(1, lblproname);
                    pst.setString(2, lblproprice);
                    pst.setString(3, getData.username);
                    pst.setInt(4, getData.cartnumber);
                    String uri = rs.getString("image");

                    pst.setString(5, uri);
                    pst.executeUpdate();
                }

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Test Connection");
                alert.setHeaderText("Inventory");
                alert.setContentText("You've added it  to the cart");
                alert.show();

            } catch (SQLException ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You cannot add more in the cart");
            alert.show();
        }
    }

    @FXML
    public void Buttoncart6(ActionEvent event) {
        int num1 = 32;

        if (getData.cartnumber != 8) {
            getData.cartnumber = getData.cartnumber + 1;

            String lblproprice = product6price.getText();
            String lblproname = product6name.getText();

            try {
                pst1 = con.prepareStatement("Select * from inventory where id='" + num1 + "'");
                ResultSet rs = pst1.executeQuery();

                if (rs.next()) {
                    pst = con.prepareStatement("Insert into cart(pro_name, pro_price, user, cartnumber, image)values(?,?,?,?,?)");
                    pst.setString(1, lblproname);
                    pst.setString(2, lblproprice);
                    pst.setString(3, getData.username);
                    pst.setInt(4, getData.cartnumber);
                    String uri = rs.getString("image");

                    pst.setString(5, uri);
                    pst.executeUpdate();
                }

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Test Connection");
                alert.setHeaderText("Inventory");
                alert.setContentText("You've added it  to the cart");
                alert.show();

            } catch (SQLException ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You cannot add more in the cart");
            alert.show();
        }
    }

    @FXML
    public void Buttoncart7(ActionEvent event) {
        int num1 = 33;

        if (getData.cartnumber != 8) {
            getData.cartnumber = getData.cartnumber + 1;

            String lblproprice = product7price.getText();
            String lblproname = product7name.getText();

            try {
                pst1 = con.prepareStatement("Select * from inventory where id='" + num1 + "'");
                ResultSet rs = pst1.executeQuery();

                if (rs.next()) {
                    pst = con.prepareStatement("Insert into cart(pro_name, pro_price, user, cartnumber, image)values(?,?,?,?,?)");
                    pst.setString(1, lblproname);
                    pst.setString(2, lblproprice);
                    pst.setString(3, getData.username);
                    pst.setInt(4, getData.cartnumber);
                    String uri = rs.getString("image");

                    pst.setString(5, uri);
                    pst.executeUpdate();
                }

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Test Connection");
                alert.setHeaderText("Inventory");
                alert.setContentText("You've added it  to the cart");
                alert.show();

            } catch (SQLException ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You cannot add more in the cart");
            alert.show();
        }
    }

    @FXML
    public void Buttoncart8(ActionEvent event) {
        int num1 = 36;

        if (getData.cartnumber != 8) {
            getData.cartnumber = getData.cartnumber + 1;

            String lblproprice = product8price.getText();
            String lblproname = product8name.getText();

            try {
                pst1 = con.prepareStatement("Select * from inventory where id='" + num1 + "'");
                ResultSet rs = pst1.executeQuery();

                if (rs.next()) {
                    pst = con.prepareStatement("Insert into cart(pro_name, pro_price, user, cartnumber, image)values(?,?,?,?,?)");
                    pst.setString(1, lblproname);
                    pst.setString(2, lblproprice);
                    pst.setString(3, getData.username);
                    pst.setInt(4, getData.cartnumber);
                    String uri = rs.getString("image");

                    pst.setString(5, uri);
                    pst.executeUpdate();
                }

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Test Connection");
                alert.setHeaderText("Inventory");
                alert.setContentText("You've added it  to the cart");
                alert.show();

            } catch (SQLException ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You cannot add more in the cart");
            alert.show();
        }
    }

    @FXML
    public void GotoCart(MouseEvent event) throws Exception {
        cartnumber1 = getData.cartnumber;
        Parent root = FXMLLoader.load(getClass().getResource("AddtoCart.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();

    }

    @FXML
    public void ButtonBuy1(ActionEvent event) throws Exception {

        int num1 = 27;
        
        String NoToCart = "NO";

        String lblproprice = product1price.getText();
        String lblproname = product1name.getText();

        try {
            pst1 = con.prepareStatement("Select * from inventory where id='" + num1 + "'");
            ResultSet rs = pst1.executeQuery();

            if (rs.next()) {
                pst = con.prepareStatement("Insert into transaction(pro_name, pro_price, pro_quant, user, image, cart)values(?,?,?,?,?,?)");
                pst.setString(1, lblproname);
                pst.setString(2, lblproprice);
                pst.setString(3, lblquantnum1.getText());
                pst.setString(4, getData.username);
                String uri = rs.getString("image");
                pst.setString(5, uri);
                pst.setString(6, NoToCart);
                pst.executeUpdate();
            }

            Parent root = FXMLLoader.load(getClass().getResource("Transaction.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void ButtonBuy2(ActionEvent event) throws Exception {

        int num1 = 28;
        int num2 = 1;
        String NoToCart = "NO";

        String lblproprice = product2price.getText();
        String lblproname = product2name.getText();

        try {
            pst1 = con.prepareStatement("Select * from inventory where id='" + num1 + "'");
            ResultSet rs = pst1.executeQuery();

            if (rs.next()) {
                pst = con.prepareStatement("Insert into transaction(pro_name, pro_price, pro_quant, user, image, cart)values(?,?,?,?,?,?)");
                pst.setString(1, lblproname);
                pst.setString(2, lblproprice);
                pst.setString(3, lblquantnum2.getText());
                pst.setString(4, getData.username);
                String uri = rs.getString("image");
                
                pst.setString(5, uri);
                pst.setString(6, NoToCart);
                pst.executeUpdate();
            }

            Parent root = FXMLLoader.load(getClass().getResource("Transaction.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void ButtonBuy3(ActionEvent event) throws Exception {

        int num1 = 29;
        int num2 = 1;
        String NoToCart = "NO";

        String lblproprice = product3price.getText();
        String lblproname = product3name.getText();

        try {
            pst1 = con.prepareStatement("Select * from inventory where id='" + num1 + "'");
            ResultSet rs = pst1.executeQuery();

            if (rs.next()) {
                pst = con.prepareStatement("Insert into transaction(pro_name, pro_price, pro_quant, user, image, cart)values(?,?,?,?,?,?)");
                pst.setString(1, lblproname);
                pst.setString(2, lblproprice);
                pst.setString(3, lblquantnum3.getText());
                pst.setString(4, getData.username);
                String uri = rs.getString("image");
                
                pst.setString(5, uri);
                pst.setString(6, NoToCart);
                pst.executeUpdate();
            }

            Parent root = FXMLLoader.load(getClass().getResource("Transaction.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void ButtonBuy4(ActionEvent event) throws Exception {

        int num1 = 30;
        int num2 = 1;
        String NoToCart = "NO";

        String lblproprice = product4price.getText();
        String lblproname = product4name.getText();

        try {
            pst1 = con.prepareStatement("Select * from inventory where id='" + num1 + "'");
            ResultSet rs = pst1.executeQuery();

            if (rs.next()) {
                pst = con.prepareStatement("Insert into transaction(pro_name, pro_price, pro_quant, user, image, cart)values(?,?,?,?,?,?)");
                pst.setString(1, lblproname);
                pst.setString(2, lblproprice);
                pst.setString(3, lblquantnum4.getText());
                pst.setString(4, getData.username);
                String uri = rs.getString("image");
              
                pst.setString(5, uri);
                pst.setString(6, NoToCart);
                pst.executeUpdate();
            }

            Parent root = FXMLLoader.load(getClass().getResource("Transaction.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void ButtonBuy5(ActionEvent event) throws Exception {

        int num1 = 31;
        int num2 = 1;
        String NoToCart = "NO";

        String lblproprice = product5price.getText();
        String lblproname = product5name.getText();

        try {
            pst1 = con.prepareStatement("Select * from inventory where id='" + num1 + "'");
            ResultSet rs = pst1.executeQuery();

            if (rs.next()) {
                pst = con.prepareStatement("Insert into transaction(pro_name, pro_price, pro_quant, user, image, cart)values(?,?,?,?,?,?)");
                pst.setString(1, lblproname);
                pst.setString(2, lblproprice);
                pst.setString(3, lblquantnum5.getText());
                pst.setString(4, getData.username);
                String uri = rs.getString("image");
               
                pst.setString(5, uri);
                pst.setString(6, NoToCart);
                pst.executeUpdate();
            }

            Parent root = FXMLLoader.load(getClass().getResource("Transaction.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void ButtonBuy6(ActionEvent event) throws Exception {

        int num1 = 32;
        int num2 = 1;
        String NoToCart = "NO";

        String lblproprice = product6price.getText();
        String lblproname = product6name.getText();

        try {
            pst1 = con.prepareStatement("Select * from inventory where id='" + num1 + "'");
            ResultSet rs = pst1.executeQuery();

            if (rs.next()) {
                pst = con.prepareStatement("Insert into transaction(pro_name, pro_price, pro_quant, user, image, cart)values(?,?,?,?,?,?)");
                pst.setString(1, lblproname);
                pst.setString(2, lblproprice);
                pst.setString(3, lblquantnum7.getText());
                pst.setString(4, getData.username);
                String uri = rs.getString("image");
                
                pst.setString(5, uri);
                pst.setString(6, NoToCart);
                pst.executeUpdate();
            }

            Parent root = FXMLLoader.load(getClass().getResource("Transaction.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void ButtonBuy7(ActionEvent event) throws Exception {

        int num1 = 33;
        int num2 = 1;
        String NoToCart = "NO";

        String lblproprice = product7price.getText();
        String lblproname = product7name.getText();

        try {
            pst1 = con.prepareStatement("Select * from inventory where id='" + num1 + "'");
            ResultSet rs = pst1.executeQuery();

            if (rs.next()) {
                pst = con.prepareStatement("Insert into transaction(pro_name, pro_price, pro_quant, user, image, cart)values(?,?,?,?,?,?)");
                pst.setString(1, lblproname);
                pst.setString(2, lblproprice);
                pst.setString(3, lblquantnum7.getText());
                pst.setString(4, getData.username);
                String uri = rs.getString("image");
              
                pst.setString(5, uri);
                pst.setString(6, NoToCart);
                pst.executeUpdate();
            }

            Parent root = FXMLLoader.load(getClass().getResource("Transaction.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void ButtonBuy8(ActionEvent event) throws Exception {

        int num1 = 36;
        int num2 = 1;
        String NoToCart = "NO";

        String lblproprice = product8price.getText();
        String lblproname = product8name.getText();

        try {
            pst1 = con.prepareStatement("Select * from inventory where id='" + num1 + "'");
            ResultSet rs = pst1.executeQuery();

            if (rs.next()) {
                pst = con.prepareStatement("Insert into transaction(pro_name, pro_price, pro_quant, user, image, cart)values(?,?,?,?,?,?)");
                pst.setString(1, lblproname);
                pst.setString(2, lblproprice);
                pst.setString(3, lblquantnum8.getText());
                pst.setString(4, getData.username);
                String uri = rs.getString("image");
               
                pst.setString(5, uri);
                pst.setString(6, NoToCart);
                pst.executeUpdate();
            }

            Parent root = FXMLLoader.load(getClass().getResource("Transaction.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void GotoHomepage(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("newhomepage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    @FXML
    private void GotoProfile(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("profile.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    @FXML
    private void addclickbutton(ActionEvent event) {

        num1 = num1 + 1;
        lblquantnum1.setText(Integer.toString(num1));

    }

    @FXML
    private void addclickbutton2(ActionEvent event) {

        num2 = num2 + 1;
        lblquantnum2.setText(Integer.toString(num2));

    }

    @FXML
    private void addclickbutton3(ActionEvent event) {

        num3 = num3 + 1;
        lblquantnum3.setText(Integer.toString(num3));

    }

    @FXML
    private void addclickbutton4(ActionEvent event) {

        num4 = num4 + 1;
        lblquantnum4.setText(Integer.toString(num4));

    }

    @FXML
    private void addclickbutton5(ActionEvent event) {

        num5 = num5 + 1;
        lblquantnum5.setText(Integer.toString(num5));

    }

    @FXML
    private void addclickbutton6(ActionEvent event) {

        num6 = num6 + 1;
        lblquantnum6.setText(Integer.toString(num6));

    }

    @FXML
    private void addclickbutton7(ActionEvent event) {

        num7 = num7 + 1;
        lblquantnum7.setText(Integer.toString(num7));

    }

    @FXML
    private void addclickbutton8(ActionEvent event) {

        num8 = num8 + 1;
        lblquantnum8.setText(Integer.toString(num8));

    }

    @FXML
    private void AddclickMinus1(ActionEvent event) {

        if (num1 > 0) {

            num1 = num1 - 1;
            lblquantnum1.setText(Integer.toString(num1));

        }
    }

    @FXML
    private void AddclickMinus2(ActionEvent event) {

        if (num2 > 0) {

            num2 = num2 - 1;
            lblquantnum2.setText(Integer.toString(num2));

        }
    }

    @FXML
    private void AddclickMinus3(ActionEvent event) {

        if (num3 > 0) {

            num3 = num3 - 1;
            lblquantnum3.setText(Integer.toString(num3));

        }
    }

    @FXML
    private void AddclickMinus4(ActionEvent event) {

        if (num4 > 0) {

            num4 = num4 - 1;
            lblquantnum4.setText(Integer.toString(num4));

        }
    }

    @FXML
    private void AddclickMinus5(ActionEvent event) {

        if (num5 > 0) {

            num5 = num5 - 1;
            lblquantnum5.setText(Integer.toString(num5));

        }
    }

    @FXML
    private void AddclickMinus6(ActionEvent event) {

        if (num6 > 0) {

            num6 = num6 - 1;
            lblquantnum6.setText(Integer.toString(num6));

        }
    }

    @FXML
    private void AddclickMinus7(ActionEvent event) {

        if (num7 > 0) {

            num7 = num7 - 1;
            lblquantnum7.setText(Integer.toString(num7));

        }
    }

    @FXML
    private void AddclickMinus8(ActionEvent event) {

        if (num8 > 0) {

            num8 = num8 - 1;
            lblquantnum8.setText(Integer.toString(num8));

        }
    }
    public static int num1;
    public static int num2;
    public static int num3;
    public static int num4;
    public static int num5;
    public static int num6;
    public static int num7;
    public static int num8;

    public void setnum() {
        num1 = 0;
        num2 = 0;
        num4 = 0;
        num3 = 0;
        num5 = 0;
        num6 = 0;
        num7 = 0;
        num8 = 0;
    }

}
