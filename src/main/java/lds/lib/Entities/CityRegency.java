/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib.Entities;


public class CityRegency {
    private final int id;
    private final String cityregency;

    public CityRegency(int id, String cityregency) {
        this.id = id;
        this.cityregency = cityregency;
    }

    public int getId() {
        return id;
    }

    public String getCityregency() {
        return cityregency;
    }
    
    @Override
    public String toString() {
        return this.cityregency;
    }
}
