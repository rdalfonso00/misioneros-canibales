package com.misioneros_canibales.Arbol;

import java.util.ArrayList;
import java.util.List;

/**
 * Estructura básica de un árbol definida de forma recursiva a partir de un nodo
 * @author poncho
 */
public class Nodo<T> {
    private T dato = null;
 
    private List<Nodo<T>> hijos = new ArrayList<>();

    private Nodo<T> parent = null;

    public Nodo(T dato) {
        this.dato = dato;
    }    
    public Nodo() {}

    public Nodo<T> addHijo(Nodo<T> hijo) {
        hijo.setPadre(this);
        this.hijos.add(hijo);
        return hijo;
    }

    public void addHijos(List<Nodo<T>> hijos) {
        hijos.forEach(each -> each.setPadre(this));
        this.hijos.addAll(hijos);
    }

    public List<Nodo<T>> getHijos() {
        return hijos;
    }

    public T getData() {
        return dato;
    }

    public void setData(T dato) {
        this.dato = dato;
    }

    private void setPadre(Nodo<T> parent) {
        this.parent = parent;
    }

    public Nodo<T> getPadre() {
        return parent;
    }

    /**
     * Imprime la estructura de un arbol partiendo de nodo de forma recursiva
     * @param nodo nodo inicial
     */
    public static void imprimirArbol(Nodo nodo, String conector){
        System.out.println(conector + nodo.getData());
        nodo.getHijos().forEach(hijo -> imprimirArbol(nodo, conector + conector));
    }


}
