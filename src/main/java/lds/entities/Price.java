/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.entities;


public class Price {
    private final int priceId;
    private final Region region;
    private final Service service;
    private final int price;

    public Price(int priceId, Region region, Service service, int price) {
        this.priceId = priceId;
        this.region = region;
        this.service = service;
        this.price = price;
    }

    public int getPriceId() {
        return priceId;
    }

    public Region getRegion() {
        return region;
    }

    public Service getService() {
        return service;
    }

    public int getPrice() {
        return price;
    }
    
    
}
