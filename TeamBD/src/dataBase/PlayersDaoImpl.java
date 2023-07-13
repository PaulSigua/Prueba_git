package dataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.*;
import views.*;

/**
 *
 * @author mateo
 */
public class PlayersDaoImpl {

    private Statement myStatement;
    private Connection con;
    private WindowMain windowMain;
    private String existingInfo;

    public boolean conection() {
        try {
            if (con != null && con.isValid(0)) {
                System.out.println("Ya existe una conexión");
            } else {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teamplayers",
                        "root", "root");
                myStatement = con.createStatement();
                System.out.println("Conexión exitosa");
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PlayersDaoImpl.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList getistPossessions() {
        ArrayList listPossessions = new ArrayList<>();
        Possession possession = null;
        ResultSet result;
        try {
            myStatement = con.createStatement();
            result = myStatement.executeQuery("select * from possession");

            while (result.next()) {
                possession = new Possession();
                possession.setId(result.getInt("idPossession"));
                possession.setNamePossession(result.getString("possession"));
                listPossessions.add(possession);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlayersDaoImpl.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

        return listPossessions;
    }

    public boolean addPlayerDaoImpl(int idPlayer, String name, String password,
            int age, String possession) {

        conection();
        windowMain = new WindowMain();
        this.existingInfo = name;
        try {
            if (windowMain.getNameTextField().equals("") || windowMain.getPasswordField().equals("")) {
                JOptionPane.showMessageDialog(windowMain, "Debe llenar todos los parametros");
            } else {
                String nameInfo = "SELECT * FROM player WHERE namePlayer='"
                        + this.existingInfo + "'";
                Statement st;
                st = con.createStatement();
                ResultSet rs = st.executeQuery(nameInfo);

                if (rs.next()) {
                    JOptionPane.showMessageDialog(windowMain, "Bienvenido: " + name);
                } else {
                    windowMain.setVisible(false);
                    JOptionPane.showMessageDialog(windowMain,
                            "Se guardo su información de forma correcta ");

                    PreparedStatement sentence = con.prepareStatement("insert "
                            + "into player values (?,?,?,?,?)");
                    sentence.setInt(1, idPlayer);
                    sentence.setString(2, name);
                    sentence.setString(3, password);
                    sentence.setInt(4, age);
                    sentence.setString(5, possession);
                    sentence.executeUpdate();

                }
            }
            return true;
        } catch (SQLSyntaxErrorException ex) {
            System.out.println("Error de sintaxis");
        } catch (SQLIntegrityConstraintViolationException ex) {
            System.out.println("Ocurrio un error");
            //JOptionPane.showMessageDialog(windowMain, "Ocurrio un error");
        } catch (SQLException ex) {
            Logger.getLogger(PlayersDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
