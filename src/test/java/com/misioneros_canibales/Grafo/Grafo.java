package com.misioneros_canibales.Grafo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Estructura de datos simple que representa un grafo dirigido
 * @author poncho
 */
public class Grafo<T> { //T = tipo de las aristas
    private HashMap<T, ArrayList<T>> listaAdyacencia;
    private boolean esDirigido;

    private ArrayList<T> listaVertices;

    public Grafo(boolean esDirigido) {
        this.esDirigido = esDirigido;
        listaAdyacencia = new HashMap<T, ArrayList<T>>();
        listaVertices = new ArrayList<T>();
    }
    /**
    *    Agrega un nuevo vertice de tipo T al grafo
    */
    public void add(T vertice, ArrayList<T> verticesConectados) {
        if(verticesConectados.isEmpty()) // si la lista de vertices está vacía, termina
            return;
        // Aniade el nueuvo vertice a la listaAdyacencia con la que se 
        // conectan sus nodos
        listaAdyacencia.put(vertice, verticesConectados);
        listaVertices.add(vertice);

        for (T verticeConectadoAlVertAgregado : verticesConectados) {
                ArrayList<T> listaConectada = listaAdyacencia
                                .get(verticeConectadoAlVertAgregado);
                // Las conexiones del vertice pueden no estar representadas 
                //en el grafo aun, asi que se aniaden implicitamente
                if (listaConectada == null) {
                        listaAdyacencia.put(verticeConectadoAlVertAgregado,
                                        new ArrayList<T>());
                        listaVertices.add(verticeConectadoAlVertAgregado);
                        listaConectada = listaAdyacencia
                                        .get(verticeConectadoAlVertAgregado);
                }
                if (!esDirigido) {
                    // The weight from one vertex back to another in an undirected
                    // graph is equal
                    listaConectada.add(vertice);
                }
        }
    }

    public boolean addArco(T source, T end) {
        if(!esDirigido){
            return false;
        }
        if (!listaAdyacencia.containsKey(source)) {
                ArrayList<T> tempList = new ArrayList<T>();
                tempList.add(end);
                add(source, tempList);
                return true;
        }
        if (!listaAdyacencia.containsKey(end)) {
                ArrayList<T> tempList = new ArrayList<T>();
                add(end, tempList);
        }
        listaAdyacencia.get(source).add(end);
        return true;
    }

    public boolean addArista(T verticeOne, T verticeTwo) {
        if(esDirigido)
            return false;
        if (!listaAdyacencia.containsKey(verticeOne)) {
                ArrayList<T> tempList = new ArrayList<T>();
                tempList.add(verticeTwo);
                add(verticeOne, tempList);
                return true;
        }

        if (!listaAdyacencia.containsKey(verticeTwo)) {
                ArrayList<T> tempList = new ArrayList<T>();
                tempList.add(verticeOne);
                add(verticeTwo, tempList);
                return true;
        }

        listaAdyacencia.get(verticeOne).add(verticeTwo);
        listaAdyacencia.get(verticeTwo).add(verticeOne);
        return true;
    }

    public ArrayList<T> getVerticesAdyacentes(T vertice){
            ArrayList<T> listaRetorno = new ArrayList<T>();
            for (T arista : listaAdyacencia.get(vertice)) {
                    listaRetorno.add(arista);
            }
            return listaRetorno;
    }

    public ArrayList<T> getVertexList() {
            return listaVertices;
    }

    public boolean existeEnGrafo(T vertice){
        if(vertice == null)
            return false;
        for(T temp: listaVertices){
            if(temp.equals(vertice))
                return true;
        }
        return false;
    }

    public boolean eliminarRepetidos() {
        ArrayList<T> repetidos = new ArrayList<T>();
        for(int i = 0; i<listaVertices.size()-1; i++){
            if(listaVertices.get(i).equals(listaVertices.get(i+1))){
                listaVertices.remove(i);
            }
        }
        return !repetidos.isEmpty();
    }

    public String toString() {
            String s = "";
            for (T vertice : listaVertices) {
                    s += vertice;
                    s += " : ";
                    s += listaAdyacencia.get(vertice);
                    s += "\n";
            }
            return s;
    }

}