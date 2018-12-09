/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conn {
    private Connection db_conn;
    private Driver db_driver;
    private final String db_user, db_pass, db_url;

    public Conn() {
        try {
            this.db_driver = new com.mysql.jdbc.Driver();
        } catch (SQLException ex) {
            Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.db_user = "root";
        this.db_pass = "";
        this.db_url = "jdbc:mysql://localhost:3306/lds_logistic";
    }
    
     public Object initConn() {
        Object result = null;
        if(this.db_conn == null) {
            try {
                DriverManager.registerDriver(this.db_driver);
                this.db_conn = DriverManager.getConnection(this.db_url, this.db_user, this.db_pass);
                result = this.db_conn;
            } catch (SQLException ex) {
                result = (String) "Error unable to connect to MySQL.";
            }
        }
        return result;
    }
    
}
