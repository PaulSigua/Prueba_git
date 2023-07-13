/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

/**
 *
 * @author aplaza
 */
public class Inicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {      
        Conexion conex1= Conexion.obtenerInstancia("Andrea", "Conexion 1");
        conex1.escribirArchivo();
        Conexion conex2= Conexion.obtenerInstancia("Juan ", "Conexion 2");

        System.out.println (conex1.getUsuario());
        //System.out.println (conex2.getUsuario());
        
        
        /*Conexion conex1= Conexion.obtenerInstancia("Andrea","conex1");
        System.out.println (conex1.getUsuario());
        System.out.println (conex1.leerDocumento());
        
        
        Conexion conex2= Conexion.obtenerInstancia("Juan","conex2");
        System.out.println (conex2.getUsuario());
        System.out.println (conex2.leerDocumento());*/

      
 
    }
    
}
