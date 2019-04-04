/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautyparlour.dao;

import beautyparlour.bean.ProductSaleDetailBean;
import beautyparlour.bean.SaleDetailBeans;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public interface ProductSaleDetailDao {

    public int saveProductSaleDetails(ProductSaleDetailBean psdb);

    public ArrayList<ProductSaleDetailBean> getAllProductSaleDetailsByCustomerId(int customerId);

    public ArrayList<ProductSaleDetailBean> getAllProductSaleDetailsBySaleId(int prodSaleId);

    public ArrayList<ProductSaleDetailBean> getAllProductSaleDetailsByInventoryId(int id, String date);

    public int modifyProductSaleDetails(ProductSaleDetailBean psdb);

    public int deleteProductSaleDetails(int prodSaleId);

}
