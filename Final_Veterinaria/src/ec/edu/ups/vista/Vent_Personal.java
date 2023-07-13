/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorPersona;
import ec.edu.ups.modelo.Persona;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guama
 */
public class Vent_Personal extends javax.swing.JInternalFrame {

    private ControladorPersona controladorPersona;
    private List<Persona> listaPersonal;
    private List<Persona> listaActual;
    private Persona personaSeleccionada;
    private boolean procesandoEvento = false;

    /**
     * Creates new form Vent_Personal
     */
    public Vent_Personal() {
        initComponents();

        tabla_Personal.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                // obtener la fila seleccionada
                if (!procesandoEvento) {
                    procesandoEvento = true;
                    int filaSeleccionada = tabla_Personal.getSelectedRow();
                    System.out.println("Fila seleccionada: " + filaSeleccionada);
                    if (filaSeleccionada != -1) {
                        System.out.println("Persona seleccionada: " + listaActual.get(filaSeleccionada).toString());
                        personaSeleccionada = listaActual.get(filaSeleccionada);
                        actEli_Persona();
                    }
                    procesandoEvento = false;
                }
            }
        });
    }

    public void actEli_Persona() {
        tabla_Personal.setEnabled(false);
        btn_Registrar.setEnabled(false);
        btn_Buscar.setEnabled(false);
        btn_Modificar.setEnabled(true);
        btn_Eliminar.setEnabled(true);
        combo_Estado.setEnabled(true);
        txt_Cedula.setText(personaSeleccionada.getCedula());
        txt_Apellidos.setText(personaSeleccionada.getApellido());
        txt_Nombres.setText(personaSeleccionada.getNombre());
        txt_Direccion.setText(personaSeleccionada.getDireccion());
        txt_Telefono.setText(personaSeleccionada.getTelefono());
        txt_Correo.setText(personaSeleccionada.getCorreo());
        if (personaSeleccionada.getEstado() == 'S') {
            combo_Estado.setSelectedItem("Activo");
        } else {
            combo_Estado.setSelectedItem("Inactivo");
        }
        if (personaSeleccionada.getTipo() == 'V') {
            combo_Tipo.setSelectedItem("Veterinario");
        } else {
            combo_Tipo.setSelectedItem("Empleado");
        }

    }

    public void setControladorPersona(ControladorPersona controladorPersona) {
        this.controladorPersona = controladorPersona;
    }

    public void actulizarTabla() {
        listaPersonal = this.controladorPersona.listarPersonal();
        listaActual = listaPersonal;
        DefaultTableModel modelo = (DefaultTableModel) tabla_Personal.getModel();

        modelo.setRowCount(0);

        for (Persona per : listaPersonal) {
            System.out.println(per.toString());

            String tipo;
            String estado;

            if (per.getTipo() == 'V') {
                tipo = "Veterinario";
            } else {
                tipo = "Empleado";
            }

            if (per.getEstado() == 'S') {
                estado = "Activo";
            } else {
                estado = "Inactivo";
            }

            Object[] fila = {per.getId(), per.getCedula(), per.getNombre(), per.getApellido(), per.getDireccion(), per.getTelefono(), per.getCorreo(), tipo, estado};
            modelo.addRow(fila);
        }

        tabla_Personal.setModel(modelo);

    }

    public void resultadoBusqueda(List<Persona> personas) {
        DefaultTableModel modelo = (DefaultTableModel) tabla_Personal.getModel();

        modelo.setRowCount(0);

        for (Persona per : personas) {
            System.out.println(per.toString());
            String tipo;
            String estado;

            if (per.getTipo() == 'V') {
                tipo = "Veterinario";
            } else {
                tipo = "Empleado";
            }

            if (per.getEstado() == 'S') {
                estado = "Activo";
            } else {
                estado = "Inactivo";
            }

            Object[] fila = {per.getId(), per.getCedula(), per.getNombre(), per.getApellido(), per.getDireccion(), per.getTelefono(), per.getCorreo(), tipo, estado};
            modelo.addRow(fila);
        }
        listaActual = personas;

        tabla_Personal.setModel(modelo);
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
        jLabel2 = new javax.swing.JLabel();
        txt_Cedula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_Nombres = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_Apellidos = new javax.swing.JTextField();
        txt_Direccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_Correo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_Telefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        combo_Tipo = new javax.swing.JComboBox<>();
        btn_Buscar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        btn_Registrar = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        btn_Modificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_Personal = new javax.swing.JTable();
        combo_Estado = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(29, 64, 97));
        jLabel2.setText("Cedula*");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, -1, -1));

        txt_Cedula.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txt_Cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CedulaActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 250, 30));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(29, 64, 97));
        jLabel3.setText("Nombres*");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, -1, -1));

        txt_Nombres.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txt_Nombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NombresActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, 250, 30));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(29, 64, 97));
        jLabel4.setText("Apellidos*");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 110, -1, -1));

        txt_Apellidos.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txt_Apellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ApellidosActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 140, 250, 30));

        txt_Direccion.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txt_Direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DireccionActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 250, 30));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(29, 64, 97));
        jLabel5.setText("Dirección*");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, -1, -1));

        txt_Correo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txt_Correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CorreoActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 210, 250, 30));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(29, 64, 97));
        jLabel6.setText("Correo*");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, -1, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(29, 64, 97));
        jLabel7.setText("Telefono*");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 180, -1, -1));

        txt_Telefono.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txt_Telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 210, 250, 30));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(29, 64, 97));
        jLabel8.setText("Estado*");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 250, -1, -1));

        combo_Tipo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        combo_Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Veterinario", "Empleado" }));
        jPanel1.add(combo_Tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 250, 30));

        btn_Buscar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Buscar.setForeground(new java.awt.Color(29, 64, 97));
        btn_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_search_50px.png"))); // NOI18N
        btn_Buscar.setText("BUSCAR");
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 630, -1, -1));

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
        jPanel1.add(btn_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 630, -1, -1));

        btn_Registrar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Registrar.setForeground(new java.awt.Color(29, 64, 97));
        btn_Registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_add_50px_1.png"))); // NOI18N
        btn_Registrar.setText("REGISTRAR");
        btn_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 630, -1, -1));

        btn_Cancelar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Cancelar.setForeground(new java.awt.Color(29, 64, 97));
        btn_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_cancel_50px.png"))); // NOI18N
        btn_Cancelar.setText("CANCELAR");
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 630, -1, -1));

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
        jPanel1.add(btn_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 630, -1, -1));

        tabla_Personal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Cedula", "Nombres", "Apellidos", "Direccion", "Telefono", "Correo", "Tipo", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_Personal);
        if (tabla_Personal.getColumnModel().getColumnCount() > 0) {
            tabla_Personal.getColumnModel().getColumn(0).setPreferredWidth(1);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 840, 280));

        combo_Estado.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        combo_Estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        combo_Estado.setEnabled(false);
        jPanel1.add(combo_Estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 280, 250, 30));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(29, 64, 97));
        jLabel9.setText("Tipo*");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/Personal.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1280, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_CedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CedulaActionPerformed

    private void txt_NombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NombresActionPerformed

    private void txt_ApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ApellidosActionPerformed

    private void txt_DireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DireccionActionPerformed

    private void txt_CorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CorreoActionPerformed

    private void txt_TelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TelefonoActionPerformed

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed
        Buscar_Personal bp = new Buscar_Personal();
        bp.setVent_Personal(this);
        bp.setControladorPersona(this.controladorPersona);
        bp.setVisible(true);
    }//GEN-LAST:event_btn_BuscarActionPerformed

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
        this.controladorPersona.eliminarPersona(personaSeleccionada);
        resetear();
        actulizarTabla();
    }//GEN-LAST:event_btn_EliminarActionPerformed

    private void btn_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarActionPerformed
        if (txt_Cedula.getText().trim().isEmpty() || txt_Apellidos.getText().trim().isEmpty() || txt_Nombres.getText().trim().isEmpty()
                || txt_Direccion.getText().trim().isEmpty() || txt_Correo.getText().trim().isEmpty() || txt_Telefono.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ningun campo puede estar vacío");
        } else {
            char tipo;
            if (combo_Tipo.getSelectedIndex() == 0) {
                tipo = 'V';
            } else {
                tipo = 'E';;
            }
            this.controladorPersona.registrarPersona(new Persona(0, txt_Cedula.getText().trim(), txt_Nombres.getText().trim(), txt_Apellidos.getText().trim(),
                    txt_Direccion.getText().trim(), txt_Telefono.getText().trim(), txt_Correo.getText().trim(), tipo, 'S'));
        }
        resetear();
        actulizarTabla();
    }//GEN-LAST:event_btn_RegistrarActionPerformed

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        resetear();
        actulizarTabla();
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void btn_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModificarActionPerformed
        if (txt_Cedula.getText().trim().isEmpty() || txt_Apellidos.getText().trim().isEmpty() || txt_Nombres.getText().trim().isEmpty()
                || txt_Direccion.getText().trim().isEmpty() || txt_Correo.getText().trim().isEmpty() || txt_Telefono.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ningun campo puede estar vacío");
        } else {
            Persona perUpdate = new Persona();
            perUpdate.setId(personaSeleccionada.getId());
            perUpdate.setCedula(txt_Cedula.getText().trim());
            perUpdate.setNombre(txt_Nombres.getText().trim());
            perUpdate.setApellido(txt_Apellidos.getText().trim());
            perUpdate.setDireccion(txt_Direccion.getText().trim());
            perUpdate.setTelefono(txt_Telefono.getText().trim());
            perUpdate.setCorreo(txt_Correo.getText().trim());
            if (combo_Tipo.getSelectedIndex() == 0) {
                perUpdate.setTipo('V');
            } else {
                perUpdate.setTipo('E');
            }
            if (combo_Estado.getSelectedIndex() == 0) {
                perUpdate.setEstado('S');
            } else {
                perUpdate.setEstado('N');
            }
            this.controladorPersona.actualizarPersona(perUpdate);
        }
        actulizarTabla();
        resetear();
    }//GEN-LAST:event_btn_ModificarActionPerformed

    public void resetear() {
        txt_Cedula.setText("");
        txt_Apellidos.setText("");
        txt_Nombres.setText("");
        txt_Direccion.setText("");
        txt_Telefono.setText("");
        txt_Correo.setText("");
        tabla_Personal.setEnabled(true);
        btn_Registrar.setEnabled(true);
        btn_Buscar.setEnabled(true);
        btn_Modificar.setEnabled(false);
        btn_Eliminar.setEnabled(false);
        combo_Estado.setEnabled(false);
        combo_Estado.setSelectedItem("Activo");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Modificar;
    private javax.swing.JButton btn_Registrar;
    private javax.swing.JComboBox<String> combo_Estado;
    private javax.swing.JComboBox<String> combo_Tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_Personal;
    private javax.swing.JTextField txt_Apellidos;
    private javax.swing.JTextField txt_Cedula;
    private javax.swing.JTextField txt_Correo;
    private javax.swing.JTextField txt_Direccion;
    private javax.swing.JTextField txt_Nombres;
    private javax.swing.JTextField txt_Telefono;
    // End of variables declaration//GEN-END:variables
}
