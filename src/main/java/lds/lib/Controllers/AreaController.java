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
import lds.lib.Entities.Area;
import lds.lib.DAO.AreaDAO;
import lds.lib.Entities.CityRegency;
import lds.lib.Entities.District;
import lds.lib.Entities.Province;
import lds.lib.Libs.Conn;


public class AreaController implements AreaDAO {
    
    private Connection con;
    
    public AreaController() {
        try {
            this.con = Conn.initConn();
        } catch (SQLException ex) {
            Logger.getLogger(AreaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Area extractResult(ResultSet rs) {
        try {
            Area area = new Area(
                rs.getString("id_area"),
                rs.getString("province_name"),
                rs.getString("cityregency_name"),
                rs.getString("district_name"),
                rs.getString("sub_district"),
                rs.getString("postal_code")
            );
            return area;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Area> getAllArea() {
        ArrayList<Area> result = new ArrayList<>();
        try {
            PreparedStatement st = con.prepareStatement(
                "SELECT " +
                "    A.id_area, " +
                "    P.province_name, " +
                "    C.cityregency_name, " +
                "    D.district_name, " +
                "    A.sub_district, " +
                "    A.postal_code " +
                "FROM " +
                "    m_area AS A " +
                "LEFT JOIN m_province AS P " +
                "ON " +
                "    A.id_province = P.id_province " +
                "LEFT JOIN m_cityregency AS C " +
                "ON " +
                "    A.id_cityregency = C.id_cityregency " +
                "LEFT JOIN m_district AS D " +
                "ON " +
                "    A.id_district = D.id_district"
            );
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Area area = this.extractResult(rs);
                result.add(area);
            }
            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Area> getAreaByParam(Province prov, CityRegency cir, District dis) {
        int idprov = prov.getId();
        int idcir = cir.getId();
        int iddis = dis.getId();
        
        ArrayList<Area> result = new ArrayList<>();
        
        try {
            PreparedStatement st = con.prepareStatement(
                "SELECT " +
                "    A.id_area, " +
                "    P.province_name, " +
                "    C.cityregency_name, " +
                "    D.district_name, " +
                "    A.sub_district, " +
                "    A.postal_code " +
                "FROM " +
                "    m_area AS A " +
                "LEFT JOIN m_province AS P " +
                "ON " +
                "    A.id_province = P.id_province " +
                "LEFT JOIN m_cityregency AS C " +
                "ON " +
                "    A.id_cityregency = C.id_cityregency " +
                "LEFT JOIN m_district AS D " +
                "ON " +
                "    A.id_district = D.id_district " +
                "WHERE " +
                "    A.id_province = ? AND A.id_cityregency = ? AND A.id_district = ?"
            );
            st.setInt(1, idprov);
            st.setInt(2, idcir);
            st.setInt(3, iddis);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Area area = this.extractResult(rs);
                result.add(area);
            }
            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    @Override
    public Area getAreaById(String id) {
        try {
            PreparedStatement st = con.prepareStatement(
                "SELECT " +
                "    A.id_area, " +
                "    P.province_name, " +
                "    C.cityregency_name, " +
                "    D.district_name, " +
                "    A.sub_district, " +
                "    A.postal_code " +
                "FROM " +
                "    m_area AS A " +
                "LEFT JOIN m_province AS P " +
                "ON " +
                "    A.id_province = P.id_province " +
                "LEFT JOIN m_cityregency AS C " +
                "ON " +
                "    A.id_cityregency = C.id_cityregency " +
                "LEFT JOIN m_district AS D " +
                "ON " +
                "    A.id_district = D.id_district " +
                "WHERE A.id_area = ?"
            );
            st.setString(1, id);
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
    public boolean updateArea(Area area) {
        try {
            PreparedStatement st = con.prepareStatement(
                "UPDATE m_area SET " +
                    "sub_district = ? , " +
                    "postal_code = ? " +
                "WHERE id_area = ?"
            );
            st.setString(1, area.getSubDistrict());
            st.setString(2, area.getPostalCode());
            st.setString(3, area.getId());
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
    public boolean insertArea(Area area, Province prov, CityRegency cir, District dis) {
        try {
            PreparedStatement st = con.prepareStatement("INSERT INTO m_area VALUES (?, ?, ?, ?, ?, ?)");
            st.setString(1, area.getId());
            st.setInt(2, prov.getId());
            st.setInt(3, cir.getId());
            st.setInt(4, dis.getId());
            st.setString(5, area.getSubDistrict());
            st.setString(6, area.getPostalCode());
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
    public boolean deleteArea(String id) {
        try {
            PreparedStatement st = con.prepareStatement("DELETE FROM m_area WHERE id_area = ?");
            st.setString(1, id);
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
