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
import lds.lib.Entities.Area;
import lds.lib.DAO.AreaDAO;
import lds.lib.Entities.CityRegion;
import lds.lib.Entities.District;
import lds.lib.Entities.Province;
import lds.lib.Libs.Conn;


public class AreaController implements AreaDAO {
    private final ProvController provC;
    private final CirController cirC;
    private final DisController disC;

    public AreaController() {
        this.provC = new ProvController();
        this.cirC = new CirController();
        this.disC = new DisController();
    }
    
    private Area extractResult(ResultSet rs) {
        try {
            Area area = new Area(
                rs.getString("id_area"),
                provC.getProvById(rs.getInt("id_province")),
                cirC.getCirById(rs.getInt("id_cityregion")),
                disC.getDisById(rs.getInt("id_district")),
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
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement("SELECT * FROM m_area");
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
    public ArrayList<Area> getAreaByProvince(Province prov) {
        ArrayList<Area> result = new ArrayList<>();
        try {
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement("SELECT * FROM m_area WHERE id_province = ?");
            st.setInt(1, prov.getId());
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
    public ArrayList<Area> getAreaByCityRegion(CityRegion cir) {
        ArrayList<Area> result = new ArrayList<>();
        try {
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement("SELECT * FROM m_area WHERE id_province = ?");
            st.setInt(1, cir.getId());
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
    public ArrayList<Area> getAreaByDistrict(District dis) {
        ArrayList<Area> result = new ArrayList<>();
        try {
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement("SELECT * FROM m_area WHERE id_province = ?");
            st.setInt(1, dis.getId());
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
    public boolean insertArea(Area area) {
        try {
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement("INSERT INTO m_area VALUES (?, ?, ?, ?, ?, ?)");
            st.setString(1, area.getId());
            st.setInt(2, area.getProvince().getId());
            st.setInt(3, area.getCityregion().getId());
            st.setInt(4, area.getDistrict().getId());
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
            Connection con = Conn.initConn();
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
