package com.interview.practice.javacoreandadvance.customBinaryTree;

public class BinaryTree<E extends Comparable<E>> {

    TreeNode<E> root;

    public BinaryTree(E key) {
        this.root = new TreeNode<>(key);
    }

    public BinaryTree() {
        this.root = null;
    }

    public void add(E key) {
        root = addRecursively(root, key);
    }

    private TreeNode<E> addRecursively(TreeNode<E> current, E key) {
        if(current == null) {
            return new TreeNode<>(key);
        }

        if(key.compareTo(current.value) < 0) {
            current.left = addRecursively(current.left, key);
        } else if(key.compareTo(current.value) > 0) {
            current.right = addRecursively(current.right, key);
        } else {
            return current;
        }
        return current;
    }
}
