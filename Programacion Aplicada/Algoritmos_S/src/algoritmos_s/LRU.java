/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmos_s;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Usuario
 */
public class LRU 
{
    private ArrayList pos;
    private Vector referencias;
    private Vector marcos;
    private int numMarcos;
    private int fallos;
    private int cont2;
    private String[][] registro;
    public LRU(Vector referencias,int numMarcos)
    {
        this.referencias=referencias;
        this.numMarcos=numMarcos;
        cont2=0;
        fallos=0;
        marcos=new Vector(numMarcos);
        for(int i=0;i<numMarcos;i++)//Colocar todos lo valores como nulos
        {
            marcos.addElement(" ");
        }
        registro=new String[numMarcos][0];
    }
    public void ejecutar()
    {
        System.out.println("ALGORITMO LRU");
        System.out.println(referencias);
        System.out.println("Marcos: "+numMarcos+"\n");
        for(int i=0;i<referencias.size();i++)
        {
            for(int j=0;j<numMarcos;j++)
            {
                if(marcos.get(j)==" " )//El marco esta vacio
                {
                    marcos.set(j,referencias.get(i));
                    registrar();
                    fallos++;
                    break;
                }else if(marcos.get(j)==referencias.get(i))//La pagina si esta cargada
                {
                    break;
                }else if((j+1)==numMarcos)//La pagina no esta cargada
                {
                    pos=new ArrayList();
                    pos.clear();
                    int menor;
                    for(int k=0;k<numMarcos;k++)//Buscar la posicion del numero mas antiguo
                    {
                        for (int l = i; l>=0; l--) 
                        {
                            if (marcos.get(k) == referencias.get(l)) 
                            {
                                pos.add(l);
                                break;
                            } 
                        }
                    }
                    menor=Integer.parseInt(pos.get(0)+"");
                    for (int k = 1; k < pos.size(); k++)//Buscar cual es el numero mas antiguo
                    {
                        if (Integer.parseInt(pos.get(k) + "") < menor)
                        {
                            menor = Integer.parseInt(pos.get(k) + "");
                        }
                    }
                    for (int k = 0; k < marcos.size(); k++)//Remplazar el marco con el numero mas lejano hacia la izquierda
                    {
                        if (Integer.parseInt(marcos.get(k) + "") == Integer.parseInt(referencias.get(menor) + "")) 
                        {
                            marcos.set(k, referencias.get(i));
                            break;
                        }
                    }
                    fallos++;
                    registrar();
                    break;
                }
            }
        }
        imprimir();
    }
    public void registrar()
    {
       int columnas=registro[0].length+1;
       String[][] registroAux=registro.clone();
       registro=new String[numMarcos][columnas];
       if(registroAux[0].length!=0)
       {
            for(int i=0;i<numMarcos;i++)
            {
                for(int j=0;j<registroAux[0].length;j++)
                {
                    registro[i][j]=registroAux[i][j];
                }
            }
       }
       for(int j=cont2;j<columnas;j++)//Hacer el registro de los marcos
       {
           for(int i=0;i<numMarcos;i++)
           {
               registro[i][j]=marcos.get(i)+"";
           }
       }
       cont2++;
    }
    public void imprimir()
    {
        int columnas=registro[0].length;
        for(int i=0;i<numMarcos;i++)//Imprimir el regristro de los marcos
        {
           for(int j=0;j<columnas;j++)
           {
               System.out.print(registro[i][j]+"   ");
           }
           System.out.println("");
       }
        System.out.println("\n"+"Fallos: "+fallos+"\n");
    }
}
