/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib.Models.tables;

import java.util.ArrayList;
import lds.lib.Entities.Area;
import javax.swing.table.AbstractTableModel;

public class AreaGridModel extends AbstractTableModel {
    private final String[] columns;
    private ArrayList<Area> data;

    public AreaGridModel(ArrayList<Area> data) {
        this.columns = new String[] {
            "ID Area", "Province", "City/Regency", "District", "Sub-District", "Postal Code"
        };
        this.data = data;
    }

    public void setData(ArrayList<Area> data) {
        this.data = data;
    }
    
    @Override
    public int getColumnCount() {
        return this.columns.length;
    }
    
    @Override
    public int getRowCount() {
        return this.data.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        
        Object tmp = null;
        switch(col) {
            case 0: tmp = data.get(row).getId(); break;
            case 1: tmp = data.get(row).getProvince();; break;
            case 2: tmp = data.get(row).getCityregency();; break;
            case 3: tmp = data.get(row).getDistrict();; break;
            case 4: tmp = data.get(row).getSubDistrict(); break;
            case 5: tmp = data.get(row).getPostalCode(); break;
            
        }
        return tmp;
    }

    @Override
    public String getColumnName(int col) {
        return this.columns[col];
    }

    @Override
    public Class<?> getColumnClass(int col) {
        return String.class;
    }
}
