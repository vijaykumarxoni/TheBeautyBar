/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautyparlour.dao;

import beautyparlour.bean.CustomerBean;
import beautyparlour.bean.DailyExpenseBean;
import beautyparlour.bean.UserBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vksoni
 */
public interface DailyExpenseDao {

    public int addDailyExpense(DailyExpenseBean deb);

    public ArrayList<DailyExpenseBean> getAllDailyExpensesByDate(String date);

    public ArrayList<DailyExpenseBean> getAllDailyExpenses();

    public int updateDailyExpense(DailyExpenseBean deb);

    public int deleteDailyExpense(Integer id);

    public DailyExpenseBean getDailyExpenseById(int id);

    public List<DailyExpenseBean> getDailyExpenseByMonth(String month,String year);
}
