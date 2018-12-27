/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib.Libs;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.commons.dbcp.BasicDataSource;

public class Conn {
    private static final BasicDataSource DATASOURCE = new BasicDataSource();
    private static String errmsg;
    
    static {
        try {
            String servhost = "localhost";
            String servport = "3306";
            String timezone = "GMT";
            String database = "lds";
            String username = "root";
            String password = "";
            String url = String.format("jdbc:mysql://address=(host=%s)(port=%s)(serverTimezone=%s)/%s",
                servhost, 
                servport, 
                timezone,
                database
            );
            DATASOURCE.setUrl(url);
            DATASOURCE.setUsername(username);
            DATASOURCE.setPassword(password);
            DATASOURCE.setMinIdle(5);
            DATASOURCE.setMaxIdle(10);
            DATASOURCE.setMaxOpenPreparedStatements(100);
        } catch (Exception ex) {
            errmsg = ex.getMessage();
        }
    }
    
    private Conn() {}
    
    public static Connection initConn() throws SQLException {
        Connection con = null;
        try {
            con = DATASOURCE.getConnection();
        } catch (SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error: ").append(errmsg).append("\n");
            sb.append("Cannot connect to MySQL.");
            
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, sb, "LDS : Error", JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }
}

