/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */
package lds.lib.DAO;

import java.util.ArrayList;
import lds.lib.Entities.CityRegion;

/**
 *
 * @author kaboel
 */
public interface CityRegionDAO {
    ArrayList<CityRegion> getAllCir();
    CityRegion getCirById(int id);
}
