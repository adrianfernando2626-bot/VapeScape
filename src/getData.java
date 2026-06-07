/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Angelica S. Fernando
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class getData {

    public static String path;
    public static String username;
    public static int cartnumber;
    public static int total;
    public static int totalfromProduct;
    public static int productnumber;
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public getData(){
        mycon();
        cartnumber();
    }
    

    public void cartnumber(){
        try {
            mycon();
            pst = con.prepareStatement("Select MAX(cartnumber) from cart)");
            rs = pst.executeQuery();
            cartnumber = Integer.parseInt(String.valueOf(rs.getString("cartnumber")));
            
        } catch (SQLException ex) {
            Logger.getLogger(getData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void mycon(){

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login1", "root", "");

        } catch (ClassNotFoundException ex) {

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
}
