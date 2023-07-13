/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.dao;

import ec.edu.ups.controlador.Conexion;
import ec.edu.ups.idao.IServicioDAO;
import ec.edu.ups.modelo.Servicio;
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
public class ServicioDAO implements IServicioDAO {

    Connection conexion = null;

    @Override
    public void create(Servicio servicio) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;

        try {
            pst = conexion.prepareStatement("INSERT INTO servicios (ser_id, ser_nombre_servicio , ser_precio, ser_iva, ser_estado) VALUES (duenioVet.seq_ser_id.nextval,?,?,?,?)");
            pst.setString(1, servicio.getNombre());
            pst.setDouble(2, servicio.getPrecio());
            pst.setString(3, "" + servicio.getIva());
            pst.setString(4, "" + servicio.getEstado());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "DATOS INGRESADOS CORRECTAMENTE");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServicioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServicioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public Servicio read(int id) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("select * from servicios WHERE ser_id= ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            Servicio ser = new Servicio();
            if (rs.next()) {

                ser.setId(rs.getInt("ser_id"));
                ser.setNombre(rs.getString("ser_nombre_servicio"));
                ser.setPrecio(rs.getDouble("ser_precio"));
                ser.setIva(rs.getString("ser_iva").charAt(0));
                ser.setEstado(rs.getString("ser_estado").charAt(0));

            }
            return ser;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServicioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServicioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public void update(Servicio servicio) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;

        try {
            pst = conexion.prepareStatement("UPDATE servicios SET ser_nombre_servicio = ?  , ser_precio= ?, ser_iva= ?, ser_estado= ? WHERE ser_id=?");
            pst.setString(1, servicio.getNombre());
            pst.setDouble(2, servicio.getPrecio());
            pst.setString(3, "" + servicio.getIva());
            pst.setString(4, "" + servicio.getEstado());
            pst.setInt(5, servicio.getId());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServicioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServicioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public void delete(Servicio servicio) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("DELETE FROM servicios WHERE ser_id= ? ");
            pst.setInt(1, servicio.getId());
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Servicio: "+servicio.getNombre()+" ELIMINADO CORRECTAMENTE");

        } catch (Exception e) {
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
                    Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public List<Servicio> buscarPorNombre(String nombre) {
         List<Servicio> servicios = new ArrayList<>();

        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("select * from servicios WHERE ser_nombre_servicio LIKE '%" + nombre + "%' order by ser_id  ASC");
            rs = pst.executeQuery();
            while (rs.next()) {
                Servicio ser = new Servicio();
                ser.setId(rs.getInt("ser_id"));
                ser.setNombre(rs.getString("ser_nombre_servicio"));
                ser.setPrecio(rs.getDouble("ser_precio"));
                ser.setIva(rs.getString("ser_iva").charAt(0));
                ser.setEstado(rs.getString("ser_estado").charAt(0));
                servicios.add(ser);
            }
            return servicios;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServicioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServicioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public List<Servicio> findAll() {
       List<Servicio> servicios = new ArrayList<>();

        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("select * from servicios order by ser_id  ASC");
            rs = pst.executeQuery();
            while (rs.next()) {
                Servicio ser = new Servicio();
                ser.setId(rs.getInt("ser_id"));
                ser.setNombre(rs.getString("ser_nombre_servicio"));
                ser.setPrecio(rs.getDouble("ser_precio"));
                ser.setIva(rs.getString("ser_iva").charAt(0));
                ser.setEstado(rs.getString("ser_estado").charAt(0));
                servicios.add(ser);
            }
            return servicios;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServicioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServicioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

}
