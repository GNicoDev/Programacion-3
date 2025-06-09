package Ejercicio1;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        int M = 289;
        Set<Integer> set = new TreeSet<Integer>();
        set.add(1);
        set.add(5);
        set.add(10);
        set.add(25);
        set.add(100);


        Ejercicio1 ejercicio1 = new Ejercicio1();
        List<Integer> solucion = ejercicio1.greedy(set, M);
        System.out.println(solucion);
    }
}
