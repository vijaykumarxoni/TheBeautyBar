/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautyparlour.frames;

import beautyparlour.bean.CustomerBean;
import beautyparlour.bean.DailyReportBean;
import beautyparlour.dao.ReportDao;
import beautyparlour.daoImpl.CustomerDaoImpl;
import beautyparlour.daoImpl.ReportDaoImpl;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;

/**
 *
 * @author Dell
 */
public class AllReportPage extends javax.swing.JFrame {

    /**
     * Creates new form DailyReportPage
     */
    DefaultTableModel tableModelReport;
    ReportDao reportDao;
    public ArrayList<DailyReportBean> daily_report_list;

    TableRowSorter<DefaultTableModel> rowSorter = null;

    public AllReportPage() {
        initComponents();
        this.getContentPane().setBackground(Color.white);

        reportDao = new ReportDaoImpl();
        tableModelReport = (DefaultTableModel) this.jTableReport.getModel();
        rowSorter = new TableRowSorter<DefaultTableModel>(tableModelReport);
        this.jTableReport.setRowSorter(rowSorter);
        LocalDate date = LocalDate.now();

        showInTable(date + "");
//        dateLabel.setText("Today's Report");

    }

    public void showInTable(String date) {
        int total_profit = 0;
        int total_customers = 0;
        tableModelReport.setRowCount(0);

        int serial = 0;
        daily_report_list = reportDao.getAllReportBean();

        for (DailyReportBean dailyReportBean : daily_report_list) {
            Vector V = new Vector();
            serial++;

            V.add(serial);
            V.add(dailyReportBean.getCustomer_name());
            V.add(dailyReportBean.getSale_date());
            V.add(dailyReportBean.getTotal_bill());

            total_profit += dailyReportBean.getTotal_bill();
            total_customers += 1;
            tableModelReport.addRow(V);
        }

        totatCustomerlabel.setText("" + total_customers);
        totatProfitlabel.setText("" + total_profit);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        totatCustomerlabel = new javax.swing.JLabel();
        totatProfitlabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableReport = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(60, 34, 19));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 100, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("All Report");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 92, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/beautyparlour/util/report.PNG"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 64, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total Customers:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 558, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Total Profit:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 598, -1, -1));

        totatCustomerlabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        totatCustomerlabel.setForeground(new java.awt.Color(255, 255, 255));
        totatCustomerlabel.setText("0");
        getContentPane().add(totatCustomerlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 558, -1, -1));

        totatProfitlabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        totatProfitlabel.setForeground(new java.awt.Color(255, 255, 255));
        totatProfitlabel.setText("0");
        getContentPane().add(totatProfitlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 598, -1, -1));

        jPanel2.setBackground(new java.awt.Color(20, 11, 6));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(60, 34, 19));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("THE BEAUTY BAR");
        jLabel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel6.setOpaque(true);
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 750, 30));

        jTableReport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTableReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S#", "Customer_name", "Sale_date", "Total_bill"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableReport);
        if (jTableReport.getColumnModel().getColumnCount() > 0) {
            jTableReport.getColumnModel().getColumn(0).setMinWidth(60);
            jTableReport.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTableReport.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 728, 380));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 660));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new ReportPage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void genReport() {

        IReportEngine engine = null;
        EngineConfig config = null;

        try {

            config = new EngineConfig();
            //config.setLogConfig("c:/temp/test", Level.FINEST);
            Platform.startup(config);
            IReportEngineFactory factory = (IReportEngineFactory) Platform
                    .createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
            engine = factory.createReportEngine(config);

            IReportRunnable design = null;
            //Open the report design
            String rpath = "beautyparlour.rptdesign";

            design = engine.openReportDesign(rpath);

            IRunAndRenderTask task = engine.createRunAndRenderTask(design);
            //task.setParameterValue("Top Count", (new Integer(5)));
            //task.validateParameters();
            // int order=DbManager.getMaxOrder();
            HTMLRenderOption options = new HTMLRenderOption();
            options.setOutputFileName("C:\\Users\\Dell\\Desktop/ReciptNo" + ".pdf");
            options.setOutputFormat("pdf");
            //options.setHtmlRtLFlag(false);
            //options.setEmbeddable(false);
            //options.setImageDirectory("C:\\test\\images");

            //PDFRenderOption options = new PDFRenderOption();
            //options.setOutputFileName("c:/temp/test.pdf");
            //options.setOutputFormat("pdf");
            task.setRenderOption(options);
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

    /**
     * s
     *
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
            java.util.logging.Logger.getLogger(AllReportPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllReportPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllReportPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllReportPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AllReportPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableReport;
    private javax.swing.JLabel totatCustomerlabel;
    private javax.swing.JLabel totatProfitlabel;
    // End of variables declaration//GEN-END:variables
}
