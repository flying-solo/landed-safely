/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */
package lds.lib.DAO;

import java.util.ArrayList;
import lds.lib.Entities.CityRegency;
import lds.lib.Entities.Province;

/**
 *
 * @author kaboel
 */
public interface CirDAO {
    ArrayList<CityRegency> getAllCir();
    ArrayList<CityRegency> getCirByProv(Province prov);
}
