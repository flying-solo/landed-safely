/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */
package lds.lib.DAO;

import java.util.ArrayList;
import lds.lib.Entities.Area;
import lds.lib.Entities.Province;
import lds.lib.Entities.CityRegency;
import lds.lib.Entities.District;

/**
 *
 * @author kaboel
 */
public interface AreaDAO {
    ArrayList<Area> getAllArea();
    ArrayList<Area> getAreaByParam(Province prov, CityRegency cir, District dis);
    ArrayList<Area> getAreaByCir(CityRegency cir);
    Area getAreaById(String id);
    boolean updateArea(Area area);
    boolean insertArea(Area area, Province prov, CityRegency cir, District dis);
    boolean deleteArea(String id);
}
