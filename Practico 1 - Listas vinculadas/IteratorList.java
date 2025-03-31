import java.util.Iterator;

class IteratorList<T> implements Iterator<T> {

    private Node<T> current;

    public IteratorList(Node<T> current) {
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        return current!= null;
    }

    @Override
    public T next() {
        T data = current.getInfo();
        current = current.next();
        return data;
    }


}
