/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautyparlour.daoImpl;

import beautyparlour.bean.CustomerBean;
import beautyparlour.bean.DailyReportBean;
import beautyparlour.dao.ReportDao;
import beautyparlour.db.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class ReportDaoImpl implements ReportDao {

    public Connection con = DbConnection.conn;

    @Override
    public ArrayList<DailyReportBean> getDailyReportBean(String date) {
        ArrayList<DailyReportBean> dailyReportList = new ArrayList<>();
        try {
            String query = "SELECT s.`sale_id`, c.`customer_name`,s.`sale_date`,s.`total_bill` "
                    + "FROM customer c, sale s WHERE c.`customer_id`=s.`customer_id` "
                    + "AND s.`sale_date`= '" + date + "' ORDER BY s.`sale_id`;";
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int sale_id = rs.getInt("sale_id");
                String customer_name = rs.getString("customer_name");
                String sale_date = rs.getString("sale_date");
                double total_bill = rs.getDouble("total_bill");

                dailyReportList.add(new DailyReportBean(sale_id, customer_name, sale_date, total_bill));

            }
        } catch (Exception e) {
            System.out.println("Error in getting DailyReport");
            e.printStackTrace();
        }

        return dailyReportList;

    }

    @Override
    public ArrayList<DailyReportBean> getMonthlyReportBean(String month, String year) {
        ArrayList<DailyReportBean> monthly_report_list = new ArrayList<>();
        System.out.println(""+month);
                System.out.println(""+year);

        String ex = "";
        int month_num = Integer.parseInt(month);
        if (month_num < 10) {
            ex = "0";
        }
        try {
            String query = "SELECT s.`sale_id`, c.`customer_name`,s.`sale_date`,s.`total_bill` "
                    + "FROM customer c, sale s WHERE c.`customer_id`=s.`customer_id` AND"
                    + " strftime('%m', s.`sale_date`) ='"+ex+""+month+"'"
                    + "AND strftime('%Y', s.`sale_date`)= '" + year + "';";
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int sale_id = rs.getInt("sale_id");
                String customer_name = rs.getString("customer_name");
                String sale_date = rs.getString("sale_date");
                double total_bill = rs.getDouble("total_bill");

                monthly_report_list.add(new DailyReportBean(sale_id, customer_name, sale_date, total_bill));

            }
        } catch (Exception e) {
            System.out.println("Error in getting DailyReport");
            e.printStackTrace();
        }

        return monthly_report_list;

    }
    
    
        @Override
    public ArrayList<DailyReportBean> getAllReportBean() {
ArrayList<DailyReportBean> dailyReportList = new ArrayList<>();
        try {
            String query = "SELECT s.`sale_id`, c.`customer_name`,s.`sale_date`,s.`total_bill` "
                    + "FROM customer c, sale s WHERE c.`customer_id`=s.`customer_id` "
                    + " ORDER BY s.`sale_id`;";
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int sale_id = rs.getInt("sale_id");
                String customer_name = rs.getString("customer_name");
                String  sale_date = rs.getString("sale_date");
                double total_bill = rs.getDouble("total_bill");

               

                dailyReportList.add(new DailyReportBean(sale_id, customer_name, sale_date, total_bill));

            }
        } catch (Exception e) {
            System.out.println("Error in getting DailyReport");
            e.printStackTrace();
        }

        return dailyReportList;
    
    }

    
    
    

}
