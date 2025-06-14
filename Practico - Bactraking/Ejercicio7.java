/*
* Ejercicio 7
Tablero mágico. Dado un tablero de tamaño n x n, construir un algoritmo que ubique (si es posible)
n*n números naturales diferentes, entre 1 y un cierto k (con k>n*n), de manera tal que la suma de las
columnas  y de las filas sea igual a S.
*
* estado -> matriz de n x n = 2x2
* S = 6
* k = {1,2,3,4,5,6}
*
* backtrack(indiceK,j,estado, arregloK,solucionEncontrada)
*   if (tableroCompletado(estado) && !solucionEncontrada)
*       if (esSolucion(estado,S)
*           solucionEncontrada = true
*   else{
*       Integer k = arregloK.get(indiceK)
*       //por cada casillero de la matriz estado le corresponde el k,
*       foreach(fila : estado)
*           if (j < n)
*               estado[j] = k
*               backTrak(inidceK+1, j +1, estado)
*           else
*               backTrack(indiceK, 0, estado)
*           //vuelvo atras el estado
*           estado¨[j] = null
*   }
* */
public class Ejercicio7 {
}
