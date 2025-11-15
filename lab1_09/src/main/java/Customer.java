public class Customer {
    public String id;
    public String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public  String toString() {
        return "id=" + id + ", name=" + name;
    }
}
