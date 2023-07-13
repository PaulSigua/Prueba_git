/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.controlador;

import ec.edu.ups.dao.Tipo_MascotaDAO;
import ec.edu.ups.idao.ITipo_MascotaDAO;
import ec.edu.ups.modelo.Tipo_Mascota;
import java.util.List;

/**
 *
 * @author guama
 */
public class ControladorTipoMascota {
    private ITipo_MascotaDAO tipo_MascotaDAO;
    
    public ControladorTipoMascota() {
        this.tipo_MascotaDAO = new Tipo_MascotaDAO();
    }
    
    public void registrarTipoMascota(Tipo_Mascota tipo_Mascota){
        this.tipo_MascotaDAO.create(tipo_Mascota);
    }
    
    public Tipo_Mascota buscarTipoMascota(int id){
        return this.tipo_MascotaDAO.read(id);
        
    }
    
    public void eliminarTipoMascota(Tipo_Mascota tipo_Mascota){
        this.tipo_MascotaDAO.delete(tipo_Mascota);
    }
    
    public List<Tipo_Mascota> listarTipoMascotas(){
        return this.tipo_MascotaDAO.findAll();
    }
}
