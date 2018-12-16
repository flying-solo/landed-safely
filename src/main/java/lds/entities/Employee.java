/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.entities;


public class Employee {
    private int id;
    private String lastname;
    private String firstname;
    private int gender;
    private String email;
    private String address;
    private String phone;
    private String date_reg;
    private String date_upd;
    private int position;
    private int activation;

    public Employee() {}
    
    public Employee(String lastname, String firstname, int gender, String email, String address, String phone, int position) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.position = position;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getGender() {
        return (this.gender == 1 ? "Laki - laki" : "Perempuan");
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate_reg() {
        return date_reg;
    }

    public void setDate_reg(String date_reg) {
        this.date_reg = date_reg;
    }

    public String getDate_upd() {
        return date_upd;
    }

    public void setDate_upd(String date_upd) {
        this.date_upd = date_upd;
    }

    public String getPosition() {
        String str;
        switch(this.position) {
            case 1  : str = "Courier"; break;
            case 2  : str = "Staff"; break;
            case 3  : str = "Supervisor"; break;
            default : str = "Not Positioned Yet";
        }
        return str;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getActivation() {
        String str;
        if(this.activation == 0) {
            str = "Non-Active";
        } else {
            str = "Active";
        }
        return str;
    }

    public void setActivation(int activation) {
        this.activation = activation;
    }

    @Override
    public String toString() {
        return this.firstname +" "+this.lastname;
    }

}
