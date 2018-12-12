/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.entities;


public class Consignee {
    private final int consigId;
    private final Shipper shipper;
    private final String regTo;
    private final String fullAddr;
    private final String phoneNum;

    public Consignee(int consigId, Shipper shipper, String regTo, String fullAddr, String phoneNum) {
        this.consigId = consigId;
        this.shipper = shipper;
        this.regTo = regTo;
        this.fullAddr = fullAddr;
        this.phoneNum = phoneNum;
    }

    public int getConsigId() {
        return consigId;
    }

    public Shipper getShipper() {
        return shipper;
    }

    public String getRegTo() {
        return regTo;
    }

    public String getFullAddr() {
        return fullAddr;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    @Override
    public String toString() {
        return this.regTo;
    }
    
    
}
