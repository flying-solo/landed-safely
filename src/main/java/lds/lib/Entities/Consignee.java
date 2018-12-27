/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib.Entities;


public class Consignee {
    private int id;
    private String id_trx;
    private String name;
    private String address;
    private String phone;
    
    public Consignee() {}

    public Consignee(int id, String id_trx, String name, String address, String phone) {
        this.id = id;
        this.id_trx = id_trx;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getId_trx() {
        return id_trx;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_trx(String id_trx) {
        this.id_trx = id_trx;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
