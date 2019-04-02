/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautyparlour.daoImpl;


import beautyparlour.bean.DailyReportBean;
import beautyparlour.bean.DailyServiceReportBean;
import beautyparlour.bean.MonthlyServiceReportBean;
import beautyparlour.dao.ServiceReportDao;
import beautyparlour.db.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class ServiceReportDaoImpl  implements ServiceReportDao {
      public Connection con = DbConnection.conn;

    @Override
    public ArrayList<DailyServiceReportBean> getDailyReportBean(String date) {
        ArrayList<DailyServiceReportBean> dailyReportList = new ArrayList<>();
        try {
            String query="select ser.`service_id`,COUNT(c.customer_id) AS customers  ,ser.`service_name`,sum(sd.price) AS amount from sale_detail sd INNER JOIN services ser ON sd.`service_id` = ser.`service_id` \n" +
"INNER JOIN customer c ON sd.`customer_id` = c.`customer_id`\n" +
"INNER JOIN sale sl ON sl.sale_id  = sd.sale_id\n" +
"WHERE sd.`sale_date`= '"+date+"' \n" +
"  group by sd.service_id";
           /* String query = "SELECT ser.`service_id`,COUNT(c.customer_id) AS customers ,ser.`service_name`,(sd.`price`*count(c.customer_id)) AS amount FROM sale_detail sd INNER JOIN services ser ON sd.`service_id` = ser.`service_id` \n" +
"INNER JOIN customer c ON sd.`customer_id` = c.`customer_id` \n" +
"WHERE sd.`sale_date`= '"+date+"' GROUP BY ser.`service_id`";
*/
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int customers = rs.getInt("customers");
                String service_name = rs.getString("service_name");
                double  amount = rs.getDouble("amount");
                int service_id = rs.getInt("service_id");
               

               

                dailyReportList.add(new DailyServiceReportBean(service_id, service_name, customers, amount));

            }
        } catch (Exception e) {
            System.out.println("Error in getting DailyReport");
            e.printStackTrace();
        }

        return dailyReportList;
    
    }

    @Override
    public ArrayList<MonthlyServiceReportBean> getMonthlyReportBean(String month, String year) {
        
        String ex="";
        int month_num= Integer.parseInt(month);
        if(month_num<10){
        ex="0";
        }
        ArrayList<MonthlyServiceReportBean> monthlyReportList = new ArrayList<>();
        try {
            
            String query = "SELECT ser.`service_id`,COUNT(c.customer_id) AS customers\n" +
"                     ,ser.`service_name`,sum(sd.price) \n" +
"                    AS amount, sd.`sale_date` AS 'Date' FROM sale_detail sd \n" +
"                    INNER JOIN services ser ON sd.`service_id` = ser.`service_id`\n" +
"                    INNER JOIN customer c ON sd.`customer_id` = c.`customer_id`\n" +
"                    INNER JOIN sale sl ON sl.sale_id  = sd.sale_id\n" +
                     "WHERE   strftime('%m', sd.`sale_date`) ='"+ex+""+month+"' "+
                    "AND strftime('%Y', sd.`sale_date`) ='"+year+"' GROUP BY ser.`service_id`";
//            String query = "SELECT ser.`service_id`,COUNT(c.customer_id) AS customers"
//                    + " ,ser.`service_name`,(ser.`service_cost`*COUNT(c.customer_id)) "
//                    + "AS amount, sd.`sale_date` AS 'Date' FROM sale_detail sd "
//                    + "INNER JOIN services ser ON sd.`service_id` = ser.`service_id`"
//                    + "INNER JOIN customer c ON sd.`customer_id` = c.`customer_id` "
//                    + "WHERE   strftime('%m', sd.`sale_date`) ='"+ex+""+month+"' "
//                    + "AND strftime('%Y', sd.`sale_date`) ='"+year+"' GROUP BY ser.`service_id`";
            Statement ps = con.createStatement();
            int count=0;
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                int customers = rs.getInt("customers");
                String service_name = rs.getString("service_name");
                double  amount = rs.getDouble("amount");
                int service_id = rs.getInt("service_id");
               String date= rs.getString("Date");
                System.out.println(""+count);
               count++;

               

                monthlyReportList.add(new MonthlyServiceReportBean(service_id, customers, service_name, amount, date));

            }
        } catch (Exception e) {
            System.out.println("Error in getting monthlyreport");
            e.printStackTrace();
        }

        return monthlyReportList;

    }
  
    
}
