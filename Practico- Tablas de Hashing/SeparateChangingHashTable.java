import java.util.*;

public class SeparateChangingHashTable<K, V> {

    private LinkedList<Integer>[] tabla;
    private int M;

    public SeparateChangingHashTable(int M) {
        tabla = new LinkedList[M];
        for (int i = 0; i < M; i++) {
            tabla[i] = new LinkedList<>();
        }
        this.M = M;
    }
    private int hash(int x) {
        return x % M;
    }

    public void insert(int x) {
        int index = hash(x);
        tabla[index].add(x);
    }

    public int getIndex(int x) {
        return hash(x);
    }

    public void display() {
        System.out.println("Tabla de hashing (Separado) con M = " + M + ":");
        for (int i = 0; i < M; i++) {
            System.out.print("[" + i + "] -> ");
            for (int valor : tabla[i]) {
                System.out.print(valor + " → ");
            }
            System.out.println("null");
        }
    }

}





