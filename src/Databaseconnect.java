
import java.sql.Connection;
import java.sql.DriverManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Databaseconnect {

    public static Connection mycon() {

        Connection con = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login1", "root", "");

        } catch (Exception e) {

            System.out.println(e);
        }

        return con;

    }

}
