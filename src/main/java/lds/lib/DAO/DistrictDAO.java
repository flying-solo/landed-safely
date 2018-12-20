/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */
package lds.lib.DAO;

import java.util.ArrayList;
import lds.lib.Entities.District;

/**
 *
 * @author kaboel
 */
public interface DistrictDAO {
    ArrayList<District> getAllDis();
    District getDisById(int id);
}
