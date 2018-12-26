/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib.Models.tableModels;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import lds.lib.Entities.Admin;


public class AdmGridModel extends AbstractTableModel {
    private final String[] columns;
    private ArrayList<Admin> data;

    public AdmGridModel(ArrayList<Admin> data) {
        this.columns = new String[] {
            "Username", "Employee Name", "Date Registered", "Permit"
        };
        this.data = data;
    }
    
    public void setData(ArrayList<Admin> data) {
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
        String permit;
        if(this.data.get(row).getPermit() == 1) {
            permit = "Superuser";
        } else {
            permit = "Administrator";
        }
        
        Object tmp = null;
        switch(col) {
            case 0: tmp = this.data.get(row).getUsername(); break;
            case 1: tmp = this.data.get(row).getEmployee(); break;
            case 2: tmp = this.data.get(row).getDate_reg(); break;
            case 3: tmp = permit; break;
            case 4: tmp = this.data.get(row).getId_admin(); break;
            case 5: tmp = this.data.get(row).getPermit(); break;
        }
        return tmp;
    }

    @Override
    public String getColumnName(int col) {
        return this.columns[col];
    }

    @Override
    public Class<?> getColumnClass(int col) {
        if(col == 4) {
            return Integer.class;
        }
        return String.class;
    }
        
}
