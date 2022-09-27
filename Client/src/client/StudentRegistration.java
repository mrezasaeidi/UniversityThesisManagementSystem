/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import Information.Student;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author Irana
 */
public class StudentRegistration extends javax.swing.JFrame {

    /**
     * Creates new form StudentRegistration
     */
    public StudentRegistration() {
        initComponents();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((int) (d.getWidth() - this.getWidth()) / 2, (int) (d.getHeight() - this.getHeight()) / 2);
        this.setTitle("Student Registration");
        lab_natcode2.setVisible(false);
        lab_id2.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField6 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_lastname = new javax.swing.JTextField();
        txt_ncode = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        txt_field = new javax.swing.JTextField();
        combo_level = new javax.swing.JComboBox();
        txt_password = new javax.swing.JPasswordField();
        txt_password2 = new javax.swing.JPasswordField();
        btn_bsck = new javax.swing.JButton();
        btn_register = new javax.swing.JButton();
        lab_name = new javax.swing.JLabel();
        lab_lastname = new javax.swing.JLabel();
        lab_natcode = new javax.swing.JLabel();
        lab_id = new javax.swing.JLabel();
        lab_field = new javax.swing.JLabel();
        lab_pass = new javax.swing.JLabel();
        lab_pass2 = new javax.swing.JLabel();
        lab_natcode2 = new javax.swing.JLabel();
        lab_id2 = new javax.swing.JLabel();
        lab_passwarning = new javax.swing.JLabel();

        jTextField6.setText("jTextField6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Student and Personnel Automation of Isfahan University");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Student Registration");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Last name:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("National code:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Student ID:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Level:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Field:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Password:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Re Password:");

        txt_name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txt_lastname.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txt_ncode.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txt_id.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txt_field.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        combo_level.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        combo_level.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "BSC", "MSC", "PHD" }));

        txt_password.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txt_password2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        btn_bsck.setText("Back");
        btn_bsck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_bsckMouseClicked(evt);
            }
        });

        btn_register.setText("Register");
        btn_register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_registerMouseClicked(evt);
            }
        });

        lab_name.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lab_name.setForeground(new java.awt.Color(255, 0, 0));
        lab_name.setText("*");

        lab_lastname.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lab_lastname.setForeground(new java.awt.Color(255, 0, 0));
        lab_lastname.setText("*");

        lab_natcode.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lab_natcode.setForeground(new java.awt.Color(255, 0, 0));
        lab_natcode.setText("*");

        lab_id.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lab_id.setForeground(new java.awt.Color(255, 0, 0));
        lab_id.setText("*");

        lab_field.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lab_field.setForeground(new java.awt.Color(255, 0, 0));
        lab_field.setText("*");

        lab_pass.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lab_pass.setForeground(new java.awt.Color(255, 0, 0));
        lab_pass.setText("*");

        lab_pass2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lab_pass2.setForeground(new java.awt.Color(255, 0, 0));
        lab_pass2.setText("*");

        lab_natcode2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lab_natcode2.setForeground(new java.awt.Color(255, 0, 0));
        lab_natcode2.setText("this national code has already exist");

        lab_id2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lab_id2.setForeground(new java.awt.Color(255, 0, 0));
        lab_id2.setText("this ID has already exist");

        lab_passwarning.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lab_passwarning.setForeground(new java.awt.Color(255, 0, 0));
        lab_passwarning.setText("at least 8 caharacters");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(81, 81, 81)
                                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(56, 56, 56)
                                    .addComponent(txt_lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(33, 33, 33)
                                    .addComponent(txt_ncode))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))
                                    .addGap(52, 52, 52)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_id, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                        .addComponent(txt_field)
                                        .addComponent(combo_level, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel10))
                                    .addGap(37, 37, 37)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_password)
                                        .addComponent(txt_password2))))
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lab_name)
                            .addComponent(lab_lastname)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lab_natcode)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lab_natcode2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lab_id)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lab_id2))
                            .addComponent(lab_field)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lab_pass)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lab_passwarning))
                            .addComponent(lab_pass2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(btn_bsck, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btn_register, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel2)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lab_name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lab_lastname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_ncode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lab_natcode)
                    .addComponent(lab_natcode2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lab_id)
                    .addComponent(lab_id2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(combo_level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lab_field))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lab_pass)
                    .addComponent(lab_passwarning))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_password2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lab_pass2))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_bsck)
                    .addComponent(btn_register))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_bsckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bsckMouseClicked
        // TODO add your handling code here:
        Register_type register = new Register_type();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        register.setLocation((int) (d.getWidth() - register.getWidth()) / 2, (int) (d.getHeight() - register.getHeight()) / 2);
        register.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_bsckMouseClicked

    private void btn_registerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_registerMouseClicked
        // TODO add your handling code here:
        boolean f = true;
        if (!txt_name.getText().isEmpty() && !txt_lastname.getText().isEmpty() && !txt_ncode.getText().isEmpty() && !txt_id.getText().isEmpty() && !txt_field.getText().isEmpty()) {
            try {
                Client.os.writeInt(3);
                Client.os.flush();
                Client.os.writeObject(txt_ncode.getText());
                Client.os.flush();
                if (Client.is.readBoolean()) {
                    lab_natcode2.setVisible(false);
                    Client.os.writeObject(txt_id.getText());
                    Client.os.flush();
                    if (Client.is.readBoolean()) {
                        lab_id2.setVisible(false);
                        if (txt_password.getText().length() >= 8) {
                            Client.os.writeBoolean(true);
                            Client.os.flush();
                            if (txt_password.getText().equals(txt_password2.getText())) {
                                Client.os.writeBoolean(true);
                                Client.os.flush();
                                lab_passwarning.setText("at least 8 caharacters");
                                Student s = new Student(txt_name.getText(), txt_lastname.getText(), txt_ncode.getText(), txt_id.getText(), (String) combo_level.getSelectedItem(), txt_field.getText(), txt_password.getText());
                                Client.os.writeObject(s);
                                Client.os.flush();
                                JOptionPane.showMessageDialog(this, "Sign up successfully :)", "welcome", JOptionPane.INFORMATION_MESSAGE);
                                Login login = new Login();
                                login.setVisible(true);
                                this.dispose();
                            } else {
                                Client.os.writeBoolean(false);
                                Client.os.flush();
                                lab_passwarning.setText("Password and iteration are not the same");
                                f = false;
                            }
                        } else {
                            Client.os.writeBoolean(false);
                            Client.os.flush();
                            lab_passwarning.setText("Password must be at least 8 caharacters");
                            f = false;
                        }
                    } else {
                        lab_id2.setVisible(true);
                        f = false;
                    }
                } else {
                    lab_natcode2.setVisible(true);
                    f = false;
                }
                if (!f) {
                    JOptionPane.showMessageDialog(this, "Error", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Server Not Find.", "ERROR", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Starred fields should not be empty", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_registerMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_bsck;
    private javax.swing.JButton btn_register;
    private javax.swing.JComboBox combo_level;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lab_field;
    private javax.swing.JLabel lab_id;
    private javax.swing.JLabel lab_id2;
    private javax.swing.JLabel lab_lastname;
    private javax.swing.JLabel lab_name;
    private javax.swing.JLabel lab_natcode;
    private javax.swing.JLabel lab_natcode2;
    private javax.swing.JLabel lab_pass;
    private javax.swing.JLabel lab_pass2;
    private javax.swing.JLabel lab_passwarning;
    private javax.swing.JTextField txt_field;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_lastname;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_ncode;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JPasswordField txt_password2;
    // End of variables declaration//GEN-END:variables
}
