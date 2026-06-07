
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.barcodelib.barcode.Linear;
import java.io.IOException;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Angelica S. Fernando
 */
public class TransactionController implements Initializable {

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
    private Label myLabel;
    @FXML
    private TextField txtfname;
    @FXML
    private TextField txtaddress;
    @FXML
    private Label lblsubtotal;

    @FXML
    private Label lbltotal;

    @FXML
    private TextField txtpostal;
    @FXML
    private TextField txtcity;
    @FXML
    private Label lbladdress;
    @FXML
    private TextField txtlname;
    @FXML
    private TextField txtphone;
    @FXML
    private Pane itempane1;

    @FXML
    private Pane itempane2;

    @FXML
    private Pane itempane3;

    @FXML
    private Pane itempane4;

    @FXML
    private Pane itempane5;

    @FXML
    private Pane itempane6;

    @FXML
    private Pane itempane7;

    @FXML
    private Pane itempane8;
    @FXML
    private VBox paymentMethodContainer;
    @FXML
    private RadioButton masterradbtn;
    @FXML
    private ToggleGroup paymentToggleGroup;
    @FXML
    private RadioButton codradbtn;
    @FXML
    private RadioButton gcashradbtn;
    @FXML
    private RadioButton payatstoreradbtn;
    @FXML
    private Button btnpaynow;
    @FXML
    private VBox deliveryContainer;

    @FXML
    private ImageView addImage1;

    @FXML
    private Image image;
    @FXML
    private RadioButton shipradbtn;
    @FXML
    private ToggleGroup deliveryToggleGroup;
    @FXML
    private RadioButton pickradbutton;
    @FXML
    private Label transacname1;
    @FXML
    private Label transacprice1;
    @FXML
    private Label transacquantity1;
    @FXML
    private Label transacquantity2;

    @FXML
    private Label transacquantity3;

    @FXML
    private Label transacquantity4;

    @FXML
    private Label transacquantity5;

    @FXML
    private Label transacquantity6;

    @FXML
    private Label transacquantity7;

    @FXML
    private Label transacquantity8;
    @FXML
    private Label transacprice2;

    @FXML
    private Label transacprice3;

    @FXML
    private Label transacprice4;

    @FXML
    private Label transacprice5;

    @FXML
    private Label transacprice6;

    @FXML
    private Label transacprice7;

    @FXML
    private Label transacprice8;
    @FXML
    private Label transacname2;

    @FXML
    private Label transacname3;

    @FXML
    private Label transacname4;

    @FXML
    private Label transacname5;

    @FXML
    private Label transacname6;

    @FXML
    private Label transacname7;

    @FXML
    private Label transacname8;
    @FXML
    private ImageView addImage2;

    @FXML
    private ImageView addImage3;

    @FXML
    private ImageView addImage4;

    @FXML
    private ImageView addImage5;

    @FXML
    private ImageView addImage6;

    @FXML
    private ImageView addImage7;

    @FXML
    private TextField txtlocate;

    @FXML
    private ImageView addImage8;

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private Stage stage;
    private Scene scene;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        SetUserName();
        addproductfromproduct();
        mycon();
        addproductfromcart();

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

    public void SetUserName() {
        mycon();

        itempane1.setVisible(false);
        itempane2.setVisible(false);
        itempane3.setVisible(false);
        itempane4.setVisible(false);
        itempane5.setVisible(false);
        itempane6.setVisible(false);
        itempane7.setVisible(false);
        itempane8.setVisible(false);

        try {
            pst = con.prepareStatement("Select * from user where user_name='" + getData.username + "'");
            rs = pst.executeQuery();
            if (rs.next()) {
                txtfname.setText(rs.getString("fname"));
                txtlname.setText(rs.getString("lname"));
                txtaddress.setText(rs.getString("address"));
                txtphone.setText(rs.getString("phone"));
                lbladdress.setText(rs.getString("address"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(TransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addproductfromproduct() {
        String Notocart = "NO";

        try {
            int tranprice = 0, tranquantity = 0, trantotal = 0;
            pst = con.prepareStatement("Select * from transaction where user ='" + getData.username + "' and cart='" + Notocart + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String uri = "file:" + rs.getString("image");
                itempane1.setVisible(true);

                image = new Image(uri, 125, 125, false, true);
                addImage1.setImage(image);
                transacname1.setText(rs.getString("pro_name"));
                transacprice1.setText(rs.getString("pro_price"));
                transacquantity1.setText(rs.getString("pro_quant"));

                String transacpricestring = transacprice1.getText();
                tranprice = Integer.parseInt(transacpricestring);
                String transquantitystring = transacquantity1.getText();
                tranquantity = Integer.parseInt(transquantitystring);
                trantotal = tranprice * tranquantity;
                getData.totalfromProduct = getData.totalfromProduct + trantotal;

            }

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        lblsubtotal.setText(String.valueOf(getData.totalfromProduct));
        lbltotal.setText(String.valueOf(getData.totalfromProduct));
    }

    public void addproductfromcart() {
        String Yestocart = "YES";

        int num;

        num = 1;

        try {
            pst = con.prepareStatement("Select * from transaction where cartnumber ='" + num + "' and cart='" + Yestocart + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int tranprice1 = 0, tranquantity1 = 0, trantotal1 = 0;
                String uri = "file:" + rs.getString("image");
                itempane1.setVisible(true);

                image = new Image(uri, 125, 125, false, true);
                addImage1.setImage(image);
                transacname1.setText(rs.getString("pro_name"));
                transacprice1.setText(rs.getString("pro_price"));
                transacquantity1.setText(rs.getString("pro_quant"));
                String transacpricestring1 = transacprice1.getText();
                tranprice1 = Integer.parseInt(transacpricestring1);
                String transquantitystring1 = transacquantity1.getText();
                tranquantity1 = Integer.parseInt(transquantitystring1);
                trantotal1 = tranprice1 * tranquantity1;
                getData.total = getData.total + trantotal1;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

        num = 2;

        try {
            pst = con.prepareStatement("Select * from transaction where cartnumber ='" + num + "' and cart='" + Yestocart + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int tranprice2 = 0, tranquantity2 = 0, trantotal2 = 0;
                String uri = "file:" + rs.getString("image");
                itempane2.setVisible(true);

                image = new Image(uri, 125, 125, false, true);
                addImage2.setImage(image);
                transacname2.setText(rs.getString("pro_name"));
                transacprice2.setText(rs.getString("pro_price"));
                transacquantity2.setText(rs.getString("pro_quant"));
                String transacpricestring2 = transacprice2.getText();
                tranprice2 = Integer.parseInt(transacpricestring2);
                String transquantitystring2 = transacquantity2.getText();
                tranquantity2 = Integer.parseInt(transquantitystring2);
                trantotal2 = tranprice2 * tranquantity2;
                getData.total = getData.total + trantotal2;

            }

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        num = 3;
        try {
            pst = con.prepareStatement("Select * from transaction where cartnumber ='" + num + "' and cart='" + Yestocart + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int tranprice3 = 0, tranquantity3 = 0, trantotal3 = 0;
                String uri = "file:" + rs.getString("image");
                itempane3.setVisible(true);

                image = new Image(uri, 125, 125, false, true);
                addImage3.setImage(image);
                transacname3.setText(rs.getString("pro_name"));
                transacprice3.setText(rs.getString("pro_price"));
                transacquantity3.setText(rs.getString("pro_quant"));
                String transacpricestring3 = transacprice3.getText();
                tranprice3 = Integer.parseInt(transacpricestring3);
                String transquantitystring3 = transacquantity3.getText();
                tranquantity3 = Integer.parseInt(transquantitystring3);
                trantotal3 = tranprice3 * tranquantity3;
                getData.total = getData.total + trantotal3;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

        num = 4;

        try {
            pst = con.prepareStatement("Select * from transaction where cartnumber ='" + num + "' and cart='" + Yestocart + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int tranprice4 = 0, tranquantity4 = 0, trantotal4 = 0;
                String uri = "file:" + rs.getString("image");
                itempane4.setVisible(true);

                image = new Image(uri, 125, 125, false, true);
                addImage4.setImage(image);
                transacname4.setText(rs.getString("pro_name"));
                transacprice4.setText(rs.getString("pro_price"));
                transacquantity4.setText(rs.getString("pro_quant"));
                String transacpricestring4 = transacprice4.getText();
                String transquantitystring4 = transacquantity4.getText();
                tranprice4 = Integer.parseInt(transacpricestring4);
                tranquantity4 = Integer.parseInt(transquantitystring4);
                trantotal4 = tranprice4 * tranquantity4;
                getData.total = getData.total + trantotal4;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

        num = 5;

        try {
            pst = con.prepareStatement("Select * from transaction where cartnumber ='" + num + "' and cart='" + Yestocart + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int tranprice5 = 0, tranquantity5 = 0, trantotal5 = 0;
                String uri = "file:" + rs.getString("image");
                itempane5.setVisible(true);

                image = new Image(uri, 125, 125, false, true);
                addImage5.setImage(image);
                transacname5.setText(rs.getString("pro_name"));
                transacprice5.setText(rs.getString("pro_price"));
                transacquantity5.setText(rs.getString("pro_quant"));
                String transacpricestring5 = transacprice5.getText();
                String transquantitystring5 = transacquantity5.getText();
                tranprice5 = Integer.parseInt(transacpricestring5);
                tranquantity5 = Integer.parseInt(transquantitystring5);
                trantotal5 = tranprice5 * tranquantity5;
                getData.total = getData.total + trantotal5;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

        num = 6;

        try {
            pst = con.prepareStatement("Select * from transaction where cartnumber ='" + num + "' and cart='" + Yestocart + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int tranprice6 = 0, tranquantity6 = 0, trantotal6 = 0;
                String uri = "file:" + rs.getString("image");
                itempane6.setVisible(true);

                image = new Image(uri, 125, 125, false, true);
                addImage6.setImage(image);
                transacname6.setText(rs.getString("pro_name"));
                transacprice6.setText(rs.getString("pro_price"));
                transacquantity6.setText(rs.getString("pro_quant"));
                String transacpricestring6 = transacprice6.getText();
                String transquantitystring6 = transacquantity6.getText();
                tranprice6 = Integer.parseInt(transacpricestring6);
                tranquantity6 = Integer.parseInt(transquantitystring6);
                trantotal6 = tranprice6 * tranquantity6;
                getData.total = getData.total + trantotal6;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

        num = 7;

        try {
            pst = con.prepareStatement("Select * from transaction where cartnumber ='" + num + "' and cart='" + Yestocart + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int tranprice7 = 0, tranquantity7 = 0, trantotal7 = 0;
                String uri = "file:" + rs.getString("image");
                itempane7.setVisible(true);

                image = new Image(uri, 125, 125, false, true);
                addImage7.setImage(image);
                transacname7.setText(rs.getString("pro_name"));
                transacprice7.setText(rs.getString("pro_price"));
                transacquantity7.setText(rs.getString("pro_quant"));
                String transacpricestring7 = transacprice7.getText();
                String transquantitystring7 = transacquantity7.getText();
                tranprice7 = Integer.parseInt(transacpricestring7);
                tranquantity7 = Integer.parseInt(transquantitystring7);
                trantotal7 = tranprice7 * tranquantity7;
                getData.total = getData.total + trantotal7;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

        num = 8;

        try {
            pst = con.prepareStatement("Select * from transaction where cartnumber ='" + num + "' and cart='" + Yestocart + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int tranprice8 = 0, tranquantity8 = 0, trantotal8 = 0;
                String uri = "file:" + rs.getString("image");
                itempane8.setVisible(true);

                image = new Image(uri, 125, 125, false, true);
                addImage8.setImage(image);
                transacname8.setText(rs.getString("pro_name"));
                transacprice8.setText(rs.getString("pro_price"));
                transacquantity8.setText(rs.getString("pro_quant"));
                String transacpricestring8 = transacprice8.getText();
                String transquantitystring8 = transacquantity8.getText();
                tranprice8 = Integer.parseInt(transacpricestring8);
                tranquantity8 = Integer.parseInt(transquantitystring8);
                trantotal8 = tranprice8 * tranquantity8;
                getData.total = getData.total + trantotal8;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

        lblsubtotal.setText(String.valueOf(getData.total));
        lbltotal.setText(String.valueOf(getData.total));
    }

    @FXML
    private void exitToHome(MouseEvent event) throws Exception {

        try {
            pst = con.prepareStatement("delete from transaction where user=?");
            pst.setString(1, getData.username);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        getData.totalfromProduct = 0;
        getData.total = 0;
        Parent root = FXMLLoader.load(getClass().getResource("Receipt.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();

    }

    @FXML
    private void Btnbarcode(ActionEvent event) throws IOException {
        if (!codradbtn.isSelected() && !gcashradbtn.isSelected()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please pick your payment method first!");
            alert.show();
            return;
        }
        String barcode1, barcode2, barcode3, barcode4, barcode5, barcode6, barcode7, barcode8;
        String barcodeprice1, barcodeprice2, barcodeprice3, barcodeprice4, barcodeprice5, barcodeprice6, barcodeprice7, barcodeprice8;
        String barcodequantity1, barcodequantity2, barcodequantity3, barcodequantity4, barcodequantity5, barcodequantity6, barcodequantity7, barcodequantity8;
        
        try {
            if (checkbox8.isSelected()) {
                getData.productnumber = getData.productnumber + 1;

                PreparedStatement pst1 = con.prepareStatement("Insert into history(fname, lname, address, username, phone, payment, productNam, productQuant, productPrice, productorder)VALUES(?,?,?,?,?,?,?,?,?,?)");
                pst1.setString(1, txtfname.getText());
                pst1.setString(2, txtlname.getText());
                pst1.setString(3, txtaddress.getText());
                pst1.setString(4, getData.username);
                pst1.setString(5, txtphone.getText());
                if (codradbtn.isSelected()) {
                    pst1.setString(6, codradbtn.getText());
                }
                if (gcashradbtn.isSelected()) {
                    pst1.setString(6, gcashradbtn.getText());

                }
                pst1.setString(7, transacname8.getText());
                pst1.setString(8, transacprice8.getText());
                pst1.setString(9, transacquantity8.getText());
                pst1.setInt(10, getData.productnumber);
                pst1.executeUpdate();
                barcode8 = " Product: " + transacname8.getText();
                barcodeprice8 = " Quantity: " + transacquantity8.getText();
                barcodequantity8 = " Price: " + transacprice8.getText();
            }
            if (checkbox7.isSelected()) {
                getData.productnumber = getData.productnumber + 1;

                PreparedStatement pst1 = con.prepareStatement("Insert into history(fname, lname, address, username, phone, payment, productNam, productQuant, productPrice, productorder)VALUES(?,?,?,?,?,?,?,?,?,?)");
                pst1.setString(1, txtfname.getText());
                pst1.setString(2, txtlname.getText());
                pst1.setString(3, txtaddress.getText());
                pst1.setString(4, getData.username);
                pst1.setString(5, txtphone.getText());
                if (codradbtn.isSelected()) {
                    pst1.setString(6, codradbtn.getText());
                }
                if (gcashradbtn.isSelected()) {
                    pst1.setString(6, gcashradbtn.getText());

                }
                pst1.setString(7, transacname7.getText());
                pst1.setString(8, transacprice7.getText());
                pst1.setString(9, transacquantity7.getText());
                pst1.setInt(10, getData.productnumber);
                pst1.executeUpdate();
                barcode7 = " Product: " + transacname8.getText();
                barcodeprice7 = " Quantity: " + transacquantity8.getText();
                barcodequantity7 = " Price: " + transacprice8.getText();

            }
            if (checkbox6.isSelected()) {
                getData.productnumber = getData.productnumber + 1;

                PreparedStatement pst1 = con.prepareStatement("Insert into history(fname, lname, address, username, phone, payment, productNam, productQuant, productPrice, productorder)VALUES(?,?,?,?,?,?,?,?,?,?)");
                pst1.setString(1, txtfname.getText());
                pst1.setString(2, txtlname.getText());
                pst1.setString(3, txtaddress.getText());
                pst1.setString(4, getData.username);
                pst1.setString(5, txtphone.getText());
                if (codradbtn.isSelected()) {
                    pst1.setString(6, codradbtn.getText());
                }
                if (gcashradbtn.isSelected()) {
                    pst1.setString(6, gcashradbtn.getText());

                }
                pst1.setString(7, transacname6.getText());
                pst1.setString(8, transacprice6.getText());
                pst1.setString(9, transacquantity6.getText());
                pst1.setInt(10, getData.productnumber);
                pst1.executeUpdate();
                barcode6 = " Product: " + transacname5.getText();
                barcodeprice6 = " Quantity: " + transacquantity5.getText();
                barcodequantity6 = " Price: " + transacprice6.getText();

            }

            if (checkbox5.isSelected()) {
                getData.productnumber = getData.productnumber + 1;

                PreparedStatement pst1 = con.prepareStatement("Insert into history(fname, lname, address, username, phone, payment, productNam, productQuant, productPrice, productorder)VALUES(?,?,?,?,?,?,?,?,?,?)");
                pst1.setString(1, txtfname.getText());
                pst1.setString(2, txtlname.getText());
                pst1.setString(3, txtaddress.getText());
                pst1.setString(4, getData.username);
                pst1.setString(5, txtphone.getText());
                if (codradbtn.isSelected()) {
                    pst1.setString(6, codradbtn.getText());
                }
                if (gcashradbtn.isSelected()) {
                    pst1.setString(6, gcashradbtn.getText());

                }
                pst1.setString(7, transacname5.getText());
                pst1.setString(8, transacprice5.getText());
                pst1.setString(9, transacquantity5.getText());
                pst1.setInt(10, getData.productnumber);
                pst1.executeUpdate();
                barcode5 = " Product: " + transacname5.getText();
                barcodeprice5 = " Quantity: " + transacquantity5.getText();
                barcodequantity5 = " Price: " + transacprice5.getText();

            }
            if (checkbox4.isSelected()) {
                getData.productnumber = getData.productnumber + 1;

                PreparedStatement pst1 = con.prepareStatement("Insert into history(fname, lname, address, username, phone, payment, productNam, productQuant, productPrice, productorder)VALUES(?,?,?,?,?,?,?,?,?,?)");
                pst1.setString(1, txtfname.getText());
                pst1.setString(2, txtlname.getText());
                pst1.setString(3, txtaddress.getText());
                pst1.setString(4, getData.username);
                pst1.setString(5, txtphone.getText());
                if (codradbtn.isSelected()) {
                    pst1.setString(6, codradbtn.getText());
                }
                if (gcashradbtn.isSelected()) {
                    pst1.setString(6, gcashradbtn.getText());

                }
                pst1.setString(7, transacname4.getText());
                pst1.setString(8, transacprice4.getText());
                pst1.setString(9, transacquantity4.getText());
                pst1.setInt(10, getData.productnumber);
                pst1.executeUpdate();
                barcode4 = " Product: " + transacname4.getText();
                barcodeprice4 = " Quantity: " + transacquantity4.getText();
                barcodequantity4 = " Price: " + transacprice4.getText();
            }
            if (checkbox3.isSelected()) {
                getData.productnumber = getData.productnumber + 1;

                PreparedStatement pst1 = con.prepareStatement("Insert into history(fname, lname, address, username, phone, payment, productNam, productQuant, productPrice, productorder)VALUES(?,?,?,?,?,?,?,?,?,?)");
                pst1.setString(1, txtfname.getText());
                pst1.setString(2, txtlname.getText());
                pst1.setString(3, txtaddress.getText());
                pst1.setString(4, getData.username);
                pst1.setString(5, txtphone.getText());
                if (codradbtn.isSelected()) {
                    pst1.setString(6, codradbtn.getText());
                }
                if (gcashradbtn.isSelected()) {
                    pst1.setString(6, gcashradbtn.getText());

                }
                pst1.setString(7, transacname3.getText());
                pst1.setString(8, transacprice3.getText());
                pst1.setString(9, transacquantity3.getText());
                pst1.setInt(10, getData.productnumber);
                pst1.executeUpdate();
                barcode3 = " Product: " + transacname3.getText();
                barcodeprice3 = " Quantity: " + transacquantity3.getText();
                barcodequantity3 = " Price: " + transacprice3.getText();

            }
            if (checkbox2.isSelected()) {
                getData.productnumber = getData.productnumber + 1;

                PreparedStatement pst1 = con.prepareStatement("Insert into history(fname, lname, address, username, phone, payment, productNam, productQuant, productPrice, productorder)VALUES(?,?,?,?,?,?,?,?,?,?)");
                pst1.setString(1, txtfname.getText());
                pst1.setString(2, txtlname.getText());
                pst1.setString(3, txtaddress.getText());
                pst1.setString(4, getData.username);
                pst1.setString(5, txtphone.getText());
                if (codradbtn.isSelected()) {
                    pst1.setString(6, codradbtn.getText());
                }
                if (gcashradbtn.isSelected()) {
                    pst1.setString(6, gcashradbtn.getText());

                }
                pst1.setString(7, transacname2.getText());
                pst1.setString(8, transacprice2.getText());
                pst1.setString(9, transacquantity2.getText());
                pst1.setInt(10, getData.productnumber);
                pst1.executeUpdate();
                barcode2 = " Product: " + transacname2.getText();
                barcodeprice2 = " Quantity: " + transacquantity2.getText();
                barcodequantity2 = " Price: " + transacprice2.getText();

            }
            if (checkbox1.isSelected()) {
                getData.productnumber = getData.productnumber + 1;

                PreparedStatement pst1 = con.prepareStatement("Insert into history(fname, lname, address, username, phone, payment, productNam, productQuant, productPrice, productorder)VALUES(?,?,?,?,?,?,?,?,?,?)");
                pst1.setString(1, txtfname.getText());
                pst1.setString(2, txtlname.getText());
                pst1.setString(3, txtaddress.getText());
                pst1.setString(4, getData.username);
                pst1.setString(5, txtphone.getText());
                if (codradbtn.isSelected()) {
                    pst1.setString(6, codradbtn.getText());
                }
                if (gcashradbtn.isSelected()) {
                    pst1.setString(6, gcashradbtn.getText());

                }
                pst1.setString(7, transacname1.getText());
                pst1.setString(8, transacprice1.getText());
                pst1.setString(9, transacquantity1.getText());
                pst1.setInt(10, getData.productnumber);
                pst1.executeUpdate();
                                barcode1 = " Product: " + transacname1.getText();
                barcodeprice1 = " Quantity: " + transacquantity1.getText();
                barcodequantity1 = " Price: " + transacprice1.getText();


            }
            pst = con.prepareStatement("delete from transaction where user=?");
            pst.setString(1, getData.username);
            pst.executeUpdate();
            Linear barcode = new Linear();
            barcode.setType(Linear.CODE128B);
            barcode.setData(" Address: " + txtaddress.getText() +" Product: " + transacname1.getText()+ " Quantity: " + transacquantity1.getText() + " Price: " + transacprice1.getText()+" Product: " + transacname2.getText()+ " Quantity: " + transacquantity2.getText() + " Price: " + transacprice2.getText()+" Product: " + transacname3.getText()+ " Quantity: " + transacquantity3.getText() + " Price: " + transacprice3.getText()+" Product: " + transacname4.getText()+ " Quantity: " + transacquantity4.getText() + " Price: " + transacprice4.getText()+" Product: " + transacname5.getText()+ " Quantity: " + transacquantity5.getText() + " Price: " + transacprice5.getText()+" Product: " + transacname6.getText()+ " Quantity: " + transacquantity6.getText() + " Price: " + transacprice6.getText()+" Product: " + transacname7.getText()+ " Quantity: " + transacquantity7.getText() + " Price: " + transacprice7.getText()+" Product: " + transacname8.getText()+ " Quantity: " + transacquantity8.getText() + " Price: " + transacprice8.getText());
            barcode.setI(11.0f);

            String fname = getData.username;
            String path = "C:\\Users\\Angelica S. Fernando\\OneDrive\\Desktop\\box\\" + fname + ".png";
            barcode.renderBarcode(path);
            int num =1;
            PreparedStatement pst2 = con.prepareStatement("Update history set barcode=? where productorder = '"+num+"'");
            pst2.setString(1, path);
            pst2.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception e) {
            e.printStackTrace();
        }

        getData.totalfromProduct = 0;
        getData.total = 0;
        Parent root = FXMLLoader.load(getClass().getResource("Receipt.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();

    }

}
