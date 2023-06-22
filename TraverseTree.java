public class TraverseTree<E> {

    public static class BinaryTreeNode<E>{
        E val;
        BinaryTreeNode<E> left;
        BinaryTreeNode<E> right;


        public BinaryTreeNode(E val) {
            this.val = val;
        }

        public E getVal() {
            return val;
        }

        public void setVal(E val) {
            this.val = val;
        }

        public BinaryTreeNode<E> getLeft() {
            return left;
        }

        public void setLeft(BinaryTreeNode<E> left) {
            this.left = left;
        }

        public BinaryTreeNode<E> getRight() {
            return right;
        }

        public void setRight(BinaryTreeNode<E> right) {
            this.right = right;
        }
    }

    public void preOrder(BinaryTreeNode<E> root){
        System.out.print(root.getVal() + " ");
        if(root.getLeft() != null){
            preOrder(root.getLeft());
        }
        if(root.getRight() != null){
            preOrder(root.getRight());
        }
    }

    public void inOrder(BinaryTreeNode<E> root){

        if(root.getLeft() != null){
            inOrder(root.getLeft());
        }
        System.out.print(root.getVal() + " ");
        if(root.getRight() != null){
            inOrder(root.getRight());
        }
    }

    public void postOrder(BinaryTreeNode<E> root){
        if(root.getLeft() != null){
            postOrder(root.getLeft());
        }
        if(root.getRight() != null){
            postOrder(root.getRight());
        }

        System.out.print(root.getVal() + " ");
    }
    public static void main(String[] args){
        TraverseTree<Integer> var = new TraverseTree<>();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);

        System.out.println("PreOrder: ");
        var.preOrder(root);
        System.out.println("\nInOrder: ");
        var.inOrder(root);
        System.out.println("\nPostOrder: ");
        var.postOrder(root);

    }
}
