public class OzonMain {
    public static void main(String[] args) {

        Customer customer = new Customer("i7597696", "Kamil");

        Seller nike = new Seller("Nike");
        Seller adidas = new Seller("Adidas");

        Product p0 = new Product(nike, "001", "Кросовки Найк", 13000);
        Product p1 = new Product(nike, "002", "Кросовки Найк размер 40", 12000);
        Product p2 = new Product(adidas, "022", "Кросовки Адидас", 13000);
        Product p3 = new Product(adidas, "024", "Футболка Адидас", 2000);

        Order order = new Order(1, customer, "Казань, Кремлевская 35", "8.11.2025");

        order.changeProductCount(p0, 2);
        order.changeProductCount(p1, 10);
        order.changeProductCount(p2, 1);
        order.changeProductCount(p3, 5);
        System.out.println(order);

        order.changeProductCount(p1, 0);
        System.out.println(order);

        order.changeProductCount(p2, 6);
        order.changeProductCount(p3, 0);
        System.out.println(order);

        order.changeProductCount(p1, 2);
        System.out.println(order);

        order.payment();
        System.out.println(order.toString());

        order.getProduct(p2, "9.11.2025");
        System.out.println(order);
    }
}
