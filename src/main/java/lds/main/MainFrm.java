/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */
package lds.main;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import lds.lib.Entities.Admin;
import lds.lib.Libs.Login;

/**
 *
 * @author kaboel
 */
public class MainFrm extends javax.swing.JFrame {
    private Admin activeUser;
    private JInternalFrame activeFrame;
    
    /**
     * Creates new form Main
     */
    public MainFrm() {
        initComponents();
        this.setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = confPrompt("Are you sure you want to Exit?");
                if(result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
     
        resetWindow();
    }
    
// ---------------------------------------------------------------
    
    public void userDialog(StringBuilder msg, String ttl, int type) {
        JOptionPane.showMessageDialog(this, msg, ttl, type);
    }
    
    public Integer confPrompt(String msg) {
        Object options[] = {"Yes", "No"};
        int result = JOptionPane.showOptionDialog(
                null, msg, "LDS (Confirmation)",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[1]
        );
        return result;
    }
    
// ---------------------------------------------------------------   
    private void resetWindow() {
        this.parentPanel.removeAll();
        this.parentPanel.add(this.childPanel0);
        this.hasLoggedIn();
        this.pack();
    }
    
    private void hasLoggedIn() {
        if(this.activeUser != null) {
            this.menuBar.setVisible(true);
            this.menuPermitControl();
            this.bottomPanel.setVisible(true);
            this.labelInfo.setText("Signed in as");
            this.labelActive.setText(this.activeUser.toString());
            this.setResizable(true);
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            JOptionPane.showMessageDialog(
                    this, "Welcome "+ activeUser.toString() +" !", "Welcome", JOptionPane.INFORMATION_MESSAGE);
        } else {
            this.menuBar.setVisible(false);
            this.bottomPanel.setVisible(false);
            this.labelInfo.setText(" ");
            this.labelActive.setText(" ");
        }
    }
    
    private void menuPermitControl() {
        if(this.activeUser.getPermit() < 1) {
            this.mnAdmin.setEnabled(false);
            this.mnEmployee.setEnabled(false);
        } else {
            this.mnAdmin.setEnabled(true);
            this.mnEmployee.setEnabled(true);
        }
    }
    
    private void setActiveUser(Admin activeUser) {
        this.activeUser = activeUser;
    }
    
    public Admin getActiveUser() {
        return this.activeUser;
    }
    
    private void clearLoginFields() {
        this.txtUser.setText("");
        this.txtPass.setText("");
        this.labelLogin.setText("");
    }
    
// ---------------------------------------------------------------
    
    private void setActiveFrame(JInternalFrame frame) {
        windowCont.removeAll();
        this.activeFrame = frame;
        showFrame();
    }
    
    
    private void showFrame() {
        Dimension contSize = windowCont.getSize();
        Dimension frameSize = activeFrame.getSize();
        windowCont.add(activeFrame);
        activeFrame.setLocation(
            (contSize.width - frameSize.width)/2,
            (contSize.height- frameSize.height)/2
        );
        activeFrame.show();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        parentPanel = new javax.swing.JPanel();
        childPanel0 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtUser = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        labelLogin = new javax.swing.JLabel();
        childPanel1 = new javax.swing.JPanel();
        windowCont = new javax.swing.JDesktopPane();
        bottomPanel = new javax.swing.JPanel();
        labelInfo = new javax.swing.JLabel();
        labelActive = new javax.swing.JLabel();
        labelImg = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnUpdProf = new javax.swing.JMenuItem();
        mnUpdPass = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnLogout = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mnTrx = new javax.swing.JMenuItem();
        mnFleet = new javax.swing.JMenuItem();
        mnRegion = new javax.swing.JMenuItem();
        mnPrice = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mnEmployee = new javax.swing.JMenuItem();
        mnAdmin = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("LDS");
        setResizable(false);

        parentPanel.setLayout(new java.awt.CardLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Sign In", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 3, 18), new java.awt.Color(153, 153, 153))); // NOI18N

        txtUser.setPreferredSize(new java.awt.Dimension(18, 23));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Username");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Password");

        btnLogin.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btnLogin.setText("Sign In");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(txtPass))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnReset))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        labelLogin.setFont(new java.awt.Font("Ubuntu", 3, 14)); // NOI18N
        labelLogin.setForeground(new java.awt.Color(255, 51, 51));
        labelLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogin.setText(" ");

        javax.swing.GroupLayout childPanel0Layout = new javax.swing.GroupLayout(childPanel0);
        childPanel0.setLayout(childPanel0Layout);
        childPanel0Layout.setHorizontalGroup(
            childPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(childPanel0Layout.createSequentialGroup()
                .addGroup(childPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(childPanel0Layout.createSequentialGroup()
                        .addGap(329, 329, 329)
                        .addComponent(labelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(childPanel0Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        childPanel0Layout.setVerticalGroup(
            childPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(childPanel0Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(labelLogin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parentPanel.add(childPanel0, "card2");

        childPanel1.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout windowContLayout = new javax.swing.GroupLayout(windowCont);
        windowCont.setLayout(windowContLayout);
        windowContLayout.setHorizontalGroup(
            windowContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 705, Short.MAX_VALUE)
        );
        windowContLayout.setVerticalGroup(
            windowContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
        );

        childPanel1.add(windowCont, java.awt.BorderLayout.CENTER);

        parentPanel.add(childPanel1, "card3");

        bottomPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), null));

        labelInfo.setFont(new java.awt.Font("Ubuntu", 1, 10)); // NOI18N
        labelInfo.setForeground(new java.awt.Color(140, 140, 140));
        labelInfo.setText("Signed in as");

        labelActive.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        labelActive.setForeground(new java.awt.Color(51, 204, 0));
        labelActive.setText("Active");

        labelImg.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        labelImg.setForeground(new java.awt.Color(140, 140, 140));
        labelImg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelImg.setText(">");

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addComponent(labelImg, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelActive)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelInfo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelActive, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jMenu1.setText("File");
        jMenu1.add(jSeparator1);

        mnUpdProf.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        mnUpdProf.setText("Update Profile");
        jMenu1.add(mnUpdProf);

        mnUpdPass.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        mnUpdPass.setText("Change Password");
        jMenu1.add(mnUpdPass);
        jMenu1.add(jSeparator2);

        mnLogout.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        mnLogout.setText("Sign Out");
        mnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnLogoutActionPerformed(evt);
            }
        });
        jMenu1.add(mnLogout);

        menuBar.add(jMenu1);

        jMenu2.setText("Menu");
        jMenu2.add(jSeparator3);

        mnTrx.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        mnTrx.setText("Transaction");
        mnTrx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnTrxActionPerformed(evt);
            }
        });
        jMenu2.add(mnTrx);

        mnFleet.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        mnFleet.setText("Fleet");
        mnFleet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnFleetActionPerformed(evt);
            }
        });
        jMenu2.add(mnFleet);

        mnRegion.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        mnRegion.setText("Region");
        mnRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnRegionActionPerformed(evt);
            }
        });
        jMenu2.add(mnRegion);

        mnPrice.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        mnPrice.setText("Price");
        mnPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPriceActionPerformed(evt);
            }
        });
        jMenu2.add(mnPrice);
        jMenu2.add(jSeparator4);

        mnEmployee.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        mnEmployee.setText("Employee");
        mnEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnEmployeeActionPerformed(evt);
            }
        });
        jMenu2.add(mnEmployee);

        mnAdmin.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        mnAdmin.setText("Admin");
        mnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAdminActionPerformed(evt);
            }
        });
        jMenu2.add(mnAdmin);

        menuBar.add(jMenu2);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(parentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnLogoutActionPerformed
        int result = confPrompt("Are you sure you want to Logout?");
        if(result == JOptionPane.YES_OPTION) {
            this.setActiveUser(null);
            this.resetWindow();
            this.setExtendedState(0);
        }
    }//GEN-LAST:event_mnLogoutActionPerformed

    private void mnTrxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnTrxActionPerformed
        TrxFrm frm = new TrxFrm();
        this.setActiveFrame(frm);
    }//GEN-LAST:event_mnTrxActionPerformed

    private void mnFleetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnFleetActionPerformed
        
    }//GEN-LAST:event_mnFleetActionPerformed

    private void mnRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnRegionActionPerformed
//        this.enaCovPanel();
    }//GEN-LAST:event_mnRegionActionPerformed

    private void mnPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPriceActionPerformed
//        this.enaPrcPanel();
    }//GEN-LAST:event_mnPriceActionPerformed

    private void mnEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnEmployeeActionPerformed
        EmpFrm frm = new EmpFrm();
        this.setActiveFrame(frm);
    }//GEN-LAST:event_mnEmployeeActionPerformed

    private void mnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAdminActionPerformed
//        this.enaAdmPanel();
    }//GEN-LAST:event_mnAdminActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        this.clearLoginFields();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String str;
        String username = this.txtUser.getText();
        String password = new String(this.txtPass.getPassword());
        Login login = new Login(username, password);
        if(!username.equals("") && !password.equals("")) {
            if(login.isValid() != null) {
                this.clearLoginFields();
                this.setActiveUser(login.isValid());
                this.parentPanel.removeAll();
                this.parentPanel.add(childPanel1);
                this.hasLoggedIn();
            } else {
                this.labelLogin.setText("* Invalid Login Info ! *");
            }
        } else {
            this.labelLogin.setText("* Fields cannot be empty ! *");
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnReset;
    private javax.swing.JPanel childPanel0;
    private javax.swing.JPanel childPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JLabel labelActive;
    private javax.swing.JLabel labelImg;
    private javax.swing.JLabel labelInfo;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mnAdmin;
    private javax.swing.JMenuItem mnEmployee;
    private javax.swing.JMenuItem mnFleet;
    private javax.swing.JMenuItem mnLogout;
    private javax.swing.JMenuItem mnPrice;
    private javax.swing.JMenuItem mnRegion;
    private javax.swing.JMenuItem mnTrx;
    private javax.swing.JMenuItem mnUpdPass;
    private javax.swing.JMenuItem mnUpdProf;
    private javax.swing.JPanel parentPanel;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    private javax.swing.JDesktopPane windowCont;
    // End of variables declaration//GEN-END:variables
}
