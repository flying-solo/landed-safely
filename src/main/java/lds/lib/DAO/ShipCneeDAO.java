/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */
package lds.lib.DAO;

import lds.lib.Entities.Consignee;
import lds.lib.Entities.Shipper;

/**
 *
 * @author kaboel
 */
public interface ShipCneeDAO {
    Shipper getShipperByTrx(String id_trx);
    boolean insertShipper(Shipper ship);
    
    Consignee getConsigByTrx(String id_trx);
    boolean insertConsig(Consignee cnee);
}
