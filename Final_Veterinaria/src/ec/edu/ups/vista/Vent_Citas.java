
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorCita;
import ec.edu.ups.controlador.ControladorMascota;
import ec.edu.ups.controlador.ControladorPersona;
import ec.edu.ups.controlador.ControladorTipoMascota;
import ec.edu.ups.modelo.Cita;
import ec.edu.ups.modelo.Mascota;
import ec.edu.ups.modelo.Persona;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guama
 */
public class Vent_Citas extends javax.swing.JInternalFrame {

    /**
     * Creates new form Vent_Citas
     */
    private ControladorCita controladorCita;
    private ControladorPersona controladorPersona;
    private ControladorMascota controladorMascota;
    private ControladorTipoMascota controladorTipoMascota;
    private List<Cita> listaCitas;
    private List<Cita> listaActual;
    private Cita citaSeleccionada;
    private boolean procesandoEvento = false;
    private Persona personalSeleccionado;
    private Mascota mascotaSeleccionada;

    public Vent_Citas() {
        initComponents();
        LocalTime currentTime = LocalTime.now();
        int hour = currentTime.getHour();
        int minute = currentTime.getMinute();

        choser_fecha.setDate(Calendar.getInstance().getTime());

        tabla_Citas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                // obtener la fila seleccionada
                if (!procesandoEvento) {
                    procesandoEvento = true;
                    int filaSeleccionada = tabla_Citas.getSelectedRow();
                    System.out.println("Fila seleccionada: " + filaSeleccionada);
                    if (filaSeleccionada != -1) {
                        System.out.println("Persona seleccionada: " + listaActual.get(filaSeleccionada).toString());
                        citaSeleccionada = listaActual.get(filaSeleccionada);
                        actEli_Cita();
                    }
                    procesandoEvento = false;
                }
            }
        });

    }

    public void setControladorCita(ControladorCita controladorCita) {
        this.controladorCita = controladorCita;
    }

    public void setControladorPersona(ControladorPersona controladorPersona) {
        this.controladorPersona = controladorPersona;
    }

    public void setControladorMascota(ControladorMascota controladorMascota) {
        this.controladorMascota = controladorMascota;
    }

    public void setControladorTipoMascota(ControladorTipoMascota controladorTipoMascota) {
        this.controladorTipoMascota = controladorTipoMascota;
    }
    
    

    public void setPersonalSeleccionado(Persona personalSeleccionado) {
        this.personalSeleccionado = personalSeleccionado;
        lbl_Veterinario.setText("Veterinario: " + this.personalSeleccionado.getNombre() + " " + this.personalSeleccionado.getApellido());
    }

    public void setMascotaSeleccionada(Mascota mascotaSeleccionada) {
        this.mascotaSeleccionada = mascotaSeleccionada;
        lbl_Mascota.setText("Mascota: " + this.mascotaSeleccionada.getNombre());
    }

    public void actEli_Cita() {
        tabla_Citas.setEnabled(false);
        btn_Registrar.setEnabled(false);
        btn_Buscar_Mascota.setEnabled(false);

        btn_Buscar.setEnabled(false);
        btn_Modificar.setEnabled(true);
        btn_Eliminar.setEnabled(true);
        combo_Estado.setEnabled(false);

        choser_fecha.setDate(citaSeleccionada.getFecha().getTime());
        int hour = citaSeleccionada.getFecha().get(Calendar.HOUR_OF_DAY);
        int minute = citaSeleccionada.getFecha().get(Calendar.MINUTE);
        if (hour == 8 || hour == 9) {
            combo_Hora.setSelectedItem("0" + hour);
        } else {
            combo_Hora.setSelectedItem("" + hour);
        }
        if (minute == 0) {
            combo_Minuto.setSelectedItem("00");
        } else {
            combo_Minuto.setSelectedItem("" + minute);
        }

        if (citaSeleccionada.getEstado() == 'I') {
            combo_Estado.setSelectedItem("Ingresada");
        } else {
            combo_Estado.setSelectedItem("Cancelada");
        }

        Persona persona = this.controladorPersona.BuscarPersona(citaSeleccionada.getPer_id());
        this.personalSeleccionado = persona;
        lbl_Veterinario.setText("Veterinario: " + persona.getNombre() + " " + persona.getApellido());

        Mascota mascota = this.controladorMascota.buscarMascota(citaSeleccionada.getMas_id());
        this.mascotaSeleccionada = mascota;
        lbl_Mascota.setText("Mascota: " + mascota.getNombre());

    }

    public void actulizarTabla() {
        listaCitas = this.controladorCita.listarCitas();
        listaActual = listaCitas;
        DefaultTableModel modelo = (DefaultTableModel) tabla_Citas.getModel();

        modelo.setRowCount(0);

        for (Cita cit : listaActual) {
            System.out.println(cit.toString());
            Date date = cit.getFecha().getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String formattedDate = dateFormat.format(date);
            
            String estado;
            if (cit.getEstado()=='I') {
                estado="Ingresada";
            }else{
                estado="Cancelada";
            }
            Persona vet=this.controladorPersona.BuscarPersona(cit.getPer_id());
            Mascota mas=this.controladorMascota.buscarMascota(cit.getMas_id());
            
            Object[] fila = {cit.getId(), formattedDate, mas.getNombre(), vet.getNombre()+" "+vet.getApellido(), estado};
            modelo.addRow(fila);
        }

        tabla_Citas.setModel(modelo);

    }

    public void resultadoBusqueda(List<Cita> citas) {
        DefaultTableModel modelo = (DefaultTableModel) tabla_Citas.getModel();

        modelo.setRowCount(0);

        for (Cita cit : citas) {
            System.out.println(cit.toString());
            Date date = cit.getFecha().getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String formattedDate = dateFormat.format(date);
            
            String estado;
            if (cit.getEstado()=='I') {
                estado="Ingresada";
            }else{
                estado="Cancelada";
            }
            
            Persona vet=this.controladorPersona.BuscarPersona(cit.getPer_id());
            Mascota mas=this.controladorMascota.buscarMascota(cit.getMas_id());
            
            Object[] fila = {cit.getId(), formattedDate, mas.getNombre(),  vet.getNombre()+" "+vet.getApellido(), estado};
            modelo.addRow(fila);
        }
        listaActual = citas;

        tabla_Citas.setModel(modelo);
    }

    public void resetear() {
        choser_fecha.setDate(Calendar.getInstance().getTime());
        personalSeleccionado = null;
        mascotaSeleccionada = null;
        lbl_Veterinario.setText("Ningun Veterinario Seleccionado");
        lbl_Mascota.setText("Ninguna Mascota Seleccionada");
        tabla_Citas.setEnabled(true);
        btn_Registrar.setEnabled(true);
        btn_Buscar_Personal.setEnabled(true);
        btn_Buscar_Mascota.setEnabled(true);
        btn_Buscar.setEnabled(true);
        btn_Modificar.setEnabled(false);
        btn_Eliminar.setEnabled(false);
        combo_Estado.setEnabled(false);
        combo_Estado.setSelectedItem("Ingresada");
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
        jLabel8 = new javax.swing.JLabel();
        combo_Estado = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btn_Buscar_Personal = new javax.swing.JButton();
        choser_fecha = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_Eliminar = new javax.swing.JButton();
        btn_Registrar = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        btn_Modificar = new javax.swing.JButton();
        btn_Buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_Citas = new javax.swing.JTable();
        btn_Buscar_Mascota = new javax.swing.JButton();
        lbl_Mascota = new javax.swing.JLabel();
        lbl_Veterinario = new javax.swing.JLabel();
        combo_Minuto = new javax.swing.JComboBox<>();
        combo_Hora = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setToolTipText("");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(29, 64, 97));
        jLabel3.setText("H:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, -1, 30));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(29, 64, 97));
        jLabel8.setText("Estado*");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 270, -1, -1));

        combo_Estado.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        combo_Estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingresada", "Cancelada" }));
        combo_Estado.setEnabled(false);
        combo_Estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_EstadoActionPerformed(evt);
            }
        });
        jPanel1.add(combo_Estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 270, 250, 30));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(29, 64, 97));
        jLabel4.setText("Fecha de La Cita*");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, -1, -1));

        btn_Buscar_Personal.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Buscar_Personal.setForeground(new java.awt.Color(29, 64, 97));
        btn_Buscar_Personal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_veterinarian_female_skin_type_2_50px.png"))); // NOI18N
        btn_Buscar_Personal.setText("SELECCIONE AL VETERINARIO");
        btn_Buscar_Personal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Buscar_PersonalActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Buscar_Personal, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, 255, 50));

        choser_fecha.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        choser_fecha.setMaxSelectableDate(new java.util.Date(32503701713000L));
        choser_fecha.setMinSelectableDate(new java.util.Date(1420092113000L));
        jPanel1.add(choser_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 200, 25));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(29, 64, 97));
        jLabel5.setText("Hora de La Cita*");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(29, 64, 97));
        jLabel6.setText("M:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, -1, 30));

        btn_Eliminar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Eliminar.setForeground(new java.awt.Color(29, 64, 97));
        btn_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_Delete_50px.png"))); // NOI18N
        btn_Eliminar.setText("CANCELAR CITA");
        btn_Eliminar.setEnabled(false);
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 630, -1, -1));

        btn_Registrar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Registrar.setForeground(new java.awt.Color(29, 64, 97));
        btn_Registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_add_50px_1.png"))); // NOI18N
        btn_Registrar.setText("AGENDAR");
        btn_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 630, -1, -1));

        btn_Cancelar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Cancelar.setForeground(new java.awt.Color(29, 64, 97));
        btn_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_cancel_50px.png"))); // NOI18N
        btn_Cancelar.setText("CANCELAR");
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 630, -1, -1));

        btn_Modificar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Modificar.setForeground(new java.awt.Color(29, 64, 97));
        btn_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_edit_property_50px.png"))); // NOI18N
        btn_Modificar.setText("REAGENDAR");
        btn_Modificar.setEnabled(false);
        btn_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 630, -1, -1));

        btn_Buscar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Buscar.setForeground(new java.awt.Color(29, 64, 97));
        btn_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_search_50px.png"))); // NOI18N
        btn_Buscar.setText("BUSCAR");
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 630, -1, -1));

        tabla_Citas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Fecha", "Mascota", "Veterinario", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
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
        jScrollPane1.setViewportView(tabla_Citas);
        if (tabla_Citas.getColumnModel().getColumnCount() > 0) {
            tabla_Citas.getColumnModel().getColumn(0).setPreferredWidth(1);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 840, 280));

        btn_Buscar_Mascota.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_Buscar_Mascota.setForeground(new java.awt.Color(29, 64, 97));
        btn_Buscar_Mascota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/icons8_pets_50px_1.png"))); // NOI18N
        btn_Buscar_Mascota.setText("SELECCIONE LA MASCOTA");
        btn_Buscar_Mascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Buscar_MascotaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Buscar_Mascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 190, 255, 50));

        lbl_Mascota.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lbl_Mascota.setForeground(new java.awt.Color(29, 64, 97));
        lbl_Mascota.setText("Ninguna Mascota Seleccionada");
        jPanel1.add(lbl_Mascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 210, -1, -1));

        lbl_Veterinario.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lbl_Veterinario.setForeground(new java.awt.Color(29, 64, 97));
        lbl_Veterinario.setText("Ningun Verterinario Seleccionado");
        jPanel1.add(lbl_Veterinario, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 140, -1, -1));

        combo_Minuto.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        combo_Minuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "15", "30", "45" }));
        combo_Minuto.setPreferredSize(new java.awt.Dimension(70, 30));
        jPanel1.add(combo_Minuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, 70, 30));

        combo_Hora.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        combo_Hora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18" }));
        combo_Hora.setPreferredSize(new java.awt.Dimension(70, 30));
        jPanel1.add(combo_Hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 70, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/Citas.png"))); // NOI18N
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

    private void combo_EstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_EstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_EstadoActionPerformed

    private void btn_Buscar_PersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Buscar_PersonalActionPerformed
        Seleccionar_Personal sP = new Seleccionar_Personal();
        sP.setVent_Citas(this);
        sP.setControladorPersona(this.controladorPersona);
        sP.actulizarTabla();
        sP.setVisible(true);
    }//GEN-LAST:event_btn_Buscar_PersonalActionPerformed

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
        this.controladorCita.cancelarCita(citaSeleccionada);
        resetear();
        actulizarTabla();
    }//GEN-LAST:event_btn_EliminarActionPerformed

    private void btn_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarActionPerformed

        Calendar calendar = Calendar.getInstance();

        calendar.setLenient(false);
        Date fechaSeleccionada = null;


        LocalDate selectedLocalDate =null;
        LocalDate today = null;

        Boolean flag1 = false;
        try {
            calendar.setTime(choser_fecha.getDate());
            fechaSeleccionada = choser_fecha.getDate();
            selectedLocalDate = fechaSeleccionada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            today = LocalDate.now();
            fechaSeleccionada = new Date();
            flag1 = true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingrese una fecha Valida");
        }
        if (flag1) {
            if (personalSeleccionado == null) {
                JOptionPane.showMessageDialog(null, "Seleccione a un Veterinario");
            } else if (mascotaSeleccionada == null) {
                JOptionPane.showMessageDialog(null, "Seleccione a una Mascora");
            } else if (!(selectedLocalDate.isAfter(today) || selectedLocalDate.isEqual(today))) {
                JOptionPane.showMessageDialog(null, "Ingrese una fecha Futura o la de hoy");
            } else {
                Calendar fechaHoraSeleccionada = Calendar.getInstance();
                fechaHoraSeleccionada.setTime(choser_fecha.getDate());

                int hora = Integer.parseInt(combo_Hora.getSelectedItem().toString());

                int minutos = Integer.parseInt(combo_Minuto.getSelectedItem().toString());

                fechaHoraSeleccionada.set(Calendar.HOUR_OF_DAY, hora);
                fechaHoraSeleccionada.set(Calendar.MINUTE, minutos);
                fechaHoraSeleccionada.set(Calendar.SECOND, 0);
                this.controladorCita.agendarCita(new Cita(0, mascotaSeleccionada.getId(), personalSeleccionado.getId(), fechaHoraSeleccionada, 'I'));
                resetear();
                actulizarTabla();
            }
        }


    }//GEN-LAST:event_btn_RegistrarActionPerformed

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        resetear();
        actulizarTabla();
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void btn_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModificarActionPerformed

        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);

        Date fechaSeleccionada = choser_fecha.getDate();
        LocalDate selectedLocalDate =null;
        LocalDate today = null;
        Boolean flag1 = false;

        try {
            calendar.setTime(choser_fecha.getDate());
            fechaSeleccionada = choser_fecha.getDate();
            selectedLocalDate = fechaSeleccionada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            today = LocalDate.now();

            flag1 = true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingrese una fecha Valida");
        }

        if (flag1) {
            if (personalSeleccionado == null) {
                JOptionPane.showMessageDialog(null, "Seleccione a un Veterinario");
            } else if (mascotaSeleccionada == null) {
                JOptionPane.showMessageDialog(null, "Seleccione a una Mascota");
            } else if (!(selectedLocalDate.isAfter(today) || selectedLocalDate.isEqual(today))) {
                JOptionPane.showMessageDialog(null, "Ingrese una fecha Futura o la de hoy");
            } else {
                Calendar fechaHoraSeleccionada = Calendar.getInstance();
                fechaHoraSeleccionada.setTime(choser_fecha.getDate());

                int hora = Integer.parseInt(combo_Hora.getSelectedItem().toString());

                int minutos = Integer.parseInt(combo_Minuto.getSelectedItem().toString());

                fechaHoraSeleccionada.set(Calendar.HOUR_OF_DAY, hora);
                fechaHoraSeleccionada.set(Calendar.MINUTE, minutos);
                fechaHoraSeleccionada.set(Calendar.SECOND, 0);
                this.controladorCita.reagendarCita(citaSeleccionada.getId(), fechaHoraSeleccionada, personalSeleccionado.getId());
                resetear();
                actulizarTabla();
            }
        }

    }//GEN-LAST:event_btn_ModificarActionPerformed

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed
        Buscar_Cita bC = new Buscar_Cita();
        bC.setVent_Citas(this);
        bC.setControladorCita(this.controladorCita);
        bC.setVisible(true);
    }//GEN-LAST:event_btn_BuscarActionPerformed

    private void btn_Buscar_MascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Buscar_MascotaActionPerformed
        Seleccionar_Mascota sM = new Seleccionar_Mascota();
        sM.setVent_Citas(this);
        sM.setControladorMascota(this.controladorMascota);
        sM.setControladorPersona(this.controladorPersona);
        sM.setControladorTipoMascota(this.controladorTipoMascota);
        sM.actulizarTabla();
        sM.setVisible(true);
    }//GEN-LAST:event_btn_Buscar_MascotaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Buscar_Mascota;
    private javax.swing.JButton btn_Buscar_Personal;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Modificar;
    private javax.swing.JButton btn_Registrar;
    private com.toedter.calendar.JDateChooser choser_fecha;
    private javax.swing.JComboBox<String> combo_Estado;
    private javax.swing.JComboBox<String> combo_Hora;
    private javax.swing.JComboBox<String> combo_Minuto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Mascota;
    private javax.swing.JLabel lbl_Veterinario;
    private javax.swing.JTable tabla_Citas;
    // End of variables declaration//GEN-END:variables
}
