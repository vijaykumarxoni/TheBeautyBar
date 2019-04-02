/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautyparlour.bean;

/**
 *
 * @author Dell
 */
public class MonthlyServiceReportBean {
    int service_id;
    int customers;
    String service_name;
    double amount;
    String date;

    public MonthlyServiceReportBean(int service_id, int customers, String service_name, double amount, String date) {
        this.service_id = service_id;
        this.customers = customers;
        this.service_name = service_name;
        this.amount = amount;
        this.date = date;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public int getCustomers() {
        return customers;
    }

    public void setCustomers(int customers) {
        this.customers = customers;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
           
}
