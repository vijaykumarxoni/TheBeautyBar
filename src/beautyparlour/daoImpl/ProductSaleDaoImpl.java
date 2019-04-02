/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautyparlour.daoImpl;

import beautyparlour.bean.InventoryBean;
import beautyparlour.bean.ProductSaleBean;
import beautyparlour.dao.CustomerDao;
import beautyparlour.dao.ProductSaleDao;
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
public class ProductSaleDaoImpl implements ProductSaleDao {

    public Connection con = DbConnection.conn;

    @Override
    public int saveSale(ProductSaleBean psb) {

        int i = 0;
        String query = "INSERT INTO product_sale ( `customer_id`, `total_cost`, `paid`, `discount_type`,discount,created_at) VALUES ( ?, ?, ?,?,?,?); ";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, psb.getCustomerBeans().getCustomer_id());
            ps.setDouble(2, psb.getTotalCost());
            ps.setDouble(3, psb.getPaid());
            ps.setString(4, psb.getDiscountType());
            ps.setDouble(5, psb.getDiscount());
            ps.setString(6, psb.getCreatedAt());

            i = ps.executeUpdate();

        } catch (Exception e) {

            System.out.println("Error saveSale");
            e.printStackTrace();
        }
        return i;

    }

    @Override
    public ArrayList<ProductSaleBean> getAllProductSales() {

        ArrayList<ProductSaleBean> productSales = new ArrayList<>();
        try {
            String query = "SELECT * FROM product_sale WHERE active=1 order by prod_sale_id desc";
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                ProductSaleBean psb = new ProductSaleBean();
                psb.setProdSaleId(rs.getInt("prod_sale_id"));
                CustomerDao customerDao = new CustomerDaoImpl();
                psb.setCustomerBeans(customerDao.getCustomerById(rs.getInt("customer_id")));
                psb.setTotalCost(rs.getDouble("total_cost"));
                psb.setPaid(rs.getDouble("paid"));
                psb.setDiscountType(rs.getString("discount_type"));
                psb.setDiscount(rs.getDouble("discount"));
                psb.setCreatedAt(rs.getString("created_at"));
                psb.setUpdatedAt(rs.getString("updated_at"));
                psb.setActive(rs.getInt("active"));
                productSales.add(psb);

            }
        } catch (Exception e) {
            System.out.println("Error in getAllProductSales");
            e.printStackTrace();
        }

        return productSales;
    }

    @Override
    public int modifySale(ProductSaleBean psb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductSaleBean getProductSaleById(int prodSaleId) {

        ProductSaleBean psb = new ProductSaleBean();
        try {
            String query = "SELECT * FROM product_sale WHERE active=1 and prod_sale_id=" + prodSaleId;
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                psb.setProdSaleId(rs.getInt("prod_sale_id"));
                CustomerDao customerDao = new CustomerDaoImpl();
                psb.setCustomerBeans(customerDao.getCustomerById(rs.getInt("customer_id")));
                psb.setTotalCost(rs.getDouble("total_cost"));
                psb.setPaid(rs.getDouble("paid"));
                psb.setDiscountType(rs.getString("discount_type"));
                psb.setDiscount(rs.getDouble("discount"));
                psb.setCreatedAt(rs.getString("created_at"));
                psb.setUpdatedAt(rs.getString("updated_at"));
                psb.setActive(rs.getInt("active"));

            }
        } catch (Exception e) {
            System.out.println("Error in getProductSaleById");
            e.printStackTrace();
        }

        return psb;
    }

    @Override
    public ArrayList<ProductSaleBean> getAllSalesByCustomId(int custoId) {

        ArrayList<ProductSaleBean> productSales = new ArrayList<>();
        try {
            String query = "SELECT * FROM product_sale WHERE active=1 and customer_id=" + custoId + " order by prod_sale_id desc";
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                ProductSaleBean psb = new ProductSaleBean();
                psb.setProdSaleId(rs.getInt("prod_sale_id"));
                CustomerDao customerDao = new CustomerDaoImpl();
                psb.setCustomerBeans(customerDao.getCustomerById(rs.getInt("customer_id")));
                psb.setTotalCost(rs.getDouble("total_cost"));
                psb.setPaid(rs.getDouble("paid"));
                psb.setDiscountType(rs.getString("discount_type"));
                psb.setDiscount(rs.getDouble("discount"));
                psb.setCreatedAt(rs.getString("created_at"));
                psb.setUpdatedAt(rs.getString("updated_at"));
                psb.setActive(rs.getInt("active"));
                productSales.add(psb);

            }
        } catch (Exception e) {
            System.out.println("Error in getAllProductSales");
            e.printStackTrace();
        }

        return productSales;
    }

    @Override
    public int deleteProductSale(Integer id) {
        int i = 0;
        String query = "UPDATE product_sale SET `active` = '0' WHERE `prod_sale_id` = ?  ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in deleteProductSale");
            e.printStackTrace();
        }
        return i;

    }

    @Override
    public int getProductSaleId() {
        int sale_id = -1;
        try {
            String query = "SELECT prod_sale_id FROM product_sale ORDER BY prod_sale_id DESC LIMIT 1;";
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                sale_id = rs.getInt("prod_sale_id");

            }
        } catch (Exception e) {
            System.out.println("Error in getProductSaleId");
            e.printStackTrace();
        }

        return sale_id;
    }
}
