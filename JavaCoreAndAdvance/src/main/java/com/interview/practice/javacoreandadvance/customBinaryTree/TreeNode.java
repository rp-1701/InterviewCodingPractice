package com.interview.practice.javacoreandadvance.customBinaryTree;

public class TreeNode<E extends Comparable<E>>  {

    E value;
    TreeNode<E> left;
    TreeNode<E> right;

    public TreeNode(E value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
