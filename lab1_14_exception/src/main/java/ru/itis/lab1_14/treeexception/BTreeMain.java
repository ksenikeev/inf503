package ru.itis.lab1_14.treeexception;

public class BTreeMain {
    public static void main(String[] args) {
        BTree bTree = new BTree();

        bTree.add(65);
        bTree.add(81);
        bTree.add(47);
        bTree.add(36);
        bTree.add(41);
        bTree.add(71);
        bTree.add(68);

        bTree.add(18);

        System.out.println(bTree.toString());

        bTree.printAsTree();

    }
}
