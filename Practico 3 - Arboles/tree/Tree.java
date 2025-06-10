package tree;

import java.util.List;

public class Tree {
    TreeNode root;

    public Tree(TreeNode root){
        this.root = root;
    }

    private void add(Integer value){
        if (root == null)
            root = new TreeNode(value);
        else {
          add(root,value);
        }
    }
    // Este metodo ordena el arbol => menor valor izq, Mayor valor Derecha
    private void add(TreeNode actual, Integer value){
        if (value < actual.getData()) {
            if (actual.getLeft() == null) {
                actual.setLeft(new TreeNode(value));
            } else {
                add(actual.getLeft(), value);
            }
        } else {
            if (actual.getRight() == null) {
                actual.setRight(new TreeNode(value));
            } else {
                add(actual.getRight(), value);
            }
        }

    }

    //Ejercicio 1
    public TreeNode getRoot(){
        return root;
    }

    public boolean hasElem(Integer value){
        TreeNode elem = findElem(root,value);
        return elem != null;
    }

    private TreeNode findElem(TreeNode actual, Integer value) {
        if (actual == null )
            return null;
        if (actual.getData() == value)
            return actual;
        else if (value < actual.getData())
            return findElem(actual.getLeft(),value);
        else
            return findElem(actual.getRight(),value);
    }

    public boolean isEmpty(){
        return root == null;
    }

     public void insert(Integer value){
        if (isEmpty())
            add(value);
        else
            add(root,value);
     }

     /// //////////////////////////////////////////////////////////
    public boolean delete(Integer value) {
        if (value == null) return false;
        if (!contains(root, value)) return false;

        root = recursiveRemove(root, value);
        return true;
    }


    private TreeNode recursiveRemove(TreeNode actual, Integer valor) {
        if (actual == null) return null;

        if (valor < actual.getData()) {
            actual.left = recursiveRemove(actual.left, valor);
        } else if (valor > actual.getData()) {
            actual.right = recursiveRemove(actual.right, valor);
        } else {
            // Nodo con un solo hijo o sin hijos
            if (actual.left == null) return actual.right;
            if (actual.right == null) return actual.left;

            // Nodo con dos hijos: buscar el sucesor in-order (menor del subárbol derecho)
            TreeNode sucesor = findMin(actual.right);
            actual.setData(sucesor.getData());
            actual.right = recursiveRemove(actual.right, sucesor.getData());
        }
        return actual;
    }

    private TreeNode findMin(TreeNode nodo) {
        while (nodo.left != null) {
            nodo = nodo.left;
        }
        return nodo;
    }

    private boolean contains(TreeNode actual, Integer valor) {
        if (actual == null) return false;
        if (valor.equals(actual.getData())) return true;
        return valor < actual.getData()
                ? contains(actual.left, valor)
                : contains(actual.right, valor);
    }

/// /////////////////////////////////////////////////////////////////////////
    public int getHeight() {
        return calculatorHeight(root);
     }

     public void printPostOrder(){
        printTreePostOrder(root);
     }

    public void printPreOrder(){
        printTreePreOrder(root);
    }


    public void printInOrder(){
        printTreeInOrder(root);
    }

    Integer getMaxElem(){
        if (root==null)
            return null;
        else
            return maxElem(root);
    }

    List getLongestBranch(){
        return null;
    }

    List getFrontera(){
        return null;
    }

    List getElemAtLevel(int elem){
        return null;
    }


    /*********************************************************************/
    private void printTreeInOrder(TreeNode root) {
        if (root == null)
            return;
        printTreeInOrder(root.left);
        System.out.println(root.data + " ");
        printTreeInOrder(root.right);
    }


    private void printTreePreOrder(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.data + " ");
        printTreePreOrder(root.left);
        printTreePreOrder(root.right);
    }
    private void printTreePostOrder(TreeNode root) {
        if (root == null)
            return;
        printTreePostOrder(root.left);
        printTreePostOrder(root.right);
        System.out.println(root.data + " ");
    }

    private int calculatorHeight(TreeNode root) {
        if (root == null)
            return 0;
        int heightLeft = calculatorHeight(root.left);
        int heightRight = calculatorHeight(root.right);
        int maxHeight;
        if (heightLeft>heightRight)
            maxHeight = heightLeft;
        else
            maxHeight=heightRight;
        return 1 + maxHeight;
    }

    private Integer maxElem(TreeNode node) {
        if (node.getRight()==null)
            return node.getData();
        else
            return maxElem(node.getRight());
    }


    /// //////////////////////////////////////////////////////////////////
    /// Metodo de incesrion manual para chequear ejercicio
    public void insertManual(TreeNode<Character> padre, char dato, boolean esIzquierdo) {
        if (padre == null) return;

        if (esIzquierdo) {
            padre.left = new TreeNode(dato);
        } else {
            padre.right = new TreeNode(dato);
        }
    }

}
