/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import Information.Employee;
import Information.Notification;
import Information.Person;
import Information.Student;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Irana
 */
public class Profile extends javax.swing.JFrame {

    /**
     * Creates new form PersonnelProfile
     *
     * @param p
     */
    private Person p;
    private DefaultTableModel model;
    private int unreadnot = 0;

    public Profile(Person p) {
        initComponents();
        this.p = p;
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((int) (d.getWidth() - this.getWidth()) / 2, (int) (d.getHeight() - this.getHeight()) / 2);
        if (p instanceof Student) {
            lab_header.setText("Student Profile");
            this.setTitle("Student Profile");
        } else {
            this.setTitle("Personnel Profile");
        }
        lab_name.setText(p.get_name() + " " + p.get_lastname());
        model = (DefaultTableModel) table_notification.getModel();
        String a[] = new String[4];
        for (int i = 0; i < p.get_notification().size(); i++) {
            model.addRow(a);
            table_notification.setValueAt(((Notification) p.get_notification().get(p.get_notification().size() - (i + 1))).get_sender(), i, 0);
            table_notification.setValueAt(((Notification) p.get_notification().get(p.get_notification().size() - (i + 1))).get_topic(), i, 1);
            table_notification.setValueAt(((Notification) p.get_notification().get(p.get_notification().size() - (i + 1))).get_date().toString(), i, 2);
            if (((Notification) p.get_notification().get(p.get_notification().size() - (i + 1))).get_status() == 0) {
                table_notification.setValueAt("Unread", i, 3);
                unreadnot++;
            } else {
                table_notification.setValueAt("Readed", i, 3);
            }
        }
        this.setVisible(true);
        if (unreadnot > 0) {
            JOptionPane.showMessageDialog(this, "You have " + unreadnot + " Unread Message.", "You have unread Message", JOptionPane.INFORMATION_MESSAGE);
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
        lab_manageTheses = new javax.swing.JLabel();
        lab_logout = new javax.swing.JLabel();
        lab_showInfo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_notification = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText(" Student and Personnel Automation of Isfahan University");

        lab_header.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lab_header.setForeground(new java.awt.Color(255, 255, 153));
        lab_header.setText("Personnel Profile");

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
                        .addGap(308, 308, 308)
                        .addComponent(lab_header)))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lab_header)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));

        lab_name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lab_name.setForeground(new java.awt.Color(255, 0, 0));
        lab_name.setText("name");

        lab_manageTheses.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lab_manageTheses.setText("Manage theses");
        lab_manageTheses.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lab_manageTheses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab_manageThesesMouseClicked(evt);
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
                    .addComponent(lab_manageTheses)
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
                .addComponent(lab_showInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lab_manageTheses)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lab_logout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setPreferredSize(new java.awt.Dimension(570, 449));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Notifications");

        table_notification.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        table_notification.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sender", "Topic", "Time", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_notification.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table_notification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_notificationMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_notification);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
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
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)))
                .addGap(80, 80, 80))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void lab_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab_logoutMouseClicked
        // TODO add your handling code here:
        Client.end();
        Client.start();
        this.dispose();
    }//GEN-LAST:event_lab_logoutMouseClicked

    private void lab_showInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab_showInfoMouseClicked
        // TODO add your handling code here:
        InformationPage info = new InformationPage(p);
        info.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lab_showInfoMouseClicked

    private void lab_manageThesesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab_manageThesesMouseClicked
        // TODO add your handling code here:
        if (p instanceof Student) {
            StudentThesisSystem sths = new StudentThesisSystem((Student) p);
            sths.setVisible(true);
            this.dispose();
        } else {
            EmployeeThesisSystem eths = new EmployeeThesisSystem((Employee) p);
            eths.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_lab_manageThesesMouseClicked

    private void table_notificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_notificationMouseClicked
        // TODO add your handling code here:
        if (((Notification) p.get_notification().get((p.get_notification().size()) - (table_notification.getSelectedRow() + 1))).get_status() == 0) {
            try {
                Client.os.writeInt(15);
                Client.os.flush();
                Client.os.writeObject(p.get_Id());
                Client.os.flush();
                Client.os.writeObject((Notification) p.get_notification().get((p.get_notification().size()) - (table_notification.getSelectedRow() + 1)));
                Client.os.flush();
                table_notification.setValueAt("Readed", table_notification.getSelectedRow(), 3);
                ((Notification) p.get_notification().get((p.get_notification().size()) - (table_notification.getSelectedRow() + 1))).set_status(1);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Server Not Find.", "ERROR", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
        NotificationPage notPage = new NotificationPage((Notification) p.get_notification().get((p.get_notification().size()) - (table_notification.getSelectedRow() + 1)), p);
        notPage.setVisible(true);
    }//GEN-LAST:event_table_notificationMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lab_header;
    private javax.swing.JLabel lab_logout;
    private javax.swing.JLabel lab_manageTheses;
    private javax.swing.JLabel lab_name;
    private javax.swing.JLabel lab_showInfo;
    private javax.swing.JTable table_notification;
    // End of variables declaration//GEN-END:variables
}