/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
//Importación de las clases/librerias a usarse
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */

public class CombosAndRecharges {
    //Creación de los HashMap para alamacenar los datos
    private HashMap<String, Line1> availableLineRecharge1;
    private HashMap<String, Line2> availableLineRecharge2;
    private HashMap<String, Line3> availableLineRecharge3;
    private HashMap<String, Line4> availableLineRecharge4;
    private HashMap<String, Line1> availableLine1;
    private HashMap<String, Line2> availableLine2;
    private HashMap<String, Line3> availableLine3;
    private HashMap<String, Line4> availableLine4;

    //Método para el manejo de archivos
    private void fillRechargeLine1(){
        //Inicializaxión de HashMap
        availableLineRecharge1 = new HashMap<>();
        
        //Lectura de archivos y asignación a HashMap
        InputStream recharge = Recharges.class.getResourceAsStream("/recharges/recharge.line2");
        
        // "try y catch" Para capturar excepiones 
        try {
            InputStreamReader inputReader = new InputStreamReader(recharge);
            BufferedReader bufferredReader = new BufferedReader(inputReader);
            String lineCode = bufferredReader.readLine();
            while (lineCode != null) {
                String[] content = lineCode.split(" ");
                Line1 line1 = new Line1();
                line1.setAlternatives(content[0] + " " + content[1] + " " +  content[2]);
                line1.setCost(Double.parseDouble(content[3]));
                availableLineRecharge1.put(content[0] + content[1] + content[2], line1);
                lineCode = bufferredReader.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CombosAndRecharges.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CombosAndRecharges.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Método para el manejo de archivo
    private void fillRechargeLine2(){
        //Inicialización de HashMap
        availableLineRecharge2 = new HashMap<>();
        
        //Lectura de archivos y asignación a HashMap
        InputStream recharge = Recharges.class.getResourceAsStream("/recharges/recharge.line2");
        //"try y catch" Para capturar excepciones
        try {
            InputStreamReader inputReader = new InputStreamReader(recharge);
            BufferedReader bufferredReader = new BufferedReader(inputReader);
            String lineCode = bufferredReader.readLine();
            while (lineCode != null) {
                String[] content = lineCode.split(" ");
                Line2 line2 = new Line2();
                line2.setAlternatives(content[0] + " " + content[1] + " " +  content[2]);
                line2.setCost(Double.parseDouble(content[3]));
                availableLineRecharge2.put(content[0] + content[1] + content[2], line2);
                lineCode = bufferredReader.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CombosAndRecharges.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CombosAndRecharges.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Método para el manejo de archivos
    public void fillRechargeLine3(){
        //Inicialización de HashMap
        availableLineRecharge3 = new HashMap<>();
        InputStream recharge = Recharges.class.getResourceAsStream("/recharges/recharge.line3");
        //"try y catch" Para capturar excepciones
        try {
            InputStreamReader inputReader = new InputStreamReader(recharge);
            BufferedReader bufferredReader = new BufferedReader(inputReader);
            String lineCode = bufferredReader.readLine();
            while (lineCode != null) {
                String[] content = lineCode.split(" ");
                Line3 line3 = new Line3();
                line3.setAlternatives(content[0]  + " " + content[1] + " " +  content[2]);
                line3.setCost(Double.parseDouble(content[3]));
                availableLineRecharge3.put(content[0] + content[1] +  content[2], line3);
                lineCode = bufferredReader.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CombosAndRecharges.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CombosAndRecharges.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Método para el manejo de archivos
    public void fillRechargeLine4(){
        //Inicialización de HashMap
        availableLineRecharge4 = new HashMap<>();
        InputStream recharge = Recharges.class.getResourceAsStream("/recharges/recharge.line4");
        
        // "try y catch" Para capturar excepciones
        try {
            InputStreamReader inputReader = new InputStreamReader(recharge);
            BufferedReader bufferredReader = new BufferedReader(inputReader);
            String lineCode = bufferredReader.readLine();
            while (lineCode != null) {
                String[] content = lineCode.split(" ");
                Line4 line4 = new Line4();
                line4.setAlternatives(content[0] + " " + content[1] + " " +  content[2]);
                line4.setCost(Double.parseDouble(content[3]));
                availableLineRecharge4.put(content[0] + content[1] + content[2], line4);
                lineCode = bufferredReader.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CombosAndRecharges.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CombosAndRecharges.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Método para el manejo de archivos
    private void fillComboLine1() {
        //Inicialización de HsshMap
        availableLine1 = new HashMap<>();
        InputStream combo = CombosAndRecharges.class.getResourceAsStream("/combos/combo.line1");
        
        // "try y catch" Para capturar excepciones 
        try {
            InputStreamReader inputReader = new InputStreamReader(combo);
            BufferedReader bufferredReader = new BufferedReader(inputReader);
            String lineCode = bufferredReader.readLine();
            while (lineCode != null) {
                String[] content = lineCode.split(" ");
                Line1 line1 = new Line1();
                line1.setAlternatives(content[0] + " " + content[1]);
                line1.setCost(Double.parseDouble(content[2]));
                availableLine1.put(content[0] + content[1], line1);
                lineCode = bufferredReader.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CombosAndRecharges.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CombosAndRecharges.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Método para el manejo de archivos
    private void fillComboLine2() {
        //Inicialización de HsshMap
        availableLine2 = new HashMap<>();
        InputStream combo = CombosAndRecharges.class.getResourceAsStream("/combos/combo.line2");
        
        // "try y catch" Para capturar excepciones
        try {
            InputStreamReader inputReader = new InputStreamReader(combo);
            BufferedReader bufferredReader = new BufferedReader(inputReader);
            String lineCode = bufferredReader.readLine();
            while (lineCode != null) {
                String[] content = lineCode.split(" ");
                Line2 line2 = new Line2();
                line2.setAlternatives(content[0] + " " + content[1]);
                line2.setCost(Double.parseDouble(content[2]));
                availableLine2.put(content[0] + content[1], line2);
                lineCode = bufferredReader.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CombosAndRecharges.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CombosAndRecharges.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Método para el manejo de archivos
    private void fillComboLine3() {
        //Inicialización de HsshMap
        availableLine3 = new HashMap<>();
        InputStream combo = CombosAndRecharges.class.getResourceAsStream("/combos/combo.line3");
        
        // "try y catch" Para capturar excepciones
        try {
            InputStreamReader inputReader = new InputStreamReader(combo);
            BufferedReader bufferredReader = new BufferedReader(inputReader);
            String lineCode = bufferredReader.readLine();
            while (lineCode != null) {
                String[] content = lineCode.split(" ");
                Line3  line3 = new Line3();
                line3.setAlternatives(content[0] + " " + content[1]);
                line3.setCost(Double.parseDouble(content[2]));
                availableLine3.put(content[0] + content[1], line3);
                lineCode = bufferredReader.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CombosAndRecharges.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CombosAndRecharges.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Método para el manejo de archivos
    private void fillComboLine4() {
        
        availableLine4 = new HashMap<>();
        InputStream combo = CombosAndRecharges.class.getResourceAsStream("/combos/combo.line1");
        
        // "try y catch" Para capturar excepciones
        try {
            InputStreamReader inputReader = new InputStreamReader(combo);
            BufferedReader bufferredReader = new BufferedReader(inputReader);
            String lineCode = bufferredReader.readLine();
            while (lineCode != null) {
                String[] content = lineCode.split(" ");
                Line4 line4 = new Line4();
                line4.setAlternatives(content[0] + " " + content[1]);
                line4.setCost(Double.parseDouble(content[2]));
                availableLine4.put(content[0] + content[1], line4);
                lineCode = bufferredReader.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CombosAndRecharges.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CombosAndRecharges.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Llamar a los métodos para leer los archivos 
    public CombosAndRecharges(){
        fillRechargeLine1();
        fillRechargeLine2();
        fillRechargeLine3();
        fillRechargeLine4();
        fillComboLine1();
        fillComboLine2();
        fillComboLine3();
        fillComboLine4();
    }
    
    //Métodos para obtener las recargas y combos
    public Line1 getRechargeLine1(String key){
        return availableLineRecharge1.get(key);
    }

    public Line2 getRechargeLine2(String key){
        return availableLineRecharge2.get(key);
    }
    
    public Line3 getRechargeLine3(String Key){
        return availableLineRecharge3.get(Key);
    }
    
    public Line4 getRechargeLine4(String key){
        return availableLineRecharge4.get(key);
    }
    
    public Line1 getComboLine1(String key){
        return availableLine1.get(key);
    }
    
    public Line2 getComboLine2(String key){
        return availableLine2.get(key);
    }
    
    public Line3 getComboLine3(String key){
        return availableLine3.get(key);
    }
    
    public Line4 getComboLine4(String key){
        return availableLine4.get(key);
    }

    //Métodos para obtener de un HashMap
    public HashMap<String, Line1> getAvailableLineRecharge1() {
        return availableLineRecharge1;
    }

    public HashMap<String, Line2> getAvailableLineRecharge2() {
        return availableLineRecharge2;
    }

    public HashMap<String, Line3> getAvailableLineRecharge3() {
        return availableLineRecharge3;
    }

    public HashMap<String, Line4> getAvailableLineRecharge4() {
        return availableLineRecharge4;
    }

    public HashMap<String, Line1> getAvailableLine1() {
        return availableLine1;
    }

    public HashMap<String, Line2> getAvailableLine2() {
        return availableLine2;
    }

    public HashMap<String, Line3> getAvailableLine3() {
        return availableLine3;
    }

    public HashMap<String, Line4> getAvailableLine4() {
        return availableLine4;
    }

    //Método sobreescrito
    @Override
    public String toString() {
        return availableLine1.toString() + availableLine2.toString() + availableLine3.toString() + availableLine4.toString() + availableLineRecharge1.toString() + availableLineRecharge2.toString() + availableLineRecharge3.toString() + availableLineRecharge4;
    }

}
