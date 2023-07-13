
package vistaGUI;

import controlador.ControladorCliente;
import controlador.ControladorReporteCajeros;
import controlador.ControladorSimulacion;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Timer;
import modelo.Figura;


public class Simulacion extends javax.swing.JInternalFrame {
    ControladorSimulacion controladorSimulacion;
    ControladorCliente controladorCliente;
    ControladorReporteCajeros controladorReporteCajeros;
    BufferedImage imagenCliente;
    Timer timer;
    int n=0;
    
    //Constructor
    public Simulacion(ControladorSimulacion controladorSimulacion) throws IOException {
        initComponents();
        this.controladorCliente = new ControladorCliente();
        this.controladorSimulacion = controladorSimulacion;
        this.imagenCliente = ImageIO.read(new File("user.png"));
        controladorCliente.listar();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dkpSimulacion = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnItmAtenderCliente = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistaGUI/cajeros.jpeg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 0, -1, 70));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistaGUI/cajeros.jpeg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, 70));

        dkpSimulacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(dkpSimulacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 540));

        jMenu1.setText("Menu");

        mnItmAtenderCliente.setText("IniciarSimulacion");
        mnItmAtenderCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItmAtenderClienteActionPerformed(evt);
            }
        });
        jMenu1.add(mnItmAtenderCliente);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnItmAtenderClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItmAtenderClienteActionPerformed
        Timer();
    }//GEN-LAST:event_mnItmAtenderClienteActionPerformed

    //Metodos
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(Figura cliente:controladorSimulacion.getListaFigura()){
            g.drawImage(imagenCliente, cliente.getX(), cliente.getY(), cliente.getAncho(), cliente.getAlto(), null);
        }
    }
    
    public void Timer() {
        int miliseconds = controladorSimulacion.getTiempo();
        timer = new Timer(miliseconds, ((ev) -> {
            //Mover el cliente en pantalla (x , y)
            mover();
            
        this.repaint();
        }));
        timer.start();
    }
    
    public void mover(){
        if(19 >= n){
                n++;
                controladorSimulacion.actualizarPosicionX();
            }else if (34 >= n) {
                n++;
                controladorSimulacion.actualizarPosicionY();
            }else{
                controladorSimulacion.crearCliente();
                n=0;
                controladorSimulacion.crearCliente();
                mover();
            }
            if(1 == n ){
                controladorSimulacion.crearCliente();
            }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dkpSimulacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mnItmAtenderCliente;
    // End of variables declaration//GEN-END:variables
}
