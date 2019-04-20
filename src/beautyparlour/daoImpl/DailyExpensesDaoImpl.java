/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautyparlour.daoImpl;

import beautyparlour.bean.DailyExpenseBean;
import beautyparlour.bean.InventoryBean;
import beautyparlour.dao.DailyExpenseDao;
import beautyparlour.db.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vksoni
 */
public class DailyExpensesDaoImpl  implements DailyExpenseDao{
    public Connection con = DbConnection.conn;

    @Override
    public int addDailyExpense(DailyExpenseBean deb) {

        int i = 0;
        String query = "INSERT INTO daily_expense ( `item`, `amount`, `created_at`) VALUES ( ?, ?, ?); ";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, deb.getItem());
            ps.setDouble(2, deb.getAmount());
            ps.setString(3, deb.getCreatedAt());

            i = ps.executeUpdate();

        } catch (Exception e) {

            System.out.println("Error addDailyExpense");
            e.printStackTrace();
        }
        return i;    }

    @Override
    public ArrayList<DailyExpenseBean> getAllDailyExpensesByDate(String date ) {

        ArrayList<DailyExpenseBean> dailyExpenses = new ArrayList<>();
        try {
            String query = "select * from daily_expense where  active=1 and created_at='"+date+"'  order by id desc";
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                DailyExpenseBean deb = new DailyExpenseBean();
                deb.setItem(rs.getString("item"));
                deb.setDailyExpenseId(rs.getInt("id"));
                deb.setAmount(rs.getDouble("amount"));
                deb.setCreatedAt(rs.getString("created_at"));
                deb.setActive(rs.getInt("active"));
                dailyExpenses.add(deb);

            }
        } catch (Exception e) {
            System.out.println("Error in getAllDailyExpensesByDate");
            e.printStackTrace();
        }

        return dailyExpenses;

    }

    @Override
    public ArrayList<DailyExpenseBean> getAllDailyExpenses() {

        ArrayList<DailyExpenseBean> dailyExpenses = new ArrayList<>();
        try {
            String query = "select * from daily_expense where  active=1  order by id desc";
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                DailyExpenseBean deb = new DailyExpenseBean();
                deb.setItem(rs.getString("item"));
                deb.setDailyExpenseId(rs.getInt("id"));
                deb.setAmount(rs.getDouble("amount"));
                deb.setCreatedAt(rs.getString("created_at"));
                deb.setActive(rs.getInt("active"));
                dailyExpenses.add(deb);

            }
        } catch (Exception e) {
            System.out.println("Error in getAllDailyExpensesByDate");
            e.printStackTrace();
        }

        return dailyExpenses;    }

    @Override
    public int updateDailyExpense(DailyExpenseBean deb) {
        int i = 0;
        String query = "UPDATE daily_expense SET `item` = ? , `amount` = ?   WHERE `id` = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, deb.getItem());
            ps.setDouble(2, deb.getAmount());
            ps.setInt(3, deb.getDailyExpenseId());

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in updateDailyExpense");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int deleteDailyExpense(Integer id) {
int i = 0;
        String query = "UPDATE daily_expense SET `active` = 0   WHERE `id` = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
          
            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in deleteDailyExpense");
            e.printStackTrace();
        }
        return i;       }

    @Override
    public DailyExpenseBean getDailyExpenseById(int id) {
 
        DailyExpenseBean deb = new DailyExpenseBean();
        try {
            String query = "select * from daily_expense where  active=1 and id='"+id+"'  order by id desc";
            Statement ps = con.createStatement();
            
            ResultSet rs = ps.executeQuery(query);
            
            while (rs.next()) {
                deb.setItem(rs.getString("item"));
                deb.setDailyExpenseId(rs.getInt("id"));
                deb.setAmount(rs.getDouble("amount"));
                deb.setCreatedAt(rs.getString("created_at"));
                deb.setActive(rs.getInt("active"));

            }
        } catch (Exception e) {
            System.out.println("Error in getAllDailyExpensesByDate");
            e.printStackTrace();
        }

        return deb; 
    }

    @Override
    public List<DailyExpenseBean> getDailyExpenseByMonth(String month, String year) {

        String ex = "";
        int month_num = Integer.parseInt(month);
        if (month_num < 10) {
            ex = "0";
        }
        ArrayList<DailyExpenseBean> dailyExpenses = new ArrayList<>();
        try {
            String query = "select * from daily_expense where  active=1 and  strftime('%m', `created_at`)='"+ex+month+"' AND strftime('%Y', `created_at`)= '"+year+"'  order by id desc";
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                DailyExpenseBean deb = new DailyExpenseBean();
                deb.setItem(rs.getString("item"));
                deb.setDailyExpenseId(rs.getInt("id"));
                deb.setAmount(rs.getDouble("amount"));
                deb.setCreatedAt(rs.getString("created_at"));
                deb.setActive(rs.getInt("active"));
                dailyExpenses.add(deb);

            }
        } catch (Exception e) {
            System.out.println("Error in getAllDailyExpensesByDate");
            e.printStackTrace();
        }

        return dailyExpenses;     }

    
 
}
