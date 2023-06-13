package com.company;

// Class containing left and right child
// of current node and key value
class Node {

    String data;

    Node left, right;
    public Node(String item)
    {
        data = item;
        left = null;
        right = null;
    }
}

// A Java program to introduce Binary Tree
public class BinaryTree {

    // Root of Binary Tree
    Node root;

    // Constructors
    BinaryTree(String item) {
        root = new Node(item);
    }
    BinaryTree() {
        root = null;
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
    }
}
