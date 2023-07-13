/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import vista.Ventana;

/**
 *
 * @author LENOVO
 */
public class BloqueDaolmpl {

    private Ventana v;
    Statement miStatement;
    Connection con;

    public boolean conectar() {
        try {

            if (con != null && con.isValid(0)) {
                System.out.println("Ya existe una conexión");
            } else {
                con = DriverManager.getConnection("jdbc:mysql://localhost:4000/Registro_bloques", "root", "teosigua2015");
                miStatement = con.createStatement();
                System.out.println("Conexión exitosa");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BloqueDaolmpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean agregarBloque(int codBloque, String nombre, int numDepa) {
        conectar();
        v = new Ventana();
        try {
            PreparedStatement sentencia = con.prepareStatement("insert into Bloque values (?,?,?)");
            sentencia.setInt(1, codBloque);
            sentencia.setString(2, nombre);
            sentencia.setInt(3, numDepa);
            sentencia.executeUpdate();
            return true;
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(v, "Ya existe el codigo " + codBloque);

        } catch (SQLException ex) {
            Logger.getLogger(BloqueDaolmpl.class.getName()).log(Level.SEVERE, null, ex);

        }

        return false;
    }
    
    /*public ArrayList agregarDepartamaentos(){
        ArrayList listaDepas = new ArrayList();
        Departamento depa = null;
        Statement st;
        ResultSet rst;
        try {
            st = con.createStatement();
            rst = st.executeQuery("select * from Departamento registro_bloques order by nombre");
            while(rst.next()){
                depa = new Departamento();
                depa.setNombre(rst.getNString("nombre"));
                listaDepas.add(depa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BloqueDaolmpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaDepas;
    }*/

}
