/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

/**
 *
 * @author aplaza
 */
public class Inicio 
{
    public static void main (String args[])
    {
        RevisionFacade cliente1=new RevisionFacade();
        cliente1.buscar("29/04/2021","02/05/2021","Cuenca","Quito");
    }
}
