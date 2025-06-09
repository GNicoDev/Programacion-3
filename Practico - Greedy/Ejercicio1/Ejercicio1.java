package Ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
*  Ejercicio 1
 Cambio de monedas: Dado un conjunto C de N tipos de monedas con un número ilimitado de
 ejemplares de cada tipo, se requiere formar, si se puede, una cantidad M empleando el mínimo
 número de ellas.
 Por ejemplo, un cajero automático dispone de billetes de distintos valores: 100$, 25$, 10$, 5$ y 1$,
 si se tiene que pagar 289$, la mejor solución consiste en dar 10 billetes: 2 de 100$, 3 de 25$, 1 de
 10$ y 4 de 1$.
* */
public class Ejercicio1 {
public List<Integer> greedy(Set<Integer> C, int M) {
    Integer m = M;
    List<Integer> S = new ArrayList<>();
    while (!solucion(S,M)){
        Integer elemnt = seleccionar(C,m);
        if (factible(elemnt,S,M)) {
            m-=elemnt;
            S.add(elemnt);
        }
    }
    return S;

}

    private boolean factible(Integer elemnt, List<Integer> s, Integer m) {
        int sum = 0;
        for (Integer elem : s){
            sum += elem;
        }
        return sum + elemnt <= m;
    }

    private Integer seleccionar(Set<Integer> c, Integer m) {
        int mejorSeleccion = 0;
        for (Integer i : c) {
            if (i>mejorSeleccion && i<= m){
                mejorSeleccion = i;
            }
        }
        m-=mejorSeleccion;
        return mejorSeleccion;
    }

    private boolean solucion(List<Integer> s, int m) {
        int sum = 0;
        for (Integer elemnt : s) {
            sum += elemnt;
        }
        return sum == m;
    }
}
