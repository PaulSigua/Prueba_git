/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

/**
 *
 * @author LENOVO
 */
public abstract class Observador {

    // Cuando el porcentaje de la bateria ingresado es bastante bajo, el tiempo estimado bajara 
    // con algo de demora. 
    
    Subject sujeto;
    public abstract void actualizar();

}
