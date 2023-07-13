/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.dao;

import ec.edu.ups.controlador.Conexion;

import ec.edu.ups.idao.IUsuarioDAO;
import ec.edu.ups.modelo.Usuario;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author guama
 */
public class UsuarioDAO implements IUsuarioDAO {

    Connection conexion = null;

    @Override
    public void create(Usuario usuario) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;

        try {
            
            
             if (usuario.getEncargo() == 'A') {
                PreparedStatement pst1 = conexion.prepareStatement("alter session set \"_oracle_script\"=true");
                pst1.execute();
                PreparedStatement pst2 = conexion.prepareStatement("CREATE USER " + usuario.getNombre_usuario()
                        + " IDENTIFIED BY \"" + usuario.getClave() + "\""
                        + " Default TABLESPACE PROYECTO"
                        + " TEMPORARY TABLESPACE PROYECT"
                        + " QUOTA UNLIMITED ON PROYECTO"
                        + " PROFILE perfil_administrador"
                        + " ACCOUNT UNLOCK");
                pst2.execute();

                PreparedStatement pst3 = conexion.prepareStatement("GRANT rol_administrador TO " + usuario.getNombre_usuario());
                pst3.execute();
            } else {
                PreparedStatement pst1 = conexion.prepareStatement("alter session set \"_oracle_script\"=true");
                pst1.execute();
                PreparedStatement pst2 = conexion.prepareStatement("CREATE USER " + usuario.getNombre_usuario()
                        + " IDENTIFIED BY \"" + usuario.getClave() + "\""
                        + " Default TABLESPACE PROYECTO"
                        + " TEMPORARY TABLESPACE PROYECT"
                        + " QUOTA UNLIMITED ON PROYECTO"
                        + " PROFILE perfil_general"
                        + " ACCOUNT UNLOCK");
                pst2.execute();

                PreparedStatement pst3 = conexion.prepareStatement("GRANT rol_general TO " + usuario.getNombre_usuario());
                pst3.execute();
                
            }
            

            pst = conexion.prepareStatement("INSERT INTO duenioVet.usuarios(usu_id, usu_encargo , usu_nombre_usuario, usu_clave,usu_estado, per_id)"
                    + " VALUES (duenioVet.seq_per_id.nextval,?,?,?,?,?)");
            pst.setString(1, "" + usuario.getEncargo());
            pst.setString(2, usuario.getNombre_usuario());
            pst.setString(3, usuario.getClave());
            pst.setString(4, "" + usuario.getEstado());
            pst.setInt(5, usuario.getPer_id());
            pst.executeUpdate();
           

            JOptionPane.showMessageDialog(null, "DATOS INGRESADOS CORRECTAMENTE");

        } catch (HeadlessException | SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {


            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public Usuario read(int id) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("select * from duenioVet.usuarios WHERE usu_id= ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            Usuario usr = new Usuario();
            if (rs.next()) {

                usr.setId(rs.getInt("usu_id"));
                usr.setEncargo((rs.getString("usu_encargo").charAt(0)));
                usr.setNombre_usuario(rs.getString("usu_nombre_usuario"));
                usr.setClave(rs.getString("usu_clave"));
                usr.setEstado((rs.getString("usu_estado").charAt(0)));
                usr.setPer_id(rs.getInt("per_id"));
            }
            return usr;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public void update(Usuario usuario) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;

        try {
            pst = conexion.prepareStatement("UPDATE duenioVet.usuarios SET usu_encargo = ?  , usu_nombre_usuario= ?, usu_clave= ?, usu_estado= ?,"
                    + " per_id= ? WHERE usu_id=?");
            pst.setString(1, "" + usuario.getEncargo());
            pst.setString(2, usuario.getNombre_usuario());
            pst.setString(3, usuario.getClave());
            pst.setString(4, "" + usuario.getEstado());
            pst.setInt(5, usuario.getPer_id());
            pst.setInt(6, usuario.getId());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public void delete(Usuario usuario) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("DELETE FROM duenioVet.usuarios WHERE usu_id= ? ");
            pst.setInt(1, usuario.getId());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuario: " + usuario.getNombre_usuario() + " ELIMINADO CORRECTAMENTE");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public List<Usuario> buscarPorPersona(String cedula) {
        List<Usuario> usuarios = new ArrayList<>();

        Conexion con = new Conexion();
        con.actulizarConexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("select * from duenioVet.usuarios JOIN duenioVet.personas ON duenioVet.usuarios.per_id = duenioVet.personas.per_id WHERE duenioVet.personas.per_cedula LIKE '%" + cedula + "%' order by usu_id  ASC");
            rs = pst.executeQuery();
            while (rs.next()) {
                Usuario usr = new Usuario();
                usr.setId(rs.getInt("usu_id"));
                usr.setEncargo((rs.getString("usu_encargo").charAt(0)));
                usr.setNombre_usuario(rs.getString("usu_nombre_usuario"));
                usr.setClave(rs.getString("usu_clave"));
                usr.setEstado((rs.getString("usu_estado").charAt(0)));
                usr.setPer_id(rs.getInt("per_id"));
                usuarios.add(usr);
            }
            return usuarios;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public List<Usuario> buscarPorUsuario(String nombre_usuario) {
        List<Usuario> usuarios = new ArrayList<>();

        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("select * from duenioVet.usuarios WHERE usu_nombre_usuario LIKE '%" + nombre_usuario + "%' order by usu_id  ASC");
            rs = pst.executeQuery();
            while (rs.next()) {
                Usuario usr = new Usuario();
                usr.setId(rs.getInt("usu_id"));
                usr.setEncargo((rs.getString("usu_encargo").charAt(0)));
                usr.setNombre_usuario(rs.getString("usu_nombre_usuario"));
                usr.setClave(rs.getString("usu_clave"));
                usr.setEstado((rs.getString("usu_estado").charAt(0)));
                usr.setPer_id(rs.getInt("per_id"));
                usuarios.add(usr);
            }
            return usuarios;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> usuarios = new ArrayList<>();

        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("select * from duenioVet.usuarios order by usu_id  ASC");
            rs = pst.executeQuery();
            while (rs.next()) {
                Usuario usr = new Usuario();
                usr.setId(rs.getInt("usu_id"));
                usr.setEncargo((rs.getString("usu_encargo").charAt(0)));
                usr.setNombre_usuario(rs.getString("usu_nombre_usuario"));
                usr.setClave(rs.getString("usu_clave"));
                usr.setEstado((rs.getString("usu_estado").charAt(0)));
                usr.setPer_id(rs.getInt("per_id"));
                usuarios.add(usr);
            }
            return usuarios;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public Usuario ingresoUsuario(String usuario, String contrasenia) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        int usu_id = 0;
        String usu_encargo = "";
        String usu_nombre_usuario = null;
        String usu_clave = null;
        String usu_estado = "";
        int per_id = 0;

        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            // Ejecutar la consulta
            pst = conexion.prepareStatement("select * from duenioVet.usuarios WHERE usu_nombre_usuario = ?");
            pst.setString(1, usuario);
            rs = pst.executeQuery();

            // Solo se obtiene el primer registro (Si existe)
            if (rs.next()) {
                usu_id = rs.getInt(1);
                usu_encargo = rs.getString(2);
                usu_nombre_usuario = rs.getString(3);
                usu_clave = rs.getString(4);
                usu_estado = rs.getString(5);
                per_id = rs.getInt(6);
                System.out.println("Usuario: " + usu_nombre_usuario);
                System.out.println("cont: " + usu_clave);
            }

            // Si se ha obtenido un usuario y password y ademas esta es coincidente
            //System.out.println("txt==== "+txt_Contrasena.getPassword());
            if (usu_nombre_usuario.equals(usuario) && usu_clave.equals(contrasenia)) {
                return new Usuario(usu_id, usu_encargo.charAt(0), usu_nombre_usuario, usu_clave, usu_estado.charAt(0), per_id);
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources
            if (rs != null) {

                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        return null;
    }

    @Override
    public Boolean cambiarContrasenia(Usuario user, String contraseniaNueva) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;

        try {
            
            PreparedStatement pst1 = conexion.prepareStatement("alter session set \"_oracle_script\"=true");
            pst1.execute();
            PreparedStatement pst2 = conexion.prepareStatement("ALTER USER " + user.getNombre_usuario() + " IDENTIFIED BY \"" + contraseniaNueva + "\"");
            pst2.execute();
            
            pst = conexion.prepareStatement("UPDATE duenioVet.usuarios SET usu_clave= ? WHERE usu_nombre_usuario=?");
            pst.setString(1, contraseniaNueva);
            pst.setString(2, user.getNombre_usuario());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "CONTRASEÑA CAMBIADA ");
            return true;

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public void desactivarUsuario(Usuario user) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;

        try {
            pst = conexion.prepareStatement("UPDATE duenioVet.usuarios SET usu_estado= 'N' WHERE usu_id=?");
            pst.setInt(1, user.getId());
            pst.executeUpdate();
            PreparedStatement pst1 = conexion.prepareStatement("alter session set \"_oracle_script\"=true");
            pst1.execute();
            PreparedStatement pst2 = conexion.prepareStatement("ALTER USER " + user.getNombre_usuario() + " ACCOUNT LOCK");
            pst2.execute();

            JOptionPane.showMessageDialog(null, "USUARIO DESACTIVADO");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public void activarUsuario(Usuario user) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;

        try {
            pst = conexion.prepareStatement("UPDATE duenioVet.usuarios SET usu_estado= 'S' WHERE usu_id=?");
            pst.setInt(1, user.getId());
            pst.executeUpdate();
            PreparedStatement pst1 = conexion.prepareStatement("alter session set \"_oracle_script\"=true");
            pst1.execute();
            PreparedStatement pst2 = conexion.prepareStatement("ALTER USER " + user.getNombre_usuario() + " ACCOUNT UNLOCK");
            pst2.execute();

            JOptionPane.showMessageDialog(null, "USUARIO ACTIVADO");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public List<Usuario> buscarIDpersona(int id) {
        List<Usuario> usuarios = new ArrayList<>();

        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("select * from duenioVet.usuarios WHERE per_id=? order by usu_id  ASC");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                Usuario usr = new Usuario();
                usr.setId(rs.getInt("usu_id"));
                usr.setEncargo((rs.getString("usu_encargo").charAt(0)));
                usr.setNombre_usuario(rs.getString("usu_nombre_usuario"));
                usr.setClave(rs.getString("usu_clave"));
                usr.setEstado((rs.getString("usu_estado").charAt(0)));
                usr.setPer_id(rs.getInt("per_id"));
                usuarios.add(usr);
            }
            return usuarios;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

}
