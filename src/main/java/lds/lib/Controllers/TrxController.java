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
import lds.lib.DAO.TrxDAO;
import lds.lib.Entities.Transact;
import lds.lib.Entities.PackageType;
import lds.lib.Entities.ServiceType;
import lds.lib.Libs.Conn;


public class TrxController implements TrxDAO {
    
    private Connection con;
    
    public TrxController() {
        try {
            this.con = Conn.initConn();
        } catch (SQLException ex) {
            Logger.getLogger(TrxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Transact extractTrx(ResultSet rs) {
        Transact trx = new Transact();
        try {
            trx.setId(rs.getString("id_trx"));
            
            return trx;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    private PackageType extractType(ResultSet rs) {
        try {
            PackageType type = new PackageType(
                    rs.getInt("id_type"),
                    rs.getString("type_name")
            );
            return type;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    private ServiceType extractServ(ResultSet rs) {
        try {
            ServiceType serv = new ServiceType(
                    rs.getInt("id_service"),
                    rs.getString("service_name")
            );
            return serv;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Transact> getAllTrx() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Transact> getTrxByStat(int stat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Transact> getTrxByOrig(int id_orig) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Transact> getTrxByDest(int id_dest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Transact> getTrxByServ(int id_serv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertTrx(Transact trx) {
        try {
            PreparedStatement st = con.prepareStatement(
                "INSERT INTO " +
                    "m_transact (" +
                        "id_trx, id_admin, " +
                        "id_origin, id_destination, pkg_details, " +
                        "pkg_weight, pkg_type, service_type, total" +
                    ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
            st.setString(1, trx.getId());
            st.setInt(2, trx.getId_admin());
            st.setString(3, trx.getId_orig());
            st.setString(4, trx.getId_dest());
            st.setString(5, trx.getPkg_details());
            st.setInt(6, trx.getPkg_weight());
            st.setInt(7, trx.getPkg_type());
            st.setInt(8, trx.getService_type());
            st.setInt(9, trx.getTotal());
            
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
    public ArrayList<PackageType> getAllType() {
        ArrayList<PackageType> result = new ArrayList<>();
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM m_type");
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                PackageType type = this.extractType(rs);
                result.add(type);
            }
            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<ServiceType> getAllServ() {
        ArrayList<ServiceType> result = new ArrayList<>();
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM m_service");
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                ServiceType type = this.extractServ(rs);
                result.add(type);
            }
            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    




}
