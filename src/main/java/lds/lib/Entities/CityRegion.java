/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib.Entities;


public class CityRegion {
    private final int id;
    private final String cityregion;

    public CityRegion(int id, String cityregion) {
        this.id = id;
        this.cityregion = cityregion;
    }

    public int getId() {
        return id;
    }

    public String getCityregion() {
        return cityregion;
    }
    
    @Override
    public String toString() {
        return this.cityregion;
    }
}
