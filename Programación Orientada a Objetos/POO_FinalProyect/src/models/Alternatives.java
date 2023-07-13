/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

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
public class Alternatives {
    private HashMap<String, Movistar> availableLineRecharge1;
    private HashMap<String, Claro> availableLineRecharge2;
    private HashMap<String, Tuenti> availableLineRecharge3;
    private HashMap<String, Maxiplus> availableLineRecharge4;
    private HashMap<String, Combo> availableLineCombos;
    
    private void fillMovi(){
        availableLineRecharge1 = new HashMap<>();
        InputStream f = Alternatives.class.getResourceAsStream("/resources/resourcesRecharge1");
        try {
            InputStreamReader fr = new InputStreamReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null){
                String[] content = line.split(" ");
                Movistar movistar = new Movistar();
                movistar.setAlternatives(content[0] + " " + content[1] + " " + content[2]);
                movistar.setCost(Double.parseDouble(content[3]));
                availableLineRecharge1.put(content[0] + content[1] +  content[2], movistar);
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Alternatives.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Alternatives.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fillClaro(){
        availableLineRecharge2 = new HashMap<>();
        InputStream f = Alternatives.class.getResourceAsStream("/resources/resourcesRecharge2");
        try {
            InputStreamReader fr = new InputStreamReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null){
                String[] content = line.split(" ");
                Claro claro = new Claro();
                claro.setAlternatives(content[0] + " " + content[1] + " " + content [2]);
                claro.setCost(Double.parseDouble(content[3]));
                availableLineRecharge2.put(content[0] + content[1] + content[2], claro);
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Alternatives.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Alternatives.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fillTuenti(){
        availableLineRecharge3 = new HashMap<>();
        InputStream f = Alternatives.class.getResourceAsStream("/resources/resourcesRecharge3");
        try {
            InputStreamReader fr = new InputStreamReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null){
                String[] content = line.split(" ");
                Tuenti tuenti = new Tuenti();
                tuenti.setAlternatives(content[0] + " " + content[1] + " " + content[2]);
                tuenti.setCost(Double.parseDouble(content[3]));
                availableLineRecharge3.put(content[0] + content[1] + content[2], tuenti);
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Alternatives.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Alternatives.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fillMaxi(){
        availableLineRecharge4 = new HashMap<>();
        InputStream f = Alternatives.class.getResourceAsStream("/resources/resourcesRecharge4");
        try {
            InputStreamReader fr = new InputStreamReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null){
                String[] content = line.split(" ");
                Maxiplus maxiplus = new Maxiplus();
                maxiplus.setAlternatives(content[0] + " " + content[1] + " " + content[2]);
                maxiplus.setCost(Double.parseDouble(content[3]));
                availableLineRecharge4.put(content[0]+ content[1] + content[2], maxiplus);
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Alternatives.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Alternatives.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fillCombos(){
        availableLineCombos = new HashMap<>();
        InputStream f = Alternatives.class.getResourceAsStream("/resources/resourcesCombo1");
        try {
            InputStreamReader fr = new InputStreamReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null){
                String[] content = line.split(" ");
                Combo combos = new Combo();
                combos.setAlternatives(content[0] + " " + content[1]);
                combos.setCost(Double.parseDouble(content[2]));
                availableLineCombos.put(content[0], combos);
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Alternatives.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Alternatives.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public Alternatives(){
        fillMovi();
        fillClaro();
        fillTuenti();
        fillMaxi();
        fillCombos();
    }
    
    public Movistar getMovi(String key){
        return availableLineRecharge1.get(key);
    }
    
    public Claro getClaro(String key){
        return availableLineRecharge2.get(key);
    }
    
    public Tuenti getTuenti(String key){
        return availableLineRecharge3.get(key);
    }
    
    public Maxiplus getMaxi(String key){
        return availableLineRecharge4.get(key);
    }

    public HashMap<String, Movistar> getAvailableLineRecharge1() {
        return availableLineRecharge1;
    }

    public HashMap<String, Claro> getAvailableLineRecharge2() {
        return availableLineRecharge2;
    }

    public HashMap<String, Tuenti> getAvailableLineRecharge3() {
        return availableLineRecharge3;
    }

    public HashMap<String, Maxiplus> getAvailableLineRecharge4() {
        return availableLineRecharge4;
    }

    public HashMap<String, Combo> getAvailableLineCombos() {
        return availableLineCombos;
    }

    @Override
    public String toString() {
        return availableLineRecharge1.toString() + availableLineRecharge2.toString() + availableLineRecharge3.toString()  + availableLineRecharge4.toString() + availableLineCombos.toString();
    }
    
    
}
