/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prototype;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aplaza
 */
public class RegistroEstImpl implements IEstudiante
{
    private String estudiante;
    private String registro;
    
    @Override
    public IEstudiante clonar() 
    {
        RegistroEstImpl registro=null;
        try 
        {
            //BIEN
            registro=(RegistroEstImpl) clone();
        } 
        catch (CloneNotSupportedException ex) 
        {
            //MAL
            Logger.getLogger(RegistroEstImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registro;
    }

    @Override
   public String toString() {
        return "RegistroEstImpl{" + "estudiante=" + estudiante + ", registro=" + registro + '}';
    }

    public String getEstudiante() {
        return estudiante;
    }

    public String getRegistro() {
        return registro;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }
    
    
    
}
