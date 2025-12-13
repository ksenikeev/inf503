package ru.itis.lab1_14.treeexception;

/*
    Значения в узлах левого поддерева <= значению в узле
    Значения в узлах правого поддерева > значению в узле
 */
public class BTree implements IntCollection {
    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public String toString() {
            return String.valueOf(value);
        }
    }

    private Node root;
    private int size = 0;

    public String toString() {
        return print(root);
    }

    private String print(Node node){
        if (node == null){
            return "";
        }

        return node.value + print(node.left) + print(node.right)+ ", ";
    }

    public void add(int value) {
        if (root == null)
            root = new Node(value);
        else
            add(value, root);
        size++;
    }

    private void add(int value, Node node){
        if (value <= node.value) {
            if (node.left == null) { // добавляем в левое поддерево
                Node v = new Node(value);
                node.left = v;
                return;
            } else if (value < node.left.value){
                add(value, node.left);
            } else {
                Node v = new Node(value);
                v.left = node.left;
                node.left = v;
            }
        } else {
            if (node.right == null) { // добавляем в правое поддерево
                Node v = new Node(value);
                node.right = v;
                return;
            } else if (value >= node.right.value){
                add(value, node.right);
            } else {
                Node v = new Node(value);
                v.right = node.right;
                node.right = v;
            }
        }
    }

    public int size() {
        return size;
    }


}
