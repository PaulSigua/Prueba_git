/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.controlador;

import ec.edu.ups.vista.Menu_Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author guama
 */
public class Conexion {
    
    private String[] arreglo;
    
    public Conexion() {
        
    }
    
    public void actulizarConexion(){
        
        arreglo=Menu_Principal.instance.getArreglo();
        separar();
    }
    
    private final String host = "localhost";
    private final int puerto = 1521;
    private final String db = "xe";
    private String usuario ;//= "veterinario";
    private String contrasena;// = "123";

    Connection conexion = null;

    public String getUsuario() {
        return usuario;
    }
    
    private void separar(){
        setUsuario(arreglo[0]);
        setContrasena(arreglo[1]);
    }

    private void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    private void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    

    public Connection getConexion() {
        System.out.println("USUARIOOOOOOO;;; "+usuario);
        System.out.println("CONTRASEÑA;;;;; "+contrasena);
        // Establece la conexión con la base de datos Oracle
        try {
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@" + host + ":" + puerto + ":" + db, usuario, contrasena);
            System.out.println("Conexión establecida con éxito.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return conexion;
    }
    
}
