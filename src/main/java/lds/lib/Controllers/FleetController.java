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
import lds.lib.DAO.FleetDAO;
import lds.lib.Entities.Fleet;
import lds.lib.Libs.Conn;


public class FleetController implements FleetDAO {
    
    private Connection con;
    private String select;

    public FleetController() {
        try {
            this.con = Conn.initConn();
            this.select = 
                "SELECT " +
                "   id_vehicle AS id, " +
                "   license_plate AS plate, " +
                "   vehicle_type as vtype " +
                "FROM m_fleet ";
        } catch (SQLException ex) {
            Logger.getLogger(FleetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Fleet extractResult(ResultSet rs) {
        try {
            Fleet flt = new Fleet(
                rs.getInt("id"),
                rs.getString("plate"),
                rs.getString("vtype")
            );
            return flt;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    @Override
    public ArrayList<Fleet> getAllFleet() {
        ArrayList<Fleet> result = new ArrayList<>();
        try {
            PreparedStatement st = con.prepareStatement(select);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Fleet flt = this.extractResult(rs);
                result.add(flt);
            }
            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Fleet> getFleeByVtype(String Vtype) {
        ArrayList<Fleet> result = new ArrayList<>();
        try {
            PreparedStatement st = con.prepareStatement(
                select + 
                "WHERE vehicle_type = ?"
            );
            st.setString(1, Vtype);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Fleet flt = this.extractResult(rs);
                result.add(flt);
            }
            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

}
