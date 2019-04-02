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
public class ProductSaleBean implements Serializable{
    
    private Integer prodSaleId;
    private CustomerBean customerBeans;
    private double totalCost;
    private double paid;
    private String discountType;
    private double discount;
    private String  createdAt;
    private String updatedAt;
    private Integer active;

    public ProductSaleBean() {
    }

    public Integer getProdSaleId() {
        return prodSaleId;
    }

    public void setProdSaleId(Integer prodSaleId) {
        this.prodSaleId = prodSaleId;
    }

    public CustomerBean getCustomerBeans() {
        return customerBeans;
    }

    public void setCustomerBeans(CustomerBean customerBeans) {
        this.customerBeans = customerBeans;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
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

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "ProductSaleBean{" + "prodSaleId=" + prodSaleId + ", customerBeans=" + customerBeans + ", totalCost=" + totalCost + ", paid=" + paid + ", discountType=" + discountType + ", discount=" + discount + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", active=" + active + '}';
    }

    
    
    
    
}
