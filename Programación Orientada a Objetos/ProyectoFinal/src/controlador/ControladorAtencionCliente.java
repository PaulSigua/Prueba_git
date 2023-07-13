/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import modelo.Cita;
import modelo.Cliente;

/**
 *
 * @author LENOVO
 */
public class ControladorAtencionCliente {
    private Queue<Cliente> colaCliente;
    private List<Cita> citas;
    private int id;
    public Random random;
    private ControladorHistorial controladorHistorial;
    
    
    public ControladorAtencionCliente()
    {
        controladorHistorial = new ControladorHistorial();
        colaCliente = new LinkedList();
        citas = new ArrayList<>();
        random= new Random();
        id=0;
    }
    
    
    public void agendarCita(String nombre, String apellido, String cedula, Date fecha)
    {
        if (validarCedula(cedula) == true)
        {
            Cliente cliente = new Cliente(id, nombre, apellido, cedula);
            Cita cita = new Cita(fecha, cliente);
            citas.add(cita);
            id++;
        }        
    }
         
    public List<Cita> getCitas()
    {
        return citas;
    }
   public ControladorHistorial getControladorHisotrial()
   {
       return controladorHistorial;
   }
 
    public void agregarClientes(String nombre, String apellido, String cedula)
    {
        if (validarCedula(cedula) == true)
        {
            Cliente cliente = new Cliente(id, nombre, apellido, cedula);
            colaCliente.offer(cliente);
            id++; 
        }
        
    }
    
    public void atenderCliente()
    {
        if (!colaCliente.isEmpty())
        {
             Cliente cliente = colaCliente.poll();
            int ventanilla = 2;//random.nextInt(3);
            int tiempo = 5 + random.nextInt(5);
            System.out.println("El cliente '" + cliente + "' ingresa atender en la ventanila " + ventanilla);
            System.out.println("El cliente se demora: " + tiempo + " minutos'");
            System.out.println("Termina el cliente: " + cliente);
            controladorHistorial.agregar(ventanilla, tiempo, cliente);
        }
        else
        {
            System.out.println("No hay clientes en cola.");
        }
       
        
    }

    public Queue<Cliente> getColaCliente() {
        return colaCliente;
    }
    
    public void setColaCliente(Queue<Cliente> colaCliente) {
        this.colaCliente = colaCliente;
    }
    
    public boolean validarFecha(String fecha)
    {
        try {
             var fechaString = fecha.split("/");
             int dia = Integer.parseInt(fechaString[0]);
             int mes = Integer.parseInt(fechaString[1]);
             return !(dia <= 0 || dia > 31 || mes <= 0 || mes > 12);
        } catch (Exception e) {
            return false;
        }          
    }
    
    
    public boolean validarCedula(String cedula)
    {
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
}
