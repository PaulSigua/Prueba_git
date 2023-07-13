package model;

import controller.ListenerButtonWindowONE;
import view.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.JOptionPane;

/**
 *
 * @author mateo
 */
public class RechargeDaoImpl {

    private WindowLineONE windowOne;
    private Statement myStatement;
    private Connection con;
    private RechargeInformation rechargeInfo;
    private String idCopy;

    public void conectar() {
        try {

            if (con != null && con.isValid(0)) {
                System.out.println("Ya existe una conexión");
            } else {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Recharges_Client", "root", "root");
                myStatement = con.createStatement();
                System.out.println("Conexión exitosa");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RechargeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean registerRechargeLineOne(int codId, String name, int idClient, int cell, int age) {
        conectar();
        rechargeInfo = new RechargeInformation();
        windowOne = new WindowLineONE(rechargeInfo);
        this.idCopy = String.valueOf(idClient);
        try {
            String sentenceValidate = "SELECT * FROM rechargeInfoMovistar WHERE "
                    + "idClient='" + this.idCopy + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sentenceValidate);
            if (rs.next()) {
                JOptionPane.showMessageDialog(windowOne, "Su recarga fue realizada estimado: " + name);
            } else {
                
                PreparedStatement sentence = con.prepareStatement("insert into RechargeInfoMovistar values (?,?,?,?,?)");
                sentence.setInt(1, codId);
                sentence.setString(2, name);
                sentence.setInt(3, idClient);
                sentence.setInt(4, cell);
                sentence.setInt(5, age);
                sentence.executeUpdate();
                return true;

            }

        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(windowOne, "¡Ya esta registrada su recarga!");
        } catch (SQLException ex) {
            Logger.getLogger(RechargeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean registerRechargeLineTwo(int codId, String name, int idClient, int cell, int age) {
        conectar();
        rechargeInfo = new RechargeInformation();
        windowOne = new WindowLineONE(rechargeInfo);
        try {
            PreparedStatement sentence = con.prepareStatement("insert into RechargeInfoClaro values (?,?,?,?,?)");
            sentence.setInt(1, codId);
            sentence.setString(2, name);
            sentence.setInt(3, idClient);
            sentence.setInt(4, cell);
            sentence.setInt(5, age);
            sentence.executeUpdate();
            return true;

        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(windowOne, "¡Ya esta registrada su recarga!");
        } catch (SQLException ex) {
            Logger.getLogger(RechargeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean registerRechargeLineThree(int codId, String name, int idClient, int cell, int age) {
        conectar();
        rechargeInfo = new RechargeInformation();
        windowOne = new WindowLineONE(rechargeInfo);
        try {
            PreparedStatement sentence = con.prepareStatement("insert into RechargeInfoTuenti values (?,?,?,?,?)");
            sentence.setInt(1, codId);
            sentence.setString(2, name);
            sentence.setInt(3, idClient);
            sentence.setInt(4, cell);
            sentence.setInt(5, age);
            sentence.executeUpdate();
            return true;

        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(windowOne, "¡Ya esta registrada su recarga!");
        } catch (SQLException ex) {
            Logger.getLogger(RechargeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean registerRechargeLineFour(int codId, String name, int idClient, int cell, int age) {
        conectar();
        rechargeInfo = new RechargeInformation();
        windowOne = new WindowLineONE(rechargeInfo);
        try {
            PreparedStatement sentence = con.prepareStatement("insert into RechargeInfoMaxiplus values (?,?,?,?,?)");
            sentence.setInt(1, codId);
            sentence.setString(2, name);
            sentence.setInt(3, idClient);
            sentence.setInt(4, cell);
            sentence.setInt(5, age);
            sentence.executeUpdate();
            return true;

        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(windowOne, "¡Ya esta registrada su recarga!");
        } catch (SQLException ex) {
            Logger.getLogger(RechargeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
