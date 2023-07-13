/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorPersona;
import ec.edu.ups.controlador.ControladorUsuario;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Usuario;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guama
 */
public class Vent_Usuarios extends javax.swing.JInternalFrame {

    private ControladorUsuario controladorUsuario;
    private ControladorPersona controladorPersona;
    private List<Usuario> listaUsuarios;
    private List<Usuario> listaActual;
    private Usuario usuarioSeleccionado;
    private boolean procesandoEvento = false;
    private Persona personalSeleccionado;

    /**
     * Creates new form Vent_Usuarios
     */
    public Vent_Usuarios() {
        initComponents();

        tabla_Usuarios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                // obtener la fila seleccionada
                if (!procesandoEvento) {
                    procesandoEvento = true;
                    int filaSeleccionada = tabla_Usuarios.getSelectedRow();
                    System.out.println("Fila seleccionada: " + filaSeleccionada);
                    if (filaSeleccionada != -1) {
                        System.out.println("Persona seleccionada: " + listaActual.get(filaSeleccionada).toString());
                        usuarioSeleccionado = listaActual.get(filaSeleccionada);
                        actEli_Usuario();
                    }
                    procesandoEvento = false;
                }
            }
        });
    }

    public void setControladorUsuario(ControladorUsuario controladorUsuario) {
        this.controladorUsuario = controladorUsuario;
    }

    public void setControladorPersona(ControladorPersona controladorPersona) {
        this.controladorPersona = controladorPersona;
    }

    public void setPersonalSeleccionado(Persona personalSeleccionado) {
        this.personalSeleccionado = personalSeleccionado;
        lbl_Persona_select.setText("Personal: " + this.personalSeleccionado.getNombre() + " " + this.personalSeleccionado.getApellido());
    }

    public void actEli_Usuario() {
        tabla_Usuarios.setEnabled(false);
        btn_Registrar.setEnabled(false);
        btn_Buscar.setEnabled(false);
        btn_Buscar_Personal.setEnabled(false);
        txt_Nombre_Usuario.setEnabled(false);
        txt_Password.setEnabled(false);
        txt_Password2.setEnabled(false);
        
        
        combo_Estado.setEnabled(false);
        combo_Encargo.setEnabled(false);
        txt_Nombre_Usuario.setText(usuarioSeleccionado.getNombre_usuario());
        txt_Password.setText(usuarioSeleccionado.getClave());
        txt_Password2.setText(usuarioSeleccionado.getClave());
        Persona persona = this.controladorPersona.BuscarPersona(usuarioSeleccionado.getPer_id());
        
        
        this.personalSeleccionado = persona;
        lbl_Persona_select.setText("Personal: " + persona.getNombre() + " " + persona.getApellido());

        if (usuarioSeleccionado.getEstado() == 'S') {
            combo_Estado.setSelectedItem("Activo");
            btn_Desactivar.setEnabled(true);
            
        } else {
            combo_Estado.setSelectedItem("Inactivo");
            btn_Activar.setEnabled(true);
        }

        if (usuarioSeleccionado.getEncargo() == 'G') {
            combo_Encargo.setSelectedItem("General");
        } else {
            combo_Encargo.setSelectedItem("Administrador");
        }
        

        
        
        
        

    }

    public void actulizarTabla() {
        listaUsuarios = this.controladorUsuario.listarUsuarios();
        listaActual = listaUsuarios;
        DefaultTableModel modelo = (DefaultTableModel) tabla_Usuarios.getModel();

        modelo.setRowCount(0);

        for (Usuario usr : listaUsuarios) {
            System.out.println(usr.toString());

            Persona per = this.controladorPersona.BuscarPersona(usr.getPer_id());
            String estado;
            String encargo;

            if (usr.getEstado() == 'S') {
                estado = "Activo";
            } else {
                estado = "Inactivo";
            }

            if (usr.getEncargo() == 'A') {
                encargo = "Administrador";
            } else {
                encargo = "General";
            }

            Object[] fila = {usr.getId(), usr.getNombre_usuario(), usr.getClave(), encargo, estado, per.getNombre()};
            modelo.addRow(fila);
        }

        tabla_Usuarios.setModel(modelo);

    }

    public void resultadoBusqueda(List<Usuario> usuarios) {
        DefaultTableModel modelo = (DefaultTableModel) tabla_Usuarios.getModel();

        modelo.setRowCount(0);

        for (Usuario usr : usuarios) {
            System.out.println(usr.toString());
            Persona per = this.controladorPersona.BuscarPersona(usr.getPer_id());
            String estado;
            String encargo;

            if (usr.getEstado() == 'S') {
                estado = "Activo";
            } else {
                estado = "Inactivo";
            }

            if (usr.getEncargo()== 'A') {
                encargo = "Administrador";
            } else {
                encargo = "General";
            }

            Object[] fila = {usr.getId(), usr.getNombre_usuario(), usr.getClave(), encargo, estado, per.getNombre()};
            modelo.addRow(fila);
        }
        listaActual = usuarios;

        tabla_Usuarios.setModel(modelo);
    }

    public void resetear() {
        txt_Nombre_Usuario.setText("");
        txt_Password.setText(null);
        txt_Password2.setText(null);
        personalSeleccionado = null;
        lbl_Persona_select.setText("Ningun Personal Seleccionado");
        tabla_Usuarios.setEnabled(true);
        btn_Registrar.setEnabled(true);
        btn_Buscar.setEnabled(true);
        btn_Activar.setEnabled(false);
        btn_Desactivar.setEnabled(false);
        combo_Estado.setEnabled(false);
        combo_Estado.setSelectedItem("Activo");
        btn_Buscar_Personal.setEnabled(true);
        txt_Nombre_Usuario.setEnabled(true);
        txt_Password.setEnabled(true);
        txt_Password2.setEnabled(true);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_Password = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        combo_Estado = new javax.swing.JComboBox<>();
        btn_Buscar_Personal = new javax.swing.JButton();
        btn_Desactivar = new javax.swing.JButton();
        btn_Registrar = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        btn_Activar = new javax.swing.JButton();
        btn_Buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_Usuarios = new javax.swing.JTable();
        combo_Encargo = new javax.swing.JComboBox<>();
        txt_Password2 = new javax.swing.JPasswordField();
        txt_Nombre_Usuario = new javax.swing.JTextField();
        lbl_Persona_select = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(29, 64, 97));
        jLabel3.setText("Nombre Usuario*");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, -1, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(29, 64, 97));
        jLabel4.setText("Contraseña*");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, -1, -1));

        txt_Password.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txt_Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_PasswordActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 210, 250, 30));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(29, 64, 97));
        jLabel8.setText("Estado*");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 250, -1, -1));

        combo_Estado.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        combo_Estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        combo_Estado.setEnabled(false);
        combo_Estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_EstadoActionPerformed(evt);
            }
        });
        jPanel1.add(combo_Estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 280, 250, 30));

        btn_Buscar_Personal.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Buscar_Personal.setForeground(new java.awt.Color(29, 64, 97));
        btn_Buscar_Personal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_contact_50px.png"))); // NOI18N
        btn_Buscar_Personal.setText("SELECCIONE AL PERSONAL");
        btn_Buscar_Personal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Buscar_PersonalActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Buscar_Personal, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, -1, -1));

        btn_Desactivar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Desactivar.setForeground(new java.awt.Color(29, 64, 97));
        btn_Desactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_lock_50px.png"))); // NOI18N
        btn_Desactivar.setText("DESACTIVAR");
        btn_Desactivar.setEnabled(false);
        btn_Desactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DesactivarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Desactivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 630, -1, -1));

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

        btn_Activar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Activar.setForeground(new java.awt.Color(29, 64, 97));
        btn_Activar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_padlock_50px.png"))); // NOI18N
        btn_Activar.setText("ACTIVAR");
        btn_Activar.setEnabled(false);
        btn_Activar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ActivarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Activar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 630, 140, -1));

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

        tabla_Usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Usuario", "Contraseña", "Encargo", "Estado", "Persona"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_Usuarios);
        if (tabla_Usuarios.getColumnModel().getColumnCount() > 0) {
            tabla_Usuarios.getColumnModel().getColumn(0).setPreferredWidth(1);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 840, 280));

        combo_Encargo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        combo_Encargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General", "Administrador" }));
        combo_Encargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_EncargoActionPerformed(evt);
            }
        });
        jPanel1.add(combo_Encargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 250, 30));

        txt_Password2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txt_Password2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Password2ActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Password2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 210, 250, 30));

        txt_Nombre_Usuario.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txt_Nombre_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Nombre_UsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Nombre_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 250, 30));

        lbl_Persona_select.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lbl_Persona_select.setForeground(new java.awt.Color(29, 64, 97));
        lbl_Persona_select.setText("Ningun Personal Seleccionado");
        jPanel1.add(lbl_Persona_select, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 220, -1));

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(29, 64, 97));
        jLabel10.setText("Confirmar Contraseña*");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 180, -1, -1));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(29, 64, 97));
        jLabel9.setText("Encargo*");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/Usuarios.png"))); // NOI18N
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

    private void btn_DesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DesactivarActionPerformed
        if (usuarioSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Seleccione un Usuario");
        } else {
            
            this.controladorUsuario.desactivarUsuario(this.usuarioSeleccionado);
            actulizarTabla();
            resetear();
        }
    }//GEN-LAST:event_btn_DesactivarActionPerformed

    private void btn_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarActionPerformed
        if (txt_Nombre_Usuario.getText().trim().isEmpty() || txt_Password.getPassword().length == 0 || txt_Password2.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Ningun campo puede estar vacío");
        } else if (!Arrays.equals(txt_Password.getPassword(), txt_Password2.getPassword())) {
            JOptionPane.showMessageDialog(null, "La contraseña deben ser iguales");
        } else if (personalSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Seleccione a un Personal");
        } else {
            char encargo;
            if (combo_Encargo.getSelectedIndex() == 0) {
                encargo = 'G';
            } else {
                encargo = 'A';;
            }
            String password = new String(txt_Password.getPassword());
            this.controladorUsuario.registrarUsuario(new Usuario(0, encargo, txt_Nombre_Usuario.getText().trim(), password, 'S', personalSeleccionado.getId()));
            resetear();
            actulizarTabla();
        }

    }//GEN-LAST:event_btn_RegistrarActionPerformed

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        resetear();
        actulizarTabla();
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void btn_ActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ActivarActionPerformed
         if (usuarioSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Seleccione un Usuario");
        } else {
            
            this.controladorUsuario.activarUsuario(this.usuarioSeleccionado);
            actulizarTabla();
            resetear();
        }
         

    }//GEN-LAST:event_btn_ActivarActionPerformed

    private void btn_Buscar_PersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Buscar_PersonalActionPerformed
        Seleccionar_Personal sP = new Seleccionar_Personal();
        sP.setVent_Usuarios(this);
        sP.setControladorPersona(this.controladorPersona);
        sP.actulizarTabla();
        sP.setVisible(true);
    }//GEN-LAST:event_btn_Buscar_PersonalActionPerformed

    private void txt_Nombre_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Nombre_UsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Nombre_UsuarioActionPerformed

    private void txt_PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PasswordActionPerformed

    private void txt_Password2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Password2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Password2ActionPerformed

    private void combo_EncargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_EncargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_EncargoActionPerformed

    private void combo_EstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_EstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_EstadoActionPerformed

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed
        Buscar_Usuario bu = new Buscar_Usuario();
        bu.setVent_Usuarios(this);
        bu.setControladorUsuario(this.controladorUsuario);
        bu.setVisible(true);
    }//GEN-LAST:event_btn_BuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Activar;
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Buscar_Personal;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Desactivar;
    private javax.swing.JButton btn_Registrar;
    private javax.swing.JComboBox<String> combo_Encargo;
    private javax.swing.JComboBox<String> combo_Estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Persona_select;
    private javax.swing.JTable tabla_Usuarios;
    private javax.swing.JTextField txt_Nombre_Usuario;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JPasswordField txt_Password2;
    // End of variables declaration//GEN-END:variables
}
