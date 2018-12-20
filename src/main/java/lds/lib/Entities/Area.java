/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib.Entities;


public class Area {
    private String id;
    private Province province;
    private CityRegion cityregion;
    private District district;
    private String subDistrict;
    private String postalCode;

    public Area() {}
    
    public Area(String id, Province province, CityRegion cityregion, District district, String subDistrict, String postalCode) {
        this.id = id;
        this.province = province;
        this.cityregion = cityregion;
        this.district = district;
        this.subDistrict = subDistrict;
        this.postalCode = postalCode;
    }

    public String getId() {
        return id;
    }

    public Province getProvince() {
        return province;
    }

    public CityRegion getCityregion() {
        return cityregion;
    }

    public District getDistrict() {
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

    public void setProvince(Province province) {
        this.province = province;
    }

    public void setCityregion(CityRegion cityregion) {
        this.cityregion = cityregion;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    
    
}
