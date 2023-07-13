/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.dao;

import ec.edu.ups.controlador.Conexion;

import ec.edu.ups.idao.IPersonaDAO;
import ec.edu.ups.modelo.Persona;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author guama
 */
public class PersonaDAO implements IPersonaDAO {

    Connection conexion = null;

    @Override
    public void create(Persona persona) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;

        try {
            pst = conexion.prepareStatement("INSERT INTO duenioVet.personas (per_id, per_cedula , per_nombre, per_apellido, per_direccion, per_telefono, per_correo, per_tipo, per_estado) VALUES (duenioVet.seq_per_id.nextval,?,?,?,?,?,?,?,?)");
            pst.setString(1, persona.getCedula());
            pst.setString(2, persona.getNombre());
            pst.setString(3, persona.getApellido());
            pst.setString(4, persona.getDireccion());
            pst.setString(5, persona.getTelefono());
            pst.setString(6, persona.getCorreo());
            pst.setString(7, "" + persona.getTipo());
            pst.setString(8, "" + persona.getEstado());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "DATOS INGRESADOS CORRECTAMENTE");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public Persona read(int id) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("select * from duenioVet.personas WHERE per_id= ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            Persona per = new Persona();
            if (rs.next()) {
                
                per.setId(rs.getInt("per_id"));
                per.setCedula(rs.getString("per_cedula"));
                per.setNombre(rs.getString("per_nombre"));
                per.setApellido(rs.getString("per_apellido"));
                per.setDireccion(rs.getString("per_direccion"));
                per.setTelefono(rs.getString("per_telefono"));
                per.setCorreo(rs.getString("per_correo"));
                per.setTipo((rs.getString("per_tipo").charAt(0)));
                per.setTipo((rs.getString("per_tipo").charAt(0)));
                per.setEstado((rs.getString("per_estado").charAt(0)));
            }
            return per;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public Boolean update(Persona persona) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;

        try {
            pst = conexion.prepareStatement("UPDATE duenioVet.personas SET per_cedula = ?  , per_nombre= ?, per_apellido= ?, per_direccion= ?,"
                    + " per_telefono= ?, per_correo= ?, per_tipo= ?, per_estado= ? WHERE per_id=?");
            pst.setString(1, persona.getCedula());
            pst.setString(2, persona.getNombre());
            pst.setString(3, persona.getApellido());
            pst.setString(4, persona.getDireccion());
            pst.setString(5, persona.getTelefono());
            pst.setString(6, persona.getCorreo());
            pst.setString(7, "" + persona.getTipo());
            pst.setString(8, "" + persona.getEstado());
            pst.setInt(9, persona.getId());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
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
                    Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public void delete(Persona persona) {

        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("DELETE FROM duenioVet.personas WHERE per_id= ? ");
            pst.setInt(1, persona.getId());
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "CLIENTE: "+persona.getNombre()+" "+persona.getApellido()+" ELIMINADO CORRECTAMENTE");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public List<Persona> buscarClientesPorCedula(String cedula) {
        List<Persona> personas = new ArrayList<>();

        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("select * from duenioVet.personas WHERE per_cedula LIKE '%" + cedula + "%' AND per_tipo='C'  order by per_id  ASC");
            rs = pst.executeQuery();
            while (rs.next()) {
                Persona per = new Persona();
                per.setId(rs.getInt("per_id"));
                per.setCedula(rs.getString("per_cedula"));
                per.setNombre(rs.getString("per_nombre"));
                per.setApellido(rs.getString("per_apellido"));
                per.setDireccion(rs.getString("per_direccion"));
                per.setTelefono(rs.getString("per_telefono"));
                per.setCorreo(rs.getString("per_correo"));
                per.setTipo((rs.getString("per_tipo").charAt(0)));
                per.setTipo((rs.getString("per_tipo").charAt(0)));
                per.setEstado((rs.getString("per_estado").charAt(0)));
                personas.add(per);
            }
            return personas;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public List<Persona> buscarClientesPorNombre(String nombre) {
        List<Persona> personas = new ArrayList<>();

        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("select * from duenioVet.personas WHERE per_nombre LIKE '%" + nombre + "%' AND per_tipo='C'  order by per_id  ASC");
            rs = pst.executeQuery();
            while (rs.next()) {
                Persona per = new Persona();
                per.setId(rs.getInt("per_id"));
                per.setCedula(rs.getString("per_cedula"));
                per.setNombre(rs.getString("per_nombre"));
                per.setApellido(rs.getString("per_apellido"));
                per.setDireccion(rs.getString("per_direccion"));
                per.setTelefono(rs.getString("per_telefono"));
                per.setCorreo(rs.getString("per_correo"));
                per.setTipo((rs.getString("per_tipo").charAt(0)));
                per.setTipo((rs.getString("per_tipo").charAt(0)));
                per.setEstado((rs.getString("per_estado").charAt(0)));
                personas.add(per);
            }
            return personas;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public List<Persona> findAll() {
        List<Persona> personas = new ArrayList<>();

        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("select * from duenioVet.personas order by per_id  ASC");
            rs = pst.executeQuery();
            while (rs.next()) {
                Persona per = new Persona();
                per.setId(rs.getInt("per_id"));
                per.setCedula(rs.getString("per_cedula"));
                per.setNombre(rs.getString("per_nombre"));
                per.setApellido(rs.getString("per_apellido"));
                per.setDireccion(rs.getString("per_direccion"));
                per.setTelefono(rs.getString("per_telefono"));
                per.setCorreo(rs.getString("per_correo"));
                per.setTipo((rs.getString("per_tipo").charAt(0)));
                per.setTipo((rs.getString("per_tipo").charAt(0)));
                per.setEstado((rs.getString("per_estado").charAt(0)));
                personas.add(per);
            }
            return personas;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public List<Persona> findAllClientes() {
        List<Persona> clientes = new ArrayList<>();

        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("select * from duenioVet.personas where per_tipo='C'  order by per_id  ASC");
            rs = pst.executeQuery();
            while (rs.next()) {
                Persona per = new Persona();
                per.setId(rs.getInt("per_id"));
                per.setCedula(rs.getString("per_cedula"));
                per.setNombre(rs.getString("per_nombre"));
                per.setApellido(rs.getString("per_apellido"));
                per.setDireccion(rs.getString("per_direccion"));
                per.setTelefono(rs.getString("per_telefono"));
                per.setCorreo(rs.getString("per_correo"));
                per.setTipo((rs.getString("per_tipo").charAt(0)));
                per.setTipo((rs.getString("per_tipo").charAt(0)));
                per.setEstado((rs.getString("per_estado").charAt(0)));
                clientes.add(per);
            }
            return clientes;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public List<Persona> buscarPersonalPorCedula(String cedula) {
         List<Persona> personas = new ArrayList<>();

        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("select * from duenioVet.personas WHERE per_cedula LIKE '%" + cedula + "%' AND per_tipo!='C'  order by per_id  ASC");
            rs = pst.executeQuery();
            while (rs.next()) {
                Persona per = new Persona();
                per.setId(rs.getInt("per_id"));
                per.setCedula(rs.getString("per_cedula"));
                per.setNombre(rs.getString("per_nombre"));
                per.setApellido(rs.getString("per_apellido"));
                per.setDireccion(rs.getString("per_direccion"));
                per.setTelefono(rs.getString("per_telefono"));
                per.setCorreo(rs.getString("per_correo"));
                per.setTipo((rs.getString("per_tipo").charAt(0)));
                per.setTipo((rs.getString("per_tipo").charAt(0)));
                per.setEstado((rs.getString("per_estado").charAt(0)));
                personas.add(per);
            }
            return personas;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public List<Persona> buscarPersonalPorNombre(String nombre) {
        List<Persona> personas = new ArrayList<>();

        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("select * from duenioVet.personas WHERE per_nombre LIKE '%" + nombre + "%' AND per_tipo!='C'  order by per_id  ASC");
            rs = pst.executeQuery();
            while (rs.next()) {
                Persona per = new Persona();
                per.setId(rs.getInt("per_id"));
                per.setCedula(rs.getString("per_cedula"));
                per.setNombre(rs.getString("per_nombre"));
                per.setApellido(rs.getString("per_apellido"));
                per.setDireccion(rs.getString("per_direccion"));
                per.setTelefono(rs.getString("per_telefono"));
                per.setCorreo(rs.getString("per_correo"));
                per.setTipo((rs.getString("per_tipo").charAt(0)));
                per.setTipo((rs.getString("per_tipo").charAt(0)));
                per.setEstado((rs.getString("per_estado").charAt(0)));
                personas.add(per);
            }
            return personas;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public List<Persona> findAllPersonal() {
        List<Persona> clientes = new ArrayList<>();

        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("select * from duenioVet.personas where per_tipo!='C'  order by per_id  ASC");
            rs = pst.executeQuery();
            while (rs.next()) {
                Persona per = new Persona();
                per.setId(rs.getInt("per_id"));
                per.setCedula(rs.getString("per_cedula"));
                per.setNombre(rs.getString("per_nombre"));
                per.setApellido(rs.getString("per_apellido"));
                per.setDireccion(rs.getString("per_direccion"));
                per.setTelefono(rs.getString("per_telefono"));
                per.setCorreo(rs.getString("per_correo"));
                per.setTipo((rs.getString("per_tipo").charAt(0)));
                per.setTipo((rs.getString("per_tipo").charAt(0)));
                per.setEstado((rs.getString("per_estado").charAt(0)));
                clientes.add(per);
            }
            return clientes;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

}
