/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignementjava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class EmployeeManagement extends javax.swing.JFrame {

    ArrayList<Employee> employeeList;
    DefaultTableModel model = new DefaultTableModel();
    Employee employee;
    int index;
    private final String mFileName = "Student.txt";

    /**
     * Creates new form EmployeeManagement
     */
   
    public EmployeeManagement() {
        initComponents();
        employeeList = new ArrayList<>();
        model = (DefaultTableModel) tb_list.getModel();
        index = 0;
        showDate();

    }

    public void fillToTable() {

        model.setRowCount(0);
        for (Employee emp : employeeList) {
            model.addRow(new Object[]{emp.getEmployeeCode(),
                emp.getName(), emp.getEmail(), emp.getAge(), emp.getSalary()});
        }
    }

    public void showPositon() {

        tf_number_record.setText(String.valueOf(tb_list.getSelectedRow() + 1) + " / " + employeeList.size());

    }

    public void addEmployee() {
        try {

            if (checkEmptyString() && checkInputString()) {
                getData();
                employeeList.add(employee);
                addModelTable();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Lương và Tuổi phải là một số");
        }
    }

    public void addModelTable() {
        
            model.addRow(new Object[]{employee.getEmployeeCode(),
                employee.getName(), employee.getEmail(),
                employee.getAge(), employee.getSalary()});
        

    }

    public boolean checkEmptyString() {
        if (tf_mnv.getText().length() == 0 || tf_age.getText().length() == 0
                || tf_name.getText().length() == 0 || tf_email.getText().length() == 0
                || tf_salary.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống các ô nhập");
            return false;

        }
        return true;
    }

    public boolean checkInputString() {
        if (Integer.parseInt(tf_age.getText()) < 18 || Integer.parseInt(tf_age.getText()) > 55) {
            JOptionPane.showMessageDialog(this, "Tuổi phải lớn hơn 18 và nhỏ hơn 55 ");
            return false;
        } else if (Integer.parseInt(tf_salary.getText()) < 5000000) {
            JOptionPane.showMessageDialog(this, "Lương phải lớn hơn 5 triệu ");
            return false;
        }
        return true;
    }

    public void getData() {
        employee.setEmployeeCode(tf_mnv.getText());
        employee.setName(tf_name.getText());
        employee.setEmail(tf_email.getText());
        employee.setAge(Integer.parseInt(tf_age.getText()));
        employee.setSalary(Long.parseLong(tf_salary.getText()));
    }

    public void showDetail() {
        if (index >= 0) {

            employee = employeeList.get(index);
            tf_mnv.setText(employee.getEmployeeCode());
            tf_name.setText(employee.getName());
            tf_email.setText(employee.getEmail());
            tf_age.setText(String.valueOf(employee.getAge()));
            tf_salary.setText(String.valueOf(employee.getSalary()));
        }
    }

    public void clear() {
        tf_mnv.setText("");
        tf_name.setText("");
        tf_email.setText("");
        tf_age.setText("");
        tf_salary.setText("");
        index = -1;
        showPositon();

    }

    public void checkData() {
        getData();

    }

    public void removeData() throws IndexOutOfBoundsException {
        if (index >= 0) {
            index = tb_list.getSelectedRow();
            employeeList.remove(index);
            model.removeRow(index);
        }
    }

    public boolean duplicateCheck(String id) {
        for (Employee emp : employeeList) {
        
            if (id.equals(emp.getEmployeeCode())) {
           
                return false;
                
            }
                index++;
        }
        return true;
    }
    public boolean findEployee(String id){
        if(!duplicateCheck(id)){
            showDetail();
            tb_list.setRowSelectionInterval(index, index);
            return true;
        }
        return false;
    }

    public void updateData() {
        try {
            if (checkEmptyString() && checkInputString()) {
                getData();
                index = tb_list.getSelectedRow();
                employeeList.add(index, employee);
                System.out.println(employeeList);
                employeeList.remove(index);
                model.setValueAt(employee.getEmployeeCode(), index, 0);
                model.setValueAt(employee.getName(), index, 1);
                model.setValueAt(employee.getEmail(), index, 2);
                model.setValueAt(employee.getAge(), index, 3);
                model.setValueAt(employee.getSalary(), index, 4);
                ;
            }

        } catch (NumberFormatException e) {
            System.out.println(e);

        }

    }
    public void showDate(){
        
      
        Thread t = new Thread(new Runnable() {
              int count = 0;

            @Override
            public void run() {
                while (true) {                    
                     try {
                         
                         Calendar c = Calendar.getInstance();
                          txDate.setText( c.get(Calendar.HOUR) + " : " +  c.get(Calendar.MINUTE) + " : " +c.get(Calendar.SECOND));
                          Thread.sleep(1000);
                          count++;
                         
                          
                } catch (Exception e) {
                    break;
                }
                    
                }
                
            }
        });
        t.start();
        
    }

    public void prevFist() {
        index = 0;
        tb_list.setRowSelectionInterval(index, index);
        showDetail();
        showPositon();

    }

    public void prevLast() {
        index = employeeList.size() - 1;
        tb_list.setRowSelectionInterval(index, index);
        showDetail();
        showPositon();

    }

    public void prev() throws Exception {
        if (index >= 0) {
            if (index > tb_list.getSelectedRow()) {
                index = tb_list.getSelectedRow() - 1;
            }
            tb_list.setRowSelectionInterval(index, index);
            index--;

        } else {

            tb_list.setRowSelectionInterval(employeeList.size() - 1, employeeList.size() - 1);
            index = employeeList.size() - 2;
        }
        showDetail();
        showPositon();
    }

    public void next() throws Exception {
        if (index <= employeeList.size() - 1) {
            if (index == tb_list.getSelectedRow()) {
                index = 0;
            }
            tb_list.setRowSelectionInterval(index, index);
            index++;

        } else {

            tb_list.setRowSelectionInterval(0, 0);
            index = 1;
        }
        showPositon();
        showDetail();
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
        txDate = new javax.swing.JLabel();
        btn_new = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        btn_open = new javax.swing.JButton();
        btn_find = new javax.swing.JButton();
        tf_number_record = new javax.swing.JTextField();
        prev_first = new javax.swing.JButton();
        prev_row = new javax.swing.JButton();
        next_row = new javax.swing.JButton();
        nextLast = new javax.swing.JButton();

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

        txDate.setBackground(new java.awt.Color(255, 0, 51));
        txDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txDate.setForeground(new java.awt.Color(255, 0, 51));
        txDate.setText("Giờ hiện tại");

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

        btn_delete.setBackground(new java.awt.Color(249, 136, 16));
        btn_delete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("DELETE");
        btn_delete.setMaximumSize(new java.awt.Dimension(80, 40));
        btn_delete.setPreferredSize(new java.awt.Dimension(90, 40));
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_exit.setBackground(new java.awt.Color(249, 136, 16));
        btn_exit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_exit.setForeground(new java.awt.Color(255, 255, 255));
        btn_exit.setText("EXIT");
        btn_exit.setPreferredSize(new java.awt.Dimension(69, 40));
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

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

        tf_number_record.setEditable(false);
        tf_number_record.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_number_record.setForeground(new java.awt.Color(255, 51, 51));
        tf_number_record.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_number_record.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        tf_number_record.setFocusCycleRoot(true);
        tf_number_record.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_number_recordActionPerformed(evt);
            }
        });

        prev_first.setBackground(new java.awt.Color(249, 136, 16));
        prev_first.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        prev_first.setForeground(new java.awt.Color(255, 255, 255));
        prev_first.setText("|<");
        prev_first.setPreferredSize(new java.awt.Dimension(69, 40));
        prev_first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prev_firstActionPerformed(evt);
            }
        });

        prev_row.setBackground(new java.awt.Color(249, 136, 16));
        prev_row.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        prev_row.setForeground(new java.awt.Color(255, 255, 255));
        prev_row.setText("<<");
        prev_row.setPreferredSize(new java.awt.Dimension(69, 40));
        prev_row.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prev_rowActionPerformed(evt);
            }
        });

        next_row.setBackground(new java.awt.Color(249, 136, 16));
        next_row.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        next_row.setForeground(new java.awt.Color(255, 255, 255));
        next_row.setText(">>");
        next_row.setPreferredSize(new java.awt.Dimension(69, 40));
        next_row.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_rowActionPerformed(evt);
            }
        });

        nextLast.setBackground(new java.awt.Color(249, 136, 16));
        nextLast.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nextLast.setForeground(new java.awt.Color(255, 255, 255));
        nextLast.setText(">|");
        nextLast.setPreferredSize(new java.awt.Dimension(69, 40));
        nextLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextLastActionPerformed(evt);
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
                        .addGap(160, 160, 160)
                        .addComponent(txDate)
                        .addGap(0, 0, Short.MAX_VALUE))
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
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_open, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(tf_mnv, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(tf_name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                                            .addComponent(tf_age, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tf_email, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tf_salary, javax.swing.GroupLayout.Alignment.LEADING))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(prev_first, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(prev_row, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_number_record, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(next_row, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nextLast, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_find, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 694, Short.MAX_VALUE)))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txDate))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_open, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prev_first, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prev_row, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_number_record, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(next_row, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_find, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openActionPerformed
        // TODO add your handling code here:
        employeeList = Utilities.readStudent(mFileName);
        index = 0;
        fillToTable();
        tb_list.setRowSelectionInterval(0, 0);
        showDetail();
        showPositon();

    }//GEN-LAST:event_btn_openActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
        if (index == -1) {
            if (duplicateCheck(tf_mnv.getText())) {
                addEmployee();
                index = -1;
                System.out.println(employeeList);
            } else {
                JOptionPane.showMessageDialog(this, "Trung ID");
                index = -1;
            }
        } else {
            try {
                updateData();
            } catch (NumberFormatException e) {
                System.out.print(e + "    Lỗi chuỗi rỗng ");
            }
        }


    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_findActionPerformed
        // TODO add your handling code here:
        
            String id = JOptionPane.showInputDialog("Nhap msv muon tim");
           if(findEployee(id)){
               JOptionPane.showMessageDialog(this, "da tim thay");
           }else{
               JOptionPane.showMessageDialog(this, "khong tim thay");
           }
        
    }//GEN-LAST:event_btn_findActionPerformed

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        // TODO add your handling code here:
        clear();

    }//GEN-LAST:event_btn_newActionPerformed

    private void tb_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_listMouseClicked
        // TODO add your handling code here:
        index = tb_list.getSelectedRow();
        showDetail();
        showPositon();


    }//GEN-LAST:event_tb_listMouseClicked

    private void tf_number_recordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_number_recordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_number_recordActionPerformed

    private void prev_firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prev_firstActionPerformed
        // TODO add your handling code here:
        prevFist();
    }//GEN-LAST:event_prev_firstActionPerformed

    private void prev_rowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prev_rowActionPerformed
        // TODO add your handling code here:
        try {
            prev();
        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_prev_rowActionPerformed

    private void next_rowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next_rowActionPerformed
        // TODO add your handling code here:
        try {
            next();
        } catch (Exception e) {
            System.out.println(e);
        }


    }//GEN-LAST:event_next_rowActionPerformed

    private void nextLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextLastActionPerformed
        // TODO add your handling code here:
        prevLast();
    }//GEN-LAST:event_nextLastActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
       int choice =   JOptionPane.showConfirmDialog(this, "Ban chac chan muon xoa");
        if (choice == JOptionPane.YES_OPTION) {
            try {
                removeData();
                clear();
            } catch (IndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(this, "Ban phai chon mot hang tren table");
            }
        }

    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        // TODO add your handling code here:
        
        int choice = JOptionPane.showConfirmDialog(this, "Ban chac chan muon thoat");
        if(choice ==  JOptionPane.YES_OPTION){
            Utilities.writeStudent(employeeList, mFileName);
            System.exit(0);
        }
    }//GEN-LAST:event_btn_exitActionPerformed

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
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_open;
    private javax.swing.JButton btn_save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JButton nextLast;
    private javax.swing.JButton next_row;
    private javax.swing.JButton prev_first;
    private javax.swing.JButton prev_row;
    private javax.swing.JTable tb_list;
    private javax.swing.JTextField tf_age;
    private javax.swing.JTextField tf_email;
    private javax.swing.JTextField tf_mnv;
    private javax.swing.JTextField tf_name;
    private javax.swing.JTextField tf_number_record;
    private javax.swing.JTextField tf_salary;
    private javax.swing.JLabel txDate;
    // End of variables declaration//GEN-END:variables
}
