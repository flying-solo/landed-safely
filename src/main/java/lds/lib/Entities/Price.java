/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib.Entities;


public class Price {
    private int id;
    
    private int id_orig;
    private String orig;
    
    private int id_dest;
    private String dest;
    
    private int id_serv;
    private String serv;
    
    private int price;

    public int getId() {
        return id;
    }

    public int getId_orig() {
        return id_orig;
    }

    public String getOrig() {
        return orig;
    }

    public int getId_dest() {
        return id_dest;
    }

    public String getDest() {
        return dest;
    }

    public int getId_serv() {
        return id_serv;
    }

    public String getServ() {
        return serv;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_orig(int id_orig) {
        this.id_orig = id_orig;
    }

    public void setOrig(String orig) {
        this.orig = orig;
    }

    public void setId_dest(int id_dest) {
        this.id_dest = id_dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public void setId_serv(int id_serv) {
        this.id_serv = id_serv;
    }

    public void setServ(String serv) {
        this.serv = serv;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
}
