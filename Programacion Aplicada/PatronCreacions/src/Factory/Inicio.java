/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;


/**
 *
 * @author aplaza
 */
public class Inicio 
{
    public static void main(String[] args) 
    {
        ConexionFactory factory=new ConexionFactory();
        
        IConexion c1=factory.getConexion("archivo");
        c1.conectar();
        
        IConexion c2=factory.getConexion("excel");
        c2.conectar();
 
    }
}
