/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignementjava;

import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class EmployeeManagement extends javax.swing.JFrame {

    Pattern pattern;
    ArrayList<Employee> empArrayList;
    Employee employee;
    DefaultTableModel model;
    int index;
    int sumRecord;

    /**
     * Creates new form EmployeeManagement
     */
    public EmployeeManagement() {
        initComponents();
        setLocationRelativeTo(null);
        try {
            empArrayList = new ArrayList<>();
            employee = new Employee();
        } catch (NullPointerException e) {
            System.out.print(e);
        }

    }

    public void addEmployee() {
        if (tf_mnv.getText().length() == 0 || tf_name.getText().length() == 0 || tf_age.getText().length() == 0 || tf_email.getText().length() == 0 || tf_salary.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống ô nhập");
        } else {
            try {
                getTextFeld();
                if (checkValidate(employee)) {
                    empArrayList.add(employee);
                    fillToTable();
                }

            } catch (NumberFormatException e) {
                System.out.println(e);
            }

        }
    }

    public void getTextFeld() throws NumberFormatException {
        employee.setEmployeeCode(tf_mnv.getText());
        employee.setName(tf_name.getText());
        employee.setEmail(tf_email.getText());
        employee.setAge(Integer.parseInt(tf_age.getText()));
        employee.setSalary(Long.parseLong(tf_salary.getText()));

    }

    public void showDetail(Employee employee) {
        try {
            tf_name.setText(employee.getName());
            tf_mnv.setText(employee.getEmployeeCode());
            tf_age.setText(String.valueOf(employee.getAge()));
            tf_email.setText(employee.getEmail());
            tf_salary.setText(String.valueOf(employee.getSalary()));
        } catch (NumberFormatException e) {
            System.out.print(" Lỗi chuỗi rỗng"+ e);
        }

    }

    public void fillToTable() {

        model = (DefaultTableModel) tb_list.getModel();
        model.setRowCount(0);
        try {
            for (Employee index : empArrayList) {
                model.addRow(new Object[]{index.getEmployeeCode(), index.getName(), index.getAge(), index.getEmail(), index.getSalary()});
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e + " Chưa có dữ liệu không thể fill ");
            e.getStackTrace();
        }

    }

    public boolean checkValidate(Employee objCheck) {
        final String email = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        pattern = Pattern.compile(email);
        if (objCheck.getAge() < 16 || objCheck.getAge() > 55) {
            JOptionPane.showMessageDialog(this, "Tuổi phải từ 16 đến 55");
            return false;
        } else if (objCheck.getSalary() < 5000000) {
            JOptionPane.showMessageDialog(this, "Lương nhân viên phải lớn hơn 5 triệu");
            return false;
        } else if (!pattern.matcher(objCheck.getEmail()).matches()) {
            JOptionPane.showMessageDialog(this, "Không đúng định dạng email");
            return false;
        } else {
            return true;
        }
    }

    public void clearFrom() {
        tf_email.setText("");
        tf_salary.setText("");
        tf_age.setText("");
        tf_mnv.setText("");
        tf_name.setText("");

    }

    public void showRecord(int indexxx) {
        try {
            sumRecord = empArrayList.size();
            tf_number_record.setText(String.valueOf(indexxx) + " OF " + String.valueOf(sumRecord));

        } catch (IndexOutOfBoundsException e) {
            System.out.println(e + "index === 0");
               
        }

    }

    public int getIndexSelected() {
       
       
            return tb_list.getSelectedRow() ;
     
        
    }

    public boolean checkID() {
        String idCheck;
        boolean bll = false;
        try {
            idCheck = tf_mnv.getText();
            for (Employee em : empArrayList) {
                if (idCheck.equalsIgnoreCase(em.getEmployeeCode())) {
                    bll = true;
                }
            }
        } catch (NumberFormatException e) {
            System.out.print(e);
                        e.getStackTrace();
        }

        return bll;
    }

    public void updateInfo() {

        try {
            getTextFeld();
            if (checkID()) {
                if (checkValidate(employee)) {
                    empArrayList.add(getIndexSelected(), employee);
                }
            } else {
                addEmployee();
            }
        } catch (Exception e) {
            System.out.print(e);
            e.getStackTrace();
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

        jTextField8 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_email = new javax.swing.JTextField();
        tf_name = new javax.swing.JTextField();
        tf_mnv = new javax.swing.JTextField();
        tf_age = new javax.swing.JTextField();
        tf_salary = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_list = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btn_prev_page = new javax.swing.JButton();
        btn_prev_row = new javax.swing.JButton();
        btn_new = new javax.swing.JButton();
        btn_netx_row = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_next_page = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        btn_open = new javax.swing.JButton();
        btn_find = new javax.swing.JButton();
        tf_number_record = new javax.swing.JTextField();

        jTextField8.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 255, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 108, 24));
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(27, 4, 88));
        jLabel3.setText("Mã nhân viên");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 4, 88));
        jLabel4.setText("Họ và tên");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(27, 4, 88));
        jLabel5.setText("Tuổi");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(27, 4, 88));
        jLabel6.setText("Email");

        tf_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));

        tf_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));

        tf_mnv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));

        tf_age.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));

        tf_salary.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));

        jLabel7.setBackground(new java.awt.Color(255, 51, 51));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(27, 4, 88));
        jLabel7.setText("Lương");

        tb_list.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 102, 0)));
        tb_list.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tb_list.setForeground(new java.awt.Color(247, 119, 24));
        tb_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã", "Họ tên", "Tuổi", "Email", "Lương"
            }
        ));
        tb_list.setAlignmentX(1.0F);
        tb_list.setAlignmentY(1.0F);
        tb_list.setGridColor(new java.awt.Color(102, 102, 102));
        tb_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_listMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_list);
        if (tb_list.getColumnModel().getColumnCount() > 0) {
            tb_list.getColumnModel().getColumn(0).setPreferredWidth(12);
        }

        jLabel2.setText("Giờ hiện tại");

        btn_prev_page.setBackground(new java.awt.Color(204, 255, 255));
        btn_prev_page.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_prev_page.setForeground(new java.awt.Color(255, 51, 51));
        btn_prev_page.setText("|<");
        btn_prev_page.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prev_pageActionPerformed(evt);
            }
        });

        btn_prev_row.setBackground(new java.awt.Color(204, 255, 255));
        btn_prev_row.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_prev_row.setForeground(new java.awt.Color(255, 51, 51));
        btn_prev_row.setText("<<");

        btn_new.setBackground(new java.awt.Color(249, 136, 16));
        btn_new.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_new.setForeground(new java.awt.Color(255, 255, 255));
        btn_new.setText("NEW");
        btn_new.setPreferredSize(new java.awt.Dimension(80, 40));
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        btn_netx_row.setBackground(new java.awt.Color(204, 255, 255));
        btn_netx_row.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_netx_row.setForeground(new java.awt.Color(255, 51, 51));
        btn_netx_row.setText(">>");

        btn_save.setBackground(new java.awt.Color(249, 136, 16));
        btn_save.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_save.setForeground(new java.awt.Color(255, 255, 255));
        btn_save.setText("SAVE");
        btn_save.setPreferredSize(new java.awt.Dimension(80, 40));
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_next_page.setBackground(new java.awt.Color(204, 255, 255));
        btn_next_page.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_next_page.setForeground(new java.awt.Color(255, 51, 51));
        btn_next_page.setText(">|");

        btn_delete.setBackground(new java.awt.Color(249, 136, 16));
        btn_delete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("DELETE");
        btn_delete.setMaximumSize(new java.awt.Dimension(80, 40));
        btn_delete.setPreferredSize(new java.awt.Dimension(90, 40));

        btn_exit.setBackground(new java.awt.Color(249, 136, 16));
        btn_exit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_exit.setForeground(new java.awt.Color(255, 255, 255));
        btn_exit.setText("EXIT");
        btn_exit.setPreferredSize(new java.awt.Dimension(69, 40));

        btn_open.setBackground(new java.awt.Color(249, 136, 16));
        btn_open.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_open.setForeground(new java.awt.Color(255, 255, 255));
        btn_open.setText("OPEN");
        btn_open.setPreferredSize(new java.awt.Dimension(69, 40));
        btn_open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openActionPerformed(evt);
            }
        });

        btn_find.setBackground(new java.awt.Color(249, 136, 16));
        btn_find.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_find.setForeground(new java.awt.Color(255, 255, 255));
        btn_find.setText("FIND");
        btn_find.setPreferredSize(new java.awt.Dimension(69, 40));
        btn_find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_findActionPerformed(evt);
            }
        });

        tf_number_record.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        tf_number_record.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_number_recordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(jLabel1)
                        .addGap(162, 162, 162)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btn_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))
                                    .addGap(34, 34, 34)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tf_mnv, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tf_name, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tf_age, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tf_email, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tf_salary, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(148, 148, 148)
                                    .addComponent(btn_prev_page)
                                    .addGap(2, 2, 2)
                                    .addComponent(btn_prev_row)
                                    .addGap(6, 6, 6)
                                    .addComponent(btn_netx_row)
                                    .addGap(6, 6, 6)
                                    .addComponent(btn_next_page))))
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(btn_find, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tf_number_record, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btn_open, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel4)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel5)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel6)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tf_mnv, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tf_name, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(tf_age, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tf_email, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(tf_salary, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tf_number_record, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_find, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_open, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_prev_page)
                            .addComponent(btn_prev_row)
                            .addComponent(btn_netx_row)
                            .addComponent(btn_next_page))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openActionPerformed
        // TODO add your handling code here:

        addEmployee();
        try {
            showDetail(empArrayList.get(0));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("lỗi index = -1 \t"  + e);
        }
            
            
            showRecord(0);
       


    }//GEN-LAST:event_btn_openActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
        updateInfo();
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_findActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_findActionPerformed

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        // TODO add your handling code here:
        clearFrom();
    }//GEN-LAST:event_btn_newActionPerformed

    private void tb_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_listMouseClicked
        // TODO add your handling code here:
        try {
            showRecord(getIndexSelected());
            showDetail(empArrayList.get(getIndexSelected()));

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print(e);
        }


    }//GEN-LAST:event_tb_listMouseClicked

    private void tf_number_recordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_number_recordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_number_recordActionPerformed

    private void btn_prev_pageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prev_pageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_prev_pageActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_find;
    private javax.swing.JButton btn_netx_row;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_next_page;
    private javax.swing.JButton btn_open;
    private javax.swing.JButton btn_prev_page;
    private javax.swing.JButton btn_prev_row;
    private javax.swing.JButton btn_save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTable tb_list;
    private javax.swing.JTextField tf_age;
    private javax.swing.JTextField tf_email;
    private javax.swing.JTextField tf_mnv;
    private javax.swing.JTextField tf_name;
    private javax.swing.JTextField tf_number_record;
    private javax.swing.JTextField tf_salary;
    // End of variables declaration//GEN-END:variables
}
