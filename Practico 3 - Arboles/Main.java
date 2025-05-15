public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree(null);

        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(20);
        tree.insert(6);

        tree.printInOrder();
        System.out.println("La profundidad del arbol es : " + tree.getHeight()); // 4
        System.out.println();
        System.out.println("El elemento mas grande del arbol es: " + tree.getMaxElem());
        System.out.println();
        tree.delete(5);
        tree.printInOrder();
    }
}
