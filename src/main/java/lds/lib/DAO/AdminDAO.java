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
    Admin getAdmByUsername(String username);
    boolean insertAdmin(Admin admin);
    boolean changePermit(int id, int permit);
    boolean changePass(int id, String pass, String salt);
    boolean deleteAdmin(int id);
}
