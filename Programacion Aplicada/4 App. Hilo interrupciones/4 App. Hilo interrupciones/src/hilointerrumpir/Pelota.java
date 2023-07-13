/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilointerrumpir;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;


/**
 *
 * @author aplaza
 */
public class Pelota 
{

    private static final int TAMX=15;
    private static final int TAMY=15;	
    private double x=50;	
    private double y=50;	

    
    // Mueve la pelota invirtiendo posición si choca con límites	
/*    public void mueve_pelota(Rectangle2D limites)
    {		
	x+=10;
    }*/
    
    public void mueve_pelota()
    {		
	x+=10;
    }

	
    //Forma de la pelota en su posición inicial
    public Ellipse2D getShape()
    {		
	return new Ellipse2D.Double(x,y,TAMX,TAMY);	
    }		
}

// Lámina que dibuja las pelotas----------------------------------------------------------------------


