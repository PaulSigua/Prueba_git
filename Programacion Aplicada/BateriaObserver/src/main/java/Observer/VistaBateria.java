/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import java.util.Timer;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author LENOVO
 */
public class VistaBateria extends javax.swing.JFrame {

    public Subject sujeto, sujeto2;
    Timer timer, timer2;
    TareaTimerTask tarea;
    Tarea2TimerTask tarea2;
    VistaBateria vista;
    Observador observador;

    /**
     * Creates new form VistaBateria
     */
    public VistaBateria() {
        initComponents();
        this.sujeto = new Subject();
        this.sujeto.agregar(observador);
        this.sujeto2 = new Subject();
        this.sujeto2.agregar(observador);
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
        conectarButton = new javax.swing.JButton();
        desconectarButton = new javax.swing.JButton();
        ingresarPorcentajeTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        recibirPorcentajeTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        temporizadorLabel = new javax.swing.JLabel();
        tiempoEstimadoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        conectarButton.setText("Conectar");
        conectarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conectarButtonActionPerformed(evt);
            }
        });

        desconectarButton.setText("Detener");
        desconectarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desconectarButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingrese el porcentaje de carga:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Simulación de la carga de una bateria");

        jLabel3.setText("Carga");

        jLabel4.setText("Tiempo estimado aproxi");

        jLabel5.setText("Temporizador");

        temporizadorLabel.setText("0");

        tiempoEstimadoLabel.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(ingresarPorcentajeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(recibirPorcentajeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(temporizadorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(tiempoEstimadoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desconectarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(conectarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(103, 103, 103))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ingresarPorcentajeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(conectarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(desconectarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(recibirPorcentajeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(temporizadorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tiempoEstimadoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void conectarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conectarButtonActionPerformed
        Integer texto = Integer.parseInt(ingresarPorcentajeTextField.getText());
        recibirPorcentajeTextField.setText(texto + "%");
        timer = new Timer();
        timer2 = new Timer();
        tarea = new TareaTimerTask(this, sujeto);
        tarea2 = new Tarea2TimerTask(this, sujeto2);
        timer.schedule(tarea, 0, 1000);
        getPorcentaje();
        
        if (texto > 100) {
            JOptionPane.showMessageDialog(this, "El porcentaje no debe ser mayor a 100");
            ingresarPorcentajeTextField.setText("");
            recibirPorcentajeTextField.setText("");
            timer.cancel();
            timer2.cancel();
        }
        
        if(texto == 100){
            actualizarTemporizador(0, -1);
            actualizarTiempoEstimado2(0, 0);
            timer.schedule(tarea2, 0, 1000);
            timer.cancel();
            timer2.cancel();
        }if(texto <= 99 && texto > 96){
            actualizarTiempoEstimado1(3);
            timer.schedule(tarea2, 0, 1000);
        }if(texto <= 95 && texto > 89){
            actualizarTiempoEstimado1(15);
            timer2.schedule(tarea2, 0, 1000);
        }if(texto <= 89 && texto > 79){
            actualizarTiempoEstimado1(23);
            timer2.schedule(tarea2, 0, 1000);
        }if(texto <= 79 && texto > 69){
            actualizarTiempoEstimado1(30);
            timer2.schedule(tarea2, 1000);
        }if(texto <= 69 && texto > 59){
            actualizarTiempoEstimado1(47);
            timer2.schedule(tarea2, 1000);
        }if(texto <= 59 && texto > 49){
            actualizarTiempoEstimado1(58);
            timer2.schedule(tarea2, 1000);
        }if(texto <= 49 && texto > 39){
            actualizarTiempoEstimado2(1, 7);
            timer2.schedule(tarea2, 1000);
        }if(texto <= 39 && texto > 29){
            actualizarTiempoEstimado2(1, 15);
            timer2.schedule(tarea2, 1000);
        }if(texto <= 29 && texto > 19){
            actualizarTiempoEstimado2(1, 20);
            timer2.schedule(tarea2, 1000);
        }if(texto <= 19 && texto > 9){
            actualizarTiempoEstimado2(1, 30);
            timer2.schedule(tarea2, 1000);
        }if(texto <= 9 && texto > 0){
            actualizarTiempoEstimado2(1, 40);
            timer2.schedule(tarea2, 1000);
        }
    }//GEN-LAST:event_conectarButtonActionPerformed

    private void desconectarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desconectarButtonActionPerformed
        timer.cancel();
        timer2.cancel();
    }//GEN-LAST:event_desconectarButtonActionPerformed

    public void actualizarTiempoEstimado1(int min){
        tiempoEstimadoLabel.setText(min + "min");
    }

    public void actualizarTiempoEstimado2(int min, int seg) {
        tiempoEstimadoLabel.setText(min + "hora " + "y " + seg + "min");
    }
    
    public void actualizarTemporizador(int min, int seg) {
        if(min == 02 && seg == 00){
            temporizadorLabel.setText(min + "min " + seg + "seg ");
            Integer texto = Integer.parseInt(ingresarPorcentajeTextField.getText());
            recibirPorcentajeTextField.setText(texto + 1 + "%");
        }else if(min == 04 && seg == 00){
            temporizadorLabel.setText(min + "min " + seg + "seg ");
            Integer texto = Integer.parseInt(ingresarPorcentajeTextField.getText());
            recibirPorcentajeTextField.setText(texto + 2 + "%");
        }
        temporizadorLabel.setText(min + "min " + seg + "seg ");
    }

    public String getPorcentaje() throws NullPointerException {
        String porcentaje = ingresarPorcentajeTextField.getText();
        if (porcentaje.equals("")) {
            throw new NullPointerException("El porcentaje no puede estar vacío");
        }
        return porcentaje;
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
            java.util.logging.Logger.getLogger(VistaBateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaBateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaBateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaBateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaBateria().setVisible(true);
            }
        });
    }

    public JTextField getRecibirPorcentajeTextField() {
        return recibirPorcentajeTextField;
    }

    public void setRecibirPorcentajeTextField(JTextField recibirPorcentajeTextField) {
        this.recibirPorcentajeTextField = recibirPorcentajeTextField;
    }

    public JButton getConectarButton() {
        return conectarButton;
    }

    public void setConectarButton(JButton conectarButton) {
        this.conectarButton = conectarButton;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton conectarButton;
    private javax.swing.JButton desconectarButton;
    private javax.swing.JTextField ingresarPorcentajeTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField recibirPorcentajeTextField;
    private javax.swing.JLabel temporizadorLabel;
    private javax.swing.JLabel tiempoEstimadoLabel;
    // End of variables declaration//GEN-END:variables
}
