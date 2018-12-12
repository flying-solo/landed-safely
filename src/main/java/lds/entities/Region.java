/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.entities;


public class Region {
    private final int regionId;
    private final String province;
    private final String city;
    private final String area;
    private final String postal;

    public Region(int regId, String province, String city, String area, String postal) {
        this.regionId = regId;
        this.province = province;
        this.city = city;
        this.area = area;
        this.postal = postal;
    }

    public int getRegionId() {
        return regionId;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getArea() {
        return area;
    }

    public String getPostal() {
        return postal;
    }
    
    
}
