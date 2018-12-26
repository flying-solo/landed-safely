/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */
package lds.lib.DAO;

import java.util.ArrayList;
import lds.lib.Entities.CityRegency;
import lds.lib.Entities.District;

/**
 *
 * @author kaboel
 */
public interface DisDAO {
    ArrayList<District> getAllDis();
    ArrayList<District> getDisByCir(CityRegency cir);
}
