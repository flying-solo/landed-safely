/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib.Entities;


public class Area {
    private String id;
    private String province;
    private int id_cityregency;
    private String cityregency;
    private String district;
    private String subDistrict;
    private String postalCode;

    public Area() {}

    public Area(String id, String province, int id_cityregency, String cityregency, String district, String subDistrict, String postalCode) {
        this.id = id;
        this.province = province;
        this.id_cityregency = id_cityregency;
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

    public void setId(String id) {
        this.id = id;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCityregency(String cityregency) {
        this.cityregency = cityregency;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getId_cityregency() {
        return id_cityregency;
    }

    public void setId_cityregency(int id_cityregency) {
        this.id_cityregency = id_cityregency;
    }
    
    
    
    @Override
    public String toString() {
        return subDistrict +", "+ cityregency;
    }
}
