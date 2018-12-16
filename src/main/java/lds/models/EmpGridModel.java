/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.models;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import lds.entities.Employee;


public class EmpGridModel extends AbstractTableModel {
    private final String[] columns;
    private ArrayList<Employee> data;
    private int rows;
    
    public EmpGridModel(ArrayList<Employee> data) {
        this.columns = new String[] {
            "Name", "Gender", "Email", "Address", "Phone", "Position", "Status"
        };
        this.data = data;
        this.rows = -1;
    }
    
    public void setData(ArrayList<Employee> data) {
        this.data = data;
    }
    
    public void setRowCount(int count) {
        this.rows = count;
    }
    
    @Override
    public int getColumnCount() {
        return this.columns.length;
    }

    @Override
    public int getRowCount() {
        if(this.rows == -1) {
            this.rows = this.data.size();
        } else if(this.data.isEmpty()) {
            this.rows = 0;
        }
        return this.rows;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Object tmp = null;
        switch(col) {
            case 0 : tmp = this.data.get(row).toString(); break;
            case 1 : tmp = this.data.get(row).getGender(); break;
            case 2 : tmp = this.data.get(row).getEmail(); break;
            case 3 : tmp = this.data.get(row).getAddress(); break;
            case 4 : tmp = this.data.get(row).getPhone(); break;
            case 5 : tmp = this.data.get(row).getPosition(); break;
            case 6 : tmp = this.data.get(row).getActivation(); break;
            case 7 : tmp = this.data.get(row).getId(); break;
        }
        return tmp;
    }

    @Override
    public String getColumnName(int col) {
        return columns[col];
    }

    @Override
    public Class<?> getColumnClass(int col) {
        if(col == 7) {
            return Integer.class;
        } else {
            return String.class;
        }
    }
}
