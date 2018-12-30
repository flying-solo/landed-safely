/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */
package lds.lib.Frames;

import java.awt.Color;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import lds.lib.Controllers.*;
import lds.lib.Entities.*;
import lds.main.MainFrm;

/**
 *
 * @author kaboel
 */
public class AddTrxFrm extends javax.swing.JDialog {

    private final MainFrm main;
    private final Admin activeUser;
    private final CirController circon;
    private final AreaController areacon;
    private final TrxController trxcon;
    private final PriceController prccon;
    
    private JDialog dialog;
    private int total;
    private int iter;
    
    public AddTrxFrm(java.awt.Frame parent, boolean modal, Admin activeUser) {
        super(parent, modal);
        
        this.main = new MainFrm();
        this.activeUser = activeUser;
        this.circon = new CirController();
        this.areacon = new AreaController();
        this.trxcon = new TrxController();
        this.prccon = new PriceController();
        
        initComponents();
        
        loadCombos();
    }
    
    private void loadCombos() {
        ArrayList<CityRegency> cir = this.circon.getAllCir();
        cir.forEach((dt) -> {
            this.comboShpCity.addItem(dt);
        });
        cir.forEach((dt) -> {
            this.comboCneeCity.addItem(dt);
        });
        
        ArrayList<PackageType> type = this.trxcon.getAllType();
        type.forEach((dt) -> {
            this.comboTrxPckg.addItem(dt);
        });
        
        ArrayList<ServiceType> serv = this.trxcon.getAllServ();
        serv.forEach((dt) -> {
            this.comboTrxSrvc.addItem(dt);
        });
    }
    
    private String getId() {
        Random random = new Random(System.currentTimeMillis());
        int rand = (1 + random.nextInt(9)) * 999 + random.nextInt(999);
        String dt = new SimpleDateFormat("yyMMdd").format(new Date());
        return String.format("TRX"+dt+rand);
//        return Integer.toString(rand);
    }
    
    private Shipper getShipper(String id) {
        Shipper ship = new Shipper();
        ship.setId_trx(id);
        ship.setName(this.txtShipName.getText());
        ship.setAddress(this.txtShipAddr.getText());
        ship.setPhone(this.txtShipPhn.getText());
        
        return ship;
    }
    
    private Consignee getConsig(String id) {
        Consignee cnee = new Consignee();
        cnee.setId_trx(id);
        cnee.setName(this.txtCneeName.getText());
        cnee.setAddress(this.txtCneeAddr.getText());
        cnee.setPhone(this.txtCneePhn.getText());
        
        return cnee;
    }
    
    private Transact getTransact(String id) {
        String idorig = ((Area) this.comboShpArea.getSelectedItem()).getId();
        String iddest = ((Area) this.comboCneeArea.getSelectedItem()).getId();
        
        int idtype = ((PackageType) this.comboTrxPckg.getSelectedItem()).getId();
        int idserv = ((ServiceType) this.comboTrxSrvc.getSelectedItem()).getId();
        
        String type = ((PackageType) this.comboTrxPckg.getSelectedItem()).getType();
        String serv = ((ServiceType) this.comboTrxSrvc.getSelectedItem()).getService();
        
        String cirorig = ((CityRegency) this.comboShpCity.getSelectedItem()).toString();
        String cirdest = ((CityRegency) this.comboCneeCity.getSelectedItem()).toString();
        
        String areaorig = ((Area) this.comboShpArea.getSelectedItem()).toString();
        String areadest = ((Area) this.comboCneeArea.getSelectedItem()).toString();
        
        String postalorig = ((Area) this.comboShpArea.getSelectedItem()).getPostalCode();
        String postaldest = ((Area) this.comboCneeArea.getSelectedItem()).getPostalCode();
        
        
        Transact trx = new Transact();
        trx.setId(id);
//        trx.setId_admin(this.activeUser.getId_admin());
        trx.setId_orig(idorig);
        trx.setId_dest(iddest);
        trx.setPkg_details(this.txtTrxDet.getText());
        trx.setPkg_weight((int) this.txtTrxWeight.getValue());
        trx.setPkg_type(idtype);
        trx.setPkg(type);
        trx.setService_type(idserv);
        trx.setServ(serv);
        trx.setCir_orig(cirorig);
        trx.setCir_dest(cirdest);
        trx.setArea_dest(areadest);
        trx.setArea_orig(areaorig);
        trx.setPostal_orig(postalorig);
        trx.setPostal_dest(postaldest);
        trx.setTotal(this.total);
        
        
        
        return trx;
    }
    
    private Object[] getResult(String id) {
        Object[] data;
        data = new Object[]{
            getShipper(id),
            getConsig(id),
            getTransact(id)
//            this.activeUser
        };
        
        return data;
    }
    
    private boolean isEmpty() {
        return this.txtShipName.getText() == null       || this.txtShipName.getText().equals("") || 
                this.txtShipAddr.getText() == null      || this.txtShipAddr.getText().equals("") ||
                this.txtShipPhn.getText() == null       || this.txtShipPhn.getText().equals("") ||
                this.txtCneeName.getText() == null      || this.txtCneeName.getText().equals("") ||
                this.txtCneePhn.getText() == null       || this.txtCneePhn.getText().equals("") ||
                this.txtCneeAddr.getText() == null      || this.txtCneeAddr.getText().equals("") ||
                this.txtTrxWeight.getValue() == null    || (int)this.txtTrxWeight.getValue() == 0 ||
                this.txtTrxDet.getText() == null        || this.txtTrxDet.getText().equals("") ||
                this.comboShpArea.isEnabled() == false  || this.comboCneeArea.isEnabled() == false;
    }
    
    private void clearShipper() {
        this.iter = 0;
        this.txtShipName.setText("");
        this.txtShipPhn.setText("");
        this.txtShipAddr.setText("");
        this.comboShpCity.setSelectedIndex(0);
        if(this.comboShpArea.isEnabled()) {
            this.comboShpArea.removeAllItems();
            this.comboShpArea.setEnabled(false);
        }
    }
    private void clearConsignee() {
        this.iter = 0;
        this.txtCneeName.setText("");
        this.txtCneePhn.setText("");
        this.txtCneeAddr.setText("");
        this.comboCneeCity.setSelectedIndex(0);
        if(this.comboCneeArea.isEnabled()) {
            this.comboCneeArea.removeAllItems();
            this.comboCneeArea.setEnabled(false);
        }
    }
    private void clearDetails() {
        this.iter = 0;
        this.txtTrxDet.setText("");
        this.trxTotal.setText("0.00 ,-");
        this.txtTrxWeight.setValue((int) 0);
        this.comboTrxPckg.setSelectedIndex(0);
        this.comboTrxSrvc.setSelectedIndex(0);
    }
    
    private int getPrice() {
        CityRegency orig = (CityRegency) this.comboShpCity.getSelectedItem();
        CityRegency dest = (CityRegency) this.comboCneeCity.getSelectedItem();
        ServiceType serv = (ServiceType) this.comboTrxSrvc.getSelectedItem();
        
        Price prc = this.prccon.getPriceByParam(orig, dest, serv);
        if(prc != null) {
            return prc.getPrice();
        }
        return 0;
    }
    
    private String getTotal() {
        int w = (int) this.txtTrxWeight.getValue();
        this.total = getPrice() * w;
        String str = Integer.toString(total);
        
        double amount = Double.parseDouble(str);
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        
        String out = formatter.format(amount) +" ,-"; 
        return out;
    }
    
    private void setDialog(JDialog dialog) {
        this.dialog = dialog;
        this.dialog.setLocationRelativeTo(null);
        this.dialog.setResizable(false);
        this.dialog.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShipper = new javax.swing.JPanel();
        txtShipName = new javax.swing.JTextField();
        txtShipPhn = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboShpCity = new javax.swing.JComboBox<CityRegency>();
        comboShpArea = new javax.swing.JComboBox<Area>();
        jLabel6 = new javax.swing.JLabel();
        btnResetShipper = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtShipAddr = new javax.swing.JTextArea();
        panelDetails = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        comboTrxPckg = new javax.swing.JComboBox<PackageType>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtTrxDet = new javax.swing.JTextArea();
        comboTrxSrvc = new javax.swing.JComboBox<ServiceType>();
        jLabel18 = new javax.swing.JLabel();
        btnResetDetails = new javax.swing.JButton();
        txtTrxWeight = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnSynchronize = new javax.swing.JButton();
        trxOrig = new javax.swing.JLabel();
        trxDest = new javax.swing.JLabel();
        trxTotal = new javax.swing.JLabel();
        panelConsig = new javax.swing.JPanel();
        txtCneeName = new javax.swing.JTextField();
        txtCneePhn = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboCneeCity = new javax.swing.JComboBox<CityRegency>();
        comboCneeArea = new javax.swing.JComboBox<Area>();
        jLabel11 = new javax.swing.JLabel();
        btnResetCnee = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtCneeAddr = new javax.swing.JTextArea();
        btnPurge = new javax.swing.JButton();
        btnProcess = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        btnbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New Transaction");
        setIconImage(null);
        setMinimumSize(this.getPreferredSize());
        setResizable(false);

        panelShipper.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Shipper"));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel2.setText("* Registered To");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel3.setText("* Phone Number");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel4.setText("* Full Address");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel5.setText("* City / Regency");

        comboShpCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboShpCityActionPerformed(evt);
            }
        });

        comboShpArea.setEnabled(false);
        comboShpArea.setMaximumSize(new java.awt.Dimension(34, 25));
        comboShpArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboShpAreaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel6.setText("* Area");

        btnResetShipper.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        btnResetShipper.setText("Reset");
        btnResetShipper.setPreferredSize(new java.awt.Dimension(100, 30));
        btnResetShipper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetShipperActionPerformed(evt);
            }
        });

        txtShipAddr.setColumns(20);
        txtShipAddr.setRows(5);
        jScrollPane5.setViewportView(txtShipAddr);

        javax.swing.GroupLayout panelShipperLayout = new javax.swing.GroupLayout(panelShipper);
        panelShipper.setLayout(panelShipperLayout);
        panelShipperLayout.setHorizontalGroup(
            panelShipperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShipperLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelShipperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShipperLayout.createSequentialGroup()
                        .addGroup(panelShipperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelShipperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtShipName)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelShipperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtShipPhn)
                            .addComponent(comboShpCity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboShpArea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnResetShipper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelShipperLayout.setVerticalGroup(
            panelShipperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShipperLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelShipperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(4, 4, 4)
                .addGroup(panelShipperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtShipName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtShipPhn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelShipperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShipperLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(panelShipperLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel4)))
                .addGap(4, 4, 4)
                .addGroup(panelShipperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShipperLayout.createSequentialGroup()
                        .addComponent(comboShpCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(4, 4, 4)
                        .addComponent(comboShpArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnResetShipper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelDetails.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Details"));

        jLabel12.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Origin");

        jLabel13.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Destination");

        jLabel14.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("* Package Type");

        jLabel15.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("* Weight");

        jLabel16.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("* Package Details");

        jLabel17.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("* Service Type");

        txtTrxDet.setColumns(20);
        txtTrxDet.setRows(5);
        jScrollPane3.setViewportView(txtTrxDet);

        comboTrxSrvc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTrxSrvcActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Total");

        btnResetDetails.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        btnResetDetails.setText("Reset");
        btnResetDetails.setPreferredSize(new java.awt.Dimension(100, 30));
        btnResetDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetDetailsActionPerformed(evt);
            }
        });

        txtTrxWeight.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtTrxWeightStateChanged(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel19.setText("kg");

        jLabel20.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel20.setText("Rp.");

        btnSynchronize.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        btnSynchronize.setText("Synchronize");
        btnSynchronize.setPreferredSize(new java.awt.Dimension(100, 30));
        btnSynchronize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSynchronizeActionPerformed(evt);
            }
        });

        trxOrig.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        trxOrig.setForeground(java.awt.Color.gray);
        trxOrig.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trxOrig.setText("Not yet specified.");

        trxDest.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        trxDest.setForeground(java.awt.Color.gray);
        trxDest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trxDest.setText("Not yet specified.");

        trxTotal.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        trxTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        trxTotal.setText("0.00 ,-");

        javax.swing.GroupLayout panelDetailsLayout = new javax.swing.GroupLayout(panelDetails);
        panelDetails.setLayout(panelDetailsLayout);
        panelDetailsLayout.setHorizontalGroup(
            panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnResetDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSynchronize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelDetailsLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(trxOrig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(trxDest, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboTrxPckg, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDetailsLayout.createSequentialGroup()
                        .addComponent(txtTrxWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboTrxSrvc, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDetailsLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(trxTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
        );
        panelDetailsLayout.setVerticalGroup(
            panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDetailsLayout.createSequentialGroup()
                        .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDetailsLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboTrxPckg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15))
                            .addGroup(panelDetailsLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDetailsLayout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTrxWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19)))
                            .addGroup(panelDetailsLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(trxOrig))
                            .addGroup(panelDetailsLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trxDest)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelDetailsLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboTrxSrvc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(trxTotal))))
                .addGap(20, 20, 20)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnResetDetails, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSynchronize, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelConsig.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Consignee"));

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel7.setText("* Send To");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel8.setText("* Phone Number");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel9.setText("* Full Address");

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel10.setText("* City / Regency");

        comboCneeCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCneeCityActionPerformed(evt);
            }
        });

        comboCneeArea.setEnabled(false);
        comboCneeArea.setMaximumSize(new java.awt.Dimension(34, 25));
        comboCneeArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCneeAreaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel11.setText("* Area");

        btnResetCnee.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        btnResetCnee.setText("Reset");
        btnResetCnee.setPreferredSize(new java.awt.Dimension(100, 31));
        btnResetCnee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetCneeActionPerformed(evt);
            }
        });

        txtCneeAddr.setColumns(20);
        txtCneeAddr.setRows(5);
        jScrollPane4.setViewportView(txtCneeAddr);

        javax.swing.GroupLayout panelConsigLayout = new javax.swing.GroupLayout(panelConsig);
        panelConsig.setLayout(panelConsigLayout);
        panelConsigLayout.setHorizontalGroup(
            panelConsigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsigLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConsigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConsigLayout.createSequentialGroup()
                        .addGroup(panelConsigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelConsigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCneeName)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelConsigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCneePhn)
                            .addComponent(comboCneeCity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboCneeArea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnResetCnee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelConsigLayout.setVerticalGroup(
            panelConsigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsigLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConsigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(4, 4, 4)
                .addGroup(panelConsigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCneeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCneePhn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelConsigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConsigLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10))
                    .addGroup(panelConsigLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel9)))
                .addGap(4, 4, 4)
                .addGroup(panelConsigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConsigLayout.createSequentialGroup()
                        .addComponent(comboCneeCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addGap(4, 4, 4)
                        .addComponent(comboCneeArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnResetCnee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnPurge.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        btnPurge.setText("Reset All");
        btnPurge.setPreferredSize(new java.awt.Dimension(110, 30));
        btnPurge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurgeActionPerformed(evt);
            }
        });

        btnProcess.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        btnProcess.setText("Next");
        btnProcess.setPreferredSize(new java.awt.Dimension(110, 30));
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel1.setText("Note : ");

        jLabel21.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel21.setText("Please fill all the blanks with");

        jLabel22.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel22.setText("Once all fields are filled, please click the");

        jLabel24.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel24.setText("button before proceeding to the next step.");

        jLabel27.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel27.setText("If you do any changes to the data after Synchronizing, please Re-synchronize.");

        jLabel28.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel28.setText("*");

        jLabel29.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel29.setText("marker. They cannot be empty !");

        btnbtn.setFont(new java.awt.Font("Ubuntu", 1, 10)); // NOI18N
        btnbtn.setText("Synchronize");
        btnbtn.setEnabled(false);
        btnbtn.setFocusable(false);
        btnbtn.setPreferredSize(new java.awt.Dimension(90, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPurge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelShipper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelConsig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24))
                            .addComponent(jLabel27))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelConsig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelShipper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPurge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel21)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jLabel24)
                            .addComponent(btnbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboShpCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboShpCityActionPerformed
        this.iter = 0;
        this.comboShpArea.removeAllItems();
        CityRegency cir = (CityRegency) this.comboShpCity.getSelectedItem();
        ArrayList<Area> data = this.areacon.getAreaByCir(cir);
        if(data.size() > 0) {
            this.comboShpArea.setEnabled(true);
            data.forEach((area) -> {
                this.comboShpArea.addItem(area);
            });
        } else {
            this.comboShpArea.setEnabled(false);
        }
    }//GEN-LAST:event_comboShpCityActionPerformed

    private void comboCneeCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCneeCityActionPerformed
        this.iter = 0;
        this.comboCneeArea.removeAllItems();
        CityRegency cir = (CityRegency) this.comboCneeCity.getSelectedItem();
        ArrayList<Area> data = this.areacon.getAreaByCir(cir);
        if(data.size() > 0) {
            this.comboCneeArea.setEnabled(true);
            data.forEach((area) -> {
                this.comboCneeArea.addItem(area);
            });
        } else {
            this.comboCneeArea.setEnabled(false);
        }
    }//GEN-LAST:event_comboCneeCityActionPerformed

    private void comboShpAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboShpAreaActionPerformed
        this.iter = 0;
        this.trxOrig.setForeground(Color.GRAY);
        this.trxOrig.setText("Not yet specified.");
        Area area = (Area) this.comboShpArea.getSelectedItem();
        if(area != null) {
            this.trxOrig.setForeground(Color.DARK_GRAY);
            this.trxOrig.setText(area.toString());
        } 
    }//GEN-LAST:event_comboShpAreaActionPerformed

    private void comboCneeAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCneeAreaActionPerformed
        this.iter = 0;
        this.trxDest.setForeground(Color.GRAY);
        this.trxDest.setText("Not yet specified.");
        Area area = (Area) this.comboCneeArea.getSelectedItem();
        if(area != null) {
            this.trxDest.setForeground(Color.DARK_GRAY);
            this.trxDest.setText(area.toString());
        } 
    }//GEN-LAST:event_comboCneeAreaActionPerformed

    private void btnResetShipperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetShipperActionPerformed
        clearShipper();
    }//GEN-LAST:event_btnResetShipperActionPerformed

    private void btnResetCneeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetCneeActionPerformed
        clearConsignee();
    }//GEN-LAST:event_btnResetCneeActionPerformed

    private void btnResetDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetDetailsActionPerformed
        clearDetails();
    }//GEN-LAST:event_btnResetDetailsActionPerformed

    private void btnPurgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurgeActionPerformed
        clearShipper();
        clearConsignee();
        clearDetails();
    }//GEN-LAST:event_btnPurgeActionPerformed

    private void btnSynchronizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSynchronizeActionPerformed
        StringBuilder sb = new StringBuilder();
        String ttl;
        int type;
        if(isEmpty()) {
            sb.append("Fields with * markers cannot be empty.");
            ttl = "LDS : Warning";
            type = JOptionPane.WARNING_MESSAGE;
            this.main.userDialog(sb, ttl, type);
        } else {
            if(this.getPrice() != 0) {
                this.trxTotal.setText(this.getTotal());
                this.iter++;
                sb.append("Data synchronized !");
                ttl = "LDS : Information";
                type = JOptionPane.INFORMATION_MESSAGE;
                this.main.userDialog(sb, ttl, type);
            } else {
                sb.append("Unable to synchronize data.");
                ttl = "LDS : Error";
                type = JOptionPane.ERROR_MESSAGE;
                this.main.userDialog(sb, ttl, type);
            }
        }
    }//GEN-LAST:event_btnSynchronizeActionPerformed

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        StringBuilder sb = new StringBuilder();
        String ttl;
        int type;
        if(isEmpty()) {
            sb.append("Fields with * markers cannot be empty.");
            ttl = "LDS : Warning";
            type = JOptionPane.WARNING_MESSAGE;
            this.main.userDialog(sb, ttl, type);
        } else {
            if(iter == 0)  {
                sb.append("Please Synchronize before proceeding.");
                ttl = "LDS : Warning";
                type = JOptionPane.WARNING_MESSAGE;
                this.main.userDialog(sb, ttl, type);
            } else {
                String id = this.getId();
                JDialog frm = new DetailsFrm(this.main, true, this.getResult(id));
                setDialog(frm);
            }
        }
    }//GEN-LAST:event_btnProcessActionPerformed

    private void comboTrxSrvcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTrxSrvcActionPerformed
        this.iter = 0;
    }//GEN-LAST:event_comboTrxSrvcActionPerformed

    private void txtTrxWeightStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtTrxWeightStateChanged
        this.iter = 0;
    }//GEN-LAST:event_txtTrxWeightStateChanged

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
            java.util.logging.Logger.getLogger(AddTrxFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddTrxFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddTrxFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddTrxFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddTrxFrm dialog = new AddTrxFrm(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton btnPurge;
    private javax.swing.JButton btnResetCnee;
    private javax.swing.JButton btnResetDetails;
    private javax.swing.JButton btnResetShipper;
    private javax.swing.JButton btnSynchronize;
    private javax.swing.JButton btnbtn;
    private javax.swing.JComboBox<Area> comboCneeArea;
    private javax.swing.JComboBox<CityRegency> comboCneeCity;
    private javax.swing.JComboBox<Area> comboShpArea;
    private javax.swing.JComboBox<CityRegency> comboShpCity;
    private javax.swing.JComboBox<PackageType> comboTrxPckg;
    private javax.swing.JComboBox<ServiceType> comboTrxSrvc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel panelConsig;
    private javax.swing.JPanel panelDetails;
    private javax.swing.JPanel panelShipper;
    private javax.swing.JLabel trxDest;
    private javax.swing.JLabel trxOrig;
    private javax.swing.JLabel trxTotal;
    private javax.swing.JTextArea txtCneeAddr;
    private javax.swing.JTextField txtCneeName;
    private javax.swing.JTextField txtCneePhn;
    private javax.swing.JTextArea txtShipAddr;
    private javax.swing.JTextField txtShipName;
    private javax.swing.JTextField txtShipPhn;
    private javax.swing.JTextArea txtTrxDet;
    private javax.swing.JSpinner txtTrxWeight;
    // End of variables declaration//GEN-END:variables
}
