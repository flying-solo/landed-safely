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
    private final ArrayList<Admin> data;

    public AdmGridModel(ArrayList<Admin> data) {
        this.columns = new String[] {
            "Username", "Employee Name", "Date Registered", "Permit"
        };
        this.data = data;
    }
    
    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
