/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautyparlour.daoImpl;

import beautyparlour.bean.CustomerBean;
import beautyparlour.bean.ServiceBeans;
import beautyparlour.dao.CustomerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import beautyparlour.db.DbConnection;

/**
 *
 * @author Dell
 */
public class CustomerDaoImpl implements CustomerDao {

   // public Connection con = SqliteDBCon.LoadDb();
     public Connection con = DbConnection.conn;

    @Override
    public int addCustomer(CustomerBean customerBeans) {
        int i = 0;
        String query = "INSERT INTO customer ( `customer_name`, `customer_contact`, `customer_address`, `customer_inserted_date`,customer_debt) VALUES ( ?, ?, ?,?,?); ";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, customerBeans.getCustomer_name());
            ps.setString(2, customerBeans.getCustomer_contact());
            ps.setString(3, customerBeans.getCustomer_address());
            ps.setString(4, customerBeans.getCustomer_inserted_date());
             ps.setDouble(5, customerBeans.getCustomer_dept());
           
           

            i = ps.executeUpdate();

        } catch (Exception e) {

            System.out.println("Error in saving Customer");
            e.printStackTrace();
        }
        return i;

    }

    @Override
    public ArrayList<CustomerBean> getAllCustomer() {
          
        ArrayList<CustomerBean> customer_list = new ArrayList<>();
        try {
            String query = "SELECT * FROM Customer WHERE customer_active=1";
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int customer_id = rs.getInt("customer_id");
                String customer_name = rs.getString("customer_name");
                String  customer_contact = rs.getString("customer_contact");
                String  customer_address = rs.getString("customer_address");
                int customer_active = rs.getInt("customer_active");
                String customer_inserted_date = rs.getString("customer_inserted_date");
                double customer_dept = rs.getDouble("customer_debt");

               

                customer_list.add(new CustomerBean(customer_id, customer_name, customer_contact, customer_address, customer_inserted_date, customer_active, customer_dept));

            }
        } catch (Exception e) {
            System.out.println("Error in getting Customer");
            e.printStackTrace();
        }

        return customer_list;
    
    }

    @Override
    public int updateCustomer(CustomerBean customerBeans) {
     int i = 0;
        String query = "UPDATE customer SET `customer_name` = ? , `customer_contact` = ? ,"
                + " `customer_address` = ?,customer_inserted_date=?,`customer_debt` = ?  WHERE `customer_id` = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, customerBeans.getCustomer_name());
            ps.setString(2, customerBeans.getCustomer_contact());
            ps.setString(3, customerBeans.getCustomer_address());
            
            ps.setString(4, customerBeans.getCustomer_inserted_date());
            ps.setDouble(5, customerBeans.getCustomer_dept());
            ps.setInt(6, customerBeans.getCustomer_id());
          

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in modification of Customer");
            e.printStackTrace();
        }
        return i;

    }

    @Override
    public int deleteCustomer(CustomerBean customerBeans) {
           int i = 0;
        String query = "UPDATE customer SET `customer_active` = '0' WHERE `customer_id` = ?  ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, customerBeans.getCustomer_id());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in deletion of Service");
            e.printStackTrace();
        }
        return i;

    }

     @Override
    public CustomerBean getCustomerById(int customer_id) {
        CustomerBean customerBeans = null;
        try {
            String query = "SELECT * FROM customer WHERE customer_active=1 AND customer_id= "+customer_id;
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int customer_id1 = rs.getInt("customer_id");
                String customer_name = rs.getString("customer_name");
                String customer_contact = rs.getString("customer_contact");
                String customer_address = rs.getString("customer_address");
                String customer_inserted_date= rs.getString("customer_inserted_date");
                  int customer_active = rs.getInt("customer_active");
                double customer_dept= rs.getDouble("customer_debt");
             
                customerBeans =new CustomerBean(customer_id1, customer_name, customer_contact, customer_address, customer_inserted_date, customer_active, customer_dept);
                

            }
        } catch (Exception e) {
            System.out.println("Error in getting customer");
            e.printStackTrace();
        }

        return customerBeans;

    }
    
        @Override
    public Double getCustomerDebtByCustomerId(int cust_id) {
        Double debt = 0.0;
        try {
            String query = "SELECT customer_debt FROM customer WHERE customer_id=" + cust_id;
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                debt = rs.getDouble("customer_debt");

            }
        } catch (Exception e) {
            System.out.println("Error in getting Customer debt by customer id");
            e.printStackTrace();
        }

        return debt;
    }

    @Override
    public int modifyCustomerDebt(int cust_id, double updatedDebt) {

        int i = 0;
        String query = "UPDATE customer SET customer_debt = "+updatedDebt+" "
                + "WHERE `customer_id` = "+cust_id;
        try {
            PreparedStatement ps = con.prepareStatement(query);

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in modification of Customer");
            e.printStackTrace();
        }
        return i;

    }

    
    
    
    

}
