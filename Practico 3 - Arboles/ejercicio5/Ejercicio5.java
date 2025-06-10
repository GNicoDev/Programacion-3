package ejercicio5;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
* Ejercicio 5
Dado un árbol binario donde todos los nodos poseen un carácter, de manera que cada rama del
árbol contiene una palabra, implementar un algoritmo que busque y retorne todas las palabras
que posea exactamente N vocales (ni más ni menos). Por ejemplo, para el siguiente árbol, con
una entrada de N = 1, el algoritmo debería retornar [“MAL”]. En cambio, para un N = 2, debería
retornar [“MANA”, “MANO”, “MISA”, “MIO”].
*
* En este caso podemos hacer un recorrido pre-order


* buscarPalabras(raiz,solucion, palabra, n, N)

    if (raiz == null)
       reutrn

    palabra+= raiz.dato
    if (esVocal(raiz.dato))
        n++;

    if esHoja(raiz) AND n==N
       solucion.add(palabra)

    buscarPalabras(raiz.left,solucion,n,N)
    buscarPalabras(raiz.right,solucion, palabra,n,N)

* */
public class Ejercicio5 {
    public List<String> buscarPalabras(TreeNode<Character> raiz, int N) {
        List<String> solucion = new ArrayList<>();
        buscarRecursivo(raiz, solucion, "", 0, N);
        return solucion;
    }

    private void buscarRecursivo(TreeNode<Character> nodo, List<String> solucion, String palabra, int n, int N) {
        if (nodo == null) return;

        palabra += nodo.data;
        if (esVocal(nodo.data)) n++;

        if (esHoja(nodo) && n == N) {
            solucion.add(palabra);
        }

        buscarRecursivo(nodo.left, solucion, palabra, n, N);
        buscarRecursivo(nodo.right, solucion, palabra, n, N);
    }
    private boolean esVocal(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    private boolean esHoja(TreeNode nodo) {
        return nodo.left == null && nodo.right == null;
    }


}
