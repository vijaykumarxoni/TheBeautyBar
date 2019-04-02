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
public class InventoryBean implements Serializable {

    private Integer inventoryId;
    private String inventoryName;
    private double actualCost;
    private double sellingCost;
    private Integer quantity;
    private Integer selectedQuantity;

    private String createAt;
    private String updatetAt;
    private Integer active;

    public InventoryBean() {
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public double getActualCost() {
        return actualCost;
    }

    public void setActualCost(double actualCost) {
        this.actualCost = actualCost;
    }

    public double getSellingCost() {
        return sellingCost;
    }

    public void setSellingCost(double sellingCost) {
        this.sellingCost = sellingCost;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdatetAt() {
        return updatetAt;
    }

    public void setUpdatetAt(String updatetAt) {
        this.updatetAt = updatetAt;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }


    public Integer getSelectedQuantity() {
        return selectedQuantity;
    }

    public void setSelectedQuantity(Integer selectedQuantity) {
        this.selectedQuantity = selectedQuantity;
    }

    @Override
    public String toString() {
        return "InventoryBean{" + "inventoryId=" + inventoryId + ", inventoryName=" + inventoryName + ", actualCost=" + actualCost + ", sellingCost=" + sellingCost + ", quantity=" + quantity + ", selectedQuantity=" + selectedQuantity + ", createAt=" + createAt + ", updatetAt=" + updatetAt + ", active=" + active + '}';
    }
    

}
