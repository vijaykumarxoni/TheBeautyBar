/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautyparlour.daoImpl;

import beautyparlour.bean.ProductSaleBean;
import beautyparlour.bean.ProductSaleDetailBean;
import beautyparlour.dao.CustomerDao;
import beautyparlour.dao.InventoryDao;
import beautyparlour.dao.ProductSaleDao;
import beautyparlour.dao.ProductSaleDetailDao;
import beautyparlour.db.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public class ProductSaleDetailDaoImpl implements ProductSaleDetailDao {

    public Connection con = DbConnection.conn;

    @Override
    public int saveProductSaleDetails(ProductSaleDetailBean psdb) {

        int i = 0;
        String query = "INSERT INTO product_sale_details     ( `prod_sale_id`, `inventory_id`, `cost`, `total_cost`,quantity,created_at,customer_id) VALUES ( ?, ?, ?,?,?,?,?); ";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, psdb.getProductSaleBean().getProdSaleId());
            ps.setInt(2, psdb.getInventoryBean().getInventoryId());
            ps.setDouble(3, psdb.getCost());
            ps.setDouble(4, psdb.getTotalCost());
            ps.setInt(5, psdb.getQuantity());
            ps.setString(6, psdb.getCreatedAt());
            ps.setInt(7, psdb.getCustomerBean().getCustomer_id());

            i = ps.executeUpdate();

        } catch (Exception e) {

            System.out.println("Error saveProductSaleDetails");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public ArrayList<ProductSaleDetailBean> getAllProductSaleDetailsByCustomerId(int customerId) {

        ArrayList<ProductSaleDetailBean> productSaleDetails = new ArrayList<>();
        try {
            String query = "SELECT * FROM product_sale_details WHERE active=1 and customer_id=" + customerId;
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                ProductSaleDetailBean psdb = new ProductSaleDetailBean();
                psdb.setProdSaleDetailId(rs.getInt("prod_sale_detail_id"));
                ProductSaleDao productSaleDao = new ProductSaleDaoImpl();
                psdb.setProductSaleBean(productSaleDao.getProductSaleById(rs.getInt("prod_sale_id")));
                InventoryDao inventoryDao = new InventoryDaoImpl();
                psdb.setInventoryBean(inventoryDao.getInventoryById(rs.getInt("inventory_id")));
                psdb.setCost(rs.getDouble("cost"));
                psdb.setTotalCost(rs.getDouble("total_cost"));
                psdb.setQuantity(rs.getInt("quantity"));
                psdb.setCreatedAt(rs.getString("created_at"));
                psdb.setActive(rs.getInt("active"));
                productSaleDetails.add(psdb);

            }
        } catch (Exception e) {
            System.out.println("Error in getAllProductSaleDetailsByCustomerId");
            e.printStackTrace();
        }

        return productSaleDetails;
    }

    @Override
    public ArrayList<ProductSaleDetailBean> getAllProductSaleDetailsBySaleId(int prodSaleId) {

        ArrayList<ProductSaleDetailBean> productSaleDetails = new ArrayList<>();
        try {
            String query = "SELECT * FROM product_sale_details WHERE active=1 and prod_sale_id=" + prodSaleId;
            Statement ps = con.createStatement();
            CustomerDao customerDao = new CustomerDaoImpl();

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                ProductSaleDetailBean psdb = new ProductSaleDetailBean();
                psdb.setProdSaleDetailId(rs.getInt("prod_sale_detail_id"));
                ProductSaleDao productSaleDao = new ProductSaleDaoImpl();
                psdb.setProductSaleBean(productSaleDao.getProductSaleById(rs.getInt("prod_sale_id")));
                InventoryDao inventoryDao = new InventoryDaoImpl();
                psdb.setInventoryBean(inventoryDao.getInventoryById(rs.getInt("inventory_id")));
                psdb.setCost(rs.getDouble("cost"));
                psdb.setCustomerBean(customerDao.getCustomerById(rs.getInt("customer_id")));

                psdb.setTotalCost(rs.getDouble("total_cost"));
                psdb.setQuantity(rs.getInt("quantity"));
                psdb.setCreatedAt(rs.getString("created_at"));
                psdb.setActive(rs.getInt("active"));
                productSaleDetails.add(psdb);

            }
        } catch (Exception e) {
            System.out.println("Error in getAllProductSaleDetailsBySaleId");
            e.printStackTrace();
        }

        return productSaleDetails;
    }

    @Override
    public int modifyProductSaleDetails(ProductSaleDetailBean psdb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteProductSaleDetails(int prodSaleId) {
        int i = 0;
        String query = "UPDATE product_sale_details SET `active` = '0' WHERE `prod_sale_id` = ?  ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, prodSaleId);

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in deleteProductSaleDetails");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public ArrayList<ProductSaleDetailBean> getAllProductSaleDetailsByInventoryId(int id, String date) {

        ArrayList<ProductSaleDetailBean> productSaleDetails = new ArrayList<>();
        try {
            String query = "SELECT * FROM product_sale_details WHERE active=1  and created_at=\"" + date + "\" and  inventory_id=" + id;
            Statement ps = con.createStatement();
            CustomerDao customerDao = new CustomerDaoImpl();
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                ProductSaleDetailBean psdb = new ProductSaleDetailBean();
                psdb.setProdSaleDetailId(rs.getInt("prod_sale_detail_id"));
                ProductSaleDao productSaleDao = new ProductSaleDaoImpl();
                psdb.setProductSaleBean(productSaleDao.getProductSaleById(rs.getInt("prod_sale_id")));
                InventoryDao inventoryDao = new InventoryDaoImpl();
                psdb.setInventoryBean(inventoryDao.getInventoryById(rs.getInt("inventory_id")));
                psdb.setCost(rs.getDouble("cost"));
                psdb.setCustomerBean(customerDao.getCustomerById(rs.getInt("customer_id")));
                psdb.setTotalCost(rs.getDouble("total_cost"));
                psdb.setQuantity(rs.getInt("quantity"));
                psdb.setCreatedAt(rs.getString("created_at"));
                psdb.setActive(rs.getInt("active"));
                productSaleDetails.add(psdb);

            }
        } catch (Exception e) {
            System.out.println("Error in getAllProductSaleDetailsBySaleId");
            e.printStackTrace();
        }

        return productSaleDetails;
    }

}
