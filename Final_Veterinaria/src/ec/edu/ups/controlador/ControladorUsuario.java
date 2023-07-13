/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.controlador;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.idao.IUsuarioDAO;
import ec.edu.ups.modelo.Usuario;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author guama
 */
public class ControladorUsuario {

    private IUsuarioDAO usuarioDAO;
    private Usuario usuarioIngresado;
    
    public ControladorUsuario() {
        this.usuarioDAO = new UsuarioDAO();
    }
    
    public Usuario getUsuarioIngresado() {
        return usuarioIngresado;
    }

    public void setUsuarioIngresado(Usuario usuarioIngresado) {
        this.usuarioIngresado = usuarioIngresado;
    }
    
       
    public void registrarUsuario(Usuario usuario){   
        this.usuarioDAO.create(usuario);
        
    }
    
    public void actualizarUsuario(Usuario usuario){   
        this.usuarioDAO.update(usuario);
        
    }
    
    public void eliminarUsuario(Usuario usuario){   
        this.usuarioDAO.delete(usuario);
        
    }
    
    public List<Usuario> listarUsuarios(){
        return this.usuarioDAO.findAll();
    }

    
    public List<Usuario> buscarUsuarioCedula(String cedula){
        List<Usuario> usuarios=this.usuarioDAO.buscarPorPersona(cedula);
        if (!usuarios.isEmpty()) {
            
            return usuarios;
        }else{
            JOptionPane.showMessageDialog(null, "No se encontro Resultados");
        }
        return null;
    }
    
    public List<Usuario> buscarUsuarioNombre(String nombre){
        List<Usuario> usuarios=this.usuarioDAO.buscarPorUsuario(nombre);
        if (!usuarios.isEmpty()) {
            
            return usuarios;
        }else{
            JOptionPane.showMessageDialog(null, "No se encontro Resultados");
        }
        return null;
    }
    
    
    public Boolean ingresoUsuario(String usuario, char[] contrasenia) {
        String password = new String(contrasenia);
        
        this.usuarioIngresado = usuarioDAO.ingresoUsuario(usuario, password);

        if (this.usuarioIngresado != null) {
            JOptionPane.showMessageDialog(null, "Bienvenido: " + this.usuarioIngresado.getNombre_usuario());
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrecta");
            return false; 
        }
    }
    
    public Boolean cambiarContrasenia(Usuario user,String contraseniaNueva){
        return this.usuarioDAO.cambiarContrasenia(user, contraseniaNueva);
    
    }
    
    public void desactivarUsuario(Usuario user){
        this.usuarioDAO.desactivarUsuario(user);
    }
    
    public void activarUsuario(Usuario user){
        this.usuarioDAO.activarUsuario(user);
    }

    
    
    
}
