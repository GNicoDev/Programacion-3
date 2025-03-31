import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T>{
    private Node<T> first;

    public MyLinkedList() {
        this.first = null;
    }

    public void insertFirst(T data){
       Node<T> tmp = new Node<>(data);
       tmp.setNext(first);
       first = tmp;
    }

    public T extractFront() {
        if (first != null) {
            Node<T> tmp = first;
            first=first.next();
            return tmp.getInfo();
        }
        return null;
    }

    public boolean isEmpty() {
        return first==null;
    }

    public T get(int index) {
        Node<T> aux = first;
        int counter = 1;
        while (aux!=null){
            if (counter==index){
                return aux.getInfo();
            }
            aux= aux.next();
            counter++;
        }
        return null;
    }

    public int size() {
        Node<T> tmp = first;
        int counter = 0;
        while (tmp !=null){
            tmp = tmp.next();
            counter++;
        }
        return counter;
    }

    @Override
    public String toString() {
        // TODO
        Node<T> aux = first;
        String response = "";
        while (aux!=null){
            response += aux.getInfo() + "-->";
            aux= aux.next();
        }
        return response + "null";
    }

    /*************************************************************************************

    /* EJERCICIO 3: A la implementación de la clase Lista realizada en el ejercicio 1, agregue un método
int indexOf(T)  , que reciba un elemento y retorne el índice donde está almacenado ese
elemento, o -1 si el elemento no existe en la lista.
     */

    public int indexOf(T data){
        Node<T> aux = first;
        int count = 1;
        while (aux!=null){
            if (aux.getInfo() == data)
                return count;
            aux=aux.next();
            count++;
        }
        return -1;
    }

    /*********************************************************************************/

    //Funcion que cambia el dato de un nodo dada una posicion (index)
    public void set(int index, T data){
        Node<T> aux = first;
        int counter = 1;
        while (aux!=null){
            if (counter==index){
                aux.setInfo(data);
                return;
            }
            counter++;
            aux=aux.next();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorList(first);
    }

}
