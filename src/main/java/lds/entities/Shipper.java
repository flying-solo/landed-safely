/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.entities;


public class Shipper {
    private final int shipperId;
    private final Trx trx;
    private final String regTo;
    private final String fullAddr;
    private final String phoneNum;

    public Shipper(int shipperId, Trx trx, String regTo, String fullAddr, String phoneNum) {
        this.shipperId = shipperId;
        this.trx = trx;
        this.regTo = regTo;
        this.fullAddr = fullAddr;
        this.phoneNum = phoneNum;
    }

    public int getShipperId() {
        return shipperId;
    }

    public Trx getTrx() {
        return trx;
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
