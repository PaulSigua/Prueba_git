/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.dao;

import ec.edu.ups.controlador.Conexion;
import ec.edu.ups.idao.IMascotaDAO;
import ec.edu.ups.modelo.Mascota;
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
public class MascotaDAO implements IMascotaDAO {

    Connection conexion = null;

    @Override
    public void create(Mascota mascota) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;

        try {
            pst = conexion.prepareStatement("INSERT INTO duenioVet.mascotas(mas_id, mas_nombre , per_id, tipo_mas_id) VALUES (duenioVet.seq_mas_id.nextval,?,?,?)");
            pst.setString(1, mascota.getNombre());
            pst.setInt(2, mascota.getPer_id());
            pst.setInt(3, mascota.getTipo_id());
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
                    Logger.getLogger(MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public Mascota read(int id) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("select * from duenioVet.mascotas WHERE mas_id= ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            Mascota msc = new Mascota();
            if (rs.next()) {

                msc.setId(rs.getInt("mas_id"));
                msc.setNombre(rs.getString("mas_nombre"));
                msc.setPer_id(rs.getInt("per_id"));
                msc.setTipo_id(rs.getInt("tipo_mas_id"));

            }
            return msc;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public void update(Mascota mascota) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;

        try {
            pst = conexion.prepareStatement("UPDATE duenioVet.mascotas SET mas_nombre = ?  , per_id= ?, tipo_mas_id= ? WHERE mas_id=?");
            pst.setString(1, mascota.getNombre());
            pst.setInt(2, mascota.getPer_id());
            pst.setInt(3, mascota.getTipo_id());
            pst.setInt(4, mascota.getId());

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
                    Logger.getLogger(MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public void delete(Mascota mascota) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("DELETE FROM duenioVet.mascotas WHERE mas_id= ? ");
            pst.setInt(1, mascota.getId());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Mascota: " + mascota.getNombre() + " ELIMINADO CORRECTAMENTE");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public List<Mascota> buscarPorNombre(String nombre) {
        List<Mascota> mascotas = new ArrayList<>();

        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("select * from duenioVet.mascotas WHERE mas_nombre LIKE '%" + nombre + "%' order by mas_id  ASC");
            rs = pst.executeQuery();
            while (rs.next()) {
                Mascota msc = new Mascota();
                msc.setId(rs.getInt("mas_id"));
                msc.setNombre(rs.getString("mas_nombre"));
                msc.setPer_id(rs.getInt("per_id"));
                msc.setTipo_id(rs.getInt("tipo_mas_id"));

                mascotas.add(msc);
            }
            return mascotas;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public List<Mascota> buscarPorDuenio(String cedula) {
        List<Mascota> mascotas = new ArrayList<>();

        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("select * from duenioVet.mascotas JOIN duenioVet.personas ON duenioVet.mascotas.per_id = duenioVet.personas.per_id WHERE duenioVet.personas.per_cedula LIKE '%" + cedula + "%' order by mas_id  ASC");
            rs = pst.executeQuery();
            while (rs.next()) {
                Mascota msc = new Mascota();
                msc.setId(rs.getInt("mas_id"));
                msc.setNombre(rs.getString("mas_nombre"));
                msc.setPer_id(rs.getInt("per_id"));
                msc.setTipo_id(rs.getInt("tipo_mas_id"));

                mascotas.add(msc);
            }
            return mascotas;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public List<Mascota> findAll() {
        List<Mascota> mascotas = new ArrayList<>();

        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("select * from duenioVet.mascotas order by mas_id  ASC");
            rs = pst.executeQuery();
            while (rs.next()) {
                Mascota msc = new Mascota();
                msc.setId(rs.getInt("mas_id"));
                msc.setNombre(rs.getString("mas_nombre"));
                msc.setPer_id(rs.getInt("per_id"));
                msc.setTipo_id(rs.getInt("tipo_mas_id"));

                mascotas.add(msc);
            }
            return mascotas;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MascotaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

}
