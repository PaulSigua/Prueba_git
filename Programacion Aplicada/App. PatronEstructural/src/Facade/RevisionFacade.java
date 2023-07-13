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
public class RevisionFacade 
{
    private Vuelo vuelo;
    
    public RevisionFacade()
    {
        vuelo=new Vuelo();
    }
    
    public void buscar(String fechaIda, String fechaDestino, String origen, String destino)
    {
        vuelo.buscarVuelo(fechaIda, fechaDestino, origen, destino);
    }
    
}
