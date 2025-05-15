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

     public boolean delete(Integer value) {
         if (root == null)
             return false;

             TreeNode foundNode = findElem(root, value);
             if (foundNode == null) {
                 return false;
             }
             //Case Leaf node
             if (isLeaf(foundNode)) {
                 if (foundNode == root) {
                     root = null;
                     return true;
                 }
                 TreeNode father = searchFather(root, foundNode);
                 removeNode(father,foundNode);
                 return true;
             }

             TreeNode nodeToRemove = searchNodeRML(foundNode);
             foundNode.setData(nodeToRemove.getData());
             removeNode(searchFather(foundNode, nodeToRemove),nodeToRemove);
             return true;
     }

    private void removeNode(TreeNode father, TreeNode nodeToRemove) {
        if (father.getLeft() == nodeToRemove){
            father.setLeft(null);
        }
        father.setRight(null);
    }

    private TreeNode searchFather(TreeNode root, TreeNode nodefound) {
        if (root.getLeft()==nodefound || root.getRight()==nodefound){
            return root;
        }
        if (nodefound.getData()<root.getData())
            return searchFather(root.getLeft(),nodefound);
        else
            return searchFather(root.getRight(),nodefound);

    }

    private boolean isLeaf(TreeNode node) {
        return node.getLeft()==null && node.getRight()==null;
    }


    private TreeNode searchNodeRML(TreeNode node) {
        if (node.getLeft() == null)
            return node;
        else
           return searchNodeRML(node.getLeft());
    }

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
}
