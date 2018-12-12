/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.entities;

import java.sql.Date;


public class Employee {
    private int empId;
    private String lastname;
    private String firstname;
    private int gender;
    private String email;
    private String addr;
    private String phone;
    private Date dateReg;
    private Date dateUpd;
    private int position;
    private int activation;

    public Employee(int empId, String lastname, String firstname, int gender, String email, String addr, String phone, Date dateReg, Date dateUpd, int position, int activation) {
        this.empId = empId;
        this.lastname = lastname;
        this.firstname = firstname;
        this.gender = gender;
        this.email = email;
        this.addr = addr;
        this.phone = phone;
        this.dateReg = dateReg;
        this.dateUpd = dateUpd;
        this.position = position;
        this.activation = activation;
    }

    public int getEmpId() {
        return empId;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public int getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getAddr() {
        return addr;
    }

    public String getPhone() {
        return phone;
    }

    public Date getDateReg() {
        return dateReg;
    }

    public Date getDateUpd() {
        return dateUpd;
    }

    public int getPosition() {
        return position;
    }

    public int getActivation() {
        return activation;
    }

    @Override
    public String toString() {
        return this.firstname+ " " +lastname;
    }
    
    
    
}