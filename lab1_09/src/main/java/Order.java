public class Order {
    /* Максимальное кол-во товаров в заказе */
    public int CAPACITY = 10;
    private int productsCount = 0;

    public int number;
    public Customer customer;
    public String deliveryPoint;
    public String orderDate;
    public double summ;
    private Product[] products = new Product[CAPACITY];
    /* Формируется, Оплачен, Закрыт */
    public String status;

    public Product[] getProducts() {
        Product[] result = new Product[productsCount];
        for (int i = 0; i < productsCount; ++i) {
            result[i] = products[i];
        }
        return result;
    }

    public Order(int number, Customer customer, String deliveryPoint, String orderDate) {
        this.number = number;
        this.customer = customer;
        this.deliveryPoint = deliveryPoint;
        this.orderDate = orderDate;
    }

    public void payment() {
        for (int i=0; i<productsCount; i++) {
            products[i].setStatus("Оплачен");
        }
        this.status = "Оплачен";
    }

    public void changeProductCount(Product product, int count) {
        for (int i = 0; i < productsCount; i++) {
            if (products[i].articule.equals(product.articule)) {
                if (count > 0) { //изменяем товар
                    products[i].count = count;
                } else { //удаляем товар
                    products[i] = products[productsCount-1];
                    products[productsCount-1] = null;
                    productsCount--;
                }
                return;
            }
        }
        //товар не нашелся, добавляем
        products[productsCount] = product;
        products[productsCount].count = count;
        productsCount++;
    }

    public void getProduct(Product product, String gettingDate) {
        product.getProduct(gettingDate);
        boolean isAllGetting = true;
        for (int i=0; i<productsCount; i++) {
            if (!(products[i].status.equals("Получен"))) {
                isAllGetting = false;
                break;
            }
        }
        if (isAllGetting) {
            this.status = "Закрыт";
        }
    }

    public String toString() {
        return "Заказ № " + number +
                ", покупатель " + customer.name;
    }
}
