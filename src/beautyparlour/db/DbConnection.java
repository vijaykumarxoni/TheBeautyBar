package beautyparlour.db;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class DbConnection {

    private static String url = "jdbc:mysql://localhost/beautyparlour";
    private static String user = "root";
    private static String password = "";
    public static Connection conn = null;

    public static void load() {
//        try {
//            conn = DriverManager.getConnection(url, user, password);
//            System.out.println("Connected");
//        } catch (SQLException ex) {
//            System.out.println("Error in load"+ex.getMessage());
//        }

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:beautyparlour.sql");
//    return con; 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
//    return null;
        }

    }
}
