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
import lds.lib.DAO.PriceDAO;
import lds.lib.Entities.CityRegency;
import lds.lib.Entities.Price;
import lds.lib.Entities.ServiceType;
import lds.lib.Libs.Conn;


public class PriceController implements PriceDAO {
    
    private Connection con;
    private String select;

    public PriceController() {
        try {
            this.con = Conn.initConn();
            this.select = 
                "SELECT " +
                "   P.id_price AS id, " +
                "   O.cityregency_name AS origin, " +
                "   D.cityregency_name AS destination, " +
                "   S.service_name AS service, " +
                "   P.price AS price " +
                "FROM " +
                "   m_price AS P " +
                "LEFT JOIN m_cityregency AS O " +
                "   ON P.id_origin = O.id_cityregency " +
                "LEFT JOIN m_cityregency AS D " +
                "   ON P.id_destination = D.id_cityregency " +
                "LEFT JOIN m_service AS S " +
                "   ON P.id_service = S.id_service ";
        } catch (SQLException ex) {
            Logger.getLogger(PriceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Price extractResult(ResultSet rs) {
        try {
            Price prc = new Price();
            prc.setId(rs.getInt("id"));
            prc.setOrig(rs.getString("origin"));
            prc.setDest(rs.getString("destination"));
            prc.setServ(rs.getString("service"));
            prc.setPrice(rs.getInt("price"));
            return prc;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    @Override
    public ArrayList<Price> getAllPrice() {
        ArrayList<Price> result = new ArrayList<>();
        try {
            PreparedStatement st = con.prepareStatement(select);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Price prc = this.extractResult(rs);
                result.add(prc);
            }
            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Price> getPriceByParam(CityRegency orig, CityRegency dest, ServiceType serv) {        
        ArrayList<Price> result = new ArrayList<>();
                
        try {
            PreparedStatement st = con.prepareStatement(
                select + 
                "WHERE id_origin = ? AND id_destination = ? AND id_service = ?"
            );
            st.setInt(1, orig.getId());
            st.setInt(2, dest.getId());
            st.setInt(3, serv.getId());
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Price prc = this.extractResult(rs);
                result.add(prc);
            }
            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Price> getPriceByServ(ServiceType service) {        
        ArrayList<Price> result = new ArrayList<>();
                
        try {
            PreparedStatement st = con.prepareStatement(
                select + 
                "WHERE id_service = ?"
            );
            st.setInt(1, service.getId());
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Price prc = this.extractResult(rs);
                result.add(prc);
            }
            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
}
