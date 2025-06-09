package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int pesoMochila = 7;
        List<ObjetoMochila> objetosMochila = new ArrayList<ObjetoMochila>();
        objetosMochila.add(new ObjetoMochila(2,15));
        objetosMochila.add(new ObjetoMochila(5,25));
        objetosMochila.add(new ObjetoMochila(4,30));
        objetosMochila.add(new ObjetoMochila(1,20));
        objetosMochila.add(new ObjetoMochila(3,28));

        Ejercicio2 ejercicio2 = new Ejercicio2();
        List<ObjetoMochila> mochila = ejercicio2.greedy(objetosMochila, pesoMochila);
        for (ObjetoMochila obj : mochila) {
            System.out.println("(" +obj.getPeso() + ", " + obj.getValor() + ")");
        }
    }
}
