/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.*;

/**
 *
 * @author aplaza
 */
public class EjemplarDaoImpl {

    Statement mistaStatement;
    Connection con;
    DefaultTableModel modelo = new DefaultTableModel(); 
    JTable tabla = new JTable();
    //Scanner entrada = new Scanner(System.in);
    //String parametro;


    public void conectar() {
        try {

            if (con != null && con.isValid(0)) {
                System.out.println("Ya existe una conexión");
            } else {
                con = DriverManager.getConnection("jdbc:mysql://localhost:4000/editorial", "root", "teosigua2015");
                mistaStatement = con.createStatement();
                System.out.println("Conexión exitosa");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EjemplarDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void realizarPrueba() {
        conectar();
        try {
            ResultSet listado = mistaStatement.executeQuery("SELECT * FROM Revista");

            while (listado.next()) {
                System.out.println(listado.getString("periodicidad"));
                /*System.out.print("Ingrese que parametro desea imprimir: ");
                parametro = entrada.next();
                if (parametro.equals("periodicidad")) {
                    System.out.println(listado.getString("periodicidad"));
                } else if (parametro.equals("titulo")) {
                    System.out.println(listado.getString("titulo"));
                } else {
                    System.out.println("Opcion no encontrada ");
                }*/
            }
        } catch (SQLException ex) {
            Logger.getLogger(EjemplarDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet buscarRevista(int codigo) {
        conectar();

        try {
            PreparedStatement sentencia = con.prepareStatement("select * from Revista where id_revista = ?");
            sentencia.setInt(1, codigo);
            ResultSet listado = sentencia.executeQuery();

            //Listar en la consola
            while(listado.next()){
                System.out.println(listado.getString("titulo"));
                System.out.println();
            }
            return listado;
        } catch (SQLException ex) {
            Logger.getLogger(EjemplarDaoImpl.class.getName()).log(Level.SEVERE,null,ex);
        }

        return null;
    }

    public boolean agregarEjemplar(int codEjemplar, String fecha, int numPag, int numVentas, int codRevista) {
        conectar();
        try {
            PreparedStatement sentencia = con.prepareStatement("insert into Ejemplar values (?,?,?,?,?)");
            sentencia.setInt(1, codEjemplar);
            sentencia.setString(2, fecha);
            sentencia.setInt(3, numPag);
            sentencia.setInt(4, numVentas);
            sentencia.setInt(5, codRevista);
            
            sentencia.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EjemplarDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    

}
