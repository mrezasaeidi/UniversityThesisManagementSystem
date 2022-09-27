/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import Information.Employee;
import Information.Person;
import Information.Student;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Irana
 */
public class InformationPage extends javax.swing.JFrame {

    /**
     * Creates new form InformationPage
     *
     * @param p
     */
    private Person p;

    public InformationPage(Person p) {
        initComponents();
        this.p = p;
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((int) (d.getWidth() - this.getWidth()) / 2, (int) (d.getHeight() - this.getHeight()) / 2);
        this.setTitle("Information");
        lab_name.setText(p.get_name() + " " + p.get_lastname());
        if (p instanceof Employee) {
            lab_idKind.setText("Employee ID:");
        }
        lab_name2.setText(p.get_name());
        lab_lastname.setText(p.get_lastname());
        lab_natcode.setText(p.get_natCode());
        lab_id.setText(p.get_Id());
        lab_level.setText(p.get_level());
        lab_field.setText(p.get_field());
        if (p instanceof Employee) {
            lab_post2.setText(((Employee) p).get_post());
            lab_post2.setVisible(true);
        } else {
            lab_post2.setVisible(false);
            lab_post.setVisible(false);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lab_idKind = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lab_name2 = new javax.swing.JLabel();
        lab_lastname = new javax.swing.JLabel();
        lab_natcode = new javax.swing.JLabel();
        lab_id = new javax.swing.JLabel();
        lab_level = new javax.swing.JLabel();
        lab_field = new javax.swing.JLabel();
        lab_post = new javax.swing.JLabel();
        lab_post2 = new javax.swing.JLabel();

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
        lab_header.setText("Show Information");

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
        lab_showInfo.setText("Home");
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Lastname:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("National code:");

        lab_idKind.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lab_idKind.setForeground(new java.awt.Color(255, 255, 255));
        lab_idKind.setText("Student ID:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Level:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Field:");

        lab_name2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lab_name2.setText("jLabel5");

        lab_lastname.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lab_lastname.setText("jLabel8");

        lab_natcode.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lab_natcode.setText("jLabel9");

        lab_id.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lab_id.setText("jLabel10");

        lab_level.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lab_level.setText("jLabel11");

        lab_field.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lab_field.setText("jLabel12");

        lab_post.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lab_post.setForeground(new java.awt.Color(255, 255, 255));
        lab_post.setText("Post:");

        lab_post2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lab_post2.setText("jLabel8");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lab_name2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lab_lastname))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lab_natcode))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lab_idKind)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lab_id))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lab_level))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lab_field))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lab_post)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lab_post2)))
                .addContainerGap(418, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lab_name2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lab_lastname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lab_natcode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab_idKind)
                    .addComponent(lab_id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lab_level))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lab_field))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab_post)
                    .addComponent(lab_post2))
                .addContainerGap(248, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(88, 88, 88))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        Profile pro = new Profile(p);
        pro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lab_showInfoMouseClicked

    private void lab_manageThesesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab_manageThesesMouseClicked
        // TODO add your handling code here:
        if (p instanceof Student) {
            StudentThesisSystem sths = new StudentThesisSystem((Student)p);
            sths.setVisible(true);
            this.dispose();
        }else{
            EmployeeThesisSystem eths = new EmployeeThesisSystem((Employee)p);
            eths.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_lab_manageThesesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lab_field;
    private javax.swing.JLabel lab_header;
    private javax.swing.JLabel lab_id;
    private javax.swing.JLabel lab_idKind;
    private javax.swing.JLabel lab_lastname;
    private javax.swing.JLabel lab_level;
    private javax.swing.JLabel lab_logout;
    private javax.swing.JLabel lab_manageTheses;
    private javax.swing.JLabel lab_name;
    private javax.swing.JLabel lab_name2;
    private javax.swing.JLabel lab_natcode;
    private javax.swing.JLabel lab_post;
    private javax.swing.JLabel lab_post2;
    private javax.swing.JLabel lab_showInfo;
    // End of variables declaration//GEN-END:variables
}