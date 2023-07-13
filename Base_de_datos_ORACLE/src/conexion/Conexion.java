package conexion;

import controllers.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mateo
 */
public class Conexion {

    private Connection con;
    private static Conexion instance;
    private String sentencia;
    private String viewResult;
    private Tables tables;
    private Sentences sentencias;

    public boolean connection() {
        try {
            if (con != null && con.isValid(0)) {
                System.out.println("Ys existe una conexión");
            } else {
                System.out.println("Conectado");
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
                        "psigua", "clave_123");
            }
            return true;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static Conexion getInstance() {
        if (instance == null) {
            instance = new Conexion();
        }
        return instance;
    }

    public String getSentencia() {
        return sentencia;
    }

    public String getViewResult() {
        return viewResult;
    }

    public ArrayList viewTable() {
        int opc = 0;
        ArrayList<String> list = new ArrayList<>();
        PreparedStatement consult;
        ResultSet result;
        Statement myStatement;

        do {
            Scanner input = new Scanner(System.in);
            System.out.println("2. Ayuda");
            System.out.println("1. Ingresar sentencia DDL o DML");
            System.out.println("0. Salir");
            opc = input.nextInt();

            if (opc == 2 || opc == 1 || opc == 0) {
                switch (opc) {
                    case 1:
                        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
                        try {
                            // SE NECESITA COMPLETAR LA CONDICION IF CON LA 
                            // VALIDACION DE LA EXCEPCION
                            if(SQLSyntaxErrorException.class.equals(sentencia)){
                                System.out.println("Intentelo de nuevo");
                            } else{
                            System.out.println("Ingrese la sentencia por favor. "
                                    + "Tiene que escribirla de manera correcta.");
                            sentencia = read.readLine();
                            System.out.println("Ingrese el nombre de una columna.");
                            viewResult = read.readLine();
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            myStatement = con.createStatement();
                            result = myStatement.executeQuery(getSentencia());

                            System.out.println("-------------------------");
                            System.out.println("Informacion obtenida a partir de la tabla " + sentencia + "   " + getViewResult());
                            while (result.next()) {
                                list.add(result.getString(getViewResult()));
                            }

                            for (int i = 0; i < list.size(); i++) {
                                System.out.println(list.get(i));
                            }
                            
                            
                        } catch (SQLSyntaxErrorException ex) {
                            System.out.println("La información ingresada no es CORRECTA");
                        } catch (SQLException ex) {
                            System.out.println("Ocurrio un error con la sentencia ingresada");
                        }
                        System.out.println("------------------------");
                    break;
                    
                    case 2:
                        this.sentencias = new Sentences();
                        sentencias.returnSentence();
                        break;
                        
                    case 0:
                        System.out.println("Termino el recorrido");
                        //System.exit(0);
                    break;
                }
            } else {
                System.out.println("Ingrese un numero que este entre las opciones");
            }

        } while (opc != 0);

        return list;
    }

}