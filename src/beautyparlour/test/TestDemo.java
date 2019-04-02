/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautyparlour.test;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import beautyparlour.db.DbConnection;
import java.util.Enumeration;

/**
 *
 * @author hp
 */
public class TestDemo {
    
     private static Connection con = DbConnection.conn;
     
    public int saveCustomer(int num) {
     
        int i = 0;
        String query = "INSERT INTO `beautyparlour`.`customer` (`customer_id`, `customer_name`, `customer_contact`, `customer_address`, `customer_inserted_date`, `customer_debt`) VALUES ( 'Rabia baji "+num+" ', '030982919"+num+"', 'Hussainabad', '2018-06-13', '0.0000'); ;";
        try {
                Statement statement = con.createStatement();
            

            i = statement.executeUpdate(query);

        } catch (Exception e) {

            System.out.println("Error in saving Customer");
            e.printStackTrace();
        }
        return i;
    }
  
    
    public String showMac() throws SocketException{
        String macadress="";
    	 final Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
        while (e.hasMoreElements()) {
            final byte [] mac = e.nextElement().getHardwareAddress();
            if (mac != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < mac.length; i++)
                    sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
               macadress= sb.toString();
            }
        }
         return macadress;
    }
       
    }

