package ru.itis.inf503.lab2_3;

public class Node {
    private String name;
    public Node(String name) {
        this.name=name;
    }
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !o.getClass().equals(Node.class)) return false;
        return ((Node) o).getName().equals(this.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
