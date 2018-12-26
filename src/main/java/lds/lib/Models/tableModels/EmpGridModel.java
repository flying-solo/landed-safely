/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib.Models.tableModels;

import java.util.ArrayList;
import lds.lib.Entities.Employee;
import javax.swing.table.AbstractTableModel;


public class EmpGridModel extends AbstractTableModel {
    private final String[] columns;
    private ArrayList<Employee> data;
    
    public EmpGridModel(ArrayList<Employee> data) {
        this.columns = new String[] {
            "Name", "Gender", "Email", "Address", "Phone", "Position", "Status", "Admin"
        };
        this.data = data;
    }
    
    public void setData(ArrayList<Employee> data) {
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
        String gender;
        if(this.data.get(row).getGender() == 1) {
            gender = "Laki -laki";
        } else {
            gender = "Perempuan";
        }
        
        String position;
        switch(this.data.get(row).getPosition()) {
            case 1  : position = "Courier"; break;
            case 2  : position = "Staff"; break;
            case 3  : position = "Supervisor"; break;
            default : position = "Not Positioned Yet";
        }
        
        String admin;
        if(this.data.get(row).getId_admin() > 0) {
            admin = "YES";
        } else {
            admin = "NO";
        }
        
        String status;
        if(this.data.get(row).getActivation() == 1) {
            status = "Active";
        } else {
            status = "Non-Active";
        }
        
        
        Object tmp = null;
        switch(col) {
            case 0 : tmp = this.data.get(row).toString(); break;
            case 1 : tmp = gender; break;
            case 2 : tmp = this.data.get(row).getEmail(); break;
            case 3 : tmp = this.data.get(row).getAddress(); break;
            case 4 : tmp = this.data.get(row).getPhone(); break;
            case 5 : tmp = position; break;
            case 6 : tmp = status; break;
            case 7 : tmp = admin; break;
            case 8 : tmp = this.data.get(row).getId(); break;
            case 9 : tmp = this.data.get(row).getId_admin(); break;
        }
        return tmp;
    }

    @Override
    public String getColumnName(int col) {
        return columns[col];
    }

    @Override
    public Class<?> getColumnClass(int col) {
        if(col == 8 || col == 9) {
            return Integer.class;
        } else {
            return String.class;
        }
    }
}
