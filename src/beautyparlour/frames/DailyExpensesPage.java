/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautyparlour.frames;

import beautyparlour.bean.DailyExpenseBean;
import beautyparlour.bean.InventoryBean;
import beautyparlour.bean.ServiceBeans;
import beautyparlour.dao.DailyExpenseDao;
import beautyparlour.dao.InventoryDao;
import beautyparlour.dao.ServiceDao;
import beautyparlour.daoImpl.DailyExpensesDaoImpl;
import beautyparlour.daoImpl.InventoryDaoImpl;
import beautyparlour.daoImpl.ServiceDaoImpl;
import beautyparlour.util.CurrentDate;
import beautyparlour.util.playAudio;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Dell
 */
public class DailyExpensesPage extends javax.swing.JFrame {

    /**
     * Creates new form CompanyForm
     */
    DefaultTableModel tableModelService;
    public ArrayList<DailyExpenseBean> dailyExpenses;
        DailyExpenseDao dailyExpenseDao;

    DefaultComboBoxModel comboBoxModelUnit;
    TableRowSorter<DefaultTableModel> rowSorter = null;


    public DailyExpensesPage() {
        initComponents();
        dailyExpenseDao = new DailyExpensesDaoImpl();
        tableModelService = (DefaultTableModel) this.jTableInventory.getModel();
        rowSorter = new TableRowSorter<DefaultTableModel>(tableModelService);

        this.jButtonUpdate.setEnabled(false);
        this.jButtonDelete.setEnabled(false);
        this.jTableInventory.setRowSorter(rowSorter);
        showInTable();
        clearFields();
        closePage();

    }

    public void showInTable() {
        tableModelService.setRowCount(0);

        int serial = 0;
        dailyExpenses = dailyExpenseDao.getAllDailyExpensesByDate("" + CurrentDate.getCurrentDate());
        for (DailyExpenseBean deb : dailyExpenses) {
            Vector V = new Vector();
            serial++;

            V.add(serial);
            V.add(deb.getDailyExpenseId());
            V.add(deb.getItem());
            V.add(deb.getAmount());
            V.add(deb.getCreatedAt());

//            V.add(customer.getCreation_date());
            tableModelService.addRow(V);
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
        jButtonBack = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldAmount = new javax.swing.JTextField();
        jButtoSave = new javax.swing.JButton();
        jButtonClear1 = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableInventory = new javax.swing.JTable();
        jTextFieldSerach = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldServiceName1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldProductName = new javax.swing.JTextField();
        jButtonBack1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(20, 11, 6));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonBack.setBackground(new java.awt.Color(60, 34, 19));
        jButtonBack.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBack.setText("Back");
        jButtonBack.setFocusPainted(false);
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Daily Expenses");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 280, -1));

        jLabel5.setBackground(java.awt.Color.white);
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setText("Amount*");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 206, 20));

        jTextFieldAmount.setBackground(new java.awt.Color(20, 11, 6));
        jTextFieldAmount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldAmount.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldAmount.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jTextFieldAmount.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextFieldAmount.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jPanel1.add(jTextFieldAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 350, 30));

        jButtoSave.setBackground(new java.awt.Color(60, 34, 19));
        jButtoSave.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtoSave.setForeground(new java.awt.Color(255, 255, 255));
        jButtoSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/beautyparlour/util/save.png"))); // NOI18N
        jButtoSave.setText("Save");
        jButtoSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoSaveActionPerformed(evt);
            }
        });
        jPanel1.add(jButtoSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 220, 40));

        jButtonClear1.setBackground(new java.awt.Color(60, 34, 19));
        jButtonClear1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonClear1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonClear1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/beautyparlour/util/clear.png"))); // NOI18N
        jButtonClear1.setText("Clear");
        jButtonClear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClear1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonClear1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 220, 40));

        jButtonUpdate.setBackground(new java.awt.Color(60, 34, 19));
        jButtonUpdate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonUpdate.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/beautyparlour/util/update.png"))); // NOI18N
        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 220, 40));

        jButtonDelete.setBackground(new java.awt.Color(60, 34, 19));
        jButtonDelete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonDelete.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/beautyparlour/util/delete.png"))); // NOI18N
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 220, 40));

        jTableInventory.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr #", "Id", "Item", "Amount", "Creation Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jTableInventory.setToolTipText("Products");
        jTableInventory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableInventory.setGridColor(new java.awt.Color(60, 34, 19));
        jTableInventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableInventoryMouseReleased(evt);
            }
        });
        jTableInventory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableInventoryKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTableInventory);
        if (jTableInventory.getColumnModel().getColumnCount() > 0) {
            jTableInventory.getColumnModel().getColumn(0).setMinWidth(70);
            jTableInventory.getColumnModel().getColumn(0).setPreferredWidth(70);
            jTableInventory.getColumnModel().getColumn(0).setMaxWidth(70);
            jTableInventory.getColumnModel().getColumn(1).setMinWidth(80);
            jTableInventory.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTableInventory.getColumnModel().getColumn(1).setMaxWidth(80);
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 900, 520));

        jTextFieldSerach.setBackground(new java.awt.Color(20, 11, 6));
        jTextFieldSerach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldSerach.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldSerach.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jTextFieldSerach.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextFieldSerach.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jTextFieldSerach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSerachActionPerformed(evt);
            }
        });
        jTextFieldSerach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSerachKeyReleased(evt);
            }
        });
        jPanel1.add(jTextFieldSerach, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 30, 210, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Search");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 30, 70, 30));

        jLabel1.setBackground(new java.awt.Color(60, 34, 19));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THE BEAUTY BAR ");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 1300, 30));

        jTextFieldServiceName1.setBackground(new java.awt.Color(20, 11, 6));
        jTextFieldServiceName1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldServiceName1.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldServiceName1.setBorder(null);
        jTextFieldServiceName1.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jPanel1.add(jTextFieldServiceName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 60, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setText("Item*");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 170, -1));

        jTextFieldProductName.setBackground(new java.awt.Color(20, 11, 6));
        jTextFieldProductName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldProductName.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldProductName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jTextFieldProductName.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextFieldProductName.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jTextFieldProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProductNameActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 350, 30));

        jButtonBack1.setBackground(new java.awt.Color(60, 34, 19));
        jButtonBack1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonBack1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBack1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/beautyparlour/util/print_1.png"))); // NOI18N
        jButtonBack1.setText("Print Report");
        jButtonBack1.setFocusPainted(false);
        jButtonBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBack1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBack1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 220, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 640));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCompanyNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldCompanyNameMouseClicked

    }//GEN-LAST:event_jTextFieldCompanyNameMouseClicked

    private void jTextFieldCompanyNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCompanyNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCompanyNameActionPerformed

    private void jTextFieldCompanyNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCompanyNameKeyPressed

    }//GEN-LAST:event_jTextFieldCompanyNameKeyPressed

    private void jTextFieldCompanyContactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldCompanyContactMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCompanyContactMouseClicked

    private void jTextFieldCompanyContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCompanyContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCompanyContactActionPerformed

    private void jTextFieldCompanyContactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCompanyContactKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCompanyContactKeyPressed

    private void jTextFieldCompanyAddressMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldCompanyAddressMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCompanyAddressMouseClicked

    private void jTextFieldCompanyAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCompanyAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCompanyAddressActionPerformed

    private void jTextFieldCompanyAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCompanyAddressKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCompanyAddressKeyPressed

    private void jTextFieldCompanyDealerNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldCompanyDealerNameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCompanyDealerNameMouseClicked

    private void jTextFieldCompanyDealerNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCompanyDealerNameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCompanyDealerNameKeyPressed

    private void jTableCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCustomerMouseClicked


    }//GEN-LAST:event_jTableCustomerMouseClicked

    private void jTextFieldSerachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldSerachMouseClicked

    }//GEN-LAST:event_jTextFieldSerachMouseClicked

    private void jTextFieldSerachKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSerachKeyPressed

    }//GEN-LAST:event_jTextFieldSerachKeyPressed

    private void jTextFieldSerachKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSerachKeyReleased
        // TODO add your handling code here:
        try {
            String searchData = this.jTextFieldSerach.getText();
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchData));
        } catch (Exception c) {
        }
    }//GEN-LAST:event_jTextFieldSerachKeyReleased

    private void jTextFieldSerachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSerachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSerachActionPerformed

    private void jTableInventoryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableInventoryKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableInventoryKeyReleased

    private void jTableInventoryMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableInventoryMouseReleased
        DailyExpenseBean deb = null;
        int id = Integer.parseInt(""
                + this.jTableInventory.getValueAt(this.jTableInventory.getSelectedRow(), 1));

        try {

            deb = dailyExpenseDao.getDailyExpenseById(id);

        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }

        this.jTextFieldAmount.setText("" + deb.getAmount());
        this.jTextFieldProductName.setText(deb.getItem());
        this.jButtonUpdate.setEnabled(true);
        this.jButtonDelete.setEnabled(true);
        jButtoSave.setEnabled(false);
        jButtonClear1.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableInventoryMouseReleased

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:

        int dialogButton = JOptionPane.showConfirmDialog(null, "Are you sure you wanna delete?", "Delete record", JOptionPane.YES_NO_OPTION);

        if (dialogButton == JOptionPane.YES_OPTION) {
            int id = (int) this.jTableInventory.getValueAt(this.jTableInventory.getSelectedRow(), 1);

            int i = dailyExpenseDao.deleteDailyExpense(id);

            if (i != 0) {
                JOptionPane.showMessageDialog(this, "Deleted Sucessfully");

                showInTable();
                jButtonUpdate.setEnabled(false);
                jButtoSave.setEnabled(true);
                jButtonClear1.setEnabled(true);
                jButtonDelete.setEnabled(false);
                clearFields();

            } else {
            }
        }

    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        String item = this.jTextFieldProductName.getText().toString();
        double amount = 0.0;
        boolean isAmountNumber = true;
        try {
            amount = Double.parseDouble(this.jTextFieldAmount.getText().toString());
        } catch (Exception ex) {
            isAmountNumber = false;
        }

        if (this.jTextFieldAmount.equals("") || this.jTextFieldProductName.equals("")) {
            new playAudio().playErrorSound();
            JOptionPane.showMessageDialog(this, "Fill the fields");
        } else if (!isAmountNumber) {
            String errorField = "";
            if (!isAmountNumber) {
                errorField = "Amount ";
                new playAudio().playErrorSound();
                JOptionPane.showMessageDialog(this, errorField + " must be numeric!");
            }

        } else {

            int dialogButton = JOptionPane.showConfirmDialog(null, "Are you sure you wanna update record?", "Update record", JOptionPane.YES_NO_OPTION);

            if (dialogButton == JOptionPane.YES_OPTION) {
                int id = (int) this.jTableInventory.getValueAt(this.jTableInventory.getSelectedRow(), 1);

                DailyExpenseBean deb = new DailyExpenseBean();
                deb.setAmount(amount);
                deb.setItem(item);
                deb.setDailyExpenseId(id);
                int i = dailyExpenseDao.updateDailyExpense(deb);

                if (i != 0) {
                    JOptionPane.showMessageDialog(this, "Record Updated Sucessfully");

                    showInTable();
                    jButtonUpdate.setEnabled(false);
                    jButtoSave.setEnabled(true);
                    jButtonClear1.setEnabled(true);
                    jButtonDelete.setEnabled(false);
                    clearFields();

                } else {

                }
            } else {
            }
        }
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClear1ActionPerformed
        // TODO add your handling code here:
        clearFields();
        this.jButtonUpdate.setEnabled(false);
        this.jButtonDelete.setEnabled(false);
        this.jButtoSave.setEnabled(true);
        showInTable();
    }//GEN-LAST:event_jButtonClear1ActionPerformed

    private void jButtoSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoSaveActionPerformed
        String item = this.jTextFieldProductName.getText().toString();
        double amount = 0.0;
        boolean isAmountNumber = true;
        try {
            amount = Double.parseDouble(this.jTextFieldAmount.getText().toString());
        } catch (Exception ex) {
            isAmountNumber = false;
        }

        if (this.jTextFieldAmount.equals("") || this.jTextFieldProductName.equals("")) {
            new playAudio().playErrorSound();
            JOptionPane.showMessageDialog(this, "Fill the fields");
        } else if (!isAmountNumber) {
            String errorField = "";
            if (!isAmountNumber) {
                errorField = "Amount ";
                new playAudio().playErrorSound();
                JOptionPane.showMessageDialog(this, errorField + " must be numeric!");
            }

        } else {
            try {
                DailyExpenseBean deb = new DailyExpenseBean();
                deb.setAmount(amount);
                deb.setItem(item);
                deb.setCreatedAt(CurrentDate.getCurrentDate());
                dailyExpenseDao.addDailyExpense(deb);
                new playAudio().playSuccessSound();

            } catch (Exception e) {
                new playAudio().playErrorSound();

                JOptionPane.showMessageDialog(this, "Some thing went wrong!");

            }
            clearFields();
            showInTable();
        }
    }//GEN-LAST:event_jButtoSaveActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jTextFieldProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProductNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProductNameActionPerformed

    private void jButtonBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBack1ActionPerformed
        MessageFormat header = new MessageFormat("THE BEAUTY BAR INVENTORY REPORT");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try {
            this.jTableInventory.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(DailyExpensesPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonBack1ActionPerformed

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
            java.util.logging.Logger.getLogger(DailyExpensesPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DailyExpensesPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DailyExpensesPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DailyExpensesPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DailyExpensesPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtoSave;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonBack1;
    private javax.swing.JButton jButtonClear1;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableInventory;
    private javax.swing.JTextField jTextFieldAmount;
    private javax.swing.JTextField jTextFieldProductName;
    private javax.swing.JTextField jTextFieldSerach;
    private javax.swing.JTextField jTextFieldServiceName1;
    // End of variables declaration//GEN-END:variables

    void clearFields() {
        this.jTextFieldAmount.setText("");
        this.jTextFieldProductName.setText("");

    }

    private int showWarningMessage() {
        String[] buttonLabels = new String[]{"Yes", "No"};
        String defaultOption = buttonLabels[0];
        Icon icon = null;

        return JOptionPane.showOptionDialog(this,
                "Are you sure you wanna close it!",
                "Warning",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE,
                icon,
                buttonLabels,
                defaultOption);
    }

    private void handleClosing() {
        {
            int answer = showWarningMessage();

            switch (answer) {
                case JOptionPane.YES_OPTION:
                    dispose();
                    break;

                case JOptionPane.NO_OPTION:
                    break;

            }
        }
    }

    public void closePage() {

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                handleClosing();
            }
        });
    }
}
