/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib.Libs;

import lds.lib.Entities.Admin;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import lds.lib.Controllers.AdminController;


public class Login {
    
    private final AdminController admcon;
    private final String username;
    private final String password;
    
    public Login(String username, String password) {
        this.admcon = new AdminController();
        this.username = username;
        this.password = password;
    }
    
    public Admin isValid() {
        try {
            Admin admin = this.admcon.getAdmByUsername(this.username);
            if(admin != null) {
                String pass = admin.getPassword();
                String salt = admin.getSalt();
                
                if(Encryption.isVerified(this.password, pass, salt)) {
                    return admin;
                }
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error: ").append(e.getMessage()).append("\n");
            sb.append("Cannot login at the momment.");
            
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, sb, "LDS : Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
