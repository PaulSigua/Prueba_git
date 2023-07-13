/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.idao;

import ec.edu.ups.modelo.Mascota;
import java.util.List;

/**
 *
 * @author guama
 */
public interface IMascotaDAO {
     //Métodos CRUD
    public void create(Mascota mascota);
    public Mascota read(int id);
    public void update(Mascota mascota);
    public void delete(Mascota mascota); 
    
    public List<Mascota> buscarPorNombre(String nombre);
    public List<Mascota> buscarPorDuenio(String cedula);
    
    public List<Mascota> findAll();
    
}
