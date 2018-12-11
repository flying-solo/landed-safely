/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib;


public class Admin {
    private final int id_admin;
    private final int id_employee;
    private final String username;
    private final String password;
    private final String date_reg;
    private final int permit;

    public Admin(int id_admin, int id_employee, String username, String password, String date_reg, int permit) {
        this.id_admin = id_admin;
        this.id_employee = id_employee;
        this.username = username;
        this.password = password;
        this.date_reg = date_reg;
        this.permit = permit;
    }
    
    public Integer getId_admin() {
        return id_admin;
    }

    public Integer getId_employee() {
        return id_employee;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDate_reg() {
        return date_reg;
    }

    public Integer getPermit() {
        return permit;
    }
    
    @Override
    public String toString() {
        return this.username;
    }
}
