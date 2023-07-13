/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodo;

/**
 *
 * @author aplaza
 */
public class Inicio 
{
/**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        /*int lista[]= new int [4];
        lista[0]=1;*/
        
        Integer lista[]= {5,3,4,6};
        
        Ordenacion o=new Ordenacion();
        //o.obtenerTamanio(lista);
        //o.ordenar(lista);
        
        /*int mayor, menor;
        mayor = menor = lista [0];
       
        for (int i = 0; i < lista.length; i++) {
            if(lista [i] > mayor) {
                mayor = lista[i];
            }
            if(lista[i]<menor) {
                menor = lista[i];
            }
        }
        System.out.println("El mayor valor es: "+mayor);
        System.out.println("El menor valor es: "+menor);
        */
        Alumno listaA[]={new Alumno(1,"Ana"),new Alumno(2,"Juan")};
        o.obtenerTamanio(listaA);
    }    
}
