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
import lds.lib.DAO.DistrictDAO;
import lds.lib.Entities.District;
import lds.lib.Libs.Conn;


public class DisController implements DistrictDAO {
    
    private District extractResult(ResultSet rs) {
        try {
            District dis = new District(
                rs.getInt("id_district"), 
                rs.getString("district")
            );
            return dis;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<District> getAllDis() {
        ArrayList<District> result = new ArrayList<>();
        try {
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement("SELECT * FROM m_district");
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                District dis = this.extractResult(rs);
                result.add(dis);
            }
            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public District getDisById(int id) {
        try {
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement("SELECT * FROM m_district WHERE id_district = ?");
            st.setInt(1, id);
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
