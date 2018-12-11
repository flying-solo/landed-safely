/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lds.lib.*;


public class Login {
    private final String username;
    private final String password;
    
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    private Admin setUser(ResultSet rs) {
        Admin admin;
        try {
            admin = new Admin(
                rs.getInt("id_admin"),
                rs.getInt("id_employee"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("date_reg"),
                rs.getInt("permit")
            );
        } catch (SQLException e) {
            admin = null;
        }
        return admin;
    }
    
    public Admin isValid() {
        Admin result = null;
        try {
            Connection con = Conn.initConn();
            PreparedStatement st = con.prepareStatement("select * from t_admin where username = ? and password = ?");
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                result = setUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
