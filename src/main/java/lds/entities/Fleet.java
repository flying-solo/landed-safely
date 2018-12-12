/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.entities;


public class Fleet {
    private final int fleetId;
    private final String licensePlate;
    private final String vehicleType;

    public Fleet(int fleetId, String licensePlate, String vehicleType) {
        this.fleetId = fleetId;
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }

    public int getFleetId() {
        return fleetId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getVehicleType() {
        return vehicleType;
    }
    
    
}
