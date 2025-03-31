public class NodeD<T> {
    private T info;
    private NodeD<T> next;
    private NodeD<T> previous;

    public NodeD(T info) {
        this.info = info;
        this.next = null;
        this.previous = null;
    }

    public T getInfo() {
        return info;
    }
    public void setInfo(T info) {
        this.info = info;
    }
    public NodeD<T> getNext() {
        return next;
    }
    public void setNext(NodeD<T> next) {
        this.next = next;
    }

    public NodeD<T> getPrevious() {
        return previous;
    }
    public void setPrevious(NodeD<T> previous) {
        this.previous = previous;
    }
}
