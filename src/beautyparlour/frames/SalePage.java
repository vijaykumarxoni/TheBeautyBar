/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautyparlour.frames;

import beautyparlour.bean.CustomerBean;
import beautyparlour.bean.PaymentDoneBeans;
import beautyparlour.bean.ServiceBeans;
import beautyparlour.dao.SaleDao;
import beautyparlour.dao.SaleDetailsDao;
import beautyparlour.dao.ServiceDao;
import beautyparlour.daoImpl.SaleDaoImpl;
import beautyparlour.daoImpl.SaleDetailDapImpl;
import beautyparlour.daoImpl.ServiceDaoImpl;
import beautyparlour.dialog.CashNowLaterDialog;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Dell
 */
public class SalePage extends javax.swing.JFrame {

    /**
     * Creates new form SalePage
     */
    DefaultTableModel tableModelServices;
    public ArrayList<ServiceBeans> services_list;
    public ArrayList<ServiceBeans> selected_services_List;
    ServiceDao serviceDao;
    SaleDao saleDao;
    SaleDetailsDao saleDetailDao;
    public static boolean sale_customer = false;
    DefaultTableModel tableModel2;
    String reference = "";
    int customer_id = -1;
    public static int total_price = 0;
    public static int total_price_temp = 0;
    TableRowSorter<DefaultTableModel> rowSorter = null;

    public SalePage() {
        initComponents();
        serviceDao = new ServiceDaoImpl();
        saleDao = new SaleDaoImpl();
        saleDetailDao = new SaleDetailDapImpl();
//        companyDao = new CompanyDaoImpl();
        this.getContentPane().setBackground(Color.white);
        customerBalanceField.setEditable(false);
        customerBalanceField.setEnabled(false);
        tableModelServices = (DefaultTableModel) this.jTable1.getModel();
        tableModel2 = (DefaultTableModel) this.jTable2.getModel();
        customer_id = -1;
        removeService.setEnabled(false);
        addField.setEnabled(false);
        nameField.setEnabled(false);
        numberField.setEnabled(false);
        addressfield.setEnabled(false);
        rowSorter = new TableRowSorter<DefaultTableModel>(tableModelServices);
        this.jTable1.setRowSorter(rowSorter);
        selected_services_List = new ArrayList<>();
//        walkingRadio.setSelected(true);
        sale_customer = false;
        generateButton.setEnabled(false);
        showInTable();
        closePage();

    }

//
    public SalePage(CustomerBean customer) {
        initComponents();
        sale_customer = true;
        nameField.setText(customer.getCustomer_name());
//        reference = customer.getCustomer_name();
        numberField.setText(customer.getCustomer_contact());
        addressfield.setText(customer.getCustomer_address());

        tableModelServices = (DefaultTableModel) this.jTable1.getModel();
        tableModel2 = (DefaultTableModel) this.jTable2.getModel();
        serviceDao = new ServiceDaoImpl();
        saleDao = new SaleDaoImpl();
        saleDetailDao = new SaleDetailDapImpl();
        removeService.setEnabled(false);

        customer_id = customer.getCustomer_id();
        this.getContentPane().setBackground(Color.white);

        if (customer.getCustomer_dept() < 0) {
            this.customerBalanceField.setForeground(Color.RED);
        }
        customerBalanceField.setText("Rs: " + customer.getCustomer_dept());

        customerBalanceField.setEditable(false);

        showInTable();
        rowSorter = new TableRowSorter<DefaultTableModel>(tableModelServices);
        this.jTable1.setRowSorter(rowSorter);

        selected_services_List = new ArrayList<>();

        this.total_price = 0;
        this.total_price_temp = 0;
        generateButton.setEnabled(false);
//        referenceField.setEnabled(false);
        addField.setEnabled(false);
        closePage();

        nameField.setEditable(false);
        numberField.setEditable(false);
        addressfield.setEditable(false);
        customerBalanceField.setEditable(false);
    }

    public void showInTable() {
        tableModelServices.setRowCount(0);
        try {

            int serial = 0;
            services_list = serviceDao.getAllService();

            for (ServiceBeans s : services_list) {
                Vector V = new Vector();
                serial++;

                V.add(serial);
                V.add(s.getService_id());
                V.add(s.getService_name());
                V.add(s.getService_cost());

//            V.add(customer.getCreation_date());
                tableModelServices.addRow(V);
                jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
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

        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        itemField = new javax.swing.JLabel();
        addField = new javax.swing.JButton();
        removeService = new javax.swing.JButton();
        toRemoveField = new javax.swing.JLabel();
        generateButton = new javax.swing.JButton();
        totalField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        discountField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        addressfield = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        customerBalanceField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        numberField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sale");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setBackground(new java.awt.Color(60, 34, 19));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Back");
        jButton5.setFocusPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 11, 100, 30));

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S#", "Service Id", "Service Name", "Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(60);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(60);
            jTable1.getColumnModel().getColumn(1).setMinWidth(60);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(60);
            jTable1.getColumnModel().getColumn(3).setMinWidth(120);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(120);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, 630, 340));

        jLabel11.setBackground(new java.awt.Color(60, 34, 19));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("THE BEAUTY BAR");
        jLabel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel11.setOpaque(true);
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 800, 1650, 20));

        jPanel1.setBackground(new java.awt.Color(20, 11, 6));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchField.setBackground(new java.awt.Color(20, 11, 6));
        searchField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        searchField.setForeground(new java.awt.Color(255, 255, 255));
        searchField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        searchField.setCaretColor(new java.awt.Color(255, 255, 255));
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });
        jPanel1.add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 580, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Search");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, 20));

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Service Name", "Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 280, 630, 320));

        itemField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        itemField.setForeground(new java.awt.Color(255, 255, 255));
        itemField.setText("Service: ------");
        jPanel1.add(itemField, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 290, 320, 170));

        addField.setBackground(new java.awt.Color(60, 34, 19));
        addField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addField.setForeground(new java.awt.Color(255, 255, 255));
        addField.setText("Add");
        addField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFieldActionPerformed(evt);
            }
        });
        jPanel1.add(addField, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 550, 112, -1));

        removeService.setBackground(new java.awt.Color(60, 34, 19));
        removeService.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        removeService.setForeground(new java.awt.Color(255, 255, 255));
        removeService.setIcon(new javax.swing.ImageIcon(getClass().getResource("/beautyparlour/util/delete.png"))); // NOI18N
        removeService.setText("Remove");
        removeService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeServiceActionPerformed(evt);
            }
        });
        jPanel1.add(removeService, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 610, 130, -1));

        toRemoveField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        toRemoveField.setForeground(new java.awt.Color(255, 255, 255));
        toRemoveField.setText("Service: ---------");
        jPanel1.add(toRemoveField, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 620, -1, -1));

        generateButton.setBackground(new java.awt.Color(60, 34, 19));
        generateButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        generateButton.setForeground(new java.awt.Color(255, 255, 255));
        generateButton.setText("Generate");
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });
        jPanel1.add(generateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 740, 219, -1));

        totalField.setEditable(false);
        totalField.setBackground(new java.awt.Color(20, 11, 6));
        totalField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        totalField.setForeground(new java.awt.Color(255, 255, 255));
        totalField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        totalField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalFieldActionPerformed(evt);
            }
        });
        jPanel1.add(totalField, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 710, 135, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Total bill:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 710, -1, -1));

        discountField.setBackground(new java.awt.Color(20, 11, 6));
        discountField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        discountField.setForeground(new java.awt.Color(255, 255, 255));
        discountField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        discountField.setCaretColor(new java.awt.Color(255, 255, 255));
        discountField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                discountFieldKeyReleased(evt);
            }
        });
        jPanel1.add(discountField, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 670, 135, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Discsount:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 670, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Amount", "Percentage" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 630, 133, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Discount Type");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 630, -1, -1));

        addressfield.setBackground(new java.awt.Color(20, 11, 6));
        addressfield.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addressfield.setForeground(new java.awt.Color(255, 255, 255));
        addressfield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        addressfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressfieldActionPerformed(evt);
            }
        });
        jPanel1.add(addressfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 160, 325, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Address:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contact:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, -1, -1));

        nameField.setBackground(new java.awt.Color(20, 11, 6));
        nameField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nameField.setForeground(new java.awt.Color(255, 255, 255));
        nameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });
        jPanel1.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, 325, -1));

        customerBalanceField.setBackground(new java.awt.Color(20, 11, 6));
        customerBalanceField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        customerBalanceField.setForeground(new java.awt.Color(255, 255, 255));
        customerBalanceField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        customerBalanceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerBalanceFieldActionPerformed(evt);
            }
        });
        jPanel1.add(customerBalanceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 190, 325, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Customer Balance:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, -1, -1));

        numberField.setBackground(new java.awt.Color(20, 11, 6));
        numberField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        numberField.setForeground(new java.awt.Color(255, 255, 255));
        numberField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        numberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberFieldActionPerformed(evt);
            }
        });
        jPanel1.add(numberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 130, 325, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/beautyparlour/util/sale.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 30, 198, 179));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(60, 34, 19));
        jButton1.setText("Get or Insert Customer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 60, 320, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Customer:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1640, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void discountFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discountFieldKeyReleased
        // TODO add your handling code here:

        if (discountField.equals("")) {
            totalField.setText(total_price + "");

        } else if (jComboBox1.getSelectedItem().toString().equalsIgnoreCase("amount")) {

            try {
                int discount = Integer.parseInt(discountField.getText().toString());
                int totalpriceget = total_price;
                if (discount > totalpriceget) {
                    JOptionPane.showMessageDialog(this, "Discount is greater than Total price");
                } else {
                    totalpriceget -= discount;
                    totalField.setText(totalpriceget + "");
                }
            } catch (Exception e) {
                totalField.setText(total_price + "");

                //                JOptionPane.showMessageDialog(this, "Invalid amount");
            }

            System.out.println("amount");
        } else if (jComboBox1.getSelectedItem().toString().equalsIgnoreCase("percentage")) {

            try {
                float discount_percent = Integer.parseInt(discountField.getText().toString());
                float discount = (discount_percent * total_price) / 100;

                int totalpriceget = total_price;
                if (discount > totalpriceget) {
                    JOptionPane.showMessageDialog(this, "Discount is greater than Total price");
                } else {

                    totalpriceget -= discount;
                    totalField.setText(totalpriceget + "");
                }

            } catch (Exception e) {
                totalField.setText(total_price + "");

                //                JOptionPane.showMessageDialog(this, "Invalid amount");
            }
            System.out.println("percentage");
        }
    }//GEN-LAST:event_discountFieldKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void numberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberFieldActionPerformed

    private void addressfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressfieldActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        // TODO add your handling code here:
//        String search_product = searchField.getText();
//        showInTableSearched(search_product);
        String searchData = this.searchField.getText();
        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchData));
    }//GEN-LAST:event_searchFieldKeyReleased

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        int id = jTable1.getSelectedRow();
//        int id1=(int) tableModelProduct.getValueAt(id, 5);
//        System.out.println("The id is"+id1);
        int service_id_table = Integer.parseInt("" + this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1));

//        int product_id_table = product_list.get(id).getP_id();
//        DbManagerInterface ob = new DbManager();
        ServiceBeans s = null;
        try {
            s = serviceDao.getServiceById(service_id_table);
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        itemField.setText("Service: " + s.getService_name());

        if (sale_customer) {

            addField.setEnabled(true);

        }

    }//GEN-LAST:event_jTable1MouseReleased

    private void addFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFieldActionPerformed
        // TODO add your handling code here:
        //        if(jTable1.isRowSelected)

        int service_id_table = Integer.parseInt("" + this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1));

//            int user_id_table = productList.get(id).getProduct_id();
//
//            DbManagerInterface ob = new DbManager();
        ServiceBeans s = serviceDao.getServiceById(service_id_table);
//            int quantity = (int) jSpinner1.getValue();
//            int product_quantity = (int) jTable1.getValueAt(jTable1.getSelectedRow(), 5);

        showInBuy(s);
        generateButton.setEnabled(true);
        addField.setEnabled(false);
        


    }//GEN-LAST:event_addFieldActionPerformed

    private void showInBuy(ServiceBeans s) {
//        DbManagerInterface ob = new DbManager();
//        tableModel2.setRowCount(0);

        Vector v = new Vector();
//        int id = p.getCategory_id();
//        String category = ob.getCategory(id).getName();
//        System.out.println("" + p.getName());
        v.add(s.getService_name());
        v.add(s.getService_cost());

        double t_price = s.getService_cost();

        total_price += t_price;
        totalField.setText("" + total_price);
        total_price_temp = total_price;
        try {
            tableModel2.addRow(v);
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        selected_services_List.add(s);
//        orderedProductList.add(new ProductBeans(p.getP_id(), ICONIFIED, p_name, ABORT, quantity, t_price));
//        System.out.println("" + orderedProductList + "\n");

    }

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        // TODO add your handling code here:
        LocalDate date = LocalDate.now();
        float discount = 0;
//        int discount_id = discountList.get(jComboBox1.getSelectedIndex()).getDiscount_id();
        try {
//            reference = this.referenceField.getText();
            discount = Float.parseFloat(discountField.getText().toString());
        } catch (Exception e) {
            discount = 0;
//            JOptionPane.showMessageDialog(this, "Invalid Discount");
        }
        float total_price = Float.parseFloat(totalField.getText().toString());

        String discount_type = jComboBox1.getSelectedItem().toString();
        Double total_priceGot = Double.parseDouble(totalField.getText().toString());
        try {
            discount = Integer.parseInt(discountField.getText().toString());
        } catch (Exception e) {
            discount = 0;

        }

        new CashNowLaterDialog(this, true, new PaymentDoneBeans(date + "", discount,
                discount_type,
                total_priceGot, customer_id, selected_services_List,
                sale_customer),this).setVisible(true);

    }//GEN-LAST:event_generateButtonActionPerformed

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:

        int i = jTable2.getSelectedRow();
        ServiceBeans s = selected_services_List.get(i);
        toRemoveField.setText("Service: " + s.getService_name());
        removeService.setEnabled(true);
    }//GEN-LAST:event_jTable2MouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new CustomerForm("ref").setVisible(true);
//        new CustomerPage(1).setVisible(true);

//            new CashNowLaterDialog(this, true,1)
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void totalFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalFieldActionPerformed

    private void removeServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeServiceActionPerformed
        // TODO add your handling code here:
        int service_remove_id = jTable2.getSelectedRow();
        removeFromBuy(service_remove_id);

    }//GEN-LAST:event_removeServiceActionPerformed

    private void customerBalanceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerBalanceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerBalanceFieldActionPerformed

    private void removeFromBuy(int service_remove_id) {
        tableModel2.setRowCount(0);
        ServiceBeans s = selected_services_List.get(service_remove_id);
        selected_services_List.remove(service_remove_id);
        total_price -= s.getService_cost();
        totalField.setText("" + total_price);

        for (ServiceBeans s1 : selected_services_List) {
            Vector v = new Vector();
//        int id = p.getCategory_id();
//        String category = ob.getCategory(id).getName();
//        System.out.println("" + p.getName());
            v.add(s1.getService_name());
            v.add(s1.getService_cost());

//        total_price_temp = total_price;
            try {
                tableModel2.addRow(v);
            } catch (Exception e) {
                System.out.println("" + e.getMessage());
            }

        }

        totalField.setText(total_price + "");
        removeService.setEnabled(false);
    }

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
            java.util.logging.Logger.getLogger(SalePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalePage().setVisible(true);
            }
        });
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addField;
    private javax.swing.JTextField addressfield;
    private javax.swing.JTextField customerBalanceField;
    private javax.swing.JTextField discountField;
    private javax.swing.JButton generateButton;
    private javax.swing.JLabel itemField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField numberField;
    private javax.swing.JButton removeService;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel toRemoveField;
    private javax.swing.JTextField totalField;
    // End of variables declaration//GEN-END:variables
}
