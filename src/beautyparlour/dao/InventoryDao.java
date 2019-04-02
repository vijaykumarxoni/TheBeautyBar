/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautyparlour.dao;

import beautyparlour.bean.CustomerBean;
import beautyparlour.bean.InventoryBean;
import java.util.ArrayList;

/**
 *
 * @author Vksoni
 */
public interface InventoryDao {

    public int saveInventory(InventoryBean ib);

    public ArrayList<InventoryBean> getAllInventories();

    public int modifyInventory(InventoryBean ib);

    public InventoryBean getInventoryById(int inventoryId);

    public int deleteInventory(Integer id);

    public int modifyInventoryQty(Integer id,int qty);

}
