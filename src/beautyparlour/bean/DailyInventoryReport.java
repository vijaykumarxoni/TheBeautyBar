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
public class DailyInventoryReport implements Serializable{
    private Integer sum;
    private InventoryBean inventoryBean;
    private String createdAt;

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public InventoryBean getInventoryBean() {
        return inventoryBean;
    }

    public void setInventoryBean(InventoryBean inventoryBean) {
        this.inventoryBean = inventoryBean;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
    
}
