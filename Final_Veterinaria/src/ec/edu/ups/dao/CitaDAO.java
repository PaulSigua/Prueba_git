/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.dao;

import ec.edu.ups.controlador.Conexion;
import ec.edu.ups.idao.ICitaDAO;
import ec.edu.ups.modelo.Cita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
public class CitaDAO implements ICitaDAO {

    Connection conexion = null;

    @Override
    public void create(Cita cita) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;

        try {

            pst = conexion.prepareStatement("INSERT INTO duenioVet.citas(cit_id, cit_fecha , cit_estado, mas_id, per_id) VALUES (duenioVet.seq_cit_id.nextval,TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS'),?,?,?)");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = dateFormat.format(cita.getFecha().getTime());

            pst.setString(1, dateString);
            pst.setString(2, "" + cita.getEstado());
            pst.setInt(3, cita.getMas_id());
            pst.setInt(4, cita.getPer_id());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "DATOS INGRESADOS CORRECTAMENTE");
        } catch (SQLException e) {
            if (e.getErrorCode() == -20001) { // Este código de error se define en el trigger
                JOptionPane.showMessageDialog(null, "Ya existe una cita para el veterinario en esta hora", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public Cita read(int id) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("select * from duenioVet.citas WHERE cit_id= ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            Cita cit = new Cita();

            if (rs.next()) {
                Calendar cal = Calendar.getInstance();
                cit.setId(rs.getInt("cit_id"));
                Timestamp timestamp = rs.getTimestamp("cit_fecha");
                cal.setTimeInMillis(timestamp.getTime());
                cit.setFecha(cal);
                cit.setEstado(rs.getString("cit_estado").charAt(0));
                cit.setMas_id(rs.getInt("mas_id"));
                cit.setPer_id(rs.getInt("per_id"));
            }
            return cit;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public void update(Cita cita) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Cita cita) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cita> buscarPorFecha(Calendar fecha) {
        List<Cita> citas = new ArrayList<>();

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

            String query = "SELECT * FROM duenioVet.citas WHERE cit_fecha >= ? AND cit_fecha < ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setTimestamp(1, sqlTimestamp);
            Calendar nextDay = (Calendar) fecha.clone();
            nextDay.add(Calendar.DATE, 1);
            statement.setTimestamp(2, new java.sql.Timestamp(nextDay.getTimeInMillis()));
            rs = statement.executeQuery();

            while (rs.next()) {
                Cita cit = new Cita();
                Calendar cal = Calendar.getInstance();
                cit.setId(rs.getInt("cit_id"));
                Timestamp timestamp = rs.getTimestamp("cit_fecha");
                cal.setTimeInMillis(timestamp.getTime());
                cit.setFecha(cal);
                cit.setEstado(rs.getString("cit_estado").charAt(0));
                cit.setMas_id(rs.getInt("mas_id"));
                cit.setPer_id(rs.getInt("per_id"));
                citas.add(cit);
            }
            return citas;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public List<Cita> buscarPorVeterinario(String cedula) {
        List<Cita> citas = new ArrayList<>();

        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("select * from duenioVet.citas JOIN duenioVet.personas ON duenioVet.citas.per_id = duenioVet.personas.per_id WHERE "
                    + "duenioVet.personas.per_cedula LIKE '%" + cedula + "%' AND  duenioVet.personas.per_tipo != 'C' order by cit_id  ASC");
            rs = pst.executeQuery();
            while (rs.next()) {
                Cita cit = new Cita();
                Calendar cal = Calendar.getInstance();
                cit.setId(rs.getInt("cit_id"));
                Timestamp timestamp = rs.getTimestamp("cit_fecha");
                cal.setTimeInMillis(timestamp.getTime());
                cit.setFecha(cal);
                cit.setEstado(rs.getString("cit_estado").charAt(0));
                cit.setMas_id(rs.getInt("mas_id"));
                cit.setPer_id(rs.getInt("per_id"));
                citas.add(cit);
            }
            return citas;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public List<Cita> buscarPorCliente(String cedula) {
        List<Cita> citas = new ArrayList<>();

        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("SELECT * FROM duenioVet.citas vcit "
                    + "JOIN duenioVet.mascotas vmas ON vcit.mas_id = vmas.mas_id "
                    + "JOIN duenioVet.personas vper ON vper.per_id = vmas.per_id "
                    + "WHERE vper.per_cedula LIKE '%" + cedula + "%' "
                    + "AND  vper.per_tipo = 'C' order by vcit.cit_id  ASC ");
            rs = pst.executeQuery();
            while (rs.next()) {
                Cita cit = new Cita();
                Calendar cal = Calendar.getInstance();
                cit.setId(rs.getInt("cit_id"));
                Timestamp timestamp = rs.getTimestamp("cit_fecha");
                cal.setTimeInMillis(timestamp.getTime());
                cit.setFecha(cal);
                cit.setEstado(rs.getString("cit_estado").charAt(0));
                cit.setMas_id(rs.getInt("mas_id"));
                cit.setPer_id(rs.getInt("per_id"));
                citas.add(cit);
            }
            return citas;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public List<Cita> findAll() {
        List<Cita> citas = new ArrayList<>();

        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("SELECT * FROM duenioVet.citas order by cit_id  ASC ");
            rs = pst.executeQuery();
            while (rs.next()) {
                Cita cit = new Cita();
                Calendar cal = Calendar.getInstance();
                cit.setId(rs.getInt("cit_id"));
                Timestamp timestamp = rs.getTimestamp("cit_fecha");
                cal.setTimeInMillis(timestamp.getTime());
                cit.setFecha(cal);
                cit.setEstado(rs.getString("cit_estado").charAt(0));
                cit.setMas_id(rs.getInt("mas_id"));
                cit.setPer_id(rs.getInt("per_id"));
                citas.add(cit);
            }
            return citas;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public void cancelarCita(Cita cita) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;

        try {
            pst = conexion.prepareStatement("UPDATE duenioVet.citas SET cit_estado = 'C'  WHERE cit_id=?");
            pst.setInt(1, cita.getId());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "CITA CANCELADA CORRECTAMENTE");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Cierre de recursos (si se usa java7 se puede usar un try-with-resources

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public void reagendarCita(int id, Calendar fecha, int per_id) {
        Conexion con = new Conexion();
        con.actulizarConexion();
        conexion = con.getConexion();
        PreparedStatement pst = null;
        try {

            pst = conexion.prepareStatement("UPDATE duenioVet.citas SET cit_fecha = TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS'),per_id=?,cit_estado='I' "
                    + "WHERE cit_id=? AND NOT EXISTS "
                    + "(SELECT 1 FROM duenioVet.citas WHERE per_id = ? "
                    + "AND cit_fecha = TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS') "
                    + "AND cit_estado <> 'C')");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = dateFormat.format(fecha.getTime());

            pst.setString(1, dateString);
            pst.setInt(2, per_id);
            pst.setInt(3, id);
            pst.setInt(4, per_id);
            pst.setString(5, dateString);
            int result = pst.executeUpdate();
            pst.close();
            if (result == 0) {
                JOptionPane.showMessageDialog(null, "No se puede reagendar la cita ya que ya existe una cita en esa hora con ese veterinario");
            } else {
                JOptionPane.showMessageDialog(null, "CITA REAGENDADA CORRECTAMENTE");
            }

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        } finally {
            try {
                conexion.setAutoCommit(true);
                // Cierre de recursos (si se usa java7 se puede usar un try-with-resources
            } catch (SQLException ex) {
                Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (pst != null) {

                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (conexion != null) {

                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

}
