public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list1 = new MyLinkedList<>();
        list1.insertFirst(7);
        list1.insertFirst(5);
        list1.insertFirst(3);
        list1.insertFirst(8);

        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        list2.insertFirst(3);
        list2.insertFirst(7);
        list2.insertFirst(5);


        System.out.println(list1.toString());
        System.out.println("The list' size is: " + list1.size());

        System.out.println("Index 2 is : " + list1.get(2));

        System.out.println("The elemnt 5 is in the position " + list1.indexOf(5));

        // 5 a)
        System.out.println();
        System.out.println("Exercise 5: The union is");
        MyLinkedList<Integer> result = unionListSorter(list1,list2);
        show(result);

        //5 b)
     /*   sortList(list1);
        show(list1);
        sortList(list2);
        show(list2);

      */
        System.out.println();
        System.out.println();

        //EXERCISE 6
        result = complement(list1,list2);
        show(result);

    }



    /* EJERCICIO 5: Escriba un procedimiento que dadas dos listas construya otra con los elementos comunes,
suponiendo que: a) Las listas están desordenadas y la lista resultante debe quedar ordenada. b)
Las listas están ordenadas y la lista resultante debe mantenerse ordenada. */

  //  A)

    private static MyLinkedList<Integer> unionListSorter(MyLinkedList<Integer> list1, MyLinkedList<Integer> list2) {
        MyLinkedList<Integer> response = new MyLinkedList<>();
        for (Integer i: list1) {
            for (Integer j: list2) {
                if (i == j) {
                    response.insertFirst(i);
                }
            }
        }
        sortList(response);
        return response;
    }

    private static void sortList(MyLinkedList<Integer> response) {
        for (int i = 1; i <= response.size(); i++) {
            for (int j = i + 1; j <= response.size(); j++) {
                if (response.get(i) > response.get(j)) {
                    // Intercambiar elementos
                    int temp = response.get(i);
                    response.set(i, response.get(j));
                    response.set(j, temp);
                }
            }
        }
    }

    // B)

    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/


        /* EJERCICIO 6: Escriba una función que dadas dos listas construya otra con los elementos que están en la
primera pero no en la segunda.*/

    private static MyLinkedList<Integer> complement(MyLinkedList<Integer> list1, MyLinkedList<Integer> list2) {
        MyLinkedList<Integer> response = new MyLinkedList<>();
        for (Integer i : list1) {
           if (!exist(i,list2)){
               response.insertFirst(i);
           }
        }
        return response;
    }

    private static boolean exist(Integer i, MyLinkedList<Integer> list2) {
        for (Integer j : list2) {
            if (i == j) {
                return true;
            }
        }
        return false;
    }

    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    private static void show(MyLinkedList<Integer> union) {
        for (Integer i: union) {
            System.out.print(i + "-->");
        }
    }
}
