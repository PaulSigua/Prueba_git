/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.dao;

import ec.edu.ups.controlador.Conexion;
import ec.edu.ups.idao.IFactura_DetDAO;
import ec.edu.ups.modelo.Factura_Detalle;
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
public class Factura_DetDAO implements IFactura_DetDAO {

    Connection conexion = null;

    @Override
    public void create(List<Factura_Detalle> detalles) {

        for (Factura_Detalle detalle : detalles) {
            Conexion con = new Conexion();
            con.actulizarConexion();
            conexion = con.getConexion();
            PreparedStatement pst = null;
            try {
                pst = conexion.prepareStatement("INSERT INTO duenioVet.factura_detalle(det_id, det_cantidad , det_precio_unitario, det_subtotal,det_valor_iva, det_total,fac_id,ser_id) VALUES (duenioVet.seq_det_id.nextval,?,?,?,?,?,?,?)");
                pst.setInt(1, detalle.getCantidad());
                pst.setDouble(2, detalle.getPrecio_unitario());
                pst.setDouble(3, detalle.getSubtotal());
                pst.setDouble(4, detalle.getValor_iva());
                pst.setDouble(5, detalle.getTotal());
                pst.setInt(6, detalle.getFac_id());
                pst.setInt(7, detalle.getSer_id());
                pst.executeUpdate();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

                if (pst != null) {

                    try {
                        pst.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Factura_DetDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                if (conexion != null) {

                    try {
                        conexion.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Factura_DetDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        }

    }

    @Override
    public Factura_Detalle read(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Factura_Detalle factura_Detalle) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Factura_Detalle factura_Detalle) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Factura_Detalle> buscarFactura(int id) {
        List<Factura_Detalle> detalles = new ArrayList<>();

        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("select * from duenioVet.factura_detalle WHERE fac_id = ? order by det_id ASC");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                Factura_Detalle fDet = new Factura_Detalle();
                fDet.setId(rs.getInt("det_id"));
                fDet.setCantidad(rs.getInt("det_cantidad"));
                fDet.setPrecio_unitario(rs.getDouble("det_precio_unitario"));
                fDet.setSubtotal(rs.getDouble("det_subtotal"));
                fDet.setValor_iva(rs.getDouble("det_valor_iva"));
                fDet.setTotal(rs.getDouble("det_total"));
                fDet.setFac_id(rs.getInt("fac_id"));
                fDet.setSer_id(rs.getInt("ser_id"));
                detalles.add(fDet);
            }
            return detalles;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Factura_DetDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Factura_DetDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

}
