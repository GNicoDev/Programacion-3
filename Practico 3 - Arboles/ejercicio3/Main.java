package ejercicio3;

import tree.Tree;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TreeNode<Integer> raiz = null;
        Tree tree = new Tree(raiz);

        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(20);
        tree.insert(6);
        tree.insert(8);
        tree.insert(11);

        tree.printInOrder();

        int k = 8;
        List<Integer> valores = new ArrayList<Integer>();
        Ejercicio3 tree1 = new Ejercicio3();
        valores = tree1.devolverValoresMayoresA(tree.getRoot(),k);
        System.out.println(valores);

    }
}
