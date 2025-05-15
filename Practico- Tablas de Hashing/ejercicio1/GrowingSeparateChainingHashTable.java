package ejercicio1;

import java.util.*;

public class GrowingSeparateChainingHashTable {
    private LinkedList<Integer>[] table;
    private int size; // cantidad de elementos insertados
    private int M;
    private final double loadFactorThreshold = 0.9;

    public GrowingSeparateChainingHashTable() {
        this.M = 7;
        this.table = new LinkedList[M];
        for (int i = 0; i < M; i++) {
            table[i] = new LinkedList<>();
        }
        this.size = 0;
    }

    private int hash(int x) {
        return x % M;
    }

    public void insert(int x) {
        if ((double)(size + 1) / M > loadFactorThreshold) {
            resize();
        }
        int index = hash(x);
        table[index].add(x);
        size++;
    }

    public int getIndex(int x) {
        return hash(x);
    }

    private void resize() {
      //  int newCapacity = nextPrime(M * 2);
        int newCapacity = M * 2;
        System.out.println("Resizing from " + M + " to " + newCapacity);
        LinkedList<Integer>[] newTable = new LinkedList[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            newTable[i] = new LinkedList<>();
        }

        for (LinkedList<Integer> bucket : table) {
            for (int x : bucket) {
                int newIndex = x % newCapacity;
                newTable[newIndex].add(x);
            }
        }

        table = newTable;
        M = newCapacity;
    }

    private int nextPrime(int n) {
        while (!isPrime(n))
            n++;
        return n;
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2)
            if (n % i == 0) return false;
        return true;
    }

    public void printTable() {
        System.out.println("Hash table with capacity = " + M);
        for (int i = 0; i < M; i++) {
            System.out.print("[" + i + "] -> ");
            for (int x : table[i]) {
                System.out.print(x + " → ");
            }
            System.out.println("null");
        }
    }

}

