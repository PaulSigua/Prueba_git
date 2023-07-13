/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.DefaultListaClientes;
import modelo.DefaultTablaCliente;
import vista.VistaOrdenes;

/**
 *
 * @author LENOVO
 */
public class ControladorCliente {
    DefaultListaClientes listaClientes;
    VistaOrdenes v;

    public ControladorCliente(DefaultListaClientes listaClientes, VistaOrdenes v) {
        this.listaClientes = listaClientes;
        this.v = v;
        
        ListenerContinuarOrden lco = new ListenerContinuarOrden(listaClientes, v);
        v.setModeloCliente(listaClientes);
        
        DefaultTablaCliente dtc = new DefaultTablaCliente(listaClientes);
        v.setModeloTabla(dtc);
        
        
    }
    
    /*
    public boolean validarCedula(String cedula){
        boolean result = true;
        try {
            if(cedula.length() != 10)
        {
            System.out.println("Cedula invalida");
            return false;
        }
        else
        {
            
            if (Integer.parseInt(cedula.substring(0,2)) < 1 || Integer.parseInt(cedula.substring(0,2)) > 24)
            {
                result=false;
            }
            else if (Integer.parseInt(String.valueOf(cedula.charAt(2))) > 5)
            {
                result = false;
            }
            int val = 2;
            int resultMod = 0;
            int counter = 0;
            for (String i : cedula.split(""))
            {
                if (counter == 9) break;counter++;
                int inti = Integer.parseInt(i);
                if (inti*val < 10)
                {
                    resultMod +=inti*val;                    
                }
                else
                {
                    resultMod +=(inti*val)-9;
                }              
                if (val==1)
                {
                    val=2;
                }
                else{
                    val=1;
                }            
            }
             resultMod = 10 - resultMod % 10;
               
             if (resultMod > 9)
             {
                 resultMod = Integer.parseInt(String.valueOf(resultMod).substring(1));
             }            
             if (resultMod != Integer.parseInt(cedula.substring(9)))
             {
                 result = false;
             }             
        }
        } catch (Exception e) {
            result =false;
        }
          
        if (result == false)
        {
            System.out.println("Cedula invalida");
        }
        return result;
    }   
    */
}
