package Ejercicio1;

import grafo.Grafo;
import grafo.GrafoDirigido;

import java.util.List;

/*Generalmentelos algoritmostienenun planteorecursivocon la
siguienteestructurabásica

*
*  Backtraking (estado e)
 {
    Condición de Corte:
        ¿e es una posible solución?
        SI:
              operar con la solución
              Ej.: fijarse si es la mejor hasta el momento, o
                   agregarla a una lista de soluciones, o
                   imprimir, etc ,etc
        NO:
               Para cada hijo c del estado actual e:
                        Backtraking(c) /// EXPLORAR recursivamente a partir de c
 }

* */
public class Main {
    public static void main(String[] args) {
        Grafo<String> habitaciones = new GrafoDirigido<>();
        habitaciones.agregarVertice(0);
        habitaciones.agregarVertice(1);
        habitaciones.agregarVertice(2);
        habitaciones.agregarVertice(3);
        habitaciones.agregarVertice(4);
        habitaciones.agregarVertice(5);
        habitaciones.agregarVertice(6);
        habitaciones.agregarVertice(7);
        habitaciones.agregarVertice(8);
        habitaciones.agregarVertice(10);
        habitaciones.agregarArco(0,1,null);
        habitaciones.agregarArco(0,2,null);
        habitaciones.agregarArco(1,4,null);
        habitaciones.agregarArco(1,6,null);
        habitaciones.agregarArco(2,3,null);
        habitaciones.agregarArco(3,8,null);
        habitaciones.agregarArco(4,7,null);
        habitaciones.agregarArco(5,4,null);
        habitaciones.agregarArco(5,7,null);
        habitaciones.agregarArco(6,5,null);
        habitaciones.agregarArco(7,3,null);
        habitaciones.agregarArco(8,7,null);
        habitaciones.agregarArco(8,10,null);

        Ejercicio1 ejercicio1 = new Ejercicio1();
        List<Integer> solucion = ejercicio1.Backtracking(habitaciones,0,10);
        imprimir(solucion);
    }

    private static void imprimir(List<Integer> solucion) {
        for (int i = 0; i < solucion.size(); i++) {
            if (i == solucion.size() - 1) {
                System.out.println(solucion.get(i));
            }
            else
                System.out.print(solucion.get(i) + " -> ");
        }
    }
}
