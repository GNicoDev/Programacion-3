public class Tree {
    TreeNode root;

    public Tree(TreeNode root){
        this.root = root;
    }

    public void add(Integer value){
        if (root == null)
            root = new TreeNode(value);
        else {
          add(root,value);
        }
    }
    // Este metodo ordena el arbol menor valor izq, Mayor valor Derecha
    public void add(TreeNode actual, Integer value){
        if (value < actual.getData()) {
            if (actual.getLeft() == null) {
                actual.setLeft(new TreeNode(value));
            } else {
                add(actual.getLeft(), value);
            }
        }
        else {
            if (actual.getRight() == null) {
                actual.setRight(new TreeNode(value));
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

     public boolean delete(Integer value){

        return false;
     }

     public int getHeight(){
         int counter = 0;
         if (root != null){
            counter = 1 + 
        }
        return counter;
     }
}
