/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautyparlour.dialog;

import beautyparlour.bean.UserBean;
import beautyparlour.dao.UserDao;
import beautyparlour.daoImpl.UserDaoImpl;
import beautyparlour.frames.HomePageAdmin;
import com.sun.glass.events.KeyEvent;
import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author Vksoni
 */
public class AdminLoginDialog extends javax.swing.JDialog {
     Frame parent;
    /**
     * Creates new form AdminLoginDialog
     */
    public AdminLoginDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.parent=parent;
        initComponents();
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
        jtextFieldUname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonLogin = new javax.swing.JButton();
        jTextFieldUpass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(20, 11, 6));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCustomerName.setBackground(new java.awt.Color(60, 34, 19));
        jLabelCustomerName.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabelCustomerName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCustomerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCustomerName.setText("Admin Login");
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
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 500, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Change Password");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 140, 20));

        jtextFieldUname.setBackground(new java.awt.Color(20, 11, 6));
        jtextFieldUname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtextFieldUname.setForeground(new java.awt.Color(255, 255, 255));
        jtextFieldUname.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jtextFieldUname.setCaretColor(new java.awt.Color(255, 255, 255));
        jtextFieldUname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextFieldUnameActionPerformed(evt);
            }
        });
        jtextFieldUname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtextFieldUnameKeyReleased(evt);
            }
        });
        jPanel1.add(jtextFieldUname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 200, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Username:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 110, 20));

        jButtonLogin.setBackground(new java.awt.Color(60, 34, 19));
        jButtonLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLogin.setText("Login");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 200, 30));

        jTextFieldUpass.setBackground(new java.awt.Color(20, 11, 6));
        jTextFieldUpass.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldUpass.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jTextFieldUpass.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextFieldUpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldUpassKeyPressed(evt);
            }
        });
        jPanel1.add(jTextFieldUpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 200, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 110, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtextFieldUnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtextFieldUnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtextFieldUnameActionPerformed

    private void jtextFieldUnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextFieldUnameKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            loginUser();
        }

    }//GEN-LAST:event_jtextFieldUnameKeyReleased

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        // TODO add your handling code here:
        loginUser();

    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jTextFieldUpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUpassKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            loginUser();
        }
    }//GEN-LAST:event_jTextFieldUpassKeyPressed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        
        new TypeOldPasswordDialog(parent, true).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(AdminLoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdminLoginDialog dialog = new AdminLoginDialog(new javax.swing.JFrame(), true);
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

    public void loginUser() {

        String uname = this.jtextFieldUname.getText().toString().trim();
        String upass = this.jTextFieldUpass.getText().toString().trim();

        UserBean ub = new UserBean();
        ub.setUname(uname);
        ub.setUpass(upass);
        UserDao userDao = new UserDaoImpl();
        UserBean userGet = userDao.userAutth(ub);
        if (userGet.getUname()!=null&& (userGet.getUpass()!=null)) {
            this.dispose();
            new HomePageAdmin().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Wrong username or password!");

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCustomerName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jTextFieldUpass;
    private javax.swing.JTextField jtextFieldUname;
    // End of variables declaration//GEN-END:variables
}
