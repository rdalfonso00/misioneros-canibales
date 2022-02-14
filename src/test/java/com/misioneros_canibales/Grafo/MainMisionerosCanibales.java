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
    final static Barco solucion = new Barco(0, 0, 3, 3, true, null);

    public static void main(String[] args){
        
        Grafo g = generarExpansionMyC(estadoInicial);
        System.out.println(g);
    }

    public static Grafo generarExpansionMyC(Barco barcoInicial){
        boolean fin = false;
        //Barco temp = barcoInicial;
        ArrayList<Barco> listaTemp, listaMalos = new ArrayList<>();
        Grafo g = new Grafo(false);
        Queue<Barco> pendientes = (Queue<Barco>) new LinkedList<Barco>();
        pendientes.add(barcoInicial);
        while(true){
            if(pendientes.isEmpty()){ //cuando dejen de haber ramas por explorar, termina la expansion
                System.out.println("No hubo fin");
                return g;
            }
            Barco b = pendientes.poll();
            listaTemp = Barco.generarSucesores(b);
            for (Barco temp : listaTemp) { // agregar sucesores  a la estructura y a los pendientes por explorar
                //if(!pendientes.contains(temp)){
                    if(temp.equals(solucion)){
                        System.out.println("Si hubo fin :)");
                        fin = true;
                    }
                    if(temp.equals(b.getPadre()) || g.existeEnGrafo(temp)){
                        listaMalos.add(temp);
                    }
                //}
            }
            listaTemp.removeAll(listaMalos);
            listaMalos.clear();
            if(!listaTemp.isEmpty()){
                g.add(b, (ArrayList<Barco>) listaTemp.clone());
                pendientes.addAll(listaTemp);
            }
            listaTemp.clear();
            if(fin){
                g.eliminarRepetidos(); //esto todavia no sé como evitarlo, pero es un fix facil
                return g;
            }
        }
        //return g;
    }




    

}
