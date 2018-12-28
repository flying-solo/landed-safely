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
import lds.lib.Entities.District;
import lds.lib.Libs.Conn;
import lds.lib.DAO.DisDAO;


public class DisController implements DisDAO {
    
    private Connection con;
    
    public DisController() {
        try {
            this.con = Conn.initConn();
        } catch (SQLException ex) {
            Logger.getLogger(DisController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private District extractResult(ResultSet rs) {
        try {
            District dis = new District(
                rs.getInt("id_district"), 
                rs.getString("district_name")
            );
            return dis;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<District> getAllDis() {
        ArrayList<District> result = new ArrayList<>();
        try {
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
    public ArrayList<District> getDisByCir(CityRegency cir) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
    
}
