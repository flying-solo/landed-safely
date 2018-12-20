/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */
package lds.lib.DAO;

import java.util.ArrayList;
import lds.lib.Entities.Area;
import lds.lib.Entities.Province;
import lds.lib.Entities.CityRegion;
import lds.lib.Entities.District;

/**
 *
 * @author kaboel
 */
public interface AreaDAO {
    ArrayList<Area> getAllArea();
    ArrayList<Area> getAreaByProvince(Province prov);
    ArrayList<Area> getAreaByCityRegion(CityRegion cir);
    ArrayList<Area> getAreaByDistrict(District dis);
    boolean insertArea(Area area);
    boolean deleteArea(String id);
}
