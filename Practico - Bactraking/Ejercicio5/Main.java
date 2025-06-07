package Ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int M = 3; //numero de procesadores
        ArrayList<Integer> tareas = new ArrayList<>();
        tareas.add(1);
        tareas.add(2);
        tareas.add(3);
        tareas.add(7);
        tareas.add(4);


        Ejercicio5 ejercicio5 = new Ejercicio5();
        List<Procesador> solucion = ejercicio5.backTracking(tareas, M);
        for (Procesador p : solucion) {
            System.out.print(" Procesador " + p.getNombre() + "->" + p.getTareas());
            System.out.println();
        }
    }
}
