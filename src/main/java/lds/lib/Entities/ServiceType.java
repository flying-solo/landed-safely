/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib.Entities;


public class ServiceType {
    private int id;
    private String service;

    public ServiceType(int id, String service) {
        this.id = id;
        this.service = service;
    }

    public int getId() {
        return id;
    }

    public String getService() {
        return service;
    }

    @Override
    public String toString() {
        return service;
    }
}
