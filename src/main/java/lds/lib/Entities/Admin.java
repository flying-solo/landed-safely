/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib.Entities;


public class Admin {
    private int id_admin;
    private String employee;
    private String username;
    private String password;
    private String salt;
    private String date_reg;
    private int permit;

    public Admin() {}
    
    public Admin(int id_admin, String employee, String username, String password, String salt, String date_reg, int permit) {
        this.id_admin = id_admin;
        this.employee = employee;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.date_reg = date_reg;
        this.permit = permit;
    }

    public int getId_admin() {
        return id_admin;
    }

    public String getEmployee() {
        return employee;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public String getDate_reg() {
        return date_reg;
    }

    public int getPermit() {
        return permit;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setDate_reg(String date_reg) {
        this.date_reg = date_reg;
    }

    public void setPermit(int permit) {
        this.permit = permit;
    }
    
    
    @Override
    public String toString() {
        return this.username;
    }
}
