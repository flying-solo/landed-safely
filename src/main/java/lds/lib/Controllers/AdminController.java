/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib.Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lds.lib.DAO.AdminDAO;
import lds.lib.Entities.Admin;
import lds.lib.Libs.Conn;

public class AdminController implements AdminDAO {

    private Connection con;
    
    public AdminController() {
        try {
            this.con = Conn.initConn();
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Admin extractResult(ResultSet rs) {
        try {
            Admin admin = new Admin(
                rs.getInt("id_admin"),
                rs.getInt("id_employee"),
                rs.getString("name"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("salt_value"),
                rs.getString("date_reg"),
                rs.getInt("permit")
            );
            return admin;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    @Override
    public ArrayList<Admin> getAllAdmin() {
        ArrayList<Admin> result = new ArrayList<>();
        try {
            PreparedStatement st = con.prepareStatement(
                "SELECT " +
                "    A.id_admin, " +
                "    A.id_employee, " +
                "    CONCAT(E.firstname, ' ', E.lastname) AS name, " +
                "    A.username, " +
                "    A.password, " +
                "    A.salt_value, " + 
                "    A.date_reg, " +
                "    A.permit " +
                "FROM " +
                "    t_admin AS A " +
                "LEFT JOIN t_employee AS E " +
                "ON " +
                "    A.id_employee = E.id_employee"
            );
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Admin admin = this.extractResult(rs);
                result.add(admin);
            }
            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Admin> getAdmByPermit(int permit) {
        ArrayList<Admin> result = new ArrayList<>();
        try {
            PreparedStatement st = con.prepareStatement(
                "SELECT " +
                "    A.id_admin, " +
                "    A.id_employee, " +
                "    CONCAT(E.firstname, ' ', E.lastname) AS name, " +
                "    A.username, " +
                "    A.password, " +
                "    A.salt_value, " + 
                "    A.date_reg, " +
                "    A.permit " +
                "FROM " +
                "    t_admin AS A " +
                "LEFT JOIN t_employee AS E " +
                "ON " +
                "    A.id_employee = E.id_employee " +
                "WHERE A.permit = ?"
            );
            st.setInt(1, permit);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Admin admin = this.extractResult(rs);
                result.add(admin);
            }
            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    @Override
    public ArrayList<Admin> getAdmByEmpName(String name) {
        ArrayList<Admin> result = new ArrayList<>();
        try {
            PreparedStatement st = con.prepareStatement(
                "SELECT " +
                "    A.id_admin, " +
                "    A.id_employee, " +
                "    CONCAT(E.firstname, ' ', E.lastname) AS name, " +
                "    A.username, " +
                "    A.password, " +
                "    A.salt_value, " + 
                "    A.date_reg, " +
                "    A.permit " +
                "FROM " +
                "    t_admin AS A " +
                "LEFT JOIN t_employee AS E " +
                "ON " +
                "    A.id_employee = E.id_employee " +
                "WHERE E.lastname LIKE ? OR E.firstname LIKE ?"
            );
            st.setString(1, "%"+name+"%");
            st.setString(2, "%"+name+"%");
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Admin admin = this.extractResult(rs);
                result.add(admin);
            }
            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean changePermit(int id, int permit) {
        int newpermit;
        if(permit == 1) {
            newpermit = 0;
        } else {
            newpermit = 1;
        }
        try {
            PreparedStatement st = con.prepareStatement(
                "UPDATE t_admin SET permit = ? WHERE id_admin = ?"
            );
            st.setInt(1, newpermit);
            st.setInt(2, id);
            int i = st.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteAdmin(int id) {
        try {
            PreparedStatement st = con.prepareStatement(
                "DELETE FROM t_admin WHERE id_admin = ?"
            );
            st.setInt(1, id);
            int i = st.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean changePass(int id, String pass, String salt) {
        try {
            PreparedStatement st = con.prepareStatement(
                "UPDATE t_admin SET " +
                    "password = ? ," +
                    "salt_value = ? " +
                "WHERE id_admin = ?"
            );
            st.setString(1, pass);
            st.setString(2, salt);
            st.setInt(3, id);
            int i = st.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean insertAdmin(Admin admin) {
        try {
            PreparedStatement st = con.prepareStatement(
                "INSERT INTO t_admin (id_employee, username, password, salt_value, date_reg, permit) " +
                "VALUES (?, ?, ?, ?, NOW(), ?)"
            );
            st.setInt(1, admin.getId_employee());
            st.setString(2, admin.getUsername());
            st.setString(3, admin.getPassword());
            st.setString(4, admin.getSalt());
            st.setInt(5, admin.getPermit());
            int i = st.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Admin getAdmByUsername(String username) {
        try {
            PreparedStatement st = con.prepareStatement(
                "SELECT " +
                "   A.id_admin, " +
                "   A.id_employee, " +
                "   CONCAT(E.firstname, ' ', E.lastname) AS name, " +
                "   A.username, " +
                "   A.password, " +
                "   A.salt_value, " + 
                "   A.date_reg, " +
                "   A.permit " +
                "FROM " +
                "   t_admin AS A " +
                "LEFT JOIN t_employee AS E " +
                "   ON A.id_employee = E.id_employee " +
                "WHERE A.username = ?"
            );
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                return this.extractResult(rs);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

}
