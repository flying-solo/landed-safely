/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib.Entities;


public class Fleet {
    private final int id;
    private final String plate;
    private final String vtype;

    public Fleet(int id, String plate, String vtype) {
        this.id = id;
        this.plate = plate;
        this.vtype = vtype;
    }

    public int getId() {
        return id;
    }

    public String getPlate() {
        return plate;
    }

    public String getVtype() {
        return vtype;
    }

    @Override
    public String toString() {
        return this.plate;
    }
    
    
}
