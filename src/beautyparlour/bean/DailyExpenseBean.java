/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautyparlour.bean;

import java.io.Serializable;

/**
 *
 * @author Vksoni
 */
public class DailyExpenseBean implements  Serializable{
    
    private Integer dailyExpenseId;
    private String item;
    private double amount;
    private String createdAt;
    private Integer active;

    public DailyExpenseBean() {
    }

    public Integer getDailyExpenseId() {
        return dailyExpenseId;
    }

    public void setDailyExpenseId(Integer dailyExpenseId) {
        this.dailyExpenseId = dailyExpenseId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "DailyExpenseBean{" + "dailyExpenseId=" + dailyExpenseId + ", item=" + item + ", amount=" + amount + ", createdAt=" + createdAt + ", active=" + active + '}';
    }

    
    
}
