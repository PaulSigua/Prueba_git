/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.idao;

import ec.edu.ups.modelo.Usuario;
import java.util.List;

/**
 *
 * @author guama
 */
public interface IUsuarioDAO {
    

//Métodos CRUD
    public void create(Usuario usuario);
    public Usuario read(int id);
    public void update(Usuario usuario);
    public void delete(Usuario usuario);  
    
    public List<Usuario> buscarPorPersona(String cedula);
    public List<Usuario> buscarPorUsuario(String nombre_usuario);
    
    public List<Usuario> findAll();
    
   public Usuario ingresoUsuario(String usuario, String contrasenia);
   
   public Boolean cambiarContrasenia(Usuario user,String contraseniaNueva);
   
   public void desactivarUsuario(Usuario user);
   
   public void activarUsuario(Usuario user);
   
   public List<Usuario> buscarIDpersona(int id);
    
}
