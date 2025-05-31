package Ejercicio2;

public class Main {
    public static void main(String[] args) {
        ObjetoLaberinto[][] laberinto = new ObjetoLaberinto[2][2];

        laberinto[0][0] = new ObjetoLaberinto(1, false, true, true, false);
        laberinto[0][1] = new ObjetoLaberinto(3, false, true, false, true);
        laberinto[1][0] = new ObjetoLaberinto(2, true, false, true, false);
        laberinto[1][1] = new ObjetoLaberinto(1, true, false, false, true);

        // [0][0] → [0][1]
        //   ↓         ↓      Yendo por el este, valorMinimo = 5
        // [1][0] → [1][1]    Yendo por el sur, valorMinimo = 4
        Ejercicio2 e2 = new Ejercicio2();
        int minimo = e2.buscarCaminoMinimo(laberinto, 0, 0, 1, 1);
        System.out.println("Camino mínimo: " + minimo);
    }
}
