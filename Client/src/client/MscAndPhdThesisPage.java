/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import Information.MscThesis;
import Information.PhdThesis;
import Information.Thesis;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author Irana
 */
public class MscAndPhdThesisPage extends javax.swing.JFrame {

    /**
     * Creates new form ThesisPage
     */
    private Thesis t;
    private int kind;

    /**
     * if visitor is normal person:k=0; if visitor is owner of thesis:k=1; if
     * visitor is supervisor1:k=2;if visitor is supervisor2:k=3; if visitor is
     * head of department:k=4; if visitor is expert of graduate:k=5;
     *
     * @param t
     * @param k
     */
    public MscAndPhdThesisPage(Thesis t, int k) {
        initComponents();
        this.t = t;
        kind = k;
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((int) (d.getWidth() - this.getWidth()) / 2, (int) (d.getHeight() - this.getHeight()) / 2);
        txt_id.setText(t.get_Id() + "");
        txt_id.setEditable(false);
        txt_ownerName.setText(t.get_stdName());
        txt_ownerName.setEditable(false);
        txt_ownerfield.setText(t.get_stdField());
        txt_ownerfield.setEditable(false);
        txt_jurorName.setText(t.get_jurorName());
        txt_jurorName.setEditable(false);
        txt_supervisorName.setText(t.get_donName());
        txt_supervisorName.setEditable(false);
        txt_location.setText(t.get_location());
        txt_location.setEditable(false);
        if (t.get_date() != null) {
            txt_time.setText(t.get_date().toString());
        } else {
            txt_time.setText("Not set");
        }
        txt_time.setEditable(false);
        txt_topic.setText(t.get_topic());
        txt_topic.setEditable(false);
        txt_summary.setText(t.get_summary());
        txt_summary.setEditable(false);
        if (t.get_status() == 0) {
            txt_status.setText("Pending approval by the supervisor");
        } else if (t.get_status() == 1 && t.get_jurorId() == null) {
            txt_status.setText("Pending appointment of the referee");
        } else if (t.get_status() == -1) {
            txt_status.setText("Rejected by the supervisor");
        } else if (t.get_status() == 1 && t.get_jurorId() != null && t.get_location().equals("Not Set")) {
            txt_status.setText("Waiting for appointment of time and place");
        } else if (t.get_status() == 1 && t.get_jurorId() != null && !(t.get_location().equals("Not Set"))) {
            txt_status.setText("Invitation sent");
        }
        txt_status.setEditable(false);
        if (t instanceof MscThesis) {
            lab_jurorName3.setVisible(false);
            txt_jurorName3.setVisible(false);
            this.setTitle("Msc Thesis Information");
            txt_advisorName.setText(((MscThesis) t).get_advisorName());
            txt_advisorName.setEditable(false);
            txt_jurorName2.setText(((MscThesis) t).get_jurorNmae2());
            txt_jurorName2.setEditable(false);
            if (((MscThesis) t).get_donName2() != null) {
                txt_supervisorName2.setText(((MscThesis) t).get_donName2());
                txt_supervisorName2.setEditable(false);
            } else {
                txt_supervisorName2.setVisible(false);
                lab_supervisorName2.setVisible(false);
            }
            txt_observerName.setText(((MscThesis) t).get_observerName());
            txt_observerName.setEditable(false);

        } else {
            this.setTitle("Phd Thesis Information");
            txt_advisorName.setText(((PhdThesis) t).get_advisorName());
            txt_advisorName.setEditable(false);
            txt_jurorName2.setText(((PhdThesis) t).get_jurorNmae2());
            txt_jurorName2.setEditable(false);
            txt_jurorName3.setText(((PhdThesis) t).get_jurorNmae3());
            txt_jurorName3.setEditable(false);
            if (((PhdThesis) t).get_donName2() != null) {
                txt_supervisorName2.setText(((PhdThesis) t).get_donName2());
                txt_supervisorName2.setEditable(false);
            } else {
                txt_supervisorName2.setVisible(false);
                lab_supervisorName2.setVisible(false);
            }
            txt_observerName.setText(((PhdThesis) t).get_observerName());
            txt_observerName.setEditable(false);
        }
        switch (k) {
            case 0:
            case 1:
                combo_action.setVisible(false);
                lab_warning.setVisible(false);
                btn_continue.setVisible(false);
                break;
            case 2:
                if (t.get_status1() == 1) {
                    combo_action.setVisible(false);
                    lab_warning.setVisible(false);
                    btn_continue.setVisible(false);
                    break;
                } else if (t.get_status1() == 0 || t.get_status1() == -1) {
                    combo_action.addItem("Approve");
                    combo_action.addItem("Do not approve");
                    break;
                }
            case 3:
                if (t.get_status2() == 1) {
                    combo_action.setVisible(false);
                    lab_warning.setVisible(false);
                    btn_continue.setVisible(false);
                    break;
                } else if (t.get_status2() == 0 || t.get_status2() == -1) {
                    combo_action.addItem("Approve");
                    combo_action.addItem("Do not approve");
                    break;
                }
            case 4:
                if (t.get_jurorName().equals("Not Set") && t.get_status() == 1) {
                    combo_action.addItem("Determine the referee");
                    break;
                } else {
                    combo_action.setVisible(false);
                    lab_warning.setVisible(false);
                    btn_continue.setVisible(false);
                    break;
                }
            case 5:
                if (t.get_location().equals("Not Set") && !(t.get_jurorName().equals("Not Set")) && t.get_status() == 1) {
                    combo_action.addItem("Determine the time and place and observer");
                    break;
                } else {
                    combo_action.setVisible(false);
                    lab_warning.setVisible(false);
                    btn_continue.setVisible(false);
                    break;
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
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lab_supervisorName2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lab_jurorName3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lab_warning = new javax.swing.JLabel();
        combo_action = new javax.swing.JComboBox();
        btn_continue = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_id = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_ownerName = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_ownerfield = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_jurorName = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        txt_supervisorName = new javax.swing.JTextPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        txt_jurorName2 = new javax.swing.JTextPane();
        jScrollPane11 = new javax.swing.JScrollPane();
        txt_observerName = new javax.swing.JTextPane();
        jScrollPane12 = new javax.swing.JScrollPane();
        txt_advisorName = new javax.swing.JTextPane();
        jScrollPane13 = new javax.swing.JScrollPane();
        txt_location = new javax.swing.JTextPane();
        jScrollPane14 = new javax.swing.JScrollPane();
        txt_time = new javax.swing.JTextPane();
        jScrollPane15 = new javax.swing.JScrollPane();
        txt_status = new javax.swing.JTextPane();
        jScrollPane16 = new javax.swing.JScrollPane();
        txt_topic = new javax.swing.JTextPane();
        jScrollPane17 = new javax.swing.JScrollPane();
        txt_summary = new javax.swing.JTextArea();
        txt_jurorName3 = new javax.swing.JTextField();
        txt_supervisorName2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jPanel2.setBackground(new java.awt.Color(102, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText(" Student and Personnel Automation of Isfahan University");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(102, 255, 204));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel2.setText("Thesis ID:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setText("Owner Name:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel4.setText("Owner Field:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel5.setText("Supervisor Name:");

        lab_supervisorName2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lab_supervisorName2.setText("Supervisor Name2:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel9.setText("Juror Name:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel10.setText("Juror Name2:");

        lab_jurorName3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lab_jurorName3.setText("Juror Name3:");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel12.setText("Advisor Name:");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel13.setText("Observer Name:");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel14.setText("Place Of Defense:");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel15.setText("Time Of Defense:");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel16.setText("Status:");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel17.setText("Topic:");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel18.setText("Summary:");

        lab_warning.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lab_warning.setForeground(new java.awt.Color(255, 0, 51));
        lab_warning.setText("Please choose action:");

        combo_action.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        combo_action.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please choose" }));

        btn_continue.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_continue.setText("Continue");
        btn_continue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_continueMouseClicked(evt);
            }
        });

        btn_back.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_back.setText("BACK");
        btn_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_backMouseClicked(evt);
            }
        });

        txt_id.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jScrollPane1.setViewportView(txt_id);

        txt_ownerName.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jScrollPane2.setViewportView(txt_ownerName);

        txt_ownerfield.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jScrollPane3.setViewportView(txt_ownerfield);

        txt_jurorName.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jScrollPane4.setViewportView(txt_jurorName);

        txt_supervisorName.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jScrollPane5.setViewportView(txt_supervisorName);

        txt_jurorName2.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jScrollPane8.setViewportView(txt_jurorName2);

        txt_observerName.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jScrollPane11.setViewportView(txt_observerName);

        txt_advisorName.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jScrollPane12.setViewportView(txt_advisorName);

        txt_location.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jScrollPane13.setViewportView(txt_location);

        txt_time.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jScrollPane14.setViewportView(txt_time);

        txt_status.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jScrollPane15.setViewportView(txt_status);

        txt_topic.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jScrollPane16.setViewportView(txt_topic);

        txt_summary.setColumns(20);
        txt_summary.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txt_summary.setRows(5);
        jScrollPane17.setViewportView(txt_summary);

        txt_jurorName3.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        txt_supervisorName2.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane17)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane5))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane3))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane4))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addComponent(jLabel13)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addComponent(lab_supervisorName2)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txt_supervisorName2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGap(11, 11, 11)
                                            .addComponent(jLabel10)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lab_jurorName3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_jurorName3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(45, 45, 45)
                                    .addComponent(lab_warning)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(combo_action, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btn_continue)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel18))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(lab_warning)
                        .addComponent(combo_action, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_back)
                        .addComponent(btn_continue))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lab_jurorName3)
                        .addComponent(txt_jurorName3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lab_supervisorName2)
                        .addComponent(txt_supervisorName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel13))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void btn_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_backMouseClicked

    private void btn_continueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_continueMouseClicked
        // TODO add your handling code here:
        try {
            if (combo_action.getSelectedItem().equals("Approve")) {
                if (t instanceof MscThesis) {
                    Client.os.writeInt(9);
                    Client.os.flush();
                    Client.os.writeInt(1);
                    Client.os.flush();
                } else if (t instanceof PhdThesis) {
                    Client.os.writeInt(9);
                    Client.os.flush();
                    Client.os.writeInt(2);
                    Client.os.flush();
                }
                Client.os.writeInt(t.get_Id());
                Client.os.flush();
                Client.os.writeInt(1);
                Client.os.flush();
                if (kind == 2) {
                    Client.os.writeInt(1);
                    Client.os.flush();
                    t.authenticate1(1);
                } else if (kind == 3) {
                    Client.os.writeInt(2);
                    Client.os.flush();
                    t.authenticate2(1);
                }
                if (Client.is.readBoolean()) {
                    JOptionPane.showMessageDialog(this, "The defense request was successfully approved", "successfully", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "This service is not  available now", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else if (combo_action.getSelectedItem().equals("Do not approve")) {
                if (t instanceof MscThesis) {
                    Client.os.writeInt(9);
                    Client.os.flush();
                    Client.os.writeInt(1);
                    Client.os.flush();
                } else if (t instanceof PhdThesis) {
                    Client.os.writeInt(9);
                    Client.os.flush();
                    Client.os.writeInt(2);
                    Client.os.flush();
                }
                Client.os.writeInt(t.get_Id());
                Client.os.flush();
                Client.os.writeInt(2);
                Client.os.flush();
                if (kind == 2) {
                    Client.os.writeInt(1);
                    Client.os.flush();
                    t.authenticate1(-1);
                } else if (kind == 3) {
                    Client.os.writeInt(2);
                    Client.os.flush();
                    t.authenticate2(-1);
                }
                if (Client.is.readBoolean()) {
                    JOptionPane.showMessageDialog(this, "The defense request was rejected successfully", "successfully", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "This service is not  available now", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else if (combo_action.getSelectedItem().equals("Determine the time and place and observer")) {
                this.dispose();
                SetTimeAndLocationAndObserver st = new SetTimeAndLocationAndObserver(t);
                st.setVisible(true);
                st.setAlwaysOnTop(true);
            } else if (combo_action.getSelectedItem().equals("Determine the referee")) {
                if (t instanceof MscThesis) {
                    this.dispose();
                    SetJuror sj = new SetJuror(2, t);
                    sj.setVisible(true);
                    sj.setAlwaysOnTop(true);
                } else if (t instanceof PhdThesis) {
                    this.dispose();
                    SetJuror sj2 = new SetJuror(3, t);
                    sj2.setVisible(true);
                    sj2.setAlwaysOnTop(true);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Server Not Find.", "ERROR", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_continueMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_continue;
    private javax.swing.JComboBox combo_action;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lab_jurorName3;
    private javax.swing.JLabel lab_supervisorName2;
    private javax.swing.JLabel lab_warning;
    private javax.swing.JTextPane txt_advisorName;
    private javax.swing.JTextPane txt_id;
    private javax.swing.JTextPane txt_jurorName;
    private javax.swing.JTextPane txt_jurorName2;
    private javax.swing.JTextField txt_jurorName3;
    private javax.swing.JTextPane txt_location;
    private javax.swing.JTextPane txt_observerName;
    private javax.swing.JTextPane txt_ownerName;
    private javax.swing.JTextPane txt_ownerfield;
    private javax.swing.JTextPane txt_status;
    private javax.swing.JTextArea txt_summary;
    private javax.swing.JTextPane txt_supervisorName;
    private javax.swing.JTextField txt_supervisorName2;
    private javax.swing.JTextPane txt_time;
    private javax.swing.JTextPane txt_topic;
    // End of variables declaration//GEN-END:variables
}
