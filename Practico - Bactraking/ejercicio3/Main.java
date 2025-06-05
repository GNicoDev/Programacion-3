package ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> conjunto = new ArrayList<Integer>();
        conjunto.add(1);
        conjunto.add(2);
        conjunto.add(3);

        Ejercicio3 ejercicio3 = new Ejercicio3();
        ejercicio3.Backtracking(conjunto,5);


        for (List<Integer> solucionParcial : ejercicio3.solucion) {
            System.out.print("Solucion Parcial: [" );
           for (int x = 0; x < solucionParcial.size(); x++) {
               if (solucionParcial.get(x) == 1) {
                   System.out.print(conjunto.get(x));
               }
               if (x < solucionParcial.size() - 1 && solucionParcial.get(x) != 0) {
                   System.out.print(", ");
               }
           }
           System.out.print("]");
            System.out.println();
        }
    }
}
