/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorCita;
import ec.edu.ups.modelo.Cita;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author guama
 */
public class Buscar_Cita extends javax.swing.JFrame {

    /**
     * Creates new form Buscar_Cliente
     */
    private Vent_Citas vent_Citas;
    private ControladorCita controladorCita;

    public Buscar_Cita() {
        initComponents();
        this.setLocationRelativeTo(null);
        chooserFecha.setVisible(false);
        GrupoRadio.add(rad_CedulaVet);
        GrupoRadio.add(rad_CedulaCli);
        GrupoRadio.add(rad_Fecha);
    }

    public void setVent_Citas(Vent_Citas vent_Citas) {
        this.vent_Citas = vent_Citas;
    }

    public void setControladorCita(ControladorCita controladorCita) {
        this.controladorCita = controladorCita;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoRadio = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        chooserFecha = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rad_Fecha = new javax.swing.JRadioButton();
        txt_Cedula = new javax.swing.JTextField();
        rad_CedulaVet = new javax.swing.JRadioButton();
        rad_CedulaCli = new javax.swing.JRadioButton();
        btn_Buscar1 = new javax.swing.JButton();
        btn_Buscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(450, 400));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setMaximumSize(new java.awt.Dimension(450, 400));
        jPanel1.setMinimumSize(new java.awt.Dimension(450, 400));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(chooserFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 290, 30));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(29, 64, 97));
        jLabel3.setText("Seleccione una opcion de busqueda e ingrese el valor a buscar:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 360, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(29, 64, 97));
        jLabel2.setText("Buscar por:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, -1));

        rad_Fecha.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        rad_Fecha.setText("Fecha");
        rad_Fecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rad_FechaMouseClicked(evt);
            }
        });
        rad_Fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_FechaActionPerformed(evt);
            }
        });
        jPanel1.add(rad_Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, -1, -1));

        txt_Cedula.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txt_Cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CedulaActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 390, 30));

        rad_CedulaVet.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        rad_CedulaVet.setText("Cedula Veterinario");
        rad_CedulaVet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rad_CedulaVetMouseClicked(evt);
            }
        });
        rad_CedulaVet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_CedulaVetActionPerformed(evt);
            }
        });
        jPanel1.add(rad_CedulaVet, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        rad_CedulaCli.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        rad_CedulaCli.setText("Cedula Cliente");
        rad_CedulaCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rad_CedulaCliMouseClicked(evt);
            }
        });
        rad_CedulaCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_CedulaCliActionPerformed(evt);
            }
        });
        jPanel1.add(rad_CedulaCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        btn_Buscar1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Buscar1.setForeground(new java.awt.Color(29, 64, 97));
        btn_Buscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_cancel_20px.png"))); // NOI18N
        btn_Buscar1.setText("CANCELAR");
        btn_Buscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Buscar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Buscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 160, -1));

        btn_Buscar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Buscar.setForeground(new java.awt.Color(29, 64, 97));
        btn_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_search_20px.png"))); // NOI18N
        btn_Buscar.setText("BUSCAR");
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 160, -1));

        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(29, 64, 97), 2, true));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 400));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/BuscarCita.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 450, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_CedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CedulaActionPerformed

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed

        if (rad_CedulaVet.isSelected()) {
            if (txt_Cedula.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "El campo no puede estar vacio");
            } else {
                List<Cita> citas = this.controladorCita.buscarCitaPorVeterinario(txt_Cedula.getText().trim());
                if (citas != null) {
                    this.vent_Citas.resultadoBusqueda(citas);
                    this.dispose();
                }
            }
        } else if (rad_CedulaCli.isSelected()) {

            if (txt_Cedula.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "El campo no puede estar vacio");
            } else {
                List<Cita> citas = this.controladorCita.buscarCitaPorCliente(txt_Cedula.getText().trim());
                if (citas != null) {
                    this.vent_Citas.resultadoBusqueda(citas);
                    this.dispose();
                }
            }
        } else if (rad_Fecha.isSelected()) {
            
             Date fechaSelecionada;
             Calendar fecha=null;
            try {
                fechaSelecionada = chooserFecha.getDate();
                fecha = Calendar.getInstance();
                fecha.setTime(fechaSelecionada);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ingrese una fecha Valida");
            }
            
            List<Cita> citas = this.controladorCita.buscarCitaPorFecha(fecha);
            if (citas != null) {
                this.vent_Citas.resultadoBusqueda(citas);
                this.dispose();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion para buscar");
        }

    }//GEN-LAST:event_btn_BuscarActionPerformed

    private void btn_Buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Buscar1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_Buscar1ActionPerformed

    private void rad_FechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rad_FechaMouseClicked
        
    }//GEN-LAST:event_rad_FechaMouseClicked

    private void rad_CedulaCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rad_CedulaCliMouseClicked
        
    }//GEN-LAST:event_rad_CedulaCliMouseClicked

    private void rad_CedulaVetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rad_CedulaVetMouseClicked
        
    }//GEN-LAST:event_rad_CedulaVetMouseClicked

    private void rad_FechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_FechaActionPerformed
        chooserFecha.setVisible(true);
        chooserFecha.setDate(Calendar.getInstance().getTime());
        txt_Cedula.setVisible(false);
    }//GEN-LAST:event_rad_FechaActionPerformed

    private void rad_CedulaCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_CedulaCliActionPerformed
        txt_Cedula.setVisible(true);
        chooserFecha.setVisible(false);
    }//GEN-LAST:event_rad_CedulaCliActionPerformed

    private void rad_CedulaVetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_CedulaVetActionPerformed
        txt_Cedula.setVisible(true);
        chooserFecha.setVisible(false);
    }//GEN-LAST:event_rad_CedulaVetActionPerformed

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
            java.util.logging.Logger.getLogger(Buscar_Cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buscar_Cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buscar_Cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buscar_Cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buscar_Cita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoRadio;
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Buscar1;
    private com.toedter.calendar.JDateChooser chooserFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rad_CedulaCli;
    private javax.swing.JRadioButton rad_CedulaVet;
    private javax.swing.JRadioButton rad_Fecha;
    private javax.swing.JTextField txt_Cedula;
    // End of variables declaration//GEN-END:variables
}
