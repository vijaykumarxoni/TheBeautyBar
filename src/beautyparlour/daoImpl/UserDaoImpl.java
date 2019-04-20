/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautyparlour.daoImpl;

import beautyparlour.bean.CustomerBean;
import beautyparlour.bean.UserBean;
import beautyparlour.dao.UserDao;
import beautyparlour.db.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Vksoni
 */
public class UserDaoImpl implements UserDao {

    public Connection con = DbConnection.conn;

    @Override
    public UserBean userAutth(UserBean ub) {
        UserBean user = new UserBean();
        try {
            String query = "select * from user where uname='" + ub.getUname() + "' and upass='" + ub.getUpass() + "'";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                user.setUserId(rs.getInt("id"));
                user.setUname(rs.getString("uname"));
                user.setUpass(rs.getString("upass"));
            }
        } catch (Exception e) {
            System.out.println("Error in userAutth");
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public int resetPass(UserBean ub, String oldPass,String oldUname) {

        int i = 0;
        String query = "UPDATE user SET `uname` = ? , `upass` = ? where upass=? and uname=? ";
        try {
            System.out.println("user"+ub.toString()+"old "+oldPass+" "+oldUname);
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, ub.getUname());
            ps.setString(2, ub.getUpass());
            ps.setString(3, oldPass);
            ps.setString(4, oldUname);
            

            i = ps.executeUpdate();
        } catch (Exception e) {

            System.out.println("Error in resetPass");
            e.printStackTrace();
        }
        return i;
    }

}
