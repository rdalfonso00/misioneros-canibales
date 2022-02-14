package com.misioneros_canibales.Grafo;

import java.util.ArrayList;

/**
 *
 * @author poncho
 */
public class Test1 {
    public static void main(String [] args){
        Grafo<String> g1 = new Grafo<>();
        ArrayList<String> connected = new ArrayList<>();
        connected.add("B");
        connected.add("C");
        connected.add("D");
        g1.add("A", connected);

        g1.addArco("C", "B");

        g1.addArco("Z", "F");

        g1.addArco("Z", "R");

        g1.addArco("D", "Z");

        g1.addArco("F", "D");

        g1.addArco("W", "L");

        System.out.println(g1.toString());
}
}
