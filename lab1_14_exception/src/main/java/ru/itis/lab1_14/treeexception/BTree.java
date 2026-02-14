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

        return node.value + "," + print(node.left) + print(node.right);
    }

    public void add(int value) {
        if (root == null)
            root = new Node(value);
        else
            add(value, root);
        size++;
    }

    private void add(int value, Node node) {
        if (value <= node.value) {
            if (node.left == null) { // добавляем в левое поддерево
                Node v = new Node(value);
                node.left = v;
                return;
            } else {
                add(value, node.left);
            }
        } else {
            if (node.right == null) { // добавляем в правое поддерево
                Node v = new Node(value);
                node.right = v;
                return;
            } else {
                add(value, node.right);
            }
        }
    }

    public int size() {
        return size;
    }

    public int max() throws EmptyTreeException {
        return 0;
    }

    public int min() throws EmptyTreeException {
        return 0;
    }

    public String[] path(int value) throws NotFoundException {
        return route(root, value, "");
    }

    private String[] route(Node node, int value, String direction) {


        return null;
    }

    public void printAsTree() {
        int countLeftNodes = cntLN(root);

        System.out.println(countLeftNodes);
    }

    private int cntLN(Node node) {
        if (node != null) {
            return 1 + cntLN(node.left);
        } else {
            return 0;
        }
    }
}
