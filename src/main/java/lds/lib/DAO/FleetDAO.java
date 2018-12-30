/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */
package lds.lib.DAO;

import java.util.ArrayList;
import lds.lib.Entities.Fleet;

/**
 *
 * @author kaboel
 */
public interface FleetDAO {
    ArrayList<Fleet> getAllFleet();
    ArrayList<Fleet> getFleeByVtype(String Vtype);
}
