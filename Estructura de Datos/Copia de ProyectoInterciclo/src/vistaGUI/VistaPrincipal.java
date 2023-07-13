
package vistaGUI;

import controlador.ControladorCliente;
import controlador.ControladorReporteCajeros;
import controlador.ControladorSimulacion;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VistaPrincipal extends javax.swing.JFrame {
    ControladorCliente controladorCliente;
    ControladorReporteCajeros controladorReporteCajeros;
    ControladorSimulacion controladorSimulacion;
    
    //Constructor
    public VistaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);//centrar pantalla
        controladorReporteCajeros = new ControladorReporteCajeros();
        controladorCliente = new ControladorCliente();
        controladorSimulacion = new ControladorSimulacion();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpnPrincipal = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mniRegistro = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dpnPrincipal.setBackground(new java.awt.Color(102, 102, 102));
        dpnPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Desarrollo e implementación de una simulación de sistema de gestión de turnos para el banco UPS.");

        dpnPrincipal.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dpnPrincipalLayout = new javax.swing.GroupLayout(dpnPrincipal);
        dpnPrincipal.setLayout(dpnPrincipalLayout);
        dpnPrincipalLayout.setHorizontalGroup(
            dpnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dpnPrincipalLayout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(91, 91, 91))
        );
        dpnPrincipalLayout.setVerticalGroup(
            dpnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dpnPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(705, Short.MAX_VALUE))
        );

        jMenu1.setText("Clientes");

        mniRegistro.setText("Registro");
        mniRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniRegistroActionPerformed(evt);
            }
        });
        jMenu1.add(mniRegistro);

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Cajeros");

        jMenuItem6.setText("ReporteCajeros");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("Simulacion");

        jMenuItem2.setText("Simulacion Banco");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Ayuda");

        jMenuItem3.setText("Acerca de...");
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Tutorial");
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpnPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpnPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Metodos
    private void mniRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniRegistroActionPerformed
        VistaCliente vistaCliente = new VistaCliente(controladorCliente);
        dpnPrincipal.add(vistaCliente);
        vistaCliente.setVisible(true);
    }//GEN-LAST:event_mniRegistroActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            Simulacion simulacion = new Simulacion(controladorSimulacion);
            dpnPrincipal.add(simulacion);
            simulacion.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        VistaReporteCajeros vistaReporteCajeros = new VistaReporteCajeros(controladorReporteCajeros);
        dpnPrincipal.add(vistaReporteCajeros);
        vistaReporteCajeros.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dpnPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem mniRegistro;
    // End of variables declaration//GEN-END:variables
}
