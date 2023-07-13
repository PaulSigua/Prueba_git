/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorPersona;
import ec.edu.ups.modelo.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guama
 */
public class Seleccionar_Personal extends javax.swing.JFrame {

    /**
     * Creates new form Buscar_Cliente
     */
    private Vent_Usuarios vent_Usuarios;
    private Vent_Citas vent_Citas;
    private ControladorPersona controladorPersona;
    private List<Persona> listaPersonal;
    private List<Persona> listaActual;
    private Persona personaSeleccionada = null;
    private boolean procesandoEvento = false;

    public Seleccionar_Personal() {
        initComponents();
        this.setLocationRelativeTo(null);
        GrupoRadio.add(rad_Cedula);
        GrupoRadio.add(rad_Nombre);
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

                    }
                    procesandoEvento = false;
                }
            }
        });
    }

    public void setVent_Usuarios(Vent_Usuarios vent_Usuarios) {
        this.vent_Usuarios = vent_Usuarios;
        this.vent_Citas = null;

    }

    public void setVent_Citas(Vent_Citas vent_Citas) {
        this.vent_Citas = vent_Citas;
        this.vent_Usuarios = null;
    }

    public void setControladorPersona(ControladorPersona controladorPersona) {
        this.controladorPersona = controladorPersona;
    }

    public void actulizarTabla() {
        listaPersonal = this.controladorPersona.listarPersonal();
        
        List<Persona> listaFiltrada = new ArrayList<>();
        for (Persona lis: listaPersonal) {
            if (lis.getEstado() == 'S') {
                listaFiltrada.add(lis);
            }
        }
        
        if (this.vent_Citas == null) {
            List<Persona> listaEmpleados = new ArrayList<>();
            for (Persona per : listaFiltrada) {
                if (per.getTipo() == 'E') {
                    listaEmpleados.add(per);
                }
            }
            listaActual = listaEmpleados;
        } else {
            List<Persona> listaVeterinarios = new ArrayList<>();
            for (Persona per : listaFiltrada) {
                if (per.getTipo() == 'V') {
                    listaVeterinarios.add(per);
                }
            }
            listaActual = listaVeterinarios;
        }

        DefaultTableModel modelo = (DefaultTableModel) tabla_Personal.getModel();

        modelo.setRowCount(0);

        for (Persona per : listaActual) {
            System.out.println(per.toString());
            String tipo;
            if (per.getTipo()=='V') {
                tipo="Veterinario";
            }else{
                tipo="Empleado";
            }
            Object[] fila = {per.getCedula(), per.getNombre(), per.getApellido(),tipo};
            modelo.addRow(fila);
        }

        tabla_Personal.setModel(modelo);

    }

    public void resultadoBusqueda(List<Persona> personas) {
        
        DefaultTableModel modelo = (DefaultTableModel) tabla_Personal.getModel();

        modelo.setRowCount(0);
        
        
        List<Persona> listaFiltrada = new ArrayList<>();
        for (Persona lis: personas) {
            if (lis.getEstado() == 'S') {
                listaFiltrada.add(lis);
            }
        }
        
        if (this.vent_Citas == null) {
            List<Persona> listaEmpleados = new ArrayList<>();
            for (Persona per : listaFiltrada) {
                if (per.getTipo() == 'E') {
                    listaEmpleados.add(per);
                }
            }
            listaActual = listaEmpleados;
        } else {
            List<Persona> listaVeterinarios = new ArrayList<>();
            for (Persona per : listaFiltrada) {
                if (per.getTipo() == 'V') {
                    listaVeterinarios.add(per);
                }
            }
            listaActual = listaVeterinarios;
        }

        for (Persona per : listaActual) {
            System.out.println(per.toString());
            String tipo;
            if (per.getTipo()=='V') {
                tipo="Veterinario";
            }else{
                tipo="Empleado";
            }
            Object[] fila = {per.getCedula(), per.getNombre(), per.getApellido(),tipo};
            modelo.addRow(fila);
        }

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

        GrupoRadio = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_Cedula = new javax.swing.JTextField();
        rad_Cedula = new javax.swing.JRadioButton();
        rad_Nombre = new javax.swing.JRadioButton();
        btn_Aceptar = new javax.swing.JButton();
        btn_Buscar1 = new javax.swing.JButton();
        btn_Buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_Personal = new javax.swing.JTable();
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

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(29, 64, 97));
        jLabel3.setText("Seleccione una opcion de busqueda e ingrese el valor a buscar:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 360, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(29, 64, 97));
        jLabel2.setText("Buscar por:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));

        txt_Cedula.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txt_Cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CedulaActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 390, 30));

        rad_Cedula.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        rad_Cedula.setText("Cedula");
        jPanel1.add(rad_Cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));

        rad_Nombre.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        rad_Nombre.setText("Nombre");
        jPanel1.add(rad_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, -1, -1));

        btn_Aceptar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Aceptar.setForeground(new java.awt.Color(29, 64, 97));
        btn_Aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_check_all_20px.png"))); // NOI18N
        btn_Aceptar.setText("ACEPTAR");
        btn_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 510, 160, -1));

        btn_Buscar1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Buscar1.setForeground(new java.awt.Color(29, 64, 97));
        btn_Buscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_cancel_20px.png"))); // NOI18N
        btn_Buscar1.setText("CANCELAR");
        btn_Buscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Buscar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Buscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 160, -1));

        btn_Buscar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Buscar.setForeground(new java.awt.Color(29, 64, 97));
        btn_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_search_20px.png"))); // NOI18N
        btn_Buscar.setText("BUSCAR");
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 160, -1));

        tabla_Personal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Cedula", "Nombres", "Apellidos", "Tipo"
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
        jScrollPane1.setViewportView(tabla_Personal);
        if (tabla_Personal.getColumnModel().getColumnCount() > 0) {
            tabla_Personal.getColumnModel().getColumn(0).setResizable(false);
            tabla_Personal.getColumnModel().getColumn(1).setResizable(false);
            tabla_Personal.getColumnModel().getColumn(2).setResizable(false);
            tabla_Personal.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 400, 230));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/SeleccionarPersonal.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 64, 97), 2));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_CedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CedulaActionPerformed

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed
        if (txt_Cedula.getText().trim().equals("")) {

            JOptionPane.showMessageDialog(null, "El campo no puede estar vacio");

        } else {

            if (rad_Cedula.isSelected()) {
                List<Persona> personas = this.controladorPersona.buscarPersonalCedula(txt_Cedula.getText().trim());
                if (personas != null) {
                    this.resultadoBusqueda(personas);

                }
            } else if (rad_Nombre.isSelected()) {
                List<Persona> personas = this.controladorPersona.buscarPersonalNombre(txt_Cedula.getText().trim());
                if (personas != null) {
                    this.resultadoBusqueda(personas);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una opcion para buscar");
            }
        }
    }//GEN-LAST:event_btn_BuscarActionPerformed

    private void btn_Buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Buscar1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_Buscar1ActionPerformed

    private void btn_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AceptarActionPerformed
        if (this.vent_Citas == null) {
            if (personaSeleccionada != null) {
                this.vent_Usuarios.setPersonalSeleccionado(personaSeleccionada);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "SElECCIONE A UN PERSONAL");
            }
        } else {
            if (personaSeleccionada != null) {
                this.vent_Citas.setPersonalSeleccionado(personaSeleccionada);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "SElECCIONE A UN PERSONAL");
            }
        }


    }//GEN-LAST:event_btn_AceptarActionPerformed

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
            java.util.logging.Logger.getLogger(Seleccionar_Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Seleccionar_Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Seleccionar_Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Seleccionar_Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Seleccionar_Personal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoRadio;
    private javax.swing.JButton btn_Aceptar;
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Buscar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rad_Cedula;
    private javax.swing.JRadioButton rad_Nombre;
    private javax.swing.JTable tabla_Personal;
    private javax.swing.JTextField txt_Cedula;
    // End of variables declaration//GEN-END:variables
}
