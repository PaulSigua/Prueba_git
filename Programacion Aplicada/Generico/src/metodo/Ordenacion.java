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
public class Ordenacion
{
    public <T> void obtenerTamanio(T[] lista)
    {
        System.out.println (lista.length);
    }
    
    public <T extends Comparable> T[] ordenar(T[] lista)
    {
        for(int i=0; i<lista.length; i++)
        {
            for(int j=i+1; j<lista.length-1;j++)
            {
                if(lista[i].compareTo(lista[j])>0)
                {
                    T aux=lista[i];
                    lista[i]=lista[j];
                    lista[j]=aux;
                }
            }
        }
        return lista;
        
    }
}
