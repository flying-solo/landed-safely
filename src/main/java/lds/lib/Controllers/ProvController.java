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
import lds.lib.Entities.Province;
import lds.lib.Libs.Conn;
import lds.lib.DAO.ProvDAO;


public class ProvController implements ProvDAO {
    
    private Connection con;
    
    public ProvController() {
        try {
            this.con = Conn.initConn();
        } catch (SQLException ex) {
            Logger.getLogger(ProvController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Province extractResult(ResultSet rs) {
        try {
            Province prov = new Province(
                rs.getInt("id_province"),
                rs.getString("province_name")
            );
            return prov;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Province> getAllProv() {
        ArrayList<Province> result = new ArrayList<>();
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM m_province");
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Province prov = this.extractResult(rs);
                result.add(prov);
            }
            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Province getProvById(int id) {
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM m_province WHERE id_province = ?");
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
