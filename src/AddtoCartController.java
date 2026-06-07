/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Angelica S. Fernando
 */
public class AddtoCartController implements Initializable {

    @FXML
    private CheckBox checkbox1;

    @FXML
    private CheckBox checkbox2;

    @FXML
    private CheckBox checkbox3;

    @FXML
    private CheckBox checkbox4;

    @FXML
    private CheckBox checkbox5;

    @FXML
    private CheckBox checkbox6;

    @FXML
    private CheckBox checkbox7;

    @FXML
    private CheckBox checkbox8;
    @FXML
    private ImageView addimagecart2;

    @FXML
    private ImageView addimagecart3;

    @FXML
    private ImageView addimagecart4;

    @FXML
    private ImageView addimagecart5;

    @FXML
    private ImageView addimagecart6;

    @FXML
    private ImageView addimagecart7;

    @FXML
    private ImageView addimagecart8;

    @FXML
    private ImageView addimagecart1;

    @FXML
    private Image image;
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
    @FXML
    private Button buttminus1;

    @FXML
    private Button buttminus2;

    @FXML
    private Button buttminus3;

    @FXML
    private Button buttminus31;

    @FXML
    private Button buttminus32;

    @FXML
    private Button buttminus321;

    @FXML
    private Button buttminus3211;

    @FXML
    private Button buttminus3212;

    @FXML
    private Button buttminus3213;

    @FXML
    private Button buttminus3214;

    @FXML
    private Button buttplus1;

    @FXML
    private Button buttplus2;

    @FXML
    private Button buttplus3;

    @FXML
    private Button buttplus31;

    @FXML
    private Button buttplus32;

    @FXML
    private Button buttplus321;

    @FXML
    private Button buttplus3211;

    @FXML
    private Button buttplus3212;

    @FXML
    private Button buttplus3213;

    @FXML
    private Button buttplus3214;

    @FXML
    private Pane itemPane;

    @FXML
    private Pane itemPane1;

    @FXML
    private Pane itemPane11;

    @FXML
    private Pane itemPane111;

    @FXML
    private Pane itemPane112;

    @FXML
    private Pane itemPane1121;

    @FXML
    private Pane itemPane11211;

    @FXML
    private Pane itemPane11212;

    @FXML
    private Pane itemPane11213;

    @FXML
    private Pane itemPane11214;

    @FXML
    private Label itemRemove;

    @FXML
    private Label itemRemove1;

    @FXML
    private Label itemRemove11;

    @FXML
    private Label itemRemove111;

    @FXML
    private Label itemRemove112;

    @FXML
    private Label itemRemove1121;

    @FXML
    private Label itemRemove11211;

    @FXML
    private Label itemRemove11212;

    @FXML
    private Label itemRemove11213;

    @FXML
    private Label itemRemove11214;

    @FXML
    private Label lblname1;

    @FXML
    private Label lblname10;

    @FXML
    private Label lblname2;

    @FXML
    private Label lblname3;

    @FXML
    private Label lblname4;

    @FXML
    private Label lblname5;

    @FXML
    private Label lblname6;

    @FXML
    private Label lblname7;

    @FXML
    private Label lblname8;

    @FXML
    private Label lblname9;

    @FXML
    private Label lblprice1;

    @FXML
    private Label lblprice10;

    @FXML
    private Label lblprice2;

    @FXML
    private Label lblprice3;

    @FXML
    private Label lblprice4;

    @FXML
    private Label lblprice5;

    @FXML
    private Label lblprice6;

    @FXML
    private Label lblprice7;

    @FXML
    private Label lblprice8;

    @FXML
    private Label lblprice9;

    @FXML
    private Label lblquantnum1;


    @FXML
    private Label lblquantnum31;

    @FXML
    private Label lblquantnum32;

    @FXML
    private Label lblquantnum321;

    @FXML
    private Label lblquantnum3211;

    @FXML
    private Label lblquantnum3212;

    @FXML
    private Label lblquantnum3213;

    @FXML
    private Label lblquantnum3214;
    Connection con = null;
    PreparedStatement pst = null;
    PreparedStatement pst1 = null;
    private Stage stage;
    private Scene scene;
    int numbercart1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AddcartProduct1();
        AddcartProduct2();
        AddcartProduct3();
        AddcartProduct4();
        AddcartProduct5();
        AddcartProduct6();
        AddcartProduct7();
        AddcartProduct8();
        setnum();
        mycon();
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
    private void addclick(ActionEvent event) {

        int number = 1;
        String cartnum;

    }

    @FXML
    private void AddcartProduct1() {

        mycon();
        int num = 1;
        if (getData.cartnumber < 1) {
            itemPane.setVisible(false);
        } else {

            try {
                pst1 = con.prepareStatement("Select pro_name, pro_price, image from cart where user ='" + getData.username + "' AND cartnumber=?");
                pst1.setInt(1, num);
                ResultSet rs = pst1.executeQuery();
                if (rs.next()) {
                    String uri = "file:" + rs.getString("image");

                    image = new Image(uri, 125, 125, false, true);
                    addimagecart1.setImage(image);
                    lblname1.setText(rs.getString("pro_name"));
                    lblprice1.setText(rs.getString("pro_price"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void AddcartProduct2() {
        mycon();
        int num = 2;
        if (getData.cartnumber < 2) {
            itemPane1.setVisible(false);
        } else {
            try {
                pst1 = con.prepareStatement("Select pro_name, pro_price, image from cart where user ='" + getData.username + "' AND cartnumber=?");
                pst1.setInt(1, num);
                ResultSet rs = pst1.executeQuery();
                if (rs.next()) {
                    String uri = "file:" + rs.getString("image");

                    image = new Image(uri, 125, 125, false, true);
                    addimagecart2.setImage(image);
                    lblname2.setText(rs.getString("pro_name"));
                    lblprice2.setText(rs.getString("pro_price"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void AddcartProduct3() {
        mycon();
      int num = 3;
        if (getData.cartnumber < 3) {
            itemPane11.setVisible(false);
        } else {
            try {
                pst1 = con.prepareStatement("Select pro_name, pro_price, image from cart where user ='" + getData.username + "' AND cartnumber=?");
                pst1.setInt(1, num);
                ResultSet rs = pst1.executeQuery();
                if (rs.next()) {
                    String uri = "file:" + rs.getString("image");

                    image = new Image(uri, 125, 125, false, true);
                    addimagecart3.setImage(image);
                    lblname3.setText(rs.getString("pro_name"));
                    lblprice3.setText(rs.getString("pro_price"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void AddcartProduct4() {
        mycon();
       int num = 4;
        if (getData.cartnumber< 4) {
            itemPane111.setVisible(false);
        } else {

            try {
                pst1 = con.prepareStatement("Select pro_name, pro_price, image from cart where user ='" + getData.username + "' AND cartnumber=?");
                pst1.setInt(1, num);
                ResultSet rs = pst1.executeQuery();
                if (rs.next()) {
                    String uri = "file:" + rs.getString("image");

                    image = new Image(uri, 125, 125, false, true);
                    addimagecart4.setImage(image);
                    lblname4.setText(rs.getString("pro_name"));
                    lblprice4.setText(rs.getString("pro_price"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    private void AddcartProduct5() {
        mycon();
        int num = 5;
        if (getData.cartnumber < 5) {
            itemPane112.setVisible(false);
        } else {

            try {
                pst1 = con.prepareStatement("Select pro_name, pro_price, image from cart where user ='" + getData.username + "' AND cartnumber=?");
                pst1.setInt(1, num);
                ResultSet rs = pst1.executeQuery();
                if (rs.next()) {
                    String uri = "file:" + rs.getString("image");

                    image = new Image(uri, 125, 125, false, true);
                    addimagecart5.setImage(image);
                    lblname5.setText(rs.getString("pro_name"));
                    lblprice5.setText(rs.getString("pro_price"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void AddcartProduct6() {
        mycon();
       int num = 6;
        if (getData.cartnumber < 6) {
            itemPane1121.setVisible(false);
        } else {

            try {
                pst1 = con.prepareStatement("Select pro_name, pro_price, image from cart where user ='" + getData.username + "' AND cartnumber=?");
                pst1.setInt(1, num);
                ResultSet rs = pst1.executeQuery();
                if (rs.next()) {
                    String uri = "file:" + rs.getString("image");

                    image = new Image(uri, 125, 125, false, true);
                    addimagecart6.setImage(image);
                    lblname6.setText(rs.getString("pro_name"));
                    lblprice6.setText( rs.getString("pro_price"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void AddcartProduct7() {
        mycon();
    int num = 7;
        if (getData.cartnumber < 7) {
            itemPane11211.setVisible(false);
        } else {

            try {
                pst1 = con.prepareStatement("Select pro_name, pro_price, image from cart where user ='" + getData.username + "' AND cartnumber=?");
                pst1.setInt(1, num);
                ResultSet rs = pst1.executeQuery();
                if (rs.next()) {
                    String uri = "file:" + rs.getString("image");

                    image = new Image(uri, 125, 125, false, true);
                    addimagecart7.setImage(image);
                    lblname7.setText(rs.getString("pro_name"));
                    lblprice7.setText(rs.getString("pro_price"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void AddcartProduct8() {
        mycon();
        int num = 8;
        if (getData.cartnumber < 8) {
            itemPane11212.setVisible(false);
        } else {
            try {
                pst1 = con.prepareStatement("Select pro_name, pro_price, image from cart where user ='" + getData.username + "' AND cartnumber=?");
                pst1.setInt(1, num);
                ResultSet rs = pst1.executeQuery();
                if (rs.next()) {
                    String uri = "file:" + rs.getString("image");

                    image = new Image(uri, 125, 125, false, true);
                    addimagecart8.setImage(image);
                    lblname8.setText(rs.getString("pro_name"));
                    lblprice8.setText(rs.getString("pro_price"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void removeCartProduct8(MouseEvent event) {

        getData.cartnumber = getData.cartnumber -1;
        int num = 8;
        mycon();
        try {

            pst1 = con.prepareStatement("DELETE FROM cart WHERE cartnumber=? and user ='" + getData.username + "'");
            pst1.setInt(1, num);
            pst1.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Test Connection");
            alert.setHeaderText("Cart");
            alert.setContentText("You've remove it from the cart");
            alert.show();
            itemPane11212.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(AddtoCartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void removeCartProduct7(MouseEvent event) {

        getData.cartnumber = getData.cartnumber -1;
        int num = 7;
        mycon();
        try {

            pst1 = con.prepareStatement("DELETE FROM cart WHERE cartnumber=? and user ='" + getData.username + "'");
            pst1.setInt(1, num);
            pst1.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Test Connection");
            alert.setHeaderText("Cart");
            alert.setContentText("You've remove it from the cart");
            alert.show();
            itemPane11211.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(AddtoCartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void removeCartProduct6(MouseEvent event) {

        getData.cartnumber = getData.cartnumber -1;
        int num = 6;
        mycon();
        try {

            pst1 = con.prepareStatement("DELETE FROM cart WHERE cartnumber=? and user ='" + getData.username + "'");
            pst1.setInt(1, num);
            pst1.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Test Connection");
            alert.setHeaderText("Cart");
            alert.setContentText("You've remove it from the cart");
            alert.show();
            itemPane1121.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(AddtoCartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void removeCartProduct5(MouseEvent event) {

        getData.cartnumber = getData.cartnumber -1;
        int num = 5;
        mycon();
        try {

            pst1 = con.prepareStatement("DELETE FROM cart WHERE cartnumber=? and user ='" + getData.username + "'");
            pst1.setInt(1, num);
            pst1.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Test Connection");
            alert.setHeaderText("Cart");
            alert.setContentText("You've remove it from the cart");
            alert.show();
            itemPane112.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(AddtoCartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void removeCartProduct4(MouseEvent event) {

        getData.cartnumber = getData.cartnumber -1;
        int num = 4;
        mycon();
        try {

            pst1 = con.prepareStatement("DELETE FROM cart WHERE cartnumber=? and user ='" + getData.username + "'");
            pst1.setInt(1, num);
            pst1.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Test Connection");
            alert.setHeaderText("Cart");
            alert.setContentText("You've remove it from the cart");
            alert.show();
            itemPane111.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(AddtoCartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void removeCartProduct3(MouseEvent event) {

        getData.cartnumber = getData.cartnumber -1;
        int num = 3;
        mycon();
        try {

            pst1 = con.prepareStatement("DELETE FROM cart WHERE cartnumber=? and user ='" + getData.username + "'");
            pst1.setInt(1, num);
            pst1.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Test Connection");
            alert.setHeaderText("Cart");
            alert.setContentText("You've remove it from the cart");
            alert.show();
            itemPane11.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(AddtoCartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void removeCartProduct2(MouseEvent event) {

        getData.cartnumber = getData.cartnumber -1;
        int num = 2;
        mycon();
        try {

            pst1 = con.prepareStatement("DELETE FROM cart WHERE cartnumber=? and user ='" + getData.username + "'");
            pst1.setInt(1, num);
            pst1.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Test Connection");
            alert.setHeaderText("Cart");
            alert.setContentText("You've remove it from the cart");
            alert.show();
            itemPane1.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(AddtoCartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void removeCartProduct1(MouseEvent event) {
        getData.cartnumber = getData.cartnumber -1;
        
        int num = 1;
        mycon();
        try {

            pst1 = con.prepareStatement("DELETE FROM cart WHERE cartnumber=? and user ='" + getData.username + "'");
            pst1.setInt(1, num);
            pst1.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Test Connection");
            alert.setHeaderText("Cart");
            alert.setContentText("You've remove it from the cart");
            alert.show();
            itemPane.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(AddtoCartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void buyoutProduct(ActionEvent event) throws Exception {
        mycon();
        int numbercart2;

    
        String Yestocart = "YES";
        if (checkbox1.isSelected()) {
            int num = 1;
            numbercart1 = numbercart1 + 1;
            try {
                pst1 = con.prepareStatement("Select * from cart where cartnumber='" + num + "'");
                ResultSet rs = pst1.executeQuery();

                if (rs.next()) {
                    pst = con.prepareStatement("Insert into transaction(pro_name, pro_price, pro_quant, user, image, cartnumber, cart)values(?,?,?,?,?,?,?)");
                    pst.setString(1, lblname1.getText());
                    pst.setString(2, lblprice1.getText());
                    pst.setString(3, lblquantnum1.getText());
                    pst.setString(4, getData.username);
                    String uri = rs.getString("image");
                    pst.setString(5, uri);
                    pst.setInt(6, numbercart1);
                    pst.setString(7, Yestocart);
                    pst.executeUpdate();
                }

            } catch (SQLException ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        }
        if (checkbox2.isSelected()) {
            int num = 2;
            numbercart1 = numbercart1 + 1;
            try {
                pst1 = con.prepareStatement("Select * from cart where cartnumber='" + num + "'");
                ResultSet rs = pst1.executeQuery();

                if (rs.next()) {
                    pst = con.prepareStatement("Insert into transaction(pro_name, pro_price, pro_quant, user, image, cartnumber, cart)values(?,?,?,?,?,?,?)");
                    pst.setString(1, lblname2.getText());
                    pst.setString(2, lblprice2.getText());
                    pst.setString(3, lblquantnum2.getText());
                    pst.setString(4, getData.username);
                    String uri = rs.getString("image");
               
                    pst.setString(5, uri);
                    pst.setInt(6, numbercart1);
                    pst.setString(7, Yestocart);
                    pst.executeUpdate();
                }

            } catch (SQLException ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        if (checkbox3.isSelected()) {
            int num = 3;
            numbercart1 = numbercart1 + 1;
            try {
                pst1 = con.prepareStatement("Select * from cart where cartnumber='" + num + "'");
                ResultSet rs = pst1.executeQuery();

                if (rs.next()) {
                    pst = con.prepareStatement("Insert into transaction(pro_name, pro_price, pro_quant, user, image, cartnumber, cart)values(?,?,?,?,?,?,?)");
                    pst.setString(1, lblname3.getText());
                    pst.setString(2, lblprice3.getText());
                    pst.setString(3, lblquantnum3.getText());
                    pst.setString(4, getData.username);
                    String uri = rs.getString("image");
                    
                    pst.setString(5, uri);
                    pst.setInt(6, numbercart1);
                    pst.setString(7, Yestocart);
                    pst.executeUpdate();
                }

            } catch (SQLException ex) {
                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
         if (checkbox4.isSelected()) {
                int num = 4;
                numbercart1 = numbercart1 + 1;
                try {
                    pst1 = con.prepareStatement("Select * from cart where cartnumber='" + num + "'");
                    ResultSet rs = pst1.executeQuery();

                    if (rs.next()) {
                        pst = con.prepareStatement("Insert into transaction(pro_name, pro_price, pro_quant, user, image, cartnumber, cart)values(?,?,?,?,?,?,?)");
                        pst.setString(1, lblname4.getText());
                        pst.setString(2, lblprice4.getText());
                        pst.setString(3, lblquantnum4.getText());
                        pst.setString(4, getData.username);
                        String uri = rs.getString("image");
                        
                        pst.setString(5, uri);
                        pst.setInt(6, numbercart1);
                        pst.setString(7, Yestocart);
                        pst.executeUpdate();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
         }
          if (checkbox5.isSelected()) {
                int num = 5;
                numbercart1 = numbercart1 + 1;
                try {
                    pst1 = con.prepareStatement("Select * from cart where cartnumber='" + num + "'");
                    ResultSet rs = pst1.executeQuery();

                    if (rs.next()) {
                        pst = con.prepareStatement("Insert into transaction(pro_name, pro_price, pro_quant, user, image, cartnumber, cart)values(?,?,?,?,?,?,?)");
                        pst.setString(1, lblname5.getText());
                        pst.setString(2, lblprice5.getText());
                        pst.setString(3, lblquantnum5.getText());
                        pst.setString(4, getData.username);
                        String uri = rs.getString("image");
                        
                        pst.setString(5, uri);
                        pst.setInt(6, numbercart1);
                        pst.setString(7, Yestocart);
                        pst.executeUpdate();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }
              
          }
           if (checkbox6.isSelected()) {
                int num = 6;
                numbercart1 = numbercart1 + 1;
                try {
                    pst1 = con.prepareStatement("Select * from cart where cartnumber='" + num + "'");
                    ResultSet rs = pst1.executeQuery();

                    if (rs.next()) {
                        pst = con.prepareStatement("Insert into transaction(pro_name, pro_price, pro_quant, user, image, cartnumber, cart)values(?,?,?,?,?,?,?)");
                        pst.setString(1, lblname6.getText());
                        pst.setString(2, lblprice6.getText());
                        pst.setString(3, lblquantnum6.getText());
                        pst.setString(4, getData.username);
                        String uri = rs.getString("image");
                      
                        pst.setString(5, uri);
                        pst.setInt(6, numbercart1);
                        pst.setString(7, Yestocart);
                        pst.executeUpdate();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
           }
            if (checkbox7.isSelected()) {
                int num = 7;
                numbercart1 = numbercart1 + 1;
                try {
                    pst1 = con.prepareStatement("Select * from cart where cartnumber='" + num + "'");
                    ResultSet rs = pst1.executeQuery();

                    if (rs.next()) {
                        pst = con.prepareStatement("Insert into transaction(pro_name, pro_price, pro_quant, user, image, cartnumber, cart)values(?,?,?,?,?,?,?)");
                        pst.setString(1, lblname7.getText());
                        pst.setString(2, lblprice7.getText());
                        pst.setString(3, lblquantnum7.getText());
                        pst.setString(4, getData.username);
                        String uri = rs.getString("image");
                       
                        pst.setString(5, uri);
                        pst.setInt(6, numbercart1);
                        pst.setString(7, Yestocart);
                        pst.executeUpdate();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }
              
            }
             if (checkbox8.isSelected()) {
                int num = 8;
                numbercart1 = numbercart1 + 1;
                try {
                    pst1 = con.prepareStatement("Select * from cart where cartnumber='" + num + "'");
                    ResultSet rs = pst1.executeQuery();

                    if (rs.next()) {
                        pst = con.prepareStatement("Insert into transaction(pro_name, pro_price, pro_quant, user, image, cartnumber, cart)values(?,?,?,?,?,?,?)");
                        pst.setString(1, lblname8.getText());
                        pst.setString(2, lblprice8.getText());
                        pst.setString(3, lblquantnum8.getText());
                        pst.setString(4, getData.username);
                        String uri = rs.getString("image");
                 
                        pst.setString(5, uri);
                        pst.setInt(6, numbercart1);
                        pst.setString(7, Yestocart);
                        pst.executeUpdate();
                    }
                    
                    
                 PreparedStatement pst1 = con.prepareStatement("delete from cart where user= ?");
                 pst1.setString(1, getData.username);
                 pst1.executeUpdate();
                 
                 
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
               
             }
        Parent root = FXMLLoader.load(getClass().getResource("Transaction.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
 

}
    public void setnum(){
               num1 = 0;
        num2 = 0;
        num4 = 0;
        num3 = 0;
        num5 = 0;
        num6 = 0;
        num7 = 0;
        num8 = 0;
    }
          public static int num1;  
          public static int num2; 
          public static int num3; 
          public static int num4; 
          public static int num5; 
          public static int num6; 
          public static int num7; 
          public static int num8; 
        
          
    @FXML
    void gotohome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("newhomepage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
        @FXML
    private void addclickbutton(ActionEvent event) {
        

        num1 = num1 +1;
        lblquantnum1.setText(Integer.toString(num1));
            
        }
            @FXML
    private void addclickbutton2(ActionEvent event) {
        

        num2 = num2 +1;
        lblquantnum2.setText(Integer.toString(num2));
            
        }
            @FXML
    private void addclickbutton3(ActionEvent event) {
        

        num3 = num3 +1;
        lblquantnum3.setText(Integer.toString(num3));
            
        }
            @FXML
    private void addclickbutton4(ActionEvent event) {
        

        num4 = num4 +1;
        lblquantnum4.setText(Integer.toString(num4));
            
        }
            @FXML
    private void addclickbutton5(ActionEvent event) {
        

        num5 = num5 +1;
        lblquantnum5.setText(Integer.toString(num5));
            
        }
            @FXML
    private void addclickbutton6(ActionEvent event) {
        

        num6 = num6 +1;
        lblquantnum6.setText(Integer.toString(num6));
            
        }
            @FXML
    private void addclickbutton7(ActionEvent event) {
        

        num7 = num7 +1;
        lblquantnum7.setText(Integer.toString(num7));
            
        }
            @FXML
    private void addclickbutton8(ActionEvent event) {
        

        num8 = num8 +1;
        lblquantnum8.setText(Integer.toString(num8));
            
        }
                @FXML
    private void AddclickMinus1(ActionEvent event) {
        
        if(num1 >0){
            
        num1 = num1 -1;
        lblquantnum1.setText(Integer.toString(num1));
                    
        
        }
        }  
    @FXML
    private void AddclickMinus2(ActionEvent event) {
        
        if(num2 >0){
            
        num2 = num2 -1;
        lblquantnum2.setText(Integer.toString(num2));
                    
        
        }
        }
                    
    @FXML
    private void AddclickMinus3(ActionEvent event) {
        
        if(num3 >0){
            
        num3 = num3 -1;
        lblquantnum3.setText(Integer.toString(num3));
                    
        
        }
        }
                    
    @FXML
    private void AddclickMinus4(ActionEvent event) {
        
        if(num4 >0){
            
        num4 = num4 -1;
        lblquantnum4.setText(Integer.toString(num4));
                    
        
        }
        }                
    @FXML
    private void AddclickMinus5(ActionEvent event) {
        
        if(num5 >0){
            
        num5 = num5 -1;
        lblquantnum5.setText(Integer.toString(num5));
                    
        
        }
        }                
    @FXML
    private void AddclickMinus6(ActionEvent event) {
        
        if(num6 >0){
            
        num6 = num6 -1;
        lblquantnum6.setText(Integer.toString(num6));
                    
        
        }
        }                @FXML
    private void AddclickMinus7(ActionEvent event) {
        
        if(num7 >0){
            
        num7 = num7 -1;
        lblquantnum7.setText(Integer.toString(num7));
                    
        
        }
        }                
    @FXML
    private void AddclickMinus8(ActionEvent event) {
        
        if(num8 >0){
            
        num8 = num8 -1;
        lblquantnum8.setText(Integer.toString(num8));
                    
        
        }
        }
  
    }
