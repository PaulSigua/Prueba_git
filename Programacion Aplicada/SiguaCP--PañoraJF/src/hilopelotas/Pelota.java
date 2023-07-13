/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilopelotas;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author aplaza
 */
public class Pelota {

    private static int TAMX = 15;
    private static int TAMY = 15;
    private double x = 80;
    private double y = 80;
    Color color;
    Color colorN;
    private int numero = 0;

    public Pelota() {
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setColorNum(Color color) {
        this.colorN = color;
    }

    public Color getColorNum(int numero) {
        return colorN;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void mueve_pelota() {
        x += 10;
    }

    //Forma de la pelota en su posición inicial
    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, TAMX, TAMY);
    }

}
