/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautyparlour.frames;

import beautyparlour.bean.CustomerBean;
import beautyparlour.bean.InventoryBean;
import beautyparlour.bean.PaymentDoneBeans;
import beautyparlour.bean.ProductPaymentDoneBean;
import beautyparlour.bean.ServiceBeans;
import beautyparlour.dao.InventoryDao;
import beautyparlour.dao.SaleDao;
import beautyparlour.dao.SaleDetailsDao;
import beautyparlour.dao.ServiceDao;
import beautyparlour.daoImpl.InventoryDaoImpl;
import beautyparlour.daoImpl.SaleDaoImpl;
import beautyparlour.daoImpl.SaleDetailDapImpl;
import beautyparlour.daoImpl.ServiceDaoImpl;
import beautyparlour.dialog.CashNowLaterDialog;
import beautyparlour.util.CurrentDate;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
public class RetailPage extends javax.swing.JFrame {

    /**
     * Creates new form SalePage
     */
    DefaultTableModel tableModelServices;
    private ArrayList<InventoryBean> inventories;
    private ArrayList<InventoryBean> selInventories;

    public ArrayList<ServiceBeans> services_list;
    public ArrayList<ServiceBeans> selected_services_List;

    ServiceDao serviceDao;
    SaleDao saleDao;
    InventoryDao inventoryDao;
    SaleDetailsDao saleDetailDao;

    public static boolean sale_customer = false;
    DefaultTableModel tableModel2;
    String reference = "";
    int customer_id = -1;
    public static int total_price = 0;
    public static int total_price_temp = 0;
    TableRowSorter<DefaultTableModel> rowSorter = null;

    public RetailPage() {
        initComponents();
        serviceDao = new ServiceDaoImpl();
        saleDao = new SaleDaoImpl();
        saleDetailDao = new SaleDetailDapImpl();
//        companyDao = new CompanyDaoImpl();
        this.getContentPane().setBackground(Color.white);
        inventoryDao = new InventoryDaoImpl();
        tableModelServices = (DefaultTableModel) this.jTable1.getModel();
        tableModel2 = (DefaultTableModel) this.jTable2.getModel();
        customer_id = -1;
        nameField.setEditable(false);
        numberField.setEditable(false);
        addressfield.setEditable(false);
        customerBalanceField.setEditable(false);

        customerBalanceField.setEnabled(false);
        rowSorter = new TableRowSorter<DefaultTableModel>(tableModelServices);
        this.jTable1.setRowSorter(rowSorter);
        selected_services_List = new ArrayList<>();
        searchField.setEnabled(false);
        this.jTable1.setEnabled(false);
        this.jTable2.setEnabled(false);
        this.jSpinnerQuantity.setEnabled(false);
        addField.setEnabled(false);
        discountField.setEnabled(false);
        jComboBoxDiscountType.setEnabled(false);
        generateButton.setEnabled(false);
        jButtonRemoveFromList.setEnabled(false);
        sale_customer = false;
        generateButton.setEnabled(false);
//        JOptionPane.showMessageDialog(null,"Select customer first!");

        showInTable();
        this.toRemoveField.setForeground(Color.WHITE);
        closePage();
    }

//
    public RetailPage(CustomerBean customer) {
        initComponents();
        sale_customer = true;
        inventories = new ArrayList<>();
        selInventories = new ArrayList<>();
        nameField.setText(customer.getCustomer_name());
        numberField.setText(customer.getCustomer_contact());
        addressfield.setText(customer.getCustomer_address());
        if (customer.getCustomer_dept() < 0) {
            this.customerBalanceField.setForeground(Color.RED);
        }
        customerBalanceField.setText("Rs: " + customer.getCustomer_dept());
        nameField.setEditable(false);
        numberField.setEditable(false);
        addressfield.setEditable(false);
        customerBalanceField.setEditable(false);
        inventoryDao = new InventoryDaoImpl();

        tableModelServices = (DefaultTableModel) this.jTable1.getModel();
        tableModel2 = (DefaultTableModel) this.jTable2.getModel();
        serviceDao = new ServiceDaoImpl();
        saleDao = new SaleDaoImpl();
        saleDetailDao = new SaleDetailDapImpl();
        jButtonRemoveFromList.setEnabled(false);

        customer_id = customer.getCustomer_id();
        this.getContentPane().setBackground(Color.white);

        showInTable();
        rowSorter = new TableRowSorter<DefaultTableModel>(tableModelServices);
        this.jTable1.setRowSorter(rowSorter);

        selected_services_List = new ArrayList<>();

        this.total_price = 0;
        this.total_price_temp = 0;
        generateButton.setEnabled(false);
//        referenceField.setEnabled(false);
        addField.setEnabled(false);
        this.toRemoveField.setForeground(Color.WHITE);
        closePage();

    }

    public void showInTable() {
        tableModelServices.setRowCount(0);
        try {

            inventories = inventoryDao.getAllInventories();

            for (InventoryBean ib : inventories) {
                Vector V = new Vector();
                V.add(ib.getInventoryId());
                V.add(ib.getInventoryName());
                V.add(ib.getSellingCost());
                V.add(ib.getQuantity());

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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        generateButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        addField = new javax.swing.JButton();
        itemField = new javax.swing.JLabel();
        jSpinnerQuantity = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxDiscountType = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        discountField = new javax.swing.JTextField();
        totalField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButtonRemoveFromList = new javax.swing.JButton();
        customerBalanceField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        addressfield = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        numberField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        toRemoveField = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sale");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(20, 11, 6));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Id", "Name", "Cost", "QTY"
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
            jTable1.getColumnModel().getColumn(0).setMinWidth(70);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(2).setMinWidth(120);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(120);
            jTable1.getColumnModel().getColumn(3).setMinWidth(70);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(70);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 660, 330));

        generateButton.setBackground(new java.awt.Color(60, 34, 19));
        generateButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        generateButton.setForeground(new java.awt.Color(255, 255, 255));
        generateButton.setText("Generate");
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });
        jPanel1.add(generateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 730, 219, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(60, 34, 19));
        jButton1.setText("Get or Insert Customer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 70, 330, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/beautyparlour/util/retail_1.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 20, 198, 179));

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr#", "Item Name", "Cost (Rs)", "QTY", "Total (Rs)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMinWidth(60);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(60);
            jTable2.getColumnModel().getColumn(2).setMinWidth(100);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable2.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable2.getColumnModel().getColumn(3).setMinWidth(60);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(3).setMaxWidth(60);
            jTable2.getColumnModel().getColumn(4).setMinWidth(120);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(120);
            jTable2.getColumnModel().getColumn(4).setMaxWidth(120);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 270, 600, 330));

        addField.setBackground(new java.awt.Color(60, 34, 19));
        addField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addField.setForeground(new java.awt.Color(255, 255, 255));
        addField.setText("Add");
        addField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFieldActionPerformed(evt);
            }
        });
        jPanel1.add(addField, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 490, 112, -1));

        itemField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        itemField.setForeground(new java.awt.Color(255, 255, 255));
        itemField.setText("Service: ------");
        jPanel1.add(itemField, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 280, 370, 70));

        jSpinnerQuantity.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jSpinnerQuantity.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jSpinnerQuantity.setValue(1);
        jPanel1.add(jSpinnerQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 450, 80, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("QTY");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 450, 40, -1));

        jComboBoxDiscountType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxDiscountType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Amount", "Percentage" }));
        jPanel1.add(jComboBoxDiscountType, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 630, 133, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Discount Type");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 630, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Discsount");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 670, -1, -1));

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
        jPanel1.add(discountField, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 670, 135, -1));

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
        jPanel1.add(totalField, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 700, 135, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Total bill");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 700, -1, -1));

        searchField.setBackground(new java.awt.Color(20, 11, 6));
        searchField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
        jPanel1.add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 610, 25));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Serach");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 237, -1, 30));

        jButton5.setBackground(new java.awt.Color(60, 34, 19));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Back");
        jButton5.setFocusPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, -1));

        jButtonRemoveFromList.setBackground(new java.awt.Color(60, 34, 19));
        jButtonRemoveFromList.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonRemoveFromList.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRemoveFromList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/beautyparlour/util/delete.png"))); // NOI18N
        jButtonRemoveFromList.setText("Remove");
        jButtonRemoveFromList.setFocusPainted(false);
        jButtonRemoveFromList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveFromListActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRemoveFromList, new org.netbeans.lib.awtextra.AbsoluteConstraints(1550, 610, 130, -1));

        customerBalanceField.setBackground(new java.awt.Color(20, 11, 6));
        customerBalanceField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        customerBalanceField.setForeground(new java.awt.Color(255, 255, 255));
        customerBalanceField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        customerBalanceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerBalanceFieldActionPerformed(evt);
            }
        });
        jPanel1.add(customerBalanceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 200, 325, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Customer Balance");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 210, -1, -1));

        addressfield.setBackground(new java.awt.Color(20, 11, 6));
        addressfield.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addressfield.setForeground(new java.awt.Color(255, 255, 255));
        addressfield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        addressfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressfieldActionPerformed(evt);
            }
        });
        jPanel1.add(addressfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 170, 325, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Address:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 170, -1, -1));

        numberField.setBackground(new java.awt.Color(20, 11, 6));
        numberField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        numberField.setForeground(new java.awt.Color(255, 255, 255));
        numberField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        numberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberFieldActionPerformed(evt);
            }
        });
        jPanel1.add(numberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 140, 325, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contact:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Customer:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, -1, -1));

        nameField.setBackground(new java.awt.Color(20, 11, 6));
        nameField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nameField.setForeground(new java.awt.Color(255, 255, 255));
        nameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });
        jPanel1.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 110, 325, -1));

        toRemoveField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        toRemoveField.setForeground(new java.awt.Color(255, 255, 255));
        toRemoveField.setText("majril");
        jPanel1.add(toRemoveField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 610, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1700, 790));

        jButton6.setBackground(new java.awt.Color(60, 34, 19));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Back");
        jButton6.setFocusPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 11, 110, 30));

        jLabel11.setBackground(new java.awt.Color(60, 34, 19));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("THE BEAUTY BAR");
        jLabel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel11.setOpaque(true);
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 790, 1700, 20));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void discountFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discountFieldKeyReleased
        // TODO add your handling code here:

        if (discountField.equals("")) {
            totalField.setText(total_price + "");

        } else if (jComboBoxDiscountType.getSelectedItem().toString().equalsIgnoreCase("amount")) {

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
        } else if (jComboBoxDiscountType.getSelectedItem().toString().equalsIgnoreCase("percentage")) {

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
        int inventoryIdTable = Integer.parseInt("" + this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0));

//        int product_id_table = product_list.get(id).getP_id();
//        DbManagerInterface ob = new DbManager();
        InventoryBean ib = null;
        try {
            ib = inventoryDao.getInventoryById(inventoryIdTable);
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        if (!(ib.getQuantity() <= 0)) {
            itemField.setText("Item: " + ib.getInventoryName());

            if (sale_customer) {

                addField.setEnabled(true);

            }
        } else {
            JOptionPane.showMessageDialog(null, ib.getInventoryName() + " is out of stock!");

        }

    }//GEN-LAST:event_jTable1MouseReleased

    private void addFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFieldActionPerformed

        int productIdTable = Integer.parseInt("" + this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0));
        Integer selectedQty = Integer.parseInt("" + this.jSpinnerQuantity.getValue());
        InventoryBean ib = inventoryDao.getInventoryById(productIdTable);
        if (selectedQty <= ib.getQuantity()) {
            int remainingQty = ib.getQuantity() - selectedQty;
            inventoryDao.modifyInventoryQty(productIdTable, remainingQty);
            showInTable();
            ib.setSelectedQuantity(selectedQty);
            this.addField.setEnabled(false);
            itemField.setText("");
            this.jSpinnerQuantity.setValue(1);
            generateButton.setEnabled(true);
            showInBuy(ib);
        } else {
            JOptionPane.showMessageDialog(null, ib.getInventoryName() + " avalialbe qunatity in stock is " + ib.getQuantity() + ". You are selecting " + selectedQty);
        }


    }//GEN-LAST:event_addFieldActionPerformed

    private void showInBuy(InventoryBean ib) {

        Vector v = new Vector();
        selInventories.add(ib);
        v.add(selInventories.size());
        v.add(ib.getInventoryName());
        v.add(ib.getSellingCost());
        v.add(ib.getSelectedQuantity());
        v.add(ib.getSelectedQuantity() * ib.getSellingCost());

        double tPrice = ib.getSellingCost() * ib.getSelectedQuantity();

        total_price += tPrice;
        totalField.setText("" + total_price);
        total_price_temp = total_price;
        try {
            tableModel2.addRow(v);
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
//        orderedProductList.add(new ProductBeans(p.getP_id(), ICONIFIED, p_name, ABORT, quantity, tPrice));
//        System.out.println("" + orderedProductList + "\n");

    }

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        // TODO add your handling code here:
        String date = CurrentDate.getCurrentDate();
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

        String discount_type = jComboBoxDiscountType.getSelectedItem().toString();
        Double total_priceGot = Double.parseDouble(totalField.getText().toString());
        try {
            discount = Integer.parseInt(discountField.getText().toString());
        } catch (Exception e) {
            discount = 0;

        }
//
        new CashNowLaterDialog(this, true, new ProductPaymentDoneBean(date + "", discount,
                discount_type,
                total_priceGot, customer_id, selInventories,
                sale_customer), true,this).setVisible(true);

//        new CashNowLaterDialog(this, true).setVisible(true);

    }//GEN-LAST:event_generateButtonActionPerformed

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:

        int i = jTable2.getSelectedRow();
        InventoryBean ib = selInventories.get(i);
        toRemoveField.setText("Item: " + ib.getInventoryName());
        jButtonRemoveFromList.setEnabled(true);
    }//GEN-LAST:event_jTable2MouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new CustomerForm("retial").setVisible(true);
//        new CustomerPage(1).setVisible(true);

//            new CashNowLaterDialog(this, true,1)
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void totalFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalFieldActionPerformed

    private void customerBalanceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerBalanceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerBalanceFieldActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButtonRemoveFromListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveFromListActionPerformed
        // TODO add your handling code here:
        int inventoryRemoveId = jTable2.getSelectedRow();
        removeFromBuy(inventoryRemoveId);
        if (selInventories.size() <= 0) {
            this.generateButton.setEnabled(false);
        }
    }//GEN-LAST:event_jButtonRemoveFromListActionPerformed

    private void removeFromBuy(int inventoryRemoveId) {
        tableModel2.setRowCount(0);
        InventoryBean ib = selInventories.get(inventoryRemoveId);
        int selectedQty = ib.getSelectedQuantity();
        int actualQty = inventoryDao.getInventoryById(ib.getInventoryId()).getQuantity();
        int remainingQty = actualQty + selectedQty;
        inventoryDao.modifyInventoryQty(ib.getInventoryId(), remainingQty);
        showInTable();
        selInventories.remove(inventoryRemoveId);
        total_price -= (ib.getSellingCost() * ib.getSelectedQuantity());
        totalField.setText("" + total_price);
        int serial = 0;
        for (InventoryBean inv : selInventories) {
            Vector v = new Vector();
            serial++;
            v.add(serial);
            v.add(inv.getInventoryName());
            v.add(inv.getSellingCost());
            v.add(inv.getSelectedQuantity());
            v.add(inv.getSelectedQuantity() * inv.getSellingCost());

//        total_price_temp = total_price;
            try {
                tableModel2.addRow(v);
            } catch (Exception e) {
                System.out.println("" + e.getMessage());
            }

        }

        totalField.setText(total_price + "");
        jButtonRemoveFromList.setEnabled(false);
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
            java.util.logging.Logger.getLogger(RetailPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RetailPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RetailPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RetailPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RetailPage().setVisible(true);
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
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonRemoveFromList;
    private javax.swing.JComboBox<String> jComboBoxDiscountType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JSpinner jSpinnerQuantity;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField numberField;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel toRemoveField;
    private javax.swing.JTextField totalField;
    // End of variables declaration//GEN-END:variables
}
