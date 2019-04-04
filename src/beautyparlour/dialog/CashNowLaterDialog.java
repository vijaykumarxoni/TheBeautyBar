/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautyparlour.dialog;

import beautyparlour.bean.CustomerBean;
import beautyparlour.bean.InventoryBean;
import beautyparlour.bean.PaymentDoneBeans;
import beautyparlour.bean.ProductPaymentDoneBean;
import beautyparlour.bean.ProductSaleBean;
import beautyparlour.bean.ProductSaleDetailBean;
import beautyparlour.bean.SaleBeans;
import beautyparlour.bean.SaleDetailBeans;
import beautyparlour.bean.ServiceBeans;
import beautyparlour.dao.CustomerDao;
import beautyparlour.dao.InventoryDao;
import beautyparlour.dao.ProductSaleDao;
import beautyparlour.dao.ProductSaleDetailDao;
import beautyparlour.dao.SaleDao;
import beautyparlour.dao.SaleDetailsDao;
import beautyparlour.dao.ServiceDao;
import beautyparlour.daoImpl.CustomerDaoImpl;
import beautyparlour.daoImpl.InventoryDaoImpl;
import beautyparlour.daoImpl.ProductSaleDaoImpl;
import beautyparlour.daoImpl.ProductSaleDetailDaoImpl;
import beautyparlour.daoImpl.SaleDaoImpl;
import beautyparlour.daoImpl.SaleDetailDapImpl;
import beautyparlour.daoImpl.ServiceDaoImpl;
import beautyparlour.frames.HomePage;
import beautyparlour.frames.RetailPage;
import beautyparlour.frames.SalePage;
import beautyparlour.util.CurrentDate;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Sides;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.print.PrinterJob;
import java.io.File;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.JFrame;
//import org.apache.fontbox.type1.DamagedFontException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;

import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;

/**
 *
 * @author Vksoni
 */
public class CashNowLaterDialog extends javax.swing.JDialog {

    PaymentDoneBeans ob = null;
    ProductPaymentDoneBean obProd = null;
    boolean isProductRetail = false;

    DefaultTableModel tableModelDebtDetails;
//    DebtDetailDao debtDao;
    SaleDao saleDao;
    ProductSaleDao productSaleDao;
    ProductSaleDetailDao productSaleDetailDao;
    CustomerDao customerDao;
    SaleDetailsDao saleDetailDao;
    boolean cashGot = false;
    ServiceDao serviceDao;
    InventoryDao inventoryDao;
    boolean printer = false;
    SalePage salePage;
    RetailPage retailPage;
//    public ArrayList<DebtDetailBeans> debt_details_list;

    /**
     * Creates new form SetingJDialog
     */
    public CashNowLaterDialog(java.awt.Frame parent, boolean modal, int cust_id, String customer_name) {
        super(parent, modal);
        initComponents();
//        debtDao = new DebtDaoImpl();
//        tableModelDebtDetails = (DefaultTableModel) this.jTableDebtDetails.getModel();
//
//        JTableHeader header = this.jTableDebtDetails.getTableHeader();
//        header.setBackground(new Color(0, 204, 0));
//        header.setForeground(new Color(255, 255, 255));
//        header.setFont(new Font("SansSerif", Font.BOLD, 18));
//        this.jLabelCustomerName.setText("Customer name: " + customer_name);
//        showInTable(cust_id);

    }

    public CashNowLaterDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

    }
    String reference = "";

    public CashNowLaterDialog(java.awt.Frame parent, boolean modal, PaymentDoneBeans ob, SalePage salePage) {
        super(parent, modal);
        initComponents();
        cashGot = true;
        this.ob = ob;
//        this.reference=reference;
        System.out.println("" + ob.getTotal_price());
        pricetoPayField.setText("Total Price To Pay:  " + ob.getTotal_price());
        payNowField.setText(ob.getTotal_price() + "");
        payLaterField.setText("0");
        saleDao = new SaleDaoImpl();
        saleDetailDao = new SaleDetailDapImpl();
        serviceDao = new ServiceDaoImpl();
//        debtDao = new DebtDaoImpl();
        customerDao = new CustomerDaoImpl();
        payLaterField.setEnabled(false);
        this.salePage = salePage;
    }

    public CashNowLaterDialog(java.awt.Frame parent, boolean modal, ProductPaymentDoneBean obProd, boolean isProductRetail, RetailPage retailPage) {
        super(parent, modal);
        initComponents();
        this.isProductRetail = isProductRetail;
        cashGot = true;
        this.retailPage = retailPage;
        this.obProd = obProd;
//        this.reference=reference;
        pricetoPayField.setText("Total Price To Pay:  " + obProd.getTotal_price());
        payNowField.setText(obProd.getTotal_price() + "");
        payLaterField.setText("0");
        productSaleDao = new ProductSaleDaoImpl();
        productSaleDetailDao = new ProductSaleDetailDaoImpl();
        inventoryDao = new InventoryDaoImpl();
//        debtDao = new DebtDaoImpl();
        customerDao = new CustomerDaoImpl();
        payLaterField.setEnabled(false);
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
        jLabelCustomerName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pricetoPayField = new javax.swing.JLabel();
        payLaterField = new javax.swing.JTextField();
        payNowField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 11, 6));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCustomerName.setBackground(new java.awt.Color(60, 34, 19));
        jLabelCustomerName.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabelCustomerName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCustomerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerName.setText("Payment");
        jLabelCustomerName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabelCustomerName.setOpaque(true);
        jPanel1.add(jLabelCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 50));

        jLabel1.setBackground(new java.awt.Color(60, 34, 19));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THE BEAUTY BAR");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 500, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Payment Later:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 110, 20));

        pricetoPayField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pricetoPayField.setForeground(new java.awt.Color(255, 255, 255));
        pricetoPayField.setText("Total Price To Pay:  ");
        jPanel1.add(pricetoPayField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 200, 20));

        payLaterField.setBackground(new java.awt.Color(20, 11, 6));
        payLaterField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        payLaterField.setForeground(new java.awt.Color(255, 255, 255));
        payLaterField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        payLaterField.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(payLaterField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 200, 20));

        payNowField.setBackground(new java.awt.Color(20, 11, 6));
        payNowField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        payNowField.setForeground(new java.awt.Color(255, 255, 255));
        payNowField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        payNowField.setCaretColor(new java.awt.Color(255, 255, 255));
        payNowField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                payNowFieldKeyReleased(evt);
            }
        });
        jPanel1.add(payNowField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 200, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Payment Now:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 110, 20));

        jButton1.setBackground(new java.awt.Color(60, 34, 19));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Generate Bill");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 200, 30));

        jButton2.setBackground(new java.awt.Color(60, 34, 19));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Select Printer ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 110, 20));

        jButton3.setBackground(new java.awt.Color(60, 34, 19));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Generate/Print Receipt");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 200, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

//                    saleDao.saveSale(new SaleBeans(1, customer_id, 1, discount_type, (int) discount, total_price));
        int i = JOptionPane.showConfirmDialog(this, "Are you sure ?");
        double paid = 0;
        try {
            paid = Double.parseDouble(this.payNowField.getText());
        } catch (Exception e) {
            paid = 0;
        }

        if (i == 0) {

            String date = CurrentDate.getCurrentDate();

            if (isProductRetail) {

                ProductSaleBean psb = new ProductSaleBean();
                CustomerBean cb = new CustomerBean();
                cb.setCustomer_id(obProd.getCustomer_id());
                psb.setCustomerBeans(cb);
                psb.setDiscount(obProd.getDiscount());
                psb.setDiscountType(obProd.getDiscount_type());
                psb.setCreatedAt(date);
                psb.setTotalCost(obProd.getTotal_price());
                psb.setPaid(paid);

                productSaleDao.saveSale(psb);
                int productSaleId = productSaleDao.getProductSaleId();

                for (InventoryBean ib : obProd.getSelectedInventories()) {

                    ProductSaleDetailBean psdb = new ProductSaleDetailBean();
                    ProductSaleBean prodSaleBean = new ProductSaleBean();
                    prodSaleBean.setProdSaleId(productSaleId);

                    psdb.setCost(ib.getSellingCost());
                    psdb.setCreatedAt(date);
                    psdb.setInventoryBean(ib);
                    psdb.setProductSaleBean(prodSaleBean);
                    psdb.setQuantity(ib.getSelectedQuantity());
                    psdb.setCustomerBean(cb);
                    psdb.setTotalCost(ib.getSellingCost() * ib.getSelectedQuantity());
                    productSaleDetailDao.saveProductSaleDetails(psdb);

                }

                double pay_now = 0;
                try {
                    pay_now = Double.parseDouble(payNowField.getText().toString());
                } catch (Exception e) {
                    pay_now = 0;

                }

                double pay_later = 0;
                try {
                    pay_later = Double.parseDouble(payLaterField.getText().toString());
                } catch (Exception e) {
                    pay_later = 0;

                }

                double puranadebt = customerDao.getCustomerDebtByCustomerId(obProd.getCustomer_id());
                customerDao.modifyCustomerDebt(obProd.getCustomer_id(), puranadebt - pay_later);

                int sale_id_recepit = productSaleDao.getProductSaleId();
                System.out.println("Id for Receipt " + sale_id_recepit);

                String date2 = CurrentDate.getCurrentDate();

//                generate product recipt
                genReportProduct(sale_id_recepit, date2 + "");
//             File file = new File("/Users/zaptox/source.txt");
                //first check if Desktop is supported by Platform or not
                if (!Desktop.isDesktopSupported()) {
                    System.out.println("Desktop is not supported");
                    return;
                }

                Desktop desktop = Desktop.getDesktop();

                //let's try to open PDF file
                File file = new File("Reports/ProductsRecipts/ProductReceipt " + sale_id_recepit + " " + date2 + ".pdf");
                if (file.exists()) {
                    try {
                        desktop.open(file);
                    } catch (IOException ex) {
                        Logger.getLogger(CashNowLaterDialog.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                this.dispose();
                retailPage.dispose();

                new RetailPage().setVisible(true);

            } else {

                saleDao.saveSale(new SaleBeans(1, ob.getCustomer_id(), 1, ob.getDiscount_type(),
                        ob.getDiscount(), ob.getTotal_price(), paid, date + ""));

                for (ServiceBeans s : ob.getSelected_service_list()) {

                    int sale_id = saleDao.getSaleId();

//                saleDetailDao.saveSaleDetails(new SaleDetailBeans(1, sale_id,ob.getCustomer_id(), product_id, quantity, p.getCompany_id(), p.getUom(), ob.getDate() + "", p.getCost()));
                    saleDetailDao.saveSaleDetails(new SaleDetailBeans(1, sale_id, ob.getCustomer_id(),
                            s.getService_id(), ob.getDate(), s.getService_cost()));
                }

                double pay_now = 0;
                try {
                    pay_now = Double.parseDouble(payNowField.getText().toString());
                } catch (Exception e) {
                    pay_now = 0;

                }

                double pay_later = 0;
                try {
                    pay_later = Double.parseDouble(payLaterField.getText().toString());
                } catch (Exception e) {
                    pay_later = 0;

                }

                double puranadebt = customerDao.getCustomerDebtByCustomerId(ob.getCustomer_id());
                customerDao.modifyCustomerDebt(ob.getCustomer_id(), puranadebt - pay_later);

                int sale_id_recepit = saleDao.getSaleId();
                System.out.println("Id for Receipt " + sale_id_recepit);

                LocalDate date2 = LocalDate.now();

                genReport(sale_id_recepit + "", date2 + "");

//             File file = new File("/Users/zaptox/source.txt");
                //first check if Desktop is supported by Platform or not
                if (!Desktop.isDesktopSupported()) {
                    System.out.println("Desktop is not supported");
                    return;
                }

                Desktop desktop = Desktop.getDesktop();
//        if(file.exists()) try {
//            desktop.open(file);
//        } catch (IOException ex) {
//            Logger.getLogger(CashNowLaterDialog.class.getName()).log(Level.SEVERE, null, ex);
//        }

                //let's try to open PDF file
                File file = new File("Reports/Receipts/Receipt " + sale_id_recepit + " " + date2 + ".pdf");
                if (file.exists()) {
                    try {
                        desktop.open(file);
                    } catch (IOException ex) {
                        Logger.getLogger(CashNowLaterDialog.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

//            try {
//                printReceipt("Reports/Receipts/Receipt " + sale_id_recepit + ".pdf", printer_name);
//            } catch (Exception e) {
//                System.out.println("" + e.getMessage());
//            }
                this.dispose();
                salePage.dispose();
                new SalePage().setVisible(true);

            }

        } else {

        }
    }//GEN-LAST:event_jButton1ActionPerformed
    public void printReceipt(String path, String printer_name) throws Exception {
//    
        try {
            //here

            PrintService[] printServices = PrinterJob.lookupPrintServices();
//        System.out.println(""+printServices[Printerinx]);
            // Iterates the print services and print out its name.
            for (PrintService printService : printServices) {
                String name = printService.getName();
                System.out.println("Name = " + name);
            }

            PDDocument document = PDDocument.load(new File(path));

            PrintService myPrintService = findPrintService(printer_name);

            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPageable(new PDFPageable(document));
            job.setPrintService(myPrintService);
//        try{
            job.print();
//        }
//        catch(Exception e){
//            System.out.println(""+e.getMessage());}
//    

        } catch (Exception e) {
//        
            JOptionPane.showMessageDialog(this, "Printer not available");
//        System.out.println("Recepit can no be printed, Rep "+ e.getMessage() );
        }
    }

    private static PrintService findPrintService(String printerName) {
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
        for (PrintService printService : printServices) {
            if (printService.getName().trim().equals(printerName)) {
                return printService;
            }
        }
        return null;
    }

    public void genReport(String sale_id, String date) {

        IReportEngine engine = null;
        EngineConfig config = null;

        Map parameters = new HashMap();
        parameters.put("sale_id", sale_id);

        try {

            config = new EngineConfig();
            //config.setLogConfig("c:/temp/test", Level.FINEST);
            Platform.startup(config);
            IReportEngineFactory factory = (IReportEngineFactory) Platform
                    .createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
            engine = factory.createReportEngine(config);

            IReportRunnable design = null;
            //Open the report design

            String rpath = "reportrptfiles/receipt_done_final.rptdesign";

            design = engine.openReportDesign(rpath);

            IRunAndRenderTask task = engine.createRunAndRenderTask(design);
            //task.setParameterValue("Top Count", (new Integer(5)));
            //task.validateParameters();
            // int order=DbManager.getMaxOrder();
            HTMLRenderOption options = new HTMLRenderOption();
//            options.setOutputFileName("C:\\Users\\Dell\\Desktop/TodaysReport" + ".pdf");
            options.setOutputFileName("Reports/Receipts/Receipt " + sale_id + " " + date + ".pdf");

            options.setOutputFormat("pdf");

            //options.setHtmlRtLFlag(false);
            //options.setEmbeddable(false);
            //options.setImageDirectory("C:\\test\\images");
            //PDFRenderOption options = new PDFRenderOption();
            //options.setOutputFileName("c:/temp/test.pdf");
            //options.setOutputFormat("pdf");
            task.setRenderOption(options);
            task.setParameterValues(parameters);

            task.run();
            task.close();
            engine.destroy();
        } catch (Exception ex) {
            System.out.println("hello");
            System.out.println(ex.getMessage());
        } finally {
            Platform.shutdown();
        }
    }

    public void genReportProduct(Integer sale_id, String date) {

        IReportEngine engine = null;
        EngineConfig config = null;

        Map parameters = new HashMap();
        parameters.put("sale_id", "" + sale_id);

        try {

            config = new EngineConfig();
            //config.setLogConfig("c:/temp/test", Level.FINEST);
            Platform.startup(config);
            IReportEngineFactory factory = (IReportEngineFactory) Platform
                    .createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
            engine = factory.createReportEngine(config);

            IReportRunnable design = null;
            //Open the report design

            String rpath = "reportrptfiles/recipt_product.rptdesign";

            design = engine.openReportDesign(rpath);

            IRunAndRenderTask task = engine.createRunAndRenderTask(design);
            //task.setParameterValue("Top Count", (new Integer(5)));
            //task.validateParameters();
            // int order=DbManager.getMaxOrder();
            HTMLRenderOption options = new HTMLRenderOption();
//            options.setOutputFileName("C:\\Users\\Dell\\Desktop/TodaysReport" + ".pdf");
            options.setOutputFileName("Reports/ProductsRecipts/ProductReceipt " + sale_id + " " + date + ".pdf");

            options.setOutputFormat("pdf");

            //options.setHtmlRtLFlag(false);
            //options.setEmbeddable(false);
            //options.setImageDirectory("C:\\test\\images");
            //PDFRenderOption options = new PDFRenderOption();
            //options.setOutputFileName("c:/temp/test.pdf");
            //options.setOutputFormat("pdf");
            task.setRenderOption(options);
            task.setParameterValues(parameters);

            task.run();
            task.close();
            engine.destroy();
        } catch (Exception ex) {
            System.out.println("hello");
            System.out.println(ex.getMessage());
        } finally {
            Platform.shutdown();
        }
    }

    private void payNowFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_payNowFieldKeyReleased
        // TODO add your handling code here:
        if (isProductRetail) {
            try {
                if (payNowField.equals("")) {
                    payLaterField.setText(obProd.getTotal_price() + "");

                } else {
                    try {

                        double pay_now = Double.parseDouble(payNowField.getText().toString());
                        if (pay_now > obProd.getTotal_price()) {
                            JOptionPane.showMessageDialog(this, "Invalid Amount");
                        } else {
                            payLaterField.setText((obProd.getTotal_price() - pay_now) + "");
                        }
                    } catch (Exception e) {
                        payLaterField.setText(obProd.getTotal_price() + "");
                    }
                }
            } catch (Exception e) {
                payLaterField.setText(obProd.getTotal_price() + "");
            }
        } else {
            try {
                if (payNowField.equals("")) {
                    payLaterField.setText(obProd.getTotal_price() + "");

                } else {
                    try {

                        double pay_now = Double.parseDouble(payNowField.getText().toString());
                        if (pay_now > ob.getTotal_price()) {
                            JOptionPane.showMessageDialog(this, "Invalid Amount");
                        } else {
                            payLaterField.setText((ob.getTotal_price() - pay_now) + "");
                        }
                    } catch (Exception e) {
                        payLaterField.setText(ob.getTotal_price() + "");
                    }
                }
            } catch (Exception e) {
                payLaterField.setText(ob.getTotal_price() + "");
            }
        }

    }//GEN-LAST:event_payNowFieldKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new PrintersAvailable(new SalePage(), true).setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        int i = JOptionPane.showConfirmDialog(this, "Are you sure ?");
        double paid = 0;
        try {
            paid = Double.parseDouble(this.payNowField.getText());
        } catch (Exception e) {
            paid = 0;
        }

        String printer_name = "";
        try {
            printer_name = PrintersAvailable.printer_name;

        } catch (Exception e) {

        }

        if (printer_name.equals("")) {
            JOptionPane.showMessageDialog(this, "Printer not Selected");
        } else if (i == 0) {

            String date = CurrentDate.getCurrentDate();

            if (isProductRetail) {

                ProductSaleBean psb = new ProductSaleBean();
                CustomerBean cb = new CustomerBean();
                cb.setCustomer_id(obProd.getCustomer_id());
                psb.setCustomerBeans(cb);
                psb.setDiscount(obProd.getDiscount());
                psb.setDiscountType(obProd.getDiscount_type());
                psb.setCreatedAt(date);
                psb.setTotalCost(obProd.getTotal_price());
                psb.setPaid(paid);

                productSaleDao.saveSale(psb);
                int productSaleId = productSaleDao.getProductSaleId();

                for (InventoryBean ib : obProd.getSelectedInventories()) {

                    ProductSaleDetailBean psdb = new ProductSaleDetailBean();
                    ProductSaleBean prodSaleBean = new ProductSaleBean();
                    prodSaleBean.setProdSaleId(productSaleId);

                    psdb.setCost(ib.getSellingCost());
                    psdb.setCreatedAt(date);
                    psdb.setInventoryBean(ib);
                    psdb.setProductSaleBean(prodSaleBean);
                    psdb.setCustomerBean(cb);

                    psdb.setQuantity(ib.getSelectedQuantity());
                    psdb.setTotalCost(ib.getSellingCost() * ib.getSelectedQuantity());
                    productSaleDetailDao.saveProductSaleDetails(psdb);

                }

                double pay_now = 0;
                try {
                    pay_now = Double.parseDouble(payNowField.getText().toString());
                } catch (Exception e) {
                    pay_now = 0;

                }

                double pay_later = 0;
                try {
                    pay_later = Double.parseDouble(payLaterField.getText().toString());
                } catch (Exception e) {
                    pay_later = 0;

                }

                double puranadebt = customerDao.getCustomerDebtByCustomerId(obProd.getCustomer_id());
                customerDao.modifyCustomerDebt(obProd.getCustomer_id(), puranadebt - pay_later);

                int sale_id_recepit = productSaleDao.getProductSaleId();
                System.out.println("Id for Receipt " + sale_id_recepit);

                String date2 = CurrentDate.getCurrentDate();

//                generate product recipt
//                genReport(sale_id_recepit + "", date2 + "");
//             File file = new File("/Users/zaptox/source.txt");
                //first check if Desktop is supported by Platform or not
                if (!Desktop.isDesktopSupported()) {
                    System.out.println("Desktop is not supported");
                    return;
                }

                Desktop desktop = Desktop.getDesktop();

                File file = new File("Reports/ProductsRecipts/ProductReceipt" + sale_id_recepit + " " + date2 + ".pdf");
                if (file.exists()) {
                    try {
                        desktop.open(file);
                    } catch (IOException ex) {
                        Logger.getLogger(CashNowLaterDialog.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                try {
                    printReceipt("Reports/ProductsRecipts/Receipt " + sale_id_recepit + " " + date2 + ".pdf", printer_name);
                } catch (Exception e) {
                    System.out.println("" + e.getMessage());
                }

                this.dispose();
                retailPage.dispose();
                new RetailPage().setVisible(true);

            } else {

                saleDao.saveSale(new SaleBeans(1, ob.getCustomer_id(), 1, ob.getDiscount_type(),
                        ob.getDiscount(), ob.getTotal_price(), paid, date + ""));

                for (ServiceBeans s : ob.getSelected_service_list()) {

                    int sale_id = saleDao.getSaleId();

//                saleDetailDao.saveSaleDetails(new SaleDetailBeans(1, sale_id,ob.getCustomer_id(), product_id, quantity, p.getCompany_id(), p.getUom(), ob.getDate() + "", p.getCost()));
                    saleDetailDao.saveSaleDetails(new SaleDetailBeans(1, sale_id, ob.getCustomer_id(),
                            s.getService_id(), ob.getDate(), s.getService_cost()));
                }

                double pay_now = 0;
                try {
                    pay_now = Double.parseDouble(payNowField.getText().toString());
                } catch (Exception e) {
                    pay_now = 0;

                }

                double pay_later = 0;
                try {
                    pay_later = Double.parseDouble(payLaterField.getText().toString());
                } catch (Exception e) {
                    pay_later = 0;

                }

                double puranadebt = customerDao.getCustomerDebtByCustomerId(ob.getCustomer_id());
                customerDao.modifyCustomerDebt(ob.getCustomer_id(), puranadebt - pay_later);

                int sale_id_recepit = saleDao.getSaleId();
                System.out.println("Id for Receipt " + sale_id_recepit);

                LocalDate date2 = LocalDate.now();

                genReport(sale_id_recepit + "", date2 + "");

//             File file = new File("/Users/zaptox/source.txt");
                //first check if Desktop is supported by Platform or not
                if (!Desktop.isDesktopSupported()) {
                    System.out.println("Desktop is not supported");
                    return;
                }

                Desktop desktop = Desktop.getDesktop();
//        if(file.exists()) try {
//            desktop.open(file);
//        } catch (IOException ex) {
//            Logger.getLogger(CashNowLaterDialog.class.getName()).log(Level.SEVERE, null, ex);
//        }

                //let's try to open PDF file
                File file = new File("Reports/Receipts/Receipt " + sale_id_recepit + " " + date2 + ".pdf");
                if (file.exists()) {
                    try {
                        desktop.open(file);
                    } catch (IOException ex) {
                        Logger.getLogger(CashNowLaterDialog.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

//            try {
//                printReceipt("Reports/Receipts/Receipt " + sale_id_recepit + ".pdf", printer_name);
//            } catch (Exception e) {
//                System.out.println("" + e.getMessage());
//            }
                try {
                    printReceipt("Reports/Receipts/Receipt " + sale_id_recepit + " " + date2 + ".pdf", printer_name);
                } catch (Exception e) {
                    System.out.println("" + e.getMessage());
                }
                this.dispose();
                salePage.dispose();
                new SalePage().setVisible(true);

            }
        } else {

        }

    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(CashNowLaterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CashNowLaterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CashNowLaterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CashNowLaterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CashNowLaterDialog dialog = new CashNowLaterDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

//    public void showInTable(int cust_id) {
//        tableModelDebtDetails.setRowCount(0);
//        int i = 1;
//        debt_details_list = debtDao.getAllDetailByCustomerId(cust_id);
//        for (DebtDetailBeans debt : debt_details_list) {
//            Vector V = new Vector();
//            V.add(i++);
//            V.add(debt.getName());
//            V.add(debt.getDebt_amount());
//            V.add(debt.getDate());
//
//            tableModelDebtDetails.addRow(V);
//        }
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCustomerName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField payLaterField;
    private javax.swing.JTextField payNowField;
    private javax.swing.JLabel pricetoPayField;
    // End of variables declaration//GEN-END:variables
}
