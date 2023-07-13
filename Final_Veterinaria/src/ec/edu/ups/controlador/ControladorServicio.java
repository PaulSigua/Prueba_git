/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.controlador;

import ec.edu.ups.dao.ServicioDAO;
import ec.edu.ups.idao.IServicioDAO;
import ec.edu.ups.modelo.Servicio;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author guama
 */
public class ControladorServicio {
    private IServicioDAO servicioDAO;
    
    public ControladorServicio() {
        this.servicioDAO = new ServicioDAO();
    }
    
    public void registrarServicio(Servicio servicio){   
        this.servicioDAO.create(servicio); 
    }
    
    public Servicio BuscarServicio(int id){   
        Servicio servicio=this.servicioDAO.read(id);
        if (servicio!=null) {
            return servicio;   
        }else{       
            JOptionPane.showMessageDialog(null, "No se encontro Resultados");
            return null; 
        }    
    }
    
    public void actualizarServicio(Servicio servicio){   
        this.servicioDAO.update(servicio);
    }
    
    public void eliminarServicio(Servicio servicio){   
        this.servicioDAO.delete(servicio);
    }
    
    public List<Servicio> listarServicios(){
        return this.servicioDAO.findAll();
    }
    
    public List<Servicio> buscarPorNombre(String nombre){
        List<Servicio> servicios=this.servicioDAO.buscarPorNombre(nombre);
        if (!servicios.isEmpty()) {
            
            return servicios;
        }else{
            JOptionPane.showMessageDialog(null, "No se encontro Resultados");
        }
        return null;
    }
    
    
    
}


