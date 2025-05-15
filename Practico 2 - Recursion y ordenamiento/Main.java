public class Main {
    final static int N = 10;
    public static void main(String[] args) {
       // int[] array = {7, 2, 9, 1, 6, 10, 4, 8, 3, 5};
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(isOrder(array,0));
        System.out.println();
        System.out.println("Buscar elemento 10. Esta? : posicion = " + isElemnt(array,10, 0,N-1));
        System.out.println();
        System.out.println("El numero binario de 26 es: " + binaryNumber(26));
        System.out.println();
        int n = 10;
        System.out.println("Los primeros" + n + " numeros de la secuencia fibonaci son: " + fibonacciSequence(n,0,1));
    }



    /* EJERCICIO 1 : Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está
    ordenado y responda:
1. ¿Qué complejidad O tiene? (La complejidad en el peor caso)
2. ¿Trae algún problema hacerlo recursivo? ¿Cuál?
3. ¿Qué cambiaría si la estructura fuera una lista en lugar de un arreglo?

    Complejidad O(N)

    Problemas de hacerlo recursivo:
          * La recursión utiliza la pila de llamadas para almacenar
    información de cada llamada activa, como el estado de las variables locales y la dirección
    de retorno. En casos donde el arreglo sea muy grande, esto puede causar un desbordamiento de
    pila (StackOverflowError), ya que la pila tiene un tamaño limitado.
         * La recursión tiende a consumir más recursos debido a la necesidad de almacenar el contexto
    de cada llamada. Esto puede ser menos eficiente en términos de uso de memoria en comparación
    con una solución iterativa, que generalmente usa O(1) de espacio.
         * Depurar código recursivo puede ser más complicado que en soluciones iterativas
     */
    public static boolean isOrder(int[] array, int i){
        if (i == N-1)
            return true;
        if(array[i] > array[i+1]){
            return false;
        }

        return isOrder(array,i+1);
    }

    /*
    EJERCICIO 2: Implemente un algoritmo recursivo para buscar un elemento en un arreglo ordenado
ascendentemente.
     */

    private static int isElemnt(int[] array, int elem, int start, int end) {
        if (start > end)
            return -1;
        int middle  = start + (end - start)/2;

        if (array[middle] == elem)
            return middle;
        if (elem < array[middle])
            return isElemnt(array,elem,start,middle-1);

        return isElemnt(array,elem,middle+1,end);
    }

    /*
    * Ejercicio 3
Implemente un algoritmo recursivo que convierta un número en notación decimal a su
equivalente en notación binaria.
Recordatorio, por ejemplo convertir el 26 a binario = 11010
    * */
    private static String binaryNumber(int number) {

        if (number==0)
            return "";
       return binaryNumber(number/2) + number%2;

    }

    /*
    * Ejercicio 4
Implemente un algoritmo recursivo que presente los primeros N términos de la secuencia de
Fibonacci.
Por ej. los 6 primeros términos son: 0 1 1 2 3 5

    * */
    private static String fibonacciSequence(int n, int actual, int previous) {
        if (n == 0)
            return "";
        return actual + " " + fibonacciSequence(n-1,actual+previous, actual);
    }


}
