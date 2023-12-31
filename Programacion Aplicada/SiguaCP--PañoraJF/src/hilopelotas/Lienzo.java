/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilopelotas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author aplaza
 */
public class Lienzo extends javax.swing.JPanel {

    /**
     * Creates new form Lienzo
     */
    public Lienzo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 882, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    Color color1;
    Color color2;
    private static ArrayList<Pelota> pelotas = new ArrayList<>();

    //Añadimos pelota a la lámina
    public void add(Pelota b) {
        pelotas.add(b);
        for (Pelota p : pelotas) {
            p.getColor();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g; //Para graficar la pelotita

        for (Pelota b : pelotas) //Voy sacando la pelotita y mandale a hacerle negrito
        {
            int x = (int) b.getX() + 5; //Posicion del numero
            int y = (int) b.getY() - 5;
            g2.setColor(b.getColor());
            g2.drawString((b.getNumero() + ""), x, y);
            g2.fill(b.getShape());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
