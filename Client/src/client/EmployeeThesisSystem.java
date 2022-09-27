/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import Information.Employee;
import Information.Thesis;
import Information.BscThesis;
import Information.MscThesis;
import Information.PhdThesis;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Irana
 */
public class EmployeeThesisSystem extends javax.swing.JFrame {

    /**
     * Creates new form EmployeeThesisSystem
     */
    private Employee e;
    private DefaultTableModel model;

    public EmployeeThesisSystem(Employee e) {
        initComponents();
        this.e = e;
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((int) (d.getWidth() - this.getWidth()) / 2, (int) (d.getHeight() - this.getHeight()) / 2);
        this.setTitle("Employee Thesis System");
        lab_name.setText(e.get_name() + " " + e.get_lastname());
        model = (DefaultTableModel) table_thesisList.getModel();
        String a[] = new String[4];
        for (int i = 0; i < e.get_thesis().size(); i++) {
            model.addRow(a);
            table_thesisList.setValueAt(((Thesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_Id(), i, 0);
            table_thesisList.setValueAt(((Thesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_topic(), i, 1);
            table_thesisList.setValueAt(((Thesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_stdName(), i, 2);
            if ((e.get_thesis().get(e.get_thesis().size() - (i + 1))) instanceof BscThesis) {
                if (((BscThesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_donId().equals(e.get_Id())) {
                    table_thesisList.setValueAt("supervisor", i, 4);
                } else if (((BscThesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_jurorId() != null && ((BscThesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_jurorId().equals(e.get_Id())) {
                    table_thesisList.setValueAt("juror", i, 4);
                } else {
                    table_thesisList.setValueAt("head of department", i, 4);
                }
            } else if ((e.get_thesis().get(e.get_thesis().size() - (i + 1))) instanceof MscThesis) {
                if (((MscThesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_donId().equals(e.get_Id())) {
                    table_thesisList.setValueAt("supervisor1", i, 4);
                } else if (((MscThesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_donId2() != null && ((MscThesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_donId2().equals(e.get_Id())) {
                    table_thesisList.setValueAt("supervisor2", i, 4);
                } else if (((MscThesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_jurorId() != null && ((MscThesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_jurorId().equals(e.get_Id())) {
                    table_thesisList.setValueAt("juror1", i, 4);
                } else if (((MscThesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_jurorId2() != null && ((MscThesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_jurorId2().equals(e.get_Id())) {
                    table_thesisList.setValueAt("juror2", i, 4);
                } else if (((MscThesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_observerId() != null && ((MscThesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_observerId().equals(e.get_Id())) {
                    table_thesisList.setValueAt("observer", i, 4);
                } else if (((MscThesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_advisorId() != null && ((MscThesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_advisorId().equals(e.get_Id())) {
                    table_thesisList.setValueAt("advisor", i, 4);
                } else if (e.get_post().equals("head of department")) {
                    table_thesisList.setValueAt("head of department", i, 4);
                } else {
                    table_thesisList.setValueAt("expert of graduate", i, 4);
                }
            } else if ((e.get_thesis().get(e.get_thesis().size() - (i + 1))) instanceof PhdThesis) {
                if (((PhdThesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_donId().equals(e.get_Id())) {
                    table_thesisList.setValueAt("supervisor1", i, 4);
                } else if (((PhdThesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_donId2() != null && ((PhdThesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_donId2().equals(e.get_Id())) {
                    table_thesisList.setValueAt("supervisor2", i, 4);
                } else if (((PhdThesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_jurorId() != null && ((PhdThesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_jurorId().equals(e.get_Id())) {
                    table_thesisList.setValueAt("juror1", i, 4);
                } else if (((PhdThesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_jurorId2() != null && ((PhdThesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_jurorId2().equals(e.get_Id())) {
                    table_thesisList.setValueAt("juror2", i, 4);
                } else if (((PhdThesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_jurorId3() != null && ((PhdThesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_jurorId3().equals(e.get_Id())) {
                    table_thesisList.setValueAt("juror3", i, 4);
                } else if (((PhdThesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_observerId() != null && ((PhdThesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_observerId().equals(e.get_Id())) {
                    table_thesisList.setValueAt("observer", i, 4);
                } else if (((PhdThesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_advisorId() != null && ((PhdThesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_advisorId().equals(e.get_Id())) {
                    table_thesisList.setValueAt("advisor", i, 4);
                } else if (e.get_post().equals("head of department")) {
                    table_thesisList.setValueAt("head of department", i, 4);
                } else {
                    table_thesisList.setValueAt("expert of graduate", i, 4);
                }
            }
            if (((Thesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_status() == 0) {
                table_thesisList.setValueAt("Pending approval by the supervisor", i, 3);
            } else if (((Thesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_status() == 1 && ((Thesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_jurorId() == null) {
                table_thesisList.setValueAt("Pending appointment of the referee", i, 3);
            } else if (((Thesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_status() == -1) {
                table_thesisList.setValueAt("Rejected by the supervisor", i, 3);
            } else if (((Thesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_status() == 1 && ((Thesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_jurorId() != null && ((Thesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_location().equals("Not Set")) {
                table_thesisList.setValueAt("Waiting for appointment of time and place", i, 3);
            } else if (((Thesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_status() == 1 && ((Thesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_jurorId() != null && !(((Thesis) e.get_thesis().get(e.get_thesis().size() - (i + 1))).get_location().equals("Not Set"))) {
                table_thesisList.setValueAt("Invitation sent", i, 3);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lab_header = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lab_name = new javax.swing.JLabel();
        lab_home = new javax.swing.JLabel();
        lab_logout = new javax.swing.JLabel();
        lab_showInfo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_thesisList = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText(" Student and Personnel Automation of Isfahan University");

        lab_header.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lab_header.setForeground(new java.awt.Color(255, 255, 153));
        lab_header.setText("Employee Theses System");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(lab_header)))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lab_header)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));

        lab_name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lab_name.setForeground(new java.awt.Color(255, 0, 0));
        lab_name.setText("name");

        lab_home.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lab_home.setText("Home");
        lab_home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lab_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab_homeMouseClicked(evt);
            }
        });

        lab_logout.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lab_logout.setText("Log out");
        lab_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lab_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab_logoutMouseClicked(evt);
            }
        });

        lab_showInfo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lab_showInfo.setText("Show information");
        lab_showInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lab_showInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab_showInfoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lab_name)
                    .addComponent(lab_home)
                    .addComponent(lab_logout)
                    .addComponent(lab_showInfo))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lab_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lab_home)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lab_showInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lab_logout)
                .addContainerGap(326, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setPreferredSize(new java.awt.Dimension(570, 449));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Theses List");

        table_thesisList.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        table_thesisList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Thesis ID", "Topic", "Owner Name", "Status", " Your role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_thesisList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table_thesisList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_thesisListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_thesisList);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(256, 256, 256))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lab_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab_homeMouseClicked
        // TODO add your handling code here:
        Profile pro = new Profile(e);
        pro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lab_homeMouseClicked

    private void lab_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab_logoutMouseClicked
        // TODO add your handling code here:
        Client.end();
        Client.start();
        this.dispose();
    }//GEN-LAST:event_lab_logoutMouseClicked

    private void lab_showInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab_showInfoMouseClicked
        // TODO add your handling code here:
        InformationPage info = new InformationPage(e);
        info.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lab_showInfoMouseClicked

    private void table_thesisListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_thesisListMouseClicked
        // TODO add your handling code here:
        int index = e.get_thesis().size() - table_thesisList.getSelectedRow() - 1;
        if ((e.get_thesis().get(index)) instanceof BscThesis) {
            if (((BscThesis) (e.get_thesis().get(index))).get_donId().equals(e.get_Id())) {
                BscThesisPage bp = new BscThesisPage((BscThesis) (e.get_thesis().get(index)), 2);
                bp.setVisible(true);
                bp.setAlwaysOnTop(true);
            } else if (((BscThesis) (e.get_thesis().get(index))).get_jurorId() != null && ((BscThesis) (e.get_thesis().get(index))).get_jurorId().equals(e.get_Id())) {
                BscThesisPage bp = new BscThesisPage((BscThesis) (e.get_thesis().get(index)), 0);
                bp.setVisible(true);
                bp.setAlwaysOnTop(true);
            } else {
                BscThesisPage bp = new BscThesisPage((BscThesis) (e.get_thesis().get(index)), 3);
                bp.setVisible(true);
                bp.setAlwaysOnTop(true);
            }
        } else if ((e.get_thesis().get(index)) instanceof MscThesis) {
            if (((MscThesis) (e.get_thesis().get(index))).get_donId().equals(e.get_Id())) {
                MscAndPhdThesisPage mp = new MscAndPhdThesisPage((Thesis) (e.get_thesis().get(index)), 2);
                mp.setVisible(true);
                mp.setAlwaysOnTop(true);
            } else if (((MscThesis) (e.get_thesis().get(index))).get_donId2() != null && ((MscThesis) (e.get_thesis().get(index))).get_donId2().equals(e.get_Id())) {
                MscAndPhdThesisPage mp = new MscAndPhdThesisPage((Thesis) (e.get_thesis().get(index)), 3);
                mp.setVisible(true);
                mp.setAlwaysOnTop(true);
            } else if (((MscThesis) (e.get_thesis().get(index))).get_jurorId() != null && ((MscThesis) (e.get_thesis().get(index))).get_jurorId().equals(e.get_Id())) {
                MscAndPhdThesisPage mp = new MscAndPhdThesisPage((Thesis) (e.get_thesis().get(index)), 0);
                mp.setVisible(true);
                mp.setAlwaysOnTop(true);
            } else if (((MscThesis) (e.get_thesis().get(index))).get_jurorId2() != null && ((MscThesis) (e.get_thesis().get(index))).get_jurorId2().equals(e.get_Id())) {
                MscAndPhdThesisPage mp = new MscAndPhdThesisPage((Thesis) (e.get_thesis().get(index)), 0);
                mp.setVisible(true);
                mp.setAlwaysOnTop(true);
            } else if (((MscThesis) (e.get_thesis().get(index))).get_observerId() != null && ((MscThesis) (e.get_thesis().get(index))).get_observerId().equals(e.get_Id())) {
                MscAndPhdThesisPage mp = new MscAndPhdThesisPage((Thesis) (e.get_thesis().get(index)), 0);
                mp.setVisible(true);
                mp.setAlwaysOnTop(true);
            } else if (((MscThesis) (e.get_thesis().get(index))).get_advisorId() != null && ((MscThesis) (e.get_thesis().get(index))).get_advisorId().equals(e.get_Id())) {
                MscAndPhdThesisPage mp = new MscAndPhdThesisPage((Thesis) (e.get_thesis().get(index)), 0);
                mp.setVisible(true);
                mp.setAlwaysOnTop(true);
            } else if (e.get_post().equals("head of department")) {
                MscAndPhdThesisPage mp = new MscAndPhdThesisPage((Thesis) (e.get_thesis().get(index)), 4);
                mp.setVisible(true);
                mp.setAlwaysOnTop(true);
            } else {
                MscAndPhdThesisPage mp = new MscAndPhdThesisPage((Thesis) (e.get_thesis().get(index)), 5);
                mp.setVisible(true);
                mp.setAlwaysOnTop(true);
            }
        } else if ((e.get_thesis().get(index)) instanceof PhdThesis) {
            if (((PhdThesis) (e.get_thesis().get(index))).get_donId().equals(e.get_Id())) {
                MscAndPhdThesisPage mp = new MscAndPhdThesisPage((Thesis) (e.get_thesis().get(index)), 2);
                mp.setVisible(true);
                mp.setAlwaysOnTop(true);
            } else if (((PhdThesis) (e.get_thesis().get(index))).get_donId2() != null && ((PhdThesis) (e.get_thesis().get(index))).get_donId2().equals(e.get_Id())) {
                MscAndPhdThesisPage mp = new MscAndPhdThesisPage((Thesis) (e.get_thesis().get(index)), 3);
                mp.setVisible(true);
                mp.setAlwaysOnTop(true);
            } else if (((PhdThesis) (e.get_thesis().get(index))).get_jurorId() != null && ((PhdThesis) (e.get_thesis().get(index))).get_jurorId().equals(e.get_Id())) {
                MscAndPhdThesisPage mp = new MscAndPhdThesisPage((Thesis) (e.get_thesis().get(index)), 0);
                mp.setVisible(true);
                mp.setAlwaysOnTop(true);
            } else if (((PhdThesis) (e.get_thesis().get(index))).get_jurorId2() != null && ((PhdThesis) (e.get_thesis().get(index))).get_jurorId2().equals(e.get_Id())) {
                MscAndPhdThesisPage mp = new MscAndPhdThesisPage((Thesis) (e.get_thesis().get(index)), 0);
                mp.setVisible(true);
                mp.setAlwaysOnTop(true);
            } else if (((PhdThesis) (e.get_thesis().get(index))).get_jurorId3() != null && ((PhdThesis) (e.get_thesis().get(index))).get_jurorId3().equals(e.get_Id())) {
                MscAndPhdThesisPage mp = new MscAndPhdThesisPage((Thesis) (e.get_thesis().get(index)), 0);
                mp.setVisible(true);
                mp.setAlwaysOnTop(true);
            } else if (((PhdThesis) (e.get_thesis().get(index))).get_observerId() != null && ((PhdThesis) (e.get_thesis().get(index))).get_observerId().equals(e.get_Id())) {
                MscAndPhdThesisPage mp = new MscAndPhdThesisPage((Thesis) (e.get_thesis().get(index)), 0);
                mp.setVisible(true);
                mp.setAlwaysOnTop(true);
            } else if (((PhdThesis) (e.get_thesis().get(index))).get_advisorId() != null && ((PhdThesis) (e.get_thesis().get(index))).get_advisorId().equals(e.get_Id())) {
                MscAndPhdThesisPage mp = new MscAndPhdThesisPage((Thesis) (e.get_thesis().get(index)), 0);
                mp.setVisible(true);
                mp.setAlwaysOnTop(true);
            } else if (e.get_post().equals("head of department")) {
                MscAndPhdThesisPage mp = new MscAndPhdThesisPage((Thesis) (e.get_thesis().get(index)), 4);
                mp.setVisible(true);
                mp.setAlwaysOnTop(true);
            } else {
                MscAndPhdThesisPage mp = new MscAndPhdThesisPage((Thesis) (e.get_thesis().get(index)), 5);
                mp.setVisible(true);
                mp.setAlwaysOnTop(true);
            }
        }
    }//GEN-LAST:event_table_thesisListMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lab_header;
    private javax.swing.JLabel lab_home;
    private javax.swing.JLabel lab_logout;
    private javax.swing.JLabel lab_name;
    private javax.swing.JLabel lab_showInfo;
    private javax.swing.JTable table_thesisList;
    // End of variables declaration//GEN-END:variables
}
