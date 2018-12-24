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
    Admin getAdmByIdPass(int id, String pass);
    boolean insertAdmin(Admin admin);
    boolean changePermit(int id, int permit);
    boolean changePass(int id, String pass);
    boolean deleteAdmin(int id);
}
