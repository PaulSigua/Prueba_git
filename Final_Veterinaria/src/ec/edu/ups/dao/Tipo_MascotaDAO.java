/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.dao;

import ec.edu.ups.controlador.Conexion;
import ec.edu.ups.idao.ITipo_MascotaDAO;
import ec.edu.ups.modelo.Tipo_Mascota;
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
public class Tipo_MascotaDAO implements ITipo_MascotaDAO{
    
    Connection conexion = null;
    
    @Override
    public void create(Tipo_Mascota tipo_Mascota) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;

        try {
            pst = conexion.prepareStatement("INSERT INTO tipo_mascotas (tipo_mas_id, tipo_mas_nombre) VALUES (duenioVet.seq_tipo_mas_id.nextval,?)");
            pst.setString(1, tipo_Mascota.getNombre());

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
                    Logger.getLogger(Tipo_MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tipo_MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public Tipo_Mascota read(int id) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("select * from tipo_mascotas WHERE tipo_mas_id= ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            Tipo_Mascota tip = new Tipo_Mascota();
            if (rs.next()) {

                tip.setId(rs.getInt("tipo_mas_id"));
                tip.setNombre(rs.getString("tipo_mas_nombre"));

            }
            return tip;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tipo_MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tipo_MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public void update(Tipo_Mascota tipo_Mascota) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Tipo_Mascota tipo_Mascota) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("DELETE FROM tipo_mascotas WHERE tipo_mas_id= ? ");
            pst.setInt(1, tipo_Mascota.getId());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Tipo Mascota: " + tipo_Mascota.getNombre() + " ELIMINADO CORRECTAMENTE");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tipo_MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tipo_MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public List<Tipo_Mascota> findAll() {
        List<Tipo_Mascota> tipo_Mascotas = new ArrayList<>();

        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("select * from tipo_mascotas order by tipo_mas_id  ASC");
            rs = pst.executeQuery();
            while (rs.next()) {
                Tipo_Mascota tip = new Tipo_Mascota();
                tip.setId(rs.getInt("tipo_mas_id"));
                tip.setNombre(rs.getString("tipo_mas_nombre"));


                tipo_Mascotas.add(tip);
            }
            return tipo_Mascotas;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tipo_MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tipo_MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }
}
    

