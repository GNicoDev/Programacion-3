import java.util.Iterator;

public class MyDoubleLinkedList<T> implements Iterable<T> {
    private NodeD<T> first;
    private NodeD<T> last;

    public MyDoubleLinkedList() {
        first = null;
        last = null;
    }

    public void insertFront(T info) {
        NodeD<T> tmp = new NodeD<T>(info);
        tmp.setNext(this.first);
        this.first = tmp;
    }

    public void insertBack(T info) {
        NodeD<T> tmp = new NodeD<>(info);
        tmp.setPrevious(this.last);
        this.last = tmp;
    }

    public T extractFront() {
        if (this.first == null) {
            return null;
        }
        T info = this.first.getInfo();
        first = this.first.getNext();
        return info;
    }

    public T extractBack() {
        if (this.last == null) {
            return null;
        }
        T info = this.last.getInfo();
        this.last = this.last.getPrevious();
        return info;
    }



    public boolean isEmpty() {
        return first == null;
    }


    /* LA idea del metodo que retorna un valor dado un indice, es preguntar, si el indice es meno a la mitad
        empiezp recorriendo por first, sino por last
    */
    public T get(int index) {
        int middle= this.size() / 2;
        if (index < middle) {
            NodeD<T> tmp = this.first;
            for (int i = 0; i < index; i++) {
                tmp = tmp.getNext();
            }
            return tmp.getInfo();
        }
        else {
            if (index < this.size()) {
                NodeD<T> tmp = this.last;
                for (int i = 0; i < index; i++) {
                    tmp = tmp.getPrevious();
                }
                return tmp.getInfo();
            }
        }
        return null;
    }

    public int size() {
        NodeD<T> tmp = first;
        int counter = 0;
        while (tmp !=null){
            tmp = tmp.getNext();
            counter++;
        }
        return counter;
    }

    @Override
    public String toString() {
        // TODO
        NodeD<T> aux = first;
        String response = "null";
        while (aux!=null){
            response += aux.getInfo() + "<==>";
            aux= aux.getNext();
        }
        return response + "null";
    }



/******************** Iterator implementation ****************************/

    @Override
    public Iterator<T> iterator() {
        return new IteratorList();
    }


    // Clase interna para el iterador
    private class IteratorList implements Iterator<T> {
        private NodeD<T> current = first;


        @Override
        public boolean hasNext() {
            return current!= null;
        }

        @Override
        public T next() {
            T data = current.getInfo();
            current = current.getNext();
            return data;
        }


    }
}
