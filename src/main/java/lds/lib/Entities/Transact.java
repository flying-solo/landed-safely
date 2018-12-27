/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib.Entities;


public class Transact {
    private String id;
    private int id_admin;
    private int id_courier;
    private int id_fleet;
    private int id_orig;
    private int id_dest;
    private String pkg_details;
    private int pkg_weight;
    private int pkg_type;
    private int service_type;
    private String date_reg;
    private String date_arrived;
    private int status;
    private int total;
    

    public String getId() {
        return id;
    }

    public int getId_admin() {
        return id_admin;
    }

    public int getId_courier() {
        return id_courier;
    }

    public int getId_fleet() {
        return id_fleet;
    }

    public int getId_orig() {
        return id_orig;
    }

    public int getId_dest() {
        return id_dest;
    }

    public String getPkg_details() {
        return pkg_details;
    }

    public int getPkg_weight() {
        return pkg_weight;
    }

    public int getPkg_type() {
        return pkg_type;
    }

    public int getService_type() {
        return service_type;
    }

    public String getDate_reg() {
        return date_reg;
    }

    public String getDate_arrived() {
        return date_arrived;
    }

    public int getStatus() {
        return status;
    }

    public int getTotal() {
        return total;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public void setId_courier(int id_courier) {
        this.id_courier = id_courier;
    }

    public void setId_fleet(int id_fleet) {
        this.id_fleet = id_fleet;
    }

    public void setId_orig(int id_orig) {
        this.id_orig = id_orig;
    }

    public void setId_dest(int id_dest) {
        this.id_dest = id_dest;
    }

    public void setPkg_details(String pkg_details) {
        this.pkg_details = pkg_details;
    }

    public void setPkg_weight(int pkg_weight) {
        this.pkg_weight = pkg_weight;
    }

    public void setPkg_type(int pkg_type) {
        this.pkg_type = pkg_type;
    }

    public void setService_type(int service_type) {
        this.service_type = service_type;
    }

    public void setDate_reg(String date_reg) {
        this.date_reg = date_reg;
    }

    public void setDate_arrived(String date_arrived) {
        this.date_arrived = date_arrived;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
