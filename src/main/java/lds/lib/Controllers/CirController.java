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
import lds.lib.DAO.CityRegionDAO;
import lds.lib.Entities.CityRegion;
import lds.lib.Libs.Conn;


public class CirController implements CityRegionDAO {
    
    private CityRegion extractResult(ResultSet rs) {
        try {
            CityRegion cir = new CityRegion(
                rs.getInt("id_cityregion"),
                rs.getString("cityregion")
            );
            return cir;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        
        return null;
    }
    
    @Override
    public ArrayList<CityRegion> getAllCir() {
        ArrayList<CityRegion> result = new ArrayList<>();
        try {
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement("SELECT * FROM m_cityregion");
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                CityRegion cir = this.extractResult(rs);
                result.add(cir);
            }
            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public CityRegion getCirById(int id) {
        try {
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement("SELECT * FROM m_cityregion WHERE id_cityregion = ?");
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
