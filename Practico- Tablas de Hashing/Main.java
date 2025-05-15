public class Main {
    public static void main(String[] args) {
        //Ejercicio 1
        int M = 7; // Tamaño de la tabla
        int[] elements = {68, 42, 47, 5, 76, 95, 23, 88, 90, 85, 31, 71, 60, 10, 46, 61, 50, 92, 74, 6, 97, 66, 1, 56, 27, 7, 14, 92};

        SeparateChangingHashTable hashTableS = new SeparateChangingHashTable(M);
        GrowingSeparateChainingHashTable GSCHashTable = new GrowingSeparateChainingHashTable();

        /*
        for (int elem : elements) {
            hashTableS.insert(elem);
        }
        hashTableS.display();
        */

        for (int elem : elements) {
            GSCHashTable.insert(elem);
        }
        GSCHashTable.printTable();
        int x = elements[0];
        System.out.println("The position of the element is: " + GSCHashTable.getIndex(x));
    }
}
