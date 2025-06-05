package ejercicio3;

import grafo.Grafo;

import java.util.ArrayList;
import java.util.List;

//Ejercicio 3
//Suma de subconjuntos. Dados n números positivos distintos, se desea encontrar todas las
//combinaciones de esos números tal que la suma sea igual a M.
public class Ejercicio3 {
    public static List<List<Integer>> solucion = new ArrayList<>();

    public List<List<Integer>> Backtracking(List<Integer> conjunto, int M) {
        List<Integer> solucionParcial = new ArrayList<>();
        explorar(0,M,conjunto,solucionParcial);

      return solucion;
    }


    private void explorar(int indice, int m, List<Integer> conjunto, List<Integer> solucionParcial) {
        System.out.println("Parcial: " + solucionParcial);
        if (indice == conjunto.size()) {
            if (esSolucion(solucionParcial,conjunto,m))
                solucion.add(new ArrayList<>(solucionParcial));
            return;
        }
            solucionParcial.add(1);
            explorar(indice+1,m,conjunto,solucionParcial);
            solucionParcial.removeLast();
            solucionParcial.add(0);
            explorar(indice+1,m,conjunto,solucionParcial);
            solucionParcial.removeLast();
    }



    private boolean esSolucion(List<Integer> solucionParcial, List<Integer> conjunto, int M) {
        int suma = 0;
        for (int i = 0; i < solucionParcial.size(); i++) {
            if (solucionParcial.get(i) == 1) {
                suma += conjunto.get(i); // Sumamos los elementos activados con '1'
            }
        }
        return suma == M;
    }



}
