/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */
package lds.lib.DAO;

import java.util.ArrayList;
import lds.lib.Entities.Admin;

/**
 *
 * @author kaboel
 */
public interface AdminDAO {
    ArrayList<Admin> getAllAdmin();
    ArrayList<Admin> getAdmByPermit(int permit);
    boolean changePermit(int id, int permit);
    boolean updateAdmin(int id);
    boolean deleteAdmin(int id);
}
