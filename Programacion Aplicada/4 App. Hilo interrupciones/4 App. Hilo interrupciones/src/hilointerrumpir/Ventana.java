/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilointerrumpir;

import java.awt.event.ActionEvent;
import java.util.Random;

/**
 *
 * @author aplaza
 */
public class Ventana extends javax.swing.JFrame 
{
    Lienzo lienzo=new Lienzo();
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
        btnIniciar1 = new javax.swing.JButton();
        btnInterrumpir1 = new javax.swing.JButton();
        btnIniciar2 = new javax.swing.JButton();
        btnInterrumpir2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout pnlCentroLayout = new javax.swing.GroupLayout(pnlCentro);
        pnlCentro.setLayout(pnlCentroLayout);
        pnlCentroLayout.setHorizontalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1027, Short.MAX_VALUE)
        );
        pnlCentroLayout.setVerticalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );

        getContentPane().add(pnlCentro, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        btnIniciar1.setText("Iniciar1");
        btnIniciar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnIniciar1, new java.awt.GridBagConstraints());

        btnInterrumpir1.setText("Interrumpir1");
        btnInterrumpir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInterrumpir1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnInterrumpir1, new java.awt.GridBagConstraints());

        btnIniciar2.setText("Iniciar2");
        btnIniciar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciar2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnIniciar2, new java.awt.GridBagConstraints());

        btnInterrumpir2.setText("Interrumpir2");
        btnInterrumpir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInterrumpir2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnInterrumpir2, new java.awt.GridBagConstraints());

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciar1ActionPerformed
        iniciar(evt);
    }//GEN-LAST:event_btnIniciar1ActionPerformed

    private void btnInterrumpir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInterrumpir1ActionPerformed
        interrumpir(evt);
    }//GEN-LAST:event_btnInterrumpir1ActionPerformed

    private void btnIniciar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciar2ActionPerformed
        iniciar(evt);
    }//GEN-LAST:event_btnIniciar2ActionPerformed

    private void btnInterrumpir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInterrumpir2ActionPerformed
        interrumpir(evt);
    }//GEN-LAST:event_btnInterrumpir2ActionPerformed

    Hilo h1, h2;
    
    public void interrumpir(ActionEvent evt)
    {
        if(evt.getSource().equals(btnInterrumpir1))
        {
            h1.interrupt();
        }
        else if (evt.getSource().equals(btnInterrumpir2))
        {
            h2.interrupt();
        }
    }
    
    //Añade pelota y la bota 1000 veces
	
    public void iniciar (ActionEvent evt)
    {					
        Pelota pelota1=new Pelota();		
	lienzo.add(pelota1);
		
        Random r = new Random();
        int valorDado = r.nextInt(15)+200; 
        
        if(evt.getSource().equals(btnIniciar1))
        {
            h1=new Hilo(pelota1, this.lienzo, valorDado);
            h1.start();
        }
        else if(evt.getSource().equals(btnIniciar2))
        {
            h2=new Hilo(pelota1, this.lienzo, valorDado);
            h2.start();
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar1;
    private javax.swing.JButton btnIniciar2;
    private javax.swing.JButton btnInterrumpir1;
    private javax.swing.JButton btnInterrumpir2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlCentro;
    // End of variables declaration//GEN-END:variables
}
