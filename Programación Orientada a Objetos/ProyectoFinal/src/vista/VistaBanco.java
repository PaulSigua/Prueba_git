
package vista;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class VistaBanco extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();
    /**
     * Creates new form NewJFrame
     */
    public VistaBanco() {
        this.setContentPane(fondo);
        initComponents();
        setTitle("Movimiento");
        setSize(800,400);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        persona2 = new javax.swing.JLabel();
        persona1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        persona2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/persona 2.png"))); // NOI18N

        persona1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/GiftEST P1.gif"))); // NOI18N
        persona1.setText("p1");
        persona1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                persona1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(409, Short.MAX_VALUE)
                .addComponent(persona1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(persona2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(persona2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(persona1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void persona1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_persona1KeyPressed

    }//GEN-LAST:event_persona1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaBanco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel persona1;
    private javax.swing.JLabel persona2;
    // End of variables declaration//GEN-END:variables
    
    class FondoPanel extends JPanel{
        private Image imagen;
        
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("/imagen/imagenEST.jpg")).getImage();
            
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            
            setOpaque(false);
            
            super.paint(g);
        }
    }
}
