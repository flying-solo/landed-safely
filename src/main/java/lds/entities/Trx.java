/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.entities;

import java.sql.Date;


public class Trx {
    private final int trxId;
    private final Admin admin;
    private final Region origin;
    private final Region destination;
    private final String pkgDetails;
    private final int pkgWeight;
    private final Type pkgtype;
    private final Service serviceType;
    private final Date dateReg;
    private final Date dateArrived;
    private final int status;
    private final int discount;

    public Trx(int trxId, Admin admin, Region origin, Region destination, String pkgDetails, int pkgWeight, Type pkgtype, Service serviceType, Date dateReg, Date dateArrived, int status, int discount) {
        this.trxId = trxId;
        this.admin = admin;
        this.origin = origin;
        this.destination = destination;
        this.pkgDetails = pkgDetails;
        this.pkgWeight = pkgWeight;
        this.pkgtype = pkgtype;
        this.serviceType = serviceType;
        this.dateReg = dateReg;
        this.dateArrived = dateArrived;
        this.status = status;
        this.discount = discount;
    }

    public int getTrxId() {
        return trxId;
    }

    public Admin getAdmin() {
        return admin;
    }

    public Region getOrigin() {
        return origin;
    }

    public Region getDestination() {
        return destination;
    }

    public String getPkgDetails() {
        return pkgDetails;
    }

    public int getPkgWeight() {
        return pkgWeight;
    }

    public Type getPkgtype() {
        return pkgtype;
    }

    public Service getServiceType() {
        return serviceType;
    }

    public Date getDateReg() {
        return dateReg;
    }

    public Date getDateArrived() {
        return dateArrived;
    }

    public int getStatus() {
        return status;
    }

    public int getDiscount() {
        return discount;
    }
    
    
}
