/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautyparlour.dao;

import beautyparlour.bean.ProductSaleBean;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public interface ProductSaleDao {

    public int saveSale(ProductSaleBean psb);

    public ArrayList<ProductSaleBean> getAllProductSales();

    public int modifySale(ProductSaleBean psb);

    public ProductSaleBean getProductSaleById(int prodSaleId);

    public ArrayList<ProductSaleBean> getAllSalesByCustomId(int custoId);

    public int deleteProductSale(Integer id);

    public int getProductSaleId();

}
