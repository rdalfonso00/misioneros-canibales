package com.misioneros_canibales.Grafo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author poncho
 */
public class MainMisionerosCanibales {
    final static Barco estadoInicial = new Barco(3, 3, 0, 0, false, null);
    //final static Barco solucion = new Barco(0, 0, 0, 0, true);

    public static void main(String[] args){
        
        Grafo g = generarExpansionMyC(estadoInicial);
        System.out.println(g);
    }

    public static Grafo generarExpansionMyC(Barco barcoInicial){
        boolean fin = false;
        //Barco temp = barcoInicial;
        ArrayList<Barco> listaTemp, listaMalos = new ArrayList<>();
        Grafo g = new Grafo();
        Queue<Barco> pendientes = (Queue<Barco>) new LinkedList<Barco>();
        pendientes.add(barcoInicial);
        while(true){
            if(pendientes.isEmpty()){ //cuando dejen de haber ramas por explorar, termina la expansion
                return g;
            }
            Barco b = pendientes.poll();
            listaTemp = Barco.generarSucesores(b);
            for (Barco temp : listaTemp) { // agregar sucesores  a la estructura y a los pendientes por explorar
                if(!pendientes.contains(temp)){
                    if(temp.esFinal())
                        return g;
                    if(!temp.igualA(b.getPadre())){
                        listaMalos.add(temp);
                    }
                }
            }
            listaTemp.removeAll(listaMalos);
            g.add(b, listaTemp);
            pendientes.addAll(listaTemp);
        }
        //return g;
    }




    

}
