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
import lds.lib.Entities.CityRegency;
import lds.lib.Libs.Conn;
import lds.lib.DAO.CityRegencyDAO;
import lds.lib.Entities.Province;


public class CirController implements CityRegencyDAO {
    
    private CityRegency extractResult(ResultSet rs) {
        try {
            CityRegency cir = new CityRegency(
                rs.getInt("id_cityregency"),
                rs.getString("cityregency_name")
            );
            return cir;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        
        return null;
    }
    
    @Override
    public ArrayList<CityRegency> getAllCir() {
        ArrayList<CityRegency> result = new ArrayList<>();
        try {
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement("SELECT * FROM m_cityregency");
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                CityRegency cir = this.extractResult(rs);
                result.add(cir);
            }
            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<CityRegency> getCirByProv(Province prov) {
        ArrayList<CityRegency> result = new ArrayList<>();
        int idprov = prov.getId();
        try {
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement(
                "SELECT " +
                "    C.id_cityregency, " +
                "    C.cityregency_name, " +
                "    COUNT(*) AS COUNT " +
                "FROM " +
                "    m_area AS A " +
                "INNER JOIN m_cityregency AS C " +
                "ON " +
                "    A.id_cityregency = C.id_cityregency " +
                "WHERE " +
                "    A.id_province = ? " +
                "HAVING " +
                "    COUNT > 1"
            );
            st.setInt(1, idprov);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                CityRegency cir = this.extractResult(rs);
                result.add(cir);
            }
            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }


    
}
