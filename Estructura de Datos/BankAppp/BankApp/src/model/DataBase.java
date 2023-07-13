/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//Obtención de los usuarios y trabajadores desde la base de datos

package model;

//Importación de las librerias necesarias
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/**
 *
 * @author josev
 */
public class DataBase {
    //Creación de HashMaps y ArrayList para almacenar usuarios y trabajadores
    private HashMap<String, Dependent> availableDependents;
    private HashMap<String, User> availableUsers;
    private ArrayList<Dependent> allDependents;
    private ArrayList<User> allUsers;
    

    private void fillUsers() {
        //Inicialización de HashMaps y ArrayList
        availableUsers = new HashMap<>();
        allDependents = new ArrayList();
        allUsers = new ArrayList();
                
        //Lectura de archivos y asignación a HashMaps y ArrayLists de los usuarios
        InputStream f = DataBase.class.getResourceAsStream("/resources/users");
        try {
            InputStreamReader fr = new InputStreamReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                String[] content = line.split(" ");
                User user = new User();
                user.setName(content[0] + " " + content[1]);
                user.setId(content[2]);
                user.setMoney(Double.parseDouble(content[3]));
                availableUsers.put(content[2], user);
                allUsers.add(user);
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fillDependents() {
        //Inicialización del HashMap a utilizar
        availableDependents = new HashMap<>();
        
        //Lectura de archivos y asignación a HashMaps y ArrayLists de los usuarios
        InputStream f = DataBase.class.getResourceAsStream("/resources/dependents");
        try {
            InputStreamReader fr = new InputStreamReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                String[] content = line.split(" ");
                Dependent dependent = new Dependent();
                dependent.setName(content[0]);
                dependent.setNumCabin(Integer.parseInt(content[1]));

                availableDependents.put(content[0], dependent);
                allDependents.add(dependent);
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    //Llamar a los métodos para leer los archivos
    public DataBase() {
        fillUsers();
        fillDependents();
    }
    
    //Métodos que devuelven  arrayList con los usuarios y trabajadores
    public ArrayList<User> getSelectedUser(){
        return allUsers;
    }
    
    public ArrayList<Dependent> getSelectedDependent(){
        return allDependents;
    }
    
    //Obtención de un usuario de acuerdo a su nombre
    public User getUser(String key){
        return availableUsers.get(key);
    }
    
    //Obtencion de los HashMap de usuarios y trabajadores
    public HashMap<String, User> getAvailableUsers() {
        return availableUsers;
    }

    public HashMap<String, Dependent> getAvailableDependet() {
        return availableDependents;
    }

}
