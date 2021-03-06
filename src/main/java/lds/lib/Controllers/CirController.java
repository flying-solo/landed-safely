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
import lds.lib.Entities.CityRegency;
import lds.lib.Libs.Conn;
import lds.lib.Entities.Province;
import lds.lib.DAO.CirDAO;


public class CirController implements CirDAO {
    
    private Connection con;
    
    public CirController() {
        try {
            this.con = Conn.initConn();
        } catch (SQLException ex) {
            Logger.getLogger(CirController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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

    public CityRegency getCirById(int id) {
        try {
            PreparedStatement st = con.prepareStatement(
               "SELECT * FROM m_cityregency WHERE id_cityregency = ?"     
            );
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
