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
    
    public int getType() {
        if(this.cityregency.contains("KOTA")) {
            return 1;
        } else if(this.cityregency.contains("KABUPATEN")) {
            return 2;
        }
        return 0;
    }
    
    @Override
    public String toString() {
        return this.cityregency;
    }
}
