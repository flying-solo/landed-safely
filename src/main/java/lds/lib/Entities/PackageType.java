/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib.Entities;


public class PackageType {
    private final int id;
    private final String type;

    public PackageType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
    
    
}
