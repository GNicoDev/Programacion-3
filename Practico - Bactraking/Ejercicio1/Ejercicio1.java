package Ejercicio1;


import grafo.Grafo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ejercicio1 {
    public List<Integer> Backtracking(Grafo<String> grafo,int origen, int destino) {
        List<Integer> mejorCamino = new ArrayList<>();
        List<Integer> caminoActual = new ArrayList<>();
        backtrack(grafo,origen,destino,caminoActual,mejorCamino);
        return mejorCamino;
    }

    private void backtrack(Grafo<String> grafo, int origen, int destino, List<Integer> caminoActual, List<Integer> mejorCamino) {
        caminoActual.add(origen);
        if (esSolucion(caminoActual,destino)){
            if(mejorCamino.size() < caminoActual.size()){
                mejorCamino.clear();
                mejorCamino.addAll(caminoActual);
            }
        }
        else{
            Iterator<Integer> it = grafo.obtenerAdyacentes(origen);
            while (it.hasNext()) {
                int element = it.next();
                if (!caminoActual.contains(element)) {
                    backtrack(grafo,element,destino,caminoActual,mejorCamino);
                }
            }
        }

    }

    private boolean esSolucion(List<Integer> caminoActual, int destino) {
        int elem = caminoActual.getLast();
        return elem == destino;
    }
}
