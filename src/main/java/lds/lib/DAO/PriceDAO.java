/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */
package lds.lib.DAO;

import java.util.ArrayList;
import lds.lib.Entities.CityRegency;
import lds.lib.Entities.Price;
import lds.lib.Entities.ServiceType;

/**
 *
 * @author kaboel
 */
public interface PriceDAO {
    ArrayList<Price> getAllPrice();
    ArrayList<Price> getPriceByParam(CityRegency orig, CityRegency dest, ServiceType serv);
    ArrayList<Price> getPriceByServ(ServiceType serv);
}
