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
public class ConexionFactory 
{
    public IConexion getConexion(String motor)
    {
        if(motor.equalsIgnoreCase("archivo"))
        {
            return new ConexionArchivoImpl();
        }
        else if(motor.equalsIgnoreCase("excel"))
        {
            return new ConexionExcelImpl();
        }
        return new ConexionArchivoImpl();  //crearse una conexion que no existe.
    }
}
