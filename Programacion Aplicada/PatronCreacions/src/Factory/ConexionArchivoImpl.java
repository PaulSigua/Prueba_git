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
public class ConexionArchivoImpl implements IConexion
{
    @Override
    public void conectar() 
    {
        System.out.println ("conexion archivo");
    }

    @Override
    public void desconectar() 
    {
        
    }
}
