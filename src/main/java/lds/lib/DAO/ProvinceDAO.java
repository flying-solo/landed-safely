/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */
package lds.lib.DAO;

import java.util.ArrayList;
import lds.lib.Entities.Province;

/**
 *
 * @author kaboel
 */
public interface ProvinceDAO {
    ArrayList<Province> getAllProv();
    Province getProvById(int id);
}
