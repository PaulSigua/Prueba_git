/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.controlador;

import ec.edu.ups.dao.MascotaDAO;
import ec.edu.ups.idao.IMascotaDAO;
import ec.edu.ups.modelo.Mascota;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author guama
 */
public class ControladorMascota {
    private IMascotaDAO mascotaDAO;
    
    public ControladorMascota() {
        this.mascotaDAO = new MascotaDAO();
    }
    
    public void registrarMascota(Mascota mascota){
        this.mascotaDAO.create(mascota);
    }
    
    public Mascota buscarMascota(int id){
        return this.mascotaDAO.read(id);
    }
    
    public void actualizarMascota(Mascota mascota){
        this.mascotaDAO.update(mascota);
    }
    
    public void eliminarMascota(Mascota mascota){
        this.mascotaDAO.delete(mascota);
    }
    
    public List<Mascota> listarMascotas(){
        return this.mascotaDAO.findAll();
    }
    
     public List<Mascota> buscarMascotaNombre(String nombre){
        List<Mascota> mascotas=this.mascotaDAO.buscarPorNombre(nombre);
        if (!mascotas.isEmpty()) {
            
            return mascotas;
        }else{
            JOptionPane.showMessageDialog(null, "No se encontro Resultados");
        }
        return null;
    }
     
     public List<Mascota> buscarMascotaDuenio(String cedula){
        List<Mascota> mascotas=this.mascotaDAO.buscarPorDuenio(cedula);
        if (!mascotas.isEmpty()) {
            
            return mascotas;
        }else{
            JOptionPane.showMessageDialog(null, "No se encontro Resultados");
        }
        return null;
    }
}
