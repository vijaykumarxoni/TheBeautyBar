/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautyparlour.dao;

import beautyparlour.bean.InventoryBean;
import beautyparlour.bean.UserBean;

/**
 *
 * @author Vksoni
 */
public interface UserDao {
        public int resetPass(UserBean ub, String oldPass,String oldUname);
            public UserBean userAutth(UserBean ub);


}
