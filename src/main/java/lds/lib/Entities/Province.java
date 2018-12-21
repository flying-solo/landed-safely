/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib.Entities;


public class Province {
    private final int id;
    private final String province;
    
    public Province(int id, String province) {
        this.id = id;
        this.province = province;
    }

    public int getId() {
        return id;
    }

    public String getProvince() {
        return province;
    }

    @Override
    public String toString() {
        return this.province;
    }
      
}
