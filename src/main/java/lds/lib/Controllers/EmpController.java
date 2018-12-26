/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib.Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import lds.lib.DAO.EmpDAO;
import lds.lib.Entities.Employee;
import lds.lib.Libs.Conn;


public class EmpController implements EmpDAO {
    
    private Employee extractResult(ResultSet rs) {
        Employee emp = new Employee();
        try {
            emp.setId(rs.getInt("id_employee"));
            emp.setLastname(rs.getString("lastname"));
            emp.setFirstname(rs.getString("firstname"));
            emp.setGender(rs.getInt("gender"));
            emp.setEmail(rs.getString("email"));
            emp.setAddress(rs.getString("address"));
            emp.setPhone(rs.getString("phone"));
            emp.setDate_reg(rs.getString("date_reg"));
            emp.setDate_upd(rs.getString("date_upd"));
            emp.setPosition(rs.getInt("position"));
            emp.setActivation(rs.getInt("activation"));
            emp.setId_admin(rs.getInt("id_admin"));
            return emp;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    @Override
    public ArrayList<Employee> getAllEmp() {
        ArrayList<Employee> result = new ArrayList<>();
        try {
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement(
                "SELECT " +
                "   E.id_employee, " +
                "   E.lastname, " +
                "   E.firstname, " +
                "   E.gender, " +
                "   E.email, " +
                "   E.address, " +
                "   E.phone, " +
                "   E.date_reg, " +
                "   E.date_upd, " +
                "   E.position, " +
                "   E.activation, " +
                "   A.id_admin " +
                "FROM t_employee AS E " +
                "LEFT JOIN t_admin AS A " +
                "   ON E.id_employee = A.id_employee "
            );
            ResultSet rs = st.executeQuery();
            
            while(rs.next()) {
                Employee emp = this.extractResult(rs);
                result.add(emp);
            }
      
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Employee> getEmpByName(String name) {
        ArrayList<Employee> result = new ArrayList<>();
        try {
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement(
                "SELECT " +
                "   E.id_employee, " +
                "   E.lastname, " +
                "   E.firstname, " +
                "   E.gender, " +
                "   E.email, " +
                "   E.address, " +
                "   E.phone, " +
                "   E.date_reg, " +
                "   E.date_upd, " +
                "   E.position, " +
                "   E.activation, " +
                "   A.id_admin " +
                "FROM t_employee AS E " +
                "LEFT JOIN t_admin AS A " +
                "   ON E.id_employee = A.id_employee " +
                "WHERE E.lastname LIKE ? OR E.firstname LIKE ?"
            );
            st.setString(1, "%"+name+"%");
            st.setString(2, "%"+name+"%");
            ResultSet rs = st.executeQuery();
            
            while(rs.next()) {
                Employee emp = this.extractResult(rs);
                result.add(emp);
            }
            
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Employee> getEmpByStatus(String status) {
        ArrayList<Employee> result = new ArrayList<>();
        try {
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement(
                "SELECT " +
                "   E.id_employee, " +
                "   E.lastname, " +
                "   E.firstname, " +
                "   E.gender, " +
                "   E.email, " +
                "   E.address, " +
                "   E.phone, " +
                "   E.date_reg, " +
                "   E.date_upd, " +
                "   E.position, " +
                "   E.activation, " +
                "   A.id_admin " +
                "FROM t_employee AS E " +
                "LEFT JOIN t_admin AS A " +
                "   ON E.id_employee = A.id_employee "+
                "WHERE E.activation = ?"
            );
            st.setString(1, status);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()) {
                Employee emp = this.extractResult(rs);
                result.add(emp);
            }
            
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Employee> getEmpByPosition(String position) {
        ArrayList<Employee> result = new ArrayList<>();
        try {
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement(
                "SELECT " +
                "   E.id_employee, " +
                "   E.lastname, " +
                "   E.firstname, " +
                "   E.gender, " +
                "   E.email, " +
                "   E.address, " +
                "   E.phone, " +
                "   E.date_reg, " +
                "   E.date_upd, " +
                "   E.position, " +
                "   E.activation, " +
                "   A.id_admin " +
                "FROM t_employee AS E " +
                "LEFT JOIN t_admin AS A " +
                "   ON E.id_employee = A.id_employee " +
                "WHERE E.position = ?"
            );
            st.setString(1, position);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()) {
                Employee emp = this.extractResult(rs);
                result.add(emp);
            }
            
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    @Override
    public Employee getEmpById(int id) {
        try {
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement(
                "SELECT " +
                "   E.id_employee, " +
                "   E.lastname, " +
                "   E.firstname, " +
                "   E.gender, " +
                "   E.email, " +
                "   E.address, " +
                "   E.phone, " +
                "   E.date_reg, " +
                "   E.date_upd, " +
                "   E.position, " +
                "   E.activation, " +
                "   A.id_admin " +
                "FROM t_employee AS E " +
                "LEFT JOIN t_admin AS A " +
                "   ON E.id_employee = A.id_employee " +
                "WHERE E.id_employee = ?"
            );
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()) {
                return this.extractResult(rs);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    @Override
    public boolean insertEmp(Employee emp) {
        try {
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement("INSERT INTO t_employee ("
                    + "lastname, firstname, gender, email, address, phone, position"
                    + ") VALUES (?, ?, ?, ?, ?, ?, ?)");
            st.setString(1, emp.getLastname());
            st.setString(2, emp.getFirstname());
            st.setInt(3, emp.getGender());
            st.setString(4, emp.getEmail());
            st.setString(5, emp.getAddress());
            st.setString(6, emp.getPhone());
            st.setInt(7, emp.getPosition());
            int i = st.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
    @Override
    public boolean updateStat(String id, String stat) {
        String newstat;
        if(stat.equalsIgnoreCase("1")) {
            newstat = "0";
        } else {
            newstat = "1";
        }
        try {
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement("UPDATE t_employee SET activation = ? WHERE id_employee = ?");
            st.setInt(1, new Integer(newstat));
            st.setInt(2, new Integer(id));
            int i = st.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updatePosition(String id, String position) {
        try {
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement("UPDATE t_employee SET position = ? WHERE id_employee = ?");
            st.setInt(1, new Integer(position));
            st.setInt(2, new Integer(id));
            int i = st.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteEmp(String id) {
        try {
            Connection con = Conn.initConn();
            Statement st = con.createStatement();
            int i = st.executeUpdate("DELETE FROM t_employee WHERE id_employee = "+ id);
            if(i == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
}
