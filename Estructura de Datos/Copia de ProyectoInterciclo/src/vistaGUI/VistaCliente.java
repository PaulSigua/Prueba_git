
package vistaGUI;

import controlador.ControladorCliente;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;


public class VistaCliente extends javax.swing.JInternalFrame {
    ControladorCliente controladorCliente;
    Cliente cliente;
    DefaultTableModel modelo;
    int contador=0;
    boolean valorBoolean;
    
    //Constructor
    public VistaCliente(ControladorCliente controladorCliente) {
        initComponents();
        valorBoolean = false;
        this.controladorCliente = controladorCliente;
        modelo=(DefaultTableModel)tablaClientes.getModel();
        tablaClientes.getSelectionModel().addListSelectionListener((ev)->{
                cargarDatosForm(tablaClientes.getSelectedRow());
        });
        cargarDatosTabla();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnAtender = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setText("Registar Clientes");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido", "Estado", "Tiempo de Atencion"
            }
        ));
        jScrollPane1.setViewportView(tablaClientes);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel4.setText("Comprobante de Entrada");

        btnAtender.setText("Atender");
        btnAtender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtenderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(txtNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAtender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(77, 77, 77))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(249, 249, 249))
            .addGroup(layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar))
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAtender)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Metodos
    
    public void comprobanteEntrada () {
        
    }
    
    public void cargarDatosTabla(){
        modelo.setRowCount(0);
        for(Cliente cliente:controladorCliente.getListaCliente()){
            Object fila[] = {cliente.getId(), cliente.getNombre(), cliente.getApellido(), 
                cliente.getEstado(), cliente.getTiempoEspera()};
            modelo.addRow(fila);
        }
        cargarDatosForm(-1);
    }
    
    public void cargarDatosForm(int posicion){
        if(posicion >= 0){//Estra si presiono sobre el cliente en la tabla
            cliente = controladorCliente.getListaCliente().get(posicion);
            txtNombre.setText(cliente.getNombre());
            txtApellido.setText(cliente.getApellido());
            JOptionPane.showMessageDialog(rootPane, "Nombres completos ->"+cliente.getNombre()+" "+cliente.getApellido()
                    , "Comprobante de entrada", JOptionPane.PLAIN_MESSAGE);
        }else {//Entra si posicion es menor a 0
            cliente=null;
            txtNombre.setText("");
            txtApellido.setText("");
            
            
        }
    }
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(cliente == null){
            cliente= new Cliente(controladorCliente.generarId(), txtNombre.getText(), txtApellido.getText(), 
                    controladorCliente.estadoCliente(), controladorCliente.tiempoEspera());
            controladorCliente.crearLista(cliente);
            controladorCliente.crear(cliente);
            valorBoolean=true;
            
        }else {
            cliente.setNombre(txtNombre.getText());
            cliente.setApellido(txtApellido.getText());
        }
        cargarDatosTabla();
        contador++;
        
    }//GEN-LAST:event_btnGuardarActionPerformed


    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int resultado = JOptionPane.showConfirmDialog(this, "Esta seguro de eliminar?");
        if(resultado == 0){
            controladorCliente.eliminar(cliente);
            cargarDatosTabla();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAtenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtenderActionPerformed
        Cliente cliente=controladorCliente.getColaCliente().poll();
        Cliente clienteLista=cliente;
        clienteLista.setEstado("Atendido");
        
    }//GEN-LAST:event_btnAtenderActionPerformed

    
    //Getters y Setters
    
    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public ControladorCliente getControladorCliente() {
        return controladorCliente;
    }

    public void setControladorCliente(ControladorCliente controladorCliente) {
        this.controladorCliente = controladorCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Boolean getValorBoolean() {
        return valorBoolean;
    }

    public void setValorBoolean(Boolean valorBoolean) {
        this.valorBoolean = valorBoolean;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtender;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
