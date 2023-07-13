/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorMascota;
import ec.edu.ups.controlador.ControladorPersona;
import ec.edu.ups.controlador.ControladorTipoMascota;
import ec.edu.ups.modelo.Mascota;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Tipo_Mascota;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guama
 */
public class Vent_Mascotas extends javax.swing.JInternalFrame {

    /**
     * Creates new form Vent_Mascotas
     */
    private ControladorTipoMascota controladorTipoMascota;
    private ControladorPersona controladorPersona;
    private ControladorMascota controladorMascota;
    private List<Mascota> listaMascotas;
    private List<Mascota> listaActual;
    private Mascota mascotaSeleccionada;
    private boolean procesandoEvento = false;
    private Persona clienteSeleccionado;
    private Tipo_Mascota tipoMascotaSeleccionada;

    public void setControladorTipoMascota(ControladorTipoMascota controladorTipoMascota) {
        this.controladorTipoMascota = controladorTipoMascota;
    }

    public void setControladorPersona(ControladorPersona controladorPersona) {
        this.controladorPersona = controladorPersona;
    }

    public void setClienteSeleccionado(Persona clienteSeleccionado) {
        this.clienteSeleccionado = clienteSeleccionado;
        lbl_Duenio_Select.setText("Dueño: " + this.clienteSeleccionado.getNombre() + " " + this.clienteSeleccionado.getApellido());
    }

    public void setControladorMascota(ControladorMascota controladorMascota) {
        this.controladorMascota = controladorMascota;
    }

    public void setTipoMascotaSeleccionada(Tipo_Mascota tipoMascotaSeleccionada) {
        this.tipoMascotaSeleccionada = tipoMascotaSeleccionada;
        lbl_Tipo_Select.setText("Tipo Mascota: " + this.tipoMascotaSeleccionada.getNombre());
    }

    public Vent_Mascotas() {
        initComponents();

        tabla_Mascotas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                // obtener la fila seleccionada
                if (!procesandoEvento) {
                    procesandoEvento = true;
                    int filaSeleccionada = tabla_Mascotas.getSelectedRow();
                    System.out.println("Fila seleccionada: " + filaSeleccionada);
                    if (filaSeleccionada != -1) {
                        System.out.println("Mascota seleccionada: " + listaActual.get(filaSeleccionada).toString());
                        mascotaSeleccionada = listaActual.get(filaSeleccionada);
                        actEli_Mascota();
                    }
                    procesandoEvento = false;
                }
            }
        });
    }

    public void actEli_Mascota() {
        tabla_Mascotas.setEnabled(false);
        btn_Registrar.setEnabled(false);
        btn_Buscar.setEnabled(false);
        btn_Modificar.setEnabled(true);
        btn_Eliminar.setEnabled(true);

        txt_Nombre_Mascota.setText(mascotaSeleccionada.getNombre());

        Persona persona = this.controladorPersona.BuscarPersona(mascotaSeleccionada.getPer_id());
        this.clienteSeleccionado = persona;
        lbl_Duenio_Select.setText("Cliente: " + persona.getNombre() + " " + persona.getApellido());

        Tipo_Mascota tipo_mas = this.controladorTipoMascota.buscarTipoMascota(mascotaSeleccionada.getTipo_id());
        this.tipoMascotaSeleccionada = tipo_mas;
        lbl_Tipo_Select.setText("Tipo: " + tipo_mas.getNombre());
    }

    public void actulizarTabla() {
        listaMascotas = this.controladorMascota.listarMascotas();
        listaActual = listaMascotas;
        DefaultTableModel modelo = (DefaultTableModel) tabla_Mascotas.getModel();

        modelo.setRowCount(0);

        for (Mascota msc : listaMascotas) {
            System.out.println(msc.toString());

            Tipo_Mascota tM = this.controladorTipoMascota.buscarTipoMascota(msc.getTipo_id());
            Persona cli = this.controladorPersona.BuscarPersona(msc.getPer_id());

            Object[] fila = {msc.getId(), msc.getNombre(), tM.getNombre(), cli.getNombre() + " " + cli.getApellido()};
            modelo.addRow(fila);
        }

        tabla_Mascotas.setModel(modelo);

    }

    public void resultadoBusqueda(List<Mascota> mascotas) {
        DefaultTableModel modelo = (DefaultTableModel) tabla_Mascotas.getModel();

        modelo.setRowCount(0);

        for (Mascota msc : mascotas) {
            System.out.println(msc.toString());
            Tipo_Mascota tM = this.controladorTipoMascota.buscarTipoMascota(msc.getTipo_id());
            Persona cli = this.controladorPersona.BuscarPersona(msc.getPer_id());

            Object[] fila = {msc.getId(), msc.getNombre(), tM.getNombre(), cli.getNombre() + " " + cli.getApellido()};
            modelo.addRow(fila);
        }
        listaActual = mascotas;

        tabla_Mascotas.setModel(modelo);
    }

    public void resetear() {
        txt_Nombre_Mascota.setText("");
        clienteSeleccionado = null;
        lbl_Duenio_Select.setText("Ningun Dueño Seleccionado");
        tipoMascotaSeleccionada = null;
        lbl_Tipo_Select.setText("Ningun Tipo de Mascota Seleccionado");
        tabla_Mascotas.setEnabled(true);
        btn_Registrar.setEnabled(true);
        btn_Buscar.setEnabled(true);
        btn_Modificar.setEnabled(false);
        btn_Eliminar.setEnabled(false);
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
        jLabel5 = new javax.swing.JLabel();
        btn_Buscar_Personal = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        btn_Registrar = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        btn_Modificar = new javax.swing.JButton();
        btn_Buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_Mascotas = new javax.swing.JTable();
        txt_Nombre_Mascota = new javax.swing.JTextField();
        lbl_Duenio_Select = new javax.swing.JLabel();
        btn_Buscar_Tipo = new javax.swing.JButton();
        lbl_Tipo_Select = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);

        jPanel2.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(29, 64, 97));
        jLabel5.setText("Nombre De La Mascota*");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, -1, -1));

        btn_Buscar_Personal.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Buscar_Personal.setForeground(new java.awt.Color(29, 64, 97));
        btn_Buscar_Personal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_pet_50px.png"))); // NOI18N
        btn_Buscar_Personal.setText("SELECCIONE AL DUEÑO");
        btn_Buscar_Personal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Buscar_PersonalActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Buscar_Personal, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, -1, -1));

        btn_Eliminar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Eliminar.setForeground(new java.awt.Color(29, 64, 97));
        btn_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_Delete_50px.png"))); // NOI18N
        btn_Eliminar.setText("ELIMINAR");
        btn_Eliminar.setEnabled(false);
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 630, -1, -1));

        btn_Registrar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Registrar.setForeground(new java.awt.Color(29, 64, 97));
        btn_Registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_add_50px_1.png"))); // NOI18N
        btn_Registrar.setText("REGISTRAR");
        btn_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 630, -1, -1));

        btn_Cancelar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Cancelar.setForeground(new java.awt.Color(29, 64, 97));
        btn_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_cancel_50px.png"))); // NOI18N
        btn_Cancelar.setText("CANCELAR");
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 630, -1, -1));

        btn_Modificar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Modificar.setForeground(new java.awt.Color(29, 64, 97));
        btn_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_edit_property_50px.png"))); // NOI18N
        btn_Modificar.setText("MODIFICAR");
        btn_Modificar.setEnabled(false);
        btn_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 630, -1, -1));

        btn_Buscar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Buscar.setForeground(new java.awt.Color(29, 64, 97));
        btn_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_search_50px.png"))); // NOI18N
        btn_Buscar.setText("BUSCAR");
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 630, -1, -1));

        tabla_Mascotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Tipo", "Dueño"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_Mascotas);
        if (tabla_Mascotas.getColumnModel().getColumnCount() > 0) {
            tabla_Mascotas.getColumnModel().getColumn(0).setPreferredWidth(1);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 840, 280));

        txt_Nombre_Mascota.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txt_Nombre_Mascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Nombre_MascotaActionPerformed(evt);
            }
        });
        jPanel2.add(txt_Nombre_Mascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 250, 30));

        lbl_Duenio_Select.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lbl_Duenio_Select.setForeground(new java.awt.Color(29, 64, 97));
        lbl_Duenio_Select.setText("Ningun Dueño Seleccionado");
        jPanel2.add(lbl_Duenio_Select, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, -1, -1));

        btn_Buscar_Tipo.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Buscar_Tipo.setForeground(new java.awt.Color(29, 64, 97));
        btn_Buscar_Tipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_pets_50px_1.png"))); // NOI18N
        btn_Buscar_Tipo.setText("SELECCIONE EL TIPO");
        btn_Buscar_Tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Buscar_TipoActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Buscar_Tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 220, -1));

        lbl_Tipo_Select.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lbl_Tipo_Select.setForeground(new java.awt.Color(29, 64, 97));
        lbl_Tipo_Select.setText("Ningun Tipo de Mascota Seleccionado");
        jPanel2.add(lbl_Tipo_Select, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 280, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/Mascotas.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1280, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_Buscar_PersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Buscar_PersonalActionPerformed
        Seleccionar_Cliente sC = new Seleccionar_Cliente();
        sC.setVent_Mascotas(this);
        sC.setControladorPersona(this.controladorPersona);
        sC.actulizarTabla();
        sC.setVisible(true);
    }//GEN-LAST:event_btn_Buscar_PersonalActionPerformed

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed

        int result = JOptionPane.showOptionDialog(null, "¿Eliminar Mascota= " + mascotaSeleccionada.getNombre() + "?", "Confirmación",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

        if (result == JOptionPane.OK_OPTION) {
            this.controladorMascota.eliminarMascota(mascotaSeleccionada);
        }

        resetear();
        actulizarTabla();
    }//GEN-LAST:event_btn_EliminarActionPerformed

    private void btn_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarActionPerformed
        if (txt_Nombre_Mascota.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ningun campo puede estar vacío");
        } else if (clienteSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Seleccione a un Cliente");
        } else if (tipoMascotaSeleccionada == null) {
            JOptionPane.showMessageDialog(null, "Seleccione un Tipo de Mascota");
        } else {

            this.controladorMascota.registrarMascota(new Mascota(0, clienteSeleccionado.getId(), tipoMascotaSeleccionada.getId(), txt_Nombre_Mascota.getText().trim()));
            resetear();
            actulizarTabla();
        }
    }//GEN-LAST:event_btn_RegistrarActionPerformed

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        resetear();
        actulizarTabla();
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void btn_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModificarActionPerformed
        if (txt_Nombre_Mascota.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ningun campo puede estar vacío");
        } else if (clienteSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Seleccione a un Cliente");
        } else if (tipoMascotaSeleccionada == null) {
            JOptionPane.showMessageDialog(null, "Seleccione un Tipo de Mascota");
        } else {
            Mascota mscUpdate = new Mascota();
            mscUpdate.setId(mascotaSeleccionada.getId());
            mscUpdate.setNombre(txt_Nombre_Mascota.getText().trim());
            mscUpdate.setPer_id(clienteSeleccionado.getId());
            mscUpdate.setTipo_id(tipoMascotaSeleccionada.getId());

            this.controladorMascota.actualizarMascota(mscUpdate);
            actulizarTabla();
            resetear();
        }
    }//GEN-LAST:event_btn_ModificarActionPerformed

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed
        Buscar_Mascota bm = new Buscar_Mascota();
        bm.setVent_Mascotas(this);
        bm.setControladorMascota(this.controladorMascota);
        bm.setVisible(true);
    }//GEN-LAST:event_btn_BuscarActionPerformed

    private void txt_Nombre_MascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Nombre_MascotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Nombre_MascotaActionPerformed

    private void btn_Buscar_TipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Buscar_TipoActionPerformed
        Seleccionar_Tipo_Mascota sT = new Seleccionar_Tipo_Mascota();
        sT.setVent_Mascotas(this);
        sT.setControladorTipoMascota(this.controladorTipoMascota);
        sT.actulizarTabla();
        sT.setVisible(true);
    }//GEN-LAST:event_btn_Buscar_TipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Buscar_Personal;
    private javax.swing.JButton btn_Buscar_Tipo;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Modificar;
    private javax.swing.JButton btn_Registrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Duenio_Select;
    private javax.swing.JLabel lbl_Tipo_Select;
    private javax.swing.JTable tabla_Mascotas;
    private javax.swing.JTextField txt_Nombre_Mascota;
    // End of variables declaration//GEN-END:variables
}
