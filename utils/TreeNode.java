package utils;

import java.util.ArrayList;

public class TreeNode<E> {
    E val;
    ArrayList<TreeNode<E>> children;

    public TreeNode(E val){
        this.val = val;
    }
    public TreeNode(E val, ArrayList<TreeNode<E>> children) {
        this.val = val;
        this.children = children;
    }


    public boolean hasChildren(){
        return this.children != null;
    }

    public E getVal() {
        return val;
    }

    public ArrayList<TreeNode<E>> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<TreeNode<E>> children) {
        this.children = children;
    }
}
