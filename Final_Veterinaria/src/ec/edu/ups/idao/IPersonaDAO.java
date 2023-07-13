/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.idao;

import ec.edu.ups.modelo.Persona;
import java.util.List;

/**
 *
 * @author guama
 */
public interface IPersonaDAO {
    //Métodos CRUD
    public void create(Persona persona);
    public Persona read(int id);
    public Boolean update(Persona persona);
    public void delete(Persona persona);
    
    public List<Persona> buscarClientesPorCedula(String cedula); 
    public List<Persona> buscarClientesPorNombre(String nombre); 
    
    public List<Persona> buscarPersonalPorCedula(String cedula); 
    public List<Persona> buscarPersonalPorNombre(String nombre); 

    public List<Persona> findAll();
    public List<Persona> findAllClientes();
    public List<Persona> findAllPersonal();
    

}
