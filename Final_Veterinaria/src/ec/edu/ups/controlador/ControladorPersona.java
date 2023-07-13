/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.controlador;

import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.idao.IPersonaDAO;
import ec.edu.ups.idao.IUsuarioDAO;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Usuario;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author guama
 */
public class ControladorPersona {
    private IPersonaDAO personaDAO;
    private IUsuarioDAO usuarioDAO;

    public ControladorPersona() {
        this.personaDAO = new PersonaDAO();
        this.usuarioDAO= new UsuarioDAO();
    }
    
    public void registrarPersona(Persona persona){   
        this.personaDAO.create(persona);
        
    }
    
    public Persona BuscarPersona(int id){   
        Persona persona=this.personaDAO.read(id);
        if (persona!=null) {
            
            return persona;
            
        }else{
            
            JOptionPane.showMessageDialog(null, "No se encontro Resultados");
            return null;
            
        }
        
    }
    
    public void actualizarPersona(Persona persona){   
        Boolean flag=this.personaDAO.update(persona);
        if (flag) {
            if (persona.getEstado()=='N' && persona.getTipo()=='E'){
                List<Usuario> users=this.usuarioDAO.buscarIDpersona(persona.getId());
                for (Usuario user : users) {
                    this.usuarioDAO.desactivarUsuario(user);
                }
                
            }
        }
        
    }
    
    public void eliminarPersona(Persona persona){   
        this.personaDAO.delete(persona);
        
    }
    
    public List<Persona> listarClientes(){
        return this.personaDAO.findAllClientes();
    }
    
     public List<Persona> listarPersonal(){
        return this.personaDAO.findAllPersonal();
    }
    
    public List<Persona> buscarClienteCedula(String cedula){
        List<Persona> personas=this.personaDAO.buscarClientesPorCedula(cedula);
        if (!personas.isEmpty()) {
            
            return personas;
        }else{
            JOptionPane.showMessageDialog(null, "No se encontro Resultados");
        }
        return null;
    }
    
    public List<Persona> buscarClienteNombre(String nombre){
        List<Persona> personas=this.personaDAO.buscarClientesPorNombre(nombre);
        if (!personas.isEmpty()) {
            
            return personas;
        }else{
            JOptionPane.showMessageDialog(null, "No se encontro Resultados");
        }
        return null;
    }
    
    public List<Persona> buscarPersonalCedula(String cedula){
        List<Persona> personas=this.personaDAO.buscarPersonalPorCedula(cedula);
        if (!personas.isEmpty()) {
            
            return personas;
        }else{
            JOptionPane.showMessageDialog(null, "No se encontro Resultados");
        }
        return null;
    }
    
    public List<Persona> buscarPersonalNombre(String nombre){
        List<Persona> personas=this.personaDAO.buscarPersonalPorNombre(nombre);
        if (!personas.isEmpty()) {
            
            return personas;
        }else{
            JOptionPane.showMessageDialog(null, "No se encontro Resultados");
        }
        return null;
    }
    
}
