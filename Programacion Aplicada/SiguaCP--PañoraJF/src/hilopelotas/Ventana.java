/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilopelotas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author aplaza
 */
public class Ventana extends javax.swing.JFrame {

    Lienzo lienzo = new Lienzo();
    private ArrayList<Hilo> h1 = new ArrayList<Hilo>();
    private ArrayList<Hilo> h2 = new ArrayList<Hilo>();
    Color color = Color.BLUE;
    Color color2 = Color.RED;
    private int contador1 = 1;
    private int contador2 = 1;

    Hilo hilo1;
    Hilo hilo2;

    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
        this.remove(pnlCentro);
        getContentPane().add(lienzo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCentro = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        interrumpir1 = new javax.swing.JButton();
        btnIniciar2Button = new javax.swing.JButton();
        interrumpir2 = new javax.swing.JButton();
        primerTextField = new javax.swing.JTextField();
        btnIniciar1Button = new javax.swing.JButton();
        segundoTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout pnlCentroLayout = new javax.swing.GroupLayout(pnlCentro);
        pnlCentro.setLayout(pnlCentroLayout);
        pnlCentroLayout.setHorizontalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1057, Short.MAX_VALUE)
        );
        pnlCentroLayout.setVerticalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );

        getContentPane().add(pnlCentro, java.awt.BorderLayout.CENTER);

        interrumpir1.setText("Interrumpir 1");
        interrumpir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interrumpir1ActionPerformed(evt);
            }
        });

        btnIniciar2Button.setText("Iniciar 2");
        btnIniciar2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciar2ButtonActionPerformed(evt);
            }
        });

        interrumpir2.setText("Interrumpir 2");
        interrumpir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interrumpir2ActionPerformed(evt);
            }
        });

        btnIniciar1Button.setText("Iniciar 1");
        btnIniciar1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciar1ButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(btnIniciar1Button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(primerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(interrumpir1)
                .addGap(65, 65, 65)
                .addComponent(btnIniciar2Button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(segundoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(interrumpir2)
                .addGap(49, 49, 49)
                .addComponent(jButton1)
                .addContainerGap(179, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(primerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIniciar1Button)
                    .addComponent(interrumpir1)
                    .addComponent(btnIniciar2Button)
                    .addComponent(interrumpir2)
                    .addComponent(segundoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciar1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciar1ButtonActionPerformed
        iniciar(evt);
    }//GEN-LAST:event_btnIniciar1ButtonActionPerformed

    private void btnIniciar2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciar2ButtonActionPerformed
        iniciar(evt);
    }//GEN-LAST:event_btnIniciar2ButtonActionPerformed

    private void interrumpir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interrumpir1ActionPerformed
        detenerHilo(evt);
    }//GEN-LAST:event_interrumpir1ActionPerformed

    private void interrumpir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interrumpir2ActionPerformed
        detenerHilo(evt);
    }//GEN-LAST:event_interrumpir2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void detenerHilo(ActionEvent evt) {
        if (evt.getSource().equals(interrumpir1)) {
            int num1 = Integer.parseInt(primerTextField.getText());
            if (num1 >= 0 && num1 <= h1.size()) {
                h1.get(num1 - 1).interrupt();
            }
        } else if (evt.getSource().equals(interrumpir2)) {
            int num2 = Integer.parseInt(segundoTextField.getText());
            if (num2 >= 0 && num2 <= h2.size()) {
                h2.get(num2 - 1).interrupt();
            }
        }
    }

    public void iniciar(ActionEvent evt) {
        Pelota pelota1 = new Pelota();

        Random r = new Random();
        int valorDado = r.nextInt(15) + 200;

        if (evt.getSource().equals(btnIniciar1Button)) {
            pelota1.setColor(color);
            pelota1.setNumero(contador1);
            pelota1.getColorNum(contador1);
            contador1++;
            lienzo.add(pelota1);
            hilo1 = new Hilo(pelota1, this.lienzo, valorDado, color);
            h1.add(hilo1);
            hilo1.start();
        } else if (evt.getSource().equals(btnIniciar2Button)) {
            pelota1.setColor(color2);
            pelota1.setNumero(contador2);
            pelota1.getColorNum(contador2);
            contador2++;
            lienzo.add(pelota1);
            hilo2 = new Hilo(pelota1, this.lienzo, valorDado, color2);
            h2.add(hilo2);
            hilo2.start();
        }
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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar1Button;
    private javax.swing.JButton btnIniciar2Button;
    private javax.swing.JButton interrumpir1;
    private javax.swing.JButton interrumpir2;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JTextField primerTextField;
    private javax.swing.JTextField segundoTextField;
    // End of variables declaration//GEN-END:variables
}
