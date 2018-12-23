/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib.Libs;

import lds.lib.Entities.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


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
                rs.getString("name"),
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
            PreparedStatement st = con.prepareStatement(
                "SELECT " +
                "    A.id_admin, " +
                "    CONCAT(E.firstname, ' ', E.lastname) AS name, " +
                "    A.username, " +
                "    A.password, " +
                "    A.date_reg, " +
                "    A.permit " +
                "FROM " +
                "    t_admin AS A " +
                "LEFT JOIN t_employee AS E " +
                "ON " +
                "    A.id_employee = E.id_employee " +
                "WHERE " +
                "    A.username = ? AND A.password = ?"
            );
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                result = setUser(rs);
            }
        } catch (SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error: ").append(e.getMessage()).append("\n");
            sb.append("Cannot login at the momment.");
            
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, sb, "LDS : Error", JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }
}
