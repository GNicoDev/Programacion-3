package extras;
/*
* Problema: El laberinto y la salida
📌 Dado un laberinto representado por una matriz, donde:
✅ 0 indica un camino transitable.
✅ 1 indica una pared (no se puede pasar).
✅ Hay un inicio (0,0) y una meta (N-1, M-1).
📌 Encuentra un camino desde el inicio hasta la meta usando backtracking
*
                0 0 1 0 0
                1 0 1 1 0
                0 0 0 1 0
                0 1 0 0 0
                0 0 0 1 0

* Estructura de la solucion es otra matriz de n*m con sus celdas en null
*
* Backtracking(estado e, laberinto i,j , solucionEncontrada )
  if (solucion(e) && !solucionEncontrada) // solucion es si llegamos a la meta en ese momento
        solucionEncontrada = true
  else
     foreach posicion posible (es decir i+1, i-1, j+1, j-1 siempre y cuando el valor en esa posicion del laberinto no sea 1)
*      if (i+1 < n)
         if (laberinto[i][j] != 1)
*           e[i][j] = visitado
            backtracking(e, laberinto, i+1,j, solucionEncontrada)


* */
public class extra1 {
}
