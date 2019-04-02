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
public class ProductSaleDetailBean  implements  Serializable{
    private Integer prodSaleDetailId;
    private ProductSaleBean productSaleBean;
    private InventoryBean inventoryBean;
    private double cost;
    private double totalCost;
    private Integer quantity;
    private String createdAt;
    private Integer active;
    private CustomerBean customerBean;
    public ProductSaleDetailBean() {
    }

    public Integer getProdSaleDetailId() {
        return prodSaleDetailId;
    }

    public void setProdSaleDetailId(Integer prodSaleDetailId) {
        this.prodSaleDetailId = prodSaleDetailId;
    }

    public ProductSaleBean getProductSaleBean() {
        return productSaleBean;
    }

    public void setProductSaleBean(ProductSaleBean productSaleBean) {
        this.productSaleBean = productSaleBean;
    }

    public InventoryBean getInventoryBean() {
        return inventoryBean;
    }

    public void setInventoryBean(InventoryBean inventoryBean) {
        this.inventoryBean = inventoryBean;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "ProductSaleDetailBean{" + "prodSaleDetailId=" + prodSaleDetailId + ", productSaleBean=" + productSaleBean + ", inventoryBean=" + inventoryBean + ", cost=" + cost + ", totalCost=" + totalCost + ", quantity=" + quantity + ", createdAt=" + createdAt + ", active=" + active + '}';
    }

    public CustomerBean getCustomerBean() {
        return customerBean;
    }

    public void setCustomerBean(CustomerBean customerBean) {
        this.customerBean = customerBean;
    }
    
    
    
}
