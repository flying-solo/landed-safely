/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib.Entities;


public class District {
    private final int id;
    private final String district;

    public District(int id, String district) {
        this.id = id;
        this.district = district;
    }

    public int getId() {
        return id;
    }

    public String getDistrict() {
        return district;
    }
    
    @Override
    public String toString() {
        return this.district;
    }
}
