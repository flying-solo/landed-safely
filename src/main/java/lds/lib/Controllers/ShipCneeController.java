/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib.Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lds.lib.DAO.ShipCneeDAO;
import lds.lib.Entities.Consignee;
import lds.lib.Entities.Shipper;
import lds.lib.Libs.Conn;


public class ShipCneeController implements ShipCneeDAO {
    
    private Shipper extractShipper(ResultSet rs) {
        try {
            Shipper ship = new Shipper(
                rs.getInt("id_shipper"),
                rs.getString("id_trx"),
                rs.getString("reg_to"),
                rs.getString("full_address"),
                rs.getString("phone_number")
            );
            return ship;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    @Override
    public Shipper getShipperByTrx(String id_trx) {
        try {
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement(
                "SELECT * FROM m_shipper WHERE id_trx = ?"
            );
            st.setString(1, id_trx);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                return this.extractShipper(rs);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean insertShipper(Shipper ship) {
        try {
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement(
                "INSERT INTO m_shipper (id_trx, reg_to, full_address, phone_number) "+
                "VALUES (?, ?, ?, ?)"
            );
            st.setString(1, ship.getId_trx());
            st.setString(2, ship.getName());
            st.setString(3, ship.getAddress());
            st.setString(4, ship.getPhone());
            int i = st.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    
    private Consignee extractConsig(ResultSet rs) {
        try {
            Consignee cnee = new Consignee(
                rs.getInt("id_consignee"),
                rs.getString("id_trx"),
                rs.getString("reg_to"),
                rs.getString("full_address"),
                rs.getString("phone_number")
            );
            return cnee;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    @Override
    public Consignee getConsigByTrx(String id_trx) {
        try {
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement(
                "SELECT * FROM m_consignee WHERE id_trx = ?"
            );
            st.setString(1, id_trx);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                return this.extractConsig(rs);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean insertConsig(Consignee cnee) {
        try {
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement(
                "INSERT INTO m_consignee (id_trx, reg_to, full_address, phone_number) "+
                "VALUES (?, ?, ?, ?)"
            );
            st.setString(1, cnee.getId_trx());
            st.setString(2, cnee.getName());
            st.setString(3, cnee.getAddress());
            st.setString(4, cnee.getPhone());
            int i = st.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

}
