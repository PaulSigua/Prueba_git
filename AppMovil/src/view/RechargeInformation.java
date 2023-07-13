package view;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo
 */
public class RechargeInformation extends javax.swing.JFrame {

    DefaultTableModel table;
    WindowLineONE windowOne;

    /**
     * Creates new form RechargeInformation
     */
    public RechargeInformation() {
        initComponents();
        this.windowOne = new WindowLineONE(this);
        String[] info = new String[]{"Linea Teléfonica", "Nombre", "Cédula", "N. de Teléfono", "Edad"};
        table = new DefaultTableModel();
        table.setColumnIdentifiers(info);
        infoTable.setModel(table);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        infoTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        infoTable.setBorder(new javax.swing.border.MatteBorder(null));
        infoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Linea", "Cliente", "Cédula", "Teléfono", "Edad"
            }
        ));
        jScrollPane1.setViewportView(infoTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable infoTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public JTable getInfoTable() {
        return infoTable;
    }
    

//    public void getTittle() {
//        if (windowOne.getNameTextField().equals("") || windowOne.getIdTextField().equals("") || windowOne.getCellTextField().equals("") || windowOne.getAgeTextField().equals("")) {
//            JOptionPane.showMessageDialog(windowOne, "Debe llenar todos los parametros");
//        } else {
//            String[] info = new String[]{"Linea Teléfonica", "Nombre", "Cédula", "N. de Teléfono", "Edad"};
//            table = new DefaultTableModel();
//            table.setColumnIdentifiers(info);
//            infoTable.setModel(table);
//        }
//
//    }

    public DefaultTableModel getTable() {
        return table;
    }
}
