/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.idao;

import ec.edu.ups.modelo.Servicio;
import java.util.List;

/**
 *
 * @author guama
 */
public interface IServicioDAO {
    
    public void create(Servicio servicio);
    public Servicio read(int id);
    public void update(Servicio servicio);
    public void delete(Servicio servicio);
    
    public List<Servicio> buscarPorNombre(String nombre);

    public List<Servicio> findAll();
}
