package ejercicio3;
import java.util.*;
public class GrowingSeparateChainingHashTable<Integer, T> {
    private LinkedList<Nodo<Integer,T>>[] tabla;
    private int cantidadElementosInsertados;
    private int M;
    private final double factorDeCarga = 0.9;

    public GrowingSeparateChainingHashTable(int M) {
        this.M = M;
        tabla = new LinkedList[M];
        for (int i = 0 ; i < M; i++) {
            tabla[i] = new LinkedList<>();
        }
        cantidadElementosInsertados = 0;
    }

    public int hash(Integer key) {
        return (int)key % M;
    }

    public void insertar(Integer key, T value) {
        if ((double)(cantidadElementosInsertados/M) >= factorDeCarga) {
            reinsertarElementos();
        }
        int indice = hash(key);
        Nodo nuevoNodo = new Nodo(key,value);
        tabla[indice].add(nuevoNodo);
        cantidadElementosInsertados++;
    }

    private void reinsertarElementos() {
        int nuevaCapacidad = M*2;
        System.out.println("La nueva capacidad de la tabla es: " + nuevaCapacidad);
        LinkedList<Nodo<Integer,T>>[] nuevaTabla = new LinkedList[nuevaCapacidad];
        for (int i = 0; i < nuevaCapacidad; i++) {
            nuevaTabla[i] = new LinkedList<>();
        }
        for (LinkedList<Nodo<Integer, T>> balde : tabla) {
            for (Nodo<Integer, T> nodo : balde) {
               int indice = hash(nodo.key);
               nuevaTabla[indice].add(nodo);
            }
        }
        M = nuevaCapacidad;
        tabla = nuevaTabla;
    }

    public T obtenerElemento(Integer key) {
        int indice = hash(key);
        for (Nodo<Integer, T> nodo : tabla[indice]) {
            if (nodo.key.equals(key)) {
                return nodo.value;
            }
        }
        return null; // Si no se encuentra
    }

    public LinkedList<Nodo<Integer,T>>[] getTableCopia() {
        LinkedList<Nodo<Integer,T>>[] copia = new LinkedList[tabla.length];
        for (int i = 0; i < tabla.length; i++) {
            copia[i] = new LinkedList<>(tabla[i]);
        }
        return copia;
    }

    public void showValue(Integer key) {
        int indice = hash(key);
        T value = obtenerElemento(key);
        System.out.println(value);
    }

    public int obtenerTamanioTabla(){
        return M;
    }

}
