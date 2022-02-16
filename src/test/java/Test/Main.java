package Test;

import com.misioneros_canibales.Arbol.Nodo;
import com.misioneros_canibales.Grafo.Barco;
import com.misioneros_canibales.Grafo.Grafo;
import static com.misioneros_canibales.MyC.generarExpansionMyC;

/**
 *
 * @author poncho
 */
public class Main {
    final static Barco estadoInicial = new Barco(3, 3, 0, 0, false, null);
    final static Barco estadoFinal = new Barco(0, 0, 3, 3, true, null);
    public static void main(String[] args){
        
        Grafo g = generarExpansionMyC(estadoInicial);
        System.out.println(g);
        g.DFS(estadoInicial, estadoFinal);
    } 
}
