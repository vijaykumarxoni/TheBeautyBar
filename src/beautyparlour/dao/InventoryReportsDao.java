/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautyparlour.dao;

import beautyparlour.bean.DailyInventoryReport;
import java.util.List;

/**
 *
 * @author Vksoni
 */
public interface InventoryReportsDao {

    public List<DailyInventoryReport> getTodaysSoldQtyOFInventories(String date);

    public List<DailyInventoryReport> getSoldQtyOFInventories();

}
