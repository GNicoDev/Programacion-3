package ejercicio4;

import tree.Tree;
import tree.TreeNode;

/*
* Ejercicio 4
Se posee un árbol binario (no de búsqueda), donde los nodos internos están vacíos, mientras
que las hojas tienen valores enteros. Se debe implementar un método que recorra el árbol y
coloque valores en los nodos vacíos (los nodos internos). El valor de cada nodo interno debe ser
igual al valor de su hijo derecho, menos el valor de su hijo izquierdo. En caso de que el nodo
tenga un solo hijo, el valor del hijo faltante se reemplaza por un 0. Por ejemplo, tomando como
entrada el árbol de la izquierda, el árbol resultante debería quedar con los mismos valores que el
de la derecha.
*
* FUNCION completarValores(nodo)
    IF nodo == NULL
        RETURN

    // Procesar los hijos primero (recorrido postorder)
    completarValores(nodo.izquierdo)
    completarValores(nodo.derecho)

    // Si el nodo es interno (no hoja), calcular su valor
    IF nodo NO ES hoja
        IF nodo.izquierdo == NULL
            nodo.dato = nodo.derecha.dato;
        ELSE IF nodo.derecha == NULL
            nodo.dato = - nodo.izquierda.dato
        ELSE
            nodo.dato = nodo.derecho.dato - nodo.izquierdo.dato
* */
public class Ejercicio4 {
   public void completaValores (TreeNode<Integer> raiz){
        if (raiz == null) {
            return;
        }
        completaValores(raiz.left);
        completaValores(raiz.right);
        if (raiz.left != null || raiz.right != null) {
            if (raiz.left == null) {
                raiz.data = (Integer) raiz.right.data;
            } else if (raiz.right == null) {
                raiz.data = (Integer) raiz.left.data * -1;
            }
            else
                raiz.data = (Integer) raiz.right.data - (Integer) raiz.left.data;

        }
    }

}
