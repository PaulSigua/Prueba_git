/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.dao;

import ec.edu.ups.controlador.Conexion;
import ec.edu.ups.idao.IFactura_CabDAO;
import ec.edu.ups.modelo.Factura_Cabecera;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author guama
 */
public class Factura_CabDAO implements IFactura_CabDAO {

    Connection conexion = null;

    @Override
    public void create(Factura_Cabecera factura) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;

        try {
            pst = conexion.prepareStatement("INSERT INTO duenioVet.factura VALUES (duenioVet.seq_fac_id.nextval,?,?,?,?,?,?,?)");

            pst.setTimestamp(1, new Timestamp(factura.getFecha().getTimeInMillis()));
            pst.setDouble(2, factura.getSubtotal());
            pst.setDouble(3, factura.getIva_total());
            pst.setDouble(4, factura.getTotal());
            pst.setInt(5, factura.getPer_id());
            pst.setString(6, "" + factura.getEstado());
            pst.setInt(7, factura.getUsu_id());
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
                    Logger.getLogger(Factura_CabDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Factura_CabDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public Factura_Cabecera read(int id) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("select * from duenioVet.factura WHERE fac_id= ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            Factura_Cabecera fac = new Factura_Cabecera();

            if (rs.next()) {
                Calendar cal = Calendar.getInstance();
                fac.setId(rs.getInt("fac_id"));
                Timestamp timestamp = rs.getTimestamp("fac_fecha");
                cal.setTimeInMillis(timestamp.getTime());
                fac.setFecha(cal);
                fac.setSubtotal(rs.getDouble("fac_subtotal"));
                fac.setIva_total(rs.getDouble("fac_total_iva"));
                fac.setTotal(rs.getDouble("fac_total_factura"));
                fac.setPer_id(rs.getInt("per_id"));
                fac.setEstado(rs.getString("fac_estado").charAt(0));
                fac.setUsu_id(rs.getInt("usu_id"));
            }
            return fac;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Factura_CabDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Factura_CabDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public void update(Factura_Cabecera factura_Cabecera) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Factura_Cabecera factura_Cabecera) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Factura_Cabecera> findAll() {
        List<Factura_Cabecera> facturas = new ArrayList<>();

        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {

            String query = "select * from duenioVet.factura order by fac_id asc";
            PreparedStatement statement = conexion.prepareStatement(query);
            rs = statement.executeQuery();

            while (rs.next()) {
                Factura_Cabecera fac = new Factura_Cabecera();
                Calendar cal = Calendar.getInstance();
                fac.setId(rs.getInt("fac_id"));
                Timestamp timestamp = rs.getTimestamp("fac_fecha");
                cal.setTimeInMillis(timestamp.getTime());
                fac.setFecha(cal);
                fac.setSubtotal(rs.getDouble("fac_subtotal"));
                fac.setIva_total(rs.getDouble("fac_total_iva"));
                fac.setTotal(rs.getDouble("fac_total_factura"));
                fac.setPer_id(rs.getInt("per_id"));
                fac.setEstado(rs.getString("fac_estado").charAt(0));
                fac.setUsu_id(rs.getInt("usu_id"));

                facturas.add(fac);
            }
            return facturas;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Factura_CabDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Factura_CabDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public void anularFactura(Factura_Cabecera factura) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;

        try {
            pst = conexion.prepareStatement("UPDATE duenioVet.factura SET fac_estado = 'N'  WHERE fac_id=?");
            pst.setInt(1, factura.getId());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "FACTURA ANULADA CORRECTAMENTE");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Factura_CabDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Factura_CabDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public List<Factura_Cabecera> buscarPorCliente(String cedula) {
        List<Factura_Cabecera> facturas = new ArrayList<>();

        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("select * from duenioVet.factura JOIN duenioVet.personas ON duenioVet.factura.per_id = duenioVet.personas.per_id WHERE "
                    + "duenioVet.personas.per_cedula LIKE '%" + cedula + "%' AND  duenioVet.personas.per_tipo = 'C' order by fac_id  ASC");
            rs = pst.executeQuery();
            while (rs.next()) {
                Factura_Cabecera fac = new Factura_Cabecera();
                Calendar cal = Calendar.getInstance();
                fac.setId(rs.getInt("fac_id"));
                Timestamp timestamp = rs.getTimestamp("fac_fecha");
                cal.setTimeInMillis(timestamp.getTime());
                fac.setFecha(cal);
                fac.setSubtotal(rs.getDouble("fac_subtotal"));
                fac.setIva_total(rs.getDouble("fac_total_iva"));
                fac.setTotal(rs.getDouble("fac_total_factura"));
                fac.setPer_id(rs.getInt("per_id"));
                fac.setEstado(rs.getString("fac_estado").charAt(0));
                fac.setUsu_id(rs.getInt("usu_id"));

                facturas.add(fac);
            }
            return facturas;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Factura_CabDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Factura_CabDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public List<Factura_Cabecera> buscarPorFecha(Calendar fecha) {
        List<Factura_Cabecera> facturas = new ArrayList<>();

        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;

        fecha.set(Calendar.HOUR_OF_DAY, 0);
        fecha.set(Calendar.MINUTE, 0);
        fecha.set(Calendar.SECOND, 0);
        fecha.set(Calendar.MILLISECOND, 0);
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(fecha.getTimeInMillis());

        try {
            
            String query = "SELECT * FROM duenioVet.factura WHERE fac_fecha >= ? AND fac_fecha < ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setTimestamp(1, sqlTimestamp);
            Calendar nextDay = (Calendar) fecha.clone();
            nextDay.add(Calendar.DATE, 1);
            statement.setTimestamp(2, new java.sql.Timestamp(nextDay.getTimeInMillis()));
            rs = statement.executeQuery();

            while (rs.next()) {
                Factura_Cabecera fac = new Factura_Cabecera();
                Calendar cal = Calendar.getInstance();
                fac.setId(rs.getInt("fac_id"));
                Timestamp timestamp = rs.getTimestamp("fac_fecha");
                cal.setTimeInMillis(timestamp.getTime());
                fac.setFecha(cal);
                fac.setSubtotal(rs.getDouble("fac_subtotal"));
                fac.setIva_total(rs.getDouble("fac_total_iva"));
                fac.setTotal(rs.getDouble("fac_total_factura"));
                fac.setPer_id(rs.getInt("per_id"));
                fac.setEstado(rs.getString("fac_estado").charAt(0));
                fac.setUsu_id(rs.getInt("usu_id"));

                facturas.add(fac);
            }
            return facturas;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Factura_CabDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Factura_CabDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public int numeroDeFactura() {

        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        int numeroFac=0;
        try {

            String query = "SELECT sequence_name, last_number FROM all_sequences WHERE sequence_name = 'SEQ_FAC_ID'";
            PreparedStatement statement = conexion.prepareStatement(query);
            rs = statement.executeQuery();

            if (rs.next()) {
                numeroFac=rs.getInt("last_number");
            }
            return numeroFac;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Factura_CabDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Factura_CabDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

}
