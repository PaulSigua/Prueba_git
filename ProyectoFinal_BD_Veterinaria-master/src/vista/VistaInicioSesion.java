/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JOptionPane;

/**
 *
 * @author mateo
 */
public class VistaInicioSesion extends javax.swing.JFrame {

    String username;
    String password;
    VistaCliente v;

    /**
     * Creates new form NewJFrame
     */
    public VistaInicioSesion() {
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

        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        okButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        passPasswordField = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setForeground(new java.awt.Color(73, 80, 87));
        jLabel6.setText("Usuario");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));
        jPanel2.add(usernameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 390, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Avatar_Container.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));

        jCheckBox1.setForeground(new java.awt.Color(73, 80, 87));
        jCheckBox1.setText("Recuerdame");
        jCheckBox1.setBorder(null);
        jCheckBox1.setContentAreaFilled(false);
        jPanel2.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        okButton.setBackground(new java.awt.Color(204, 255, 255));
        okButton.setForeground(new java.awt.Color(94, 174, 253));
        okButton.setText("Iniciar sesión");
        okButton.setBorder(null);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        jPanel2.add(okButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 390, 40));

        jLabel7.setForeground(new java.awt.Color(73, 80, 87));
        jLabel7.setText("Contraseña");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/patitas.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Lock.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 20, -1));

        jButton2.setForeground(new java.awt.Color(116, 120, 141));
        jButton2.setText("¿Olvidaste la contraseña?");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 190, 20));
        jPanel2.add(passPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 390, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Card_Content.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 450, 380));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 450, 490));

        jPanel1.setBackground(new java.awt.Color(244, 243, 243));
        jPanel1.setForeground(new java.awt.Color(60, 63, 65));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Ellipse 209.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 450, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/fondobueno.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        jLabel10.setForeground(new java.awt.Color(73, 80, 87));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Copyright_Container.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 620, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        checkinfo();
    }//GEN-LAST:event_okButtonActionPerformed

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
            java.util.logging.Logger.getLogger(VistaInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new VistaInicioSesion().setVisible(true);
            }
        });
    }

    public String getUsername() {
        return username = usernameTextField.getText();
    }

    public String getPassword() {
        return password = passPasswordField.getText();
    }

    public void checkinfo() {
        v = new VistaCliente();
        if (getUsername().equals("") || getPassword().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar sus datos por favor");
        } else{
            v.setVisible(true);
            this.setVisible(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton okButton;
    private javax.swing.JPasswordField passPasswordField;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
