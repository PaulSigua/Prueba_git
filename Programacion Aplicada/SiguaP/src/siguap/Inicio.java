/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siguap;

import java.io.FileNotFoundException;

/**
 *
 * @author LENOVO
 */
public class Inicio {
    public static void main(String[]args) throws FileNotFoundException{
        Conexion conex1= Conexion.obtenerInstancia("Andrea", "Conexion 1");
        conex1.leerArchivo();
        Conexion conex2= Conexion.obtenerInstancia("Juan ", "Conexion 2");
        conex2.leerArchivo();
    }
}
