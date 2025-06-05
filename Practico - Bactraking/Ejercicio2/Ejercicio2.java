package Ejercicio2;

//Ejercicio 2
//Dado un laberinto consistente en una matriz cuadrada que tiene en cada posición un valor natural y
//cuatro valores booleanos, indicando estos últimos si desde esa casilla se puede ir al norte, este, sur
//y oeste, encontrar un camino de longitud mínima entre dos casillas dadas, siendo la longitud de un
//camino la suma de los valores naturales de las casillas por las que pasa. Idea: podría representarse
//el laberinto como una matriz, de objetos, donde cada objeto tiene el valor natural, y cuatro
//booleanos, uno para cada dirección a la que se permite ir desde allí.
public class Ejercicio2 {

    private int valorMinimo;

    public int buscarCaminoMinimo(ObjetoLaberinto[][] laberinto, int inicioX, int inicioY, int finX, int finY) {
        valorMinimo = Integer.MAX_VALUE;
        int valorActual = 0;
        boolean[][] visitados = new boolean[laberinto.length][laberinto[0].length];
        backtrack(laberinto, inicioX, inicioY, finX, finY, valorActual, visitados);
        return valorMinimo;
    }
// Suponiendo que x se mueve en el sentido de las filas e Y en el sentido de las columnas
// Debemos abanzar segun el estado de la celda, es decir:
// si Norte=true -> (x-1,y),
//    Sur=true   -> (x+1,y)
//    Este=true  -> (x,y+1),
//    Oeste=true -> (x,y-1)

    private void backtrack(ObjetoLaberinto[][] laberinto, int x, int y, int finX, int finY,
                           int valorActual, boolean[][] visitados) {

        if (x < 0 || y < 0 || x >= laberinto.length || y >= laberinto[0].length || visitados[x][y]) {
            return;
        }

        valorActual += laberinto[x][y].getValor();

        if (valorActual >= valorMinimo) return; //poda

        if (esSolucion(x, y, finX, finY)) {
            valorMinimo = valorActual;
            return;
        }

        visitados[x][y] = true;

        ObjetoLaberinto celda = laberinto[x][y];

        if (celda.getNorte()) backtrack(laberinto, x - 1, y, finX, finY, valorActual, visitados);
        if (celda.getSur())   backtrack(laberinto, x + 1, y, finX, finY, valorActual, visitados);
        if (celda.getEste())  backtrack(laberinto, x, y + 1, finX, finY, valorActual, visitados);
        if (celda.getOeste()) backtrack(laberinto, x, y - 1, finX, finY, valorActual, visitados);

        visitados[x][y] = false;
    }

    private boolean esSolucion(int x, int y, int finX, int finY) {
        return x == finX && y == finY;
    }
}
