/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautyparlour.daoImpl;

import beautyparlour.bean.CustomerBean;
import beautyparlour.bean.InventoryBean;
import beautyparlour.dao.InventoryDao;
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
public class InventoryDaoImpl implements InventoryDao {

    public Connection con = DbConnection.conn;

    @Override
    public int saveInventory(InventoryBean ib) {

        int i = 0;
        String query = "INSERT INTO inventory ( `inventory_name`, `actual_cost`, `selling_cost`, `quantity`,created_at) VALUES ( ?, ?, ?,?,?); ";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, ib.getInventoryName());
            ps.setDouble(2, ib.getActualCost());
            ps.setDouble(3, ib.getSellingCost());
            ps.setInt(4, ib.getQuantity());
            ps.setString(5, ib.getCreateAt());

            i = ps.executeUpdate();

        } catch (Exception e) {

            System.out.println("Error saveInventory");
            e.printStackTrace();
        }
        return i;

    }

    @Override
    public ArrayList<InventoryBean> getAllInventories() {

        ArrayList<InventoryBean> inventories = new ArrayList<>();
        try {
            String query = "SELECT * FROM inventory WHERE active=1 order by inventory_id desc";
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                InventoryBean ib = new InventoryBean();
                ib.setInventoryId(rs.getInt("inventory_id"));
                ib.setInventoryName(rs.getString("inventory_name"));
                ib.setActualCost(rs.getDouble("actual_cost"));
                ib.setSellingCost(rs.getDouble("selling_cost"));
                ib.setQuantity(rs.getInt("quantity"));
                ib.setCreateAt(rs.getString("created_at"));
                ib.setUpdatetAt(rs.getString("update_at"));
                ib.setActive(rs.getInt("active"));
                inventories.add(ib);

            }
        } catch (Exception e) {
            System.out.println("Error in getAllInventories");
            e.printStackTrace();
        }

        return inventories;
    }

    @Override
    public int modifyInventory(InventoryBean ib) {
        int i = 0;
        String query = "UPDATE inventory SET `inventory_name` = ? , `actual_cost` = ? ,"
                + " `selling_cost` = ?,quantity=?,`update_at` = ?  WHERE `inventory_id` = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, ib.getInventoryName());
            ps.setDouble(2, ib.getActualCost());
            ps.setDouble(3, ib.getSellingCost());
            ps.setInt(4, ib.getQuantity());
            ps.setString(5, ib.getUpdatetAt());
            ps.setInt(6, ib.getInventoryId());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in modifyInventory");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public InventoryBean getInventoryById(int inventoryId) {

        InventoryBean ib = new InventoryBean();
        try {
            String query = "SELECT * FROM inventory WHERE active=1 and inventory_id=" + inventoryId + " order by inventory_id desc";
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                ib.setInventoryId(rs.getInt("inventory_id"));
                ib.setInventoryName(rs.getString("inventory_name"));
                ib.setActualCost(rs.getDouble("actual_cost"));
                ib.setSellingCost(rs.getDouble("selling_cost"));
                ib.setQuantity(rs.getInt("quantity"));
                ib.setCreateAt(rs.getString("created_at"));
                ib.setUpdatetAt(rs.getString("update_at"));
                ib.setActive(rs.getInt("active"));

            }
        } catch (Exception e) {
            System.out.println("Error in getInventoryById");
            e.printStackTrace();
        }

        return ib;
    }

    @Override
    public int deleteInventory(Integer id) {
        int i = 0;
        String query = "UPDATE inventory SET `active` = '0' WHERE `inventory_id` = ?  ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in deleteInventory");
            e.printStackTrace();
        }
        return i;

    }

    @Override
    public int modifyInventoryQty(Integer id, int qty) {
        int i = 0;
        String query = "UPDATE inventory SET quantity=?  WHERE `inventory_id` = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, qty);
            ps.setInt(2, id);

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in modifyInventoryQty");
            e.printStackTrace();
        }
        return i;
    }

}
