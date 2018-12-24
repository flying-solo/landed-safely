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
import lds.lib.DAO.AdminDAO;
import lds.lib.Entities.Admin;
import lds.lib.Libs.Conn;

public class AdminController implements AdminDAO {

    private Admin extractResult(ResultSet rs) {
        try {
            Admin admin = new Admin(
                rs.getInt("id_admin"),
                rs.getString("name"),
                rs.getString("username"),
                rs.getString("password"),
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
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement(
                "SELECT " +
                "    A.id_admin, " +
                "    CONCAT(E.firstname, ' ', E.lastname) AS name, " +
                "    A.username, " +
                "    A.password, " +
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
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement(
                "SELECT " +
                "    A.id_admin, " +
                "    CONCAT(E.firstname, ' ', E.lastname) AS name, " +
                "    A.username, " +
                "    A.password, " +
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
    public boolean changePermit(int id, int permit) {
        int newpermit;
        if(permit == 1) {
            newpermit = 0;
        } else {
            newpermit = 1;
        }
        try {
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement(
                "UPDATE t_admin SET permit = ? WHERE id_admin = ?"
            );
            st.setInt(1, id);
            st.setInt(2, newpermit);
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
            Connection con = Conn.initConn();
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
    public Admin getAdmByIdPass(int id, String pass) {
        try {
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement(
                "SELECT " +
                "    A.id_admin, " +
                "    CONCAT(E.firstname, ' ', E.lastname) AS name, " +
                "    A.username, " +
                "    A.password, " +
                "    A.date_reg, " +
                "    A.permit " +
                "FROM " +
                "    t_admin AS A " +
                "LEFT JOIN t_employee AS E " +
                "ON " +
                "    A.id_employee = E.id_employee " +
                "WHERE A.id_admin = ? AND A.password = ?"
            );
            st.setInt(1, id);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                return this.extractResult(rs);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean changePass(int id, String pass) {
        try {
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement(
                "UPDATE t_admin SET password = ? WHERE id_admin = ?"
            );
            st.setString(1, pass);
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
    public boolean insertAdmin(Admin admin) {
        return false;
    }

}
