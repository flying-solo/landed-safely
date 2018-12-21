/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib.Entities;


public class Area {
    private String id;
    private String province;
    private String cityregency;
    private String district;
    private String subDistrict;
    private String postalCode;

    public Area() {}

    public Area(String id, String province, String cityregency, String district, String subDistrict, String postalCode) {
        this.id = id;
        this.province = province;
        this.cityregency = cityregency;
        this.district = district;
        this.subDistrict = subDistrict;
        this.postalCode = postalCode;
    }

    public String getId() {
        return id;
    }

    public String getProvince() {
        return province;
    }

    public String getCityregency() {
        return cityregency;
    }

    public String getDistrict() {
        return district;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public String getPostalCode() {
        return postalCode;
    } 
}
