package ejercicio3;
/*
*
* Dado un árbol binario de búsqueda que almacena números
enteros y un valor de entrada K, implementar un algoritmo
que permita obtener un listado con los valores de todas las
hojas cuyo valor supere K. Por ejemplo, para el árbol de la
derecha, con un valor K = 8, el resultado debería ser [9, 11]. */


import java.util.ArrayList;
import java.util.List;
import tree.TreeNode;

public class Ejercicio3 {
    public List<Integer> devolverValoresMayoresA(TreeNode<Integer> raiz, int k) {
        List<Integer> valores = new ArrayList<Integer>();
        if (raiz==null)
            return valores;
        else
            buscarRecursivo(raiz, k, valores);
        return valores;
    }

    private void buscarRecursivo(TreeNode<Integer> nodo, int k, List<Integer> valores) {
        if (nodo == null)
            return;

        // Si es hoja y su valor es mayor a K, agregarlo
        if (nodo.left == null && nodo.right == null && nodo.getData() > k) {
            valores.add(nodo.getData());
        }

        buscarRecursivo(nodo.left, k, valores);
        buscarRecursivo(nodo.right, k, valores);
    }

}
