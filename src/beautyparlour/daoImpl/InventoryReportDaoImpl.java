/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautyparlour.daoImpl;

import beautyparlour.bean.DailyInventoryReport;
import beautyparlour.bean.InventoryBean;
import beautyparlour.dao.InventoryDao;
import beautyparlour.dao.InventoryReportsDao;
import beautyparlour.db.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vksoni
 */
public class InventoryReportDaoImpl implements InventoryReportsDao {

    public Connection con = DbConnection.conn;

    @Override
    public List<DailyInventoryReport> getTodaysSoldQtyOFInventories(String date) {

        ArrayList<DailyInventoryReport> inventories = new ArrayList<>();
        try {
            String query = "Select sum(quantity) as sum,inventory_id,created_at from product_sale_details  group by inventory_id ,created_at having created_at=\"" + date + "\"";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                DailyInventoryReport ib = new DailyInventoryReport();
                ib.setSum(rs.getInt("sum"));
                InventoryDao inventoryDao = new InventoryDaoImpl();
                ib.setInventoryBean(inventoryDao.getInventoryById(rs.getInt("inventory_id")));
                ib.setCreatedAt(rs.getString("created_at"));
                System.out.println("in get today    " + i);

                inventories.add(ib);

            }
        } catch (Exception e) {
            System.out.println("Error in getTodaysSoldQtyOFInventories");
            e.printStackTrace();
        }

        return inventories;

    }
    
    @Override
    public List<DailyInventoryReport> getSoldQtyOFInventories() {

        ArrayList<DailyInventoryReport> inventories = new ArrayList<>();
        try {
            String query = "Select sum(quantity) as sum,inventory_id,created_at from product_sale_details  group by inventory_id ,created_at";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                DailyInventoryReport ib = new DailyInventoryReport();
                ib.setSum(rs.getInt("sum"));
                InventoryDao inventoryDao = new InventoryDaoImpl();
                ib.setInventoryBean(inventoryDao.getInventoryById(rs.getInt("inventory_id")));
                ib.setCreatedAt(rs.getString("created_at"));
                System.out.println("in get today    " + i);

                inventories.add(ib);

            }
        } catch (Exception e) {
            System.out.println("Error in getSoldQtyOFInventories");
            e.printStackTrace();
        }

        return inventories;

    }

}
