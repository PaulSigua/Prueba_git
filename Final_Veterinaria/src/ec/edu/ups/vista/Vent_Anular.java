/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorFacturaCab;
import ec.edu.ups.controlador.ControladorFacturaDet;
import ec.edu.ups.controlador.ControladorPersona;
import ec.edu.ups.controlador.CreacionPDF;
import ec.edu.ups.modelo.Factura_Cabecera;
import ec.edu.ups.modelo.Factura_Detalle;
import ec.edu.ups.modelo.Persona;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guama
 */
public class Vent_Anular extends javax.swing.JInternalFrame {

    /**
     * Creates new form Vent_Anular
     */
    private ControladorFacturaCab controladorFacturaCab;
    private ControladorFacturaDet controladorFacturaDet;
    private ControladorPersona controladorPersona;
    private List<Factura_Cabecera> listaFacturas;
    private List<Factura_Cabecera> listaActual;
    private Factura_Cabecera facturaSeleccionada;
    private boolean procesandoEvento = false;

    public Vent_Anular() {
        initComponents();

        tabla_Facturas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                // obtener la fila seleccionada
                if (!procesandoEvento) {
                    procesandoEvento = true;
                    int filaSeleccionada = tabla_Facturas.getSelectedRow();
                    System.out.println("Fila seleccionada: " + filaSeleccionada);
                    if (filaSeleccionada != -1) {
                        System.out.println("Persona seleccionada: " + listaActual.get(filaSeleccionada).toString());
                        facturaSeleccionada = listaActual.get(filaSeleccionada);
                    }
                    procesandoEvento = false;
                }
            }
        });
    }

    public void setControladorFacturaCab(ControladorFacturaCab controladorFacturaCab) {
        this.controladorFacturaCab = controladorFacturaCab;
    }

    public void setControladorPersona(ControladorPersona controladorPersona) {
        this.controladorPersona = controladorPersona;
    }

    public void setControladorFacturaDet(ControladorFacturaDet controladorFacturaDet) {
        this.controladorFacturaDet = controladorFacturaDet;
    }

    public void actulizarTabla() {
        listaFacturas = this.controladorFacturaCab.listarFacturas();
        listaActual = listaFacturas;
        DefaultTableModel modelo = (DefaultTableModel) tabla_Facturas.getModel();

        modelo.setRowCount(0);

        for (Factura_Cabecera fac : listaActual) {
            System.out.println(fac.toString());
            Date date = fac.getFecha().getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String formattedDate = dateFormat.format(date);

            Persona p = this.controladorPersona.BuscarPersona(fac.getPer_id());
            String estado;
            if (fac.getEstado() == 'N') {
                estado = "Anulada";
            } else {
                estado = "OK";
            }
            Object[] fila = {fac.getId(), formattedDate, p.getNombre() + " " + p.getApellido(), fac.getTotal(), estado};
            modelo.addRow(fila);
        }

        tabla_Facturas.setModel(modelo);

    }

    public void resultadoBusqueda(List<Factura_Cabecera> facturas) {
        DefaultTableModel modelo = (DefaultTableModel) tabla_Facturas.getModel();

        modelo.setRowCount(0);

        for (Factura_Cabecera fac : facturas) {
            System.out.println(fac.toString());
            Date date = fac.getFecha().getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String formattedDate = dateFormat.format(date);
            Persona p = this.controladorPersona.BuscarPersona(fac.getPer_id());
            String estado;
            if (fac.getEstado() == 'N') {
                estado = "Anulada";
            } else {
                estado = "OK";
            }
            Object[] fila = {fac.getId(), formattedDate, p.getNombre() + " " + p.getApellido(), fac.getTotal(), estado};
            modelo.addRow(fila);
        }
        listaActual = facturas;

        tabla_Facturas.setModel(modelo);
    }

    public void resetear() {
        facturaSeleccionada = null;
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
        btn_Pdf = new javax.swing.JButton();
        btn_Anular = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_Facturas = new javax.swing.JTable();
        btn_Buscar_Fac = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Pdf.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Pdf.setForeground(new java.awt.Color(29, 64, 97));
        btn_Pdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_pdf_50px.png"))); // NOI18N
        btn_Pdf.setText("MOSTRAR PDF");
        btn_Pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PdfActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Pdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 140, 255, 50));

        btn_Anular.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Anular.setForeground(new java.awt.Color(29, 64, 97));
        btn_Anular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_cancel_subscription_50px.png"))); // NOI18N
        btn_Anular.setText("ANULAR FACTURA");
        btn_Anular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AnularActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Anular, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 640, 250, 50));

        btn_Cancelar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Cancelar.setForeground(new java.awt.Color(29, 64, 97));
        btn_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_cancel_50px.png"))); // NOI18N
        btn_Cancelar.setText("CANCELAR");
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 640, 250, 50));

        tabla_Facturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Fecha", "Cliente", "Total", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_Facturas);
        if (tabla_Facturas.getColumnModel().getColumnCount() > 0) {
            tabla_Facturas.getColumnModel().getColumn(0).setPreferredWidth(1);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 880, 350));

        btn_Buscar_Fac.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Buscar_Fac.setForeground(new java.awt.Color(29, 64, 97));
        btn_Buscar_Fac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_analyze_50px.png"))); // NOI18N
        btn_Buscar_Fac.setText("BUSCAR FACTURA");
        btn_Buscar_Fac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Buscar_FacActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Buscar_Fac, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 255, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/Anular.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AnularActionPerformed
        if (facturaSeleccionada == null) {
            JOptionPane.showMessageDialog(null, "Seleccione una factura");
        } else {
            this.controladorFacturaCab.anularFacura(facturaSeleccionada);
            actulizarTabla();
            resetear();
        }
    }//GEN-LAST:event_btn_AnularActionPerformed

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        resetear();
        actulizarTabla();
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void btn_Buscar_FacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Buscar_FacActionPerformed
        Buscar_Factura bF = new Buscar_Factura();
        bF.setVent_Anular(this);
        bF.setControladorFacturaCab(this.controladorFacturaCab);
        bF.setVisible(true);
    }//GEN-LAST:event_btn_Buscar_FacActionPerformed

    private void btn_PdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PdfActionPerformed
        if (facturaSeleccionada == null) {
            JOptionPane.showMessageDialog(null, "Seleccione una factura");
        } else {
            CreacionPDF crePdf = new CreacionPDF();

            List<Factura_Detalle> servicios = this.controladorFacturaDet.buscarFactura(facturaSeleccionada.getId());
            try {
                crePdf.crearFacturaPdf(facturaSeleccionada, servicios, "_Reimpresion");
            } catch (IOException ex) {
                Logger.getLogger(Vent_Anular.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btn_PdfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Anular;
    private javax.swing.JButton btn_Buscar_Fac;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Pdf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_Facturas;
    // End of variables declaration//GEN-END:variables
}
