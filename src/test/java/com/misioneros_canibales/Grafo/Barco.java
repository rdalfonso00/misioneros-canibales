package com.misioneros_canibales.Grafo;

import java.util.ArrayList;

/**
 *
 * @author poncho
 */
public class Barco {
    final static int N = 3; // numero de canibales-misioneros totales
    private int numCanibales, numMisioneros, numCanibalesBarco, numMisionerosBarco;
    private boolean estadoBarco;
    private Barco padre;

    public Barco(int numCanibales, int numMisioneros, int numCanibalesBarco, int numMisionerosBarco, boolean estadoBarco, Barco padre) {
        this.numCanibales = numCanibales;
        this.numMisioneros = numMisioneros;
        this.numCanibalesBarco = numCanibalesBarco;
        this.numMisionerosBarco = numMisionerosBarco;
        this.estadoBarco = estadoBarco;
        this.padre = padre;
    }

    /**
     *
     * @return
     */
    public boolean esValido(){
        if((numMisioneros != 0) && (numMisioneros != N)){
            return numMisioneros == numCanibales;
        }else if(numMisioneros > N || numCanibales > N || numMisioneros < 0 || numCanibales < 0)
            return false;
        return true;
    }
    
    public boolean esFinal(){
        return (numCanibales == 0) && (numMisioneros==0) && (numCanibalesBarco==0) && (numMisionerosBarco==0) && estadoBarco;
    }

    /**
     *
     * @param barcoInicial
     * @return
     */
    public static ArrayList<Barco> generarSucesores(Barco barcoInicial){
        ArrayList<Barco> lista = new ArrayList<>();
        int nMisioneros, nCanibales;
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++){
                if(i == 0 && j == 0)
                    continue;
                if(i+j > 2)
                    break;
                nMisioneros = i;
                nCanibales = j;
                int dirBarco = barcoInicial.getEstadoBarco() ? 1 : -1;
                /*Barco bTemp = new Barco(barcoInicial.getNumCanibales()-j*dirBarco, 
                                barcoInicial.getNumMisioneros()-i*dirBarco, 
                                N-barcoInicial.getNumCanibales()+j*dirBarco, 
                                N-barcoInicial.getNumMisioneros()+i*dirBarco, 
                                !barcoInicial.getEstadoBarco(), barcoInicial);
                */
                Barco bTemp = new Barco(barcoInicial.getNumCanibales()+nCanibales*dirBarco, 
                                barcoInicial.getNumMisioneros()+nMisioneros*dirBarco, 
                                N-(barcoInicial.getNumCanibales()+nCanibales*dirBarco), 
                                N-(barcoInicial.getNumMisioneros()+nMisioneros*dirBarco), 
                                !barcoInicial.getEstadoBarco(), barcoInicial);
                if(bTemp.esValido())
                    lista.add(bTemp);
            }
        }
        return lista;
    }
    public Barco getPadre(){
        return this.padre;
    }

    public int getNumCanibales() {
        return numCanibales;
    }

    public void setNumCanibales(int numCanibales) {
        this.numCanibales = numCanibales;
    }

    public int getNumMisioneros() {
        return numMisioneros;
    }

    public void setNumMisioneros(int numMisioneros) {
        this.numMisioneros = numMisioneros;
    }

    public int getNumCanibalesBarco() {
        return numCanibalesBarco;
    }

    public void setNumCanibalesBarco(int numCanibalesBarco) {
        this.numCanibalesBarco = numCanibalesBarco;
    }

    public int getNumMisionerosBarco() {
        return numMisionerosBarco;
    }

    public void setNumMisionerosBarco(int numMisionerosBarco) {
        this.numMisionerosBarco = numMisionerosBarco;
    }

    public String toString(){
        String dir;
        if(estadoBarco == true)
            dir = "->";
        else
            dir = "<-";
        return numMisioneros + "-M " + numCanibales + "-C "+ dir +" R: " + 
        numMisionerosBarco + "-M " + numCanibalesBarco + "-C";
    }

    public boolean igualA(Barco b){
        if(b == null){
            return false;
        }
        return numMisioneros==b.getNumMisioneros() && numCanibales==b.getNumCanibales() && numMisionerosBarco==b.getNumMisionerosBarco() && numCanibalesBarco==b.numCanibalesBarco;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Barco b = (Barco) obj;
        return numMisioneros==b.getNumMisioneros() && numCanibales==b.getNumCanibales() && numMisionerosBarco==b.getNumMisionerosBarco() && numCanibalesBarco==b.getNumCanibalesBarco() && estadoBarco==b.getEstadoBarco();
    }

    private boolean getEstadoBarco() {
        return this.estadoBarco;
    }
}
