/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author LENOVO
 */
public class Logica {
    BloqueDaolmpl bloqueDaolmpl = new BloqueDaolmpl();
    
    public boolean agregarBloque(int codBloque, String nombreBloque, int numDepa){
        return bloqueDaolmpl.agregarBloque(codBloque,nombreBloque, numDepa);
    }
}
