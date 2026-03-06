import java.util.ArrayList;

public class Payment {
    private String namePocupatel;
    private String date;
    private ArrayList<Product> products;

    public Payment(String namePocupatel, String date){
        this.namePocupatel = namePocupatel;
        this.date = date;
        this.products = new ArrayList<>();
    }

    public String getNamePoc() {
        return namePocupatel;
    }

    public void setNamePoc(String namePocupatel) {
        this.namePocupatel = namePocupatel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public class Product {
        private String name;
        private double price;
        private int kol_vo;

        public Product(String name, double price, int kol_vo) {
            this.name = name;
            this.price = price;
            this.kol_vo = kol_vo;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getKol_vo() {
            return kol_vo;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setKol_vo(int kol_vo) {
            this.kol_vo = kol_vo;
        }

        public double getTotalPrice() {
            return price * kol_vo;
        }

        @Override
        public String toString() {
            return String.format("%s x%d = %.2f руб.", name, kol_vo, getTotalPrice());
        }
    }
    public void addProd(String name, double price, int kol_vo) {
        Product p = new Product(name, price, kol_vo);
        products.add(p);
        System.out.println("Добавлен товар " + name);
    }

    public void removeProduct(int index) {
        if (index >= 0 && index < products.size()) {
            Product p = products.get(index);
            products.remove(index);
            System.out.println("Удален товар: " + p.getName());
        } else {
            System.out.println("Товара нет!");
        }
    }
    public double getTotalSum() {
        double total = 0;
        for (Product p : products) {
            total += p.getTotalPrice();
        }
        return total;
    }
    public void Check() {
        System.out.println("Покупатель: " + namePocupatel);
        System.out.println("Дата: " + date);
        System.out.println("Товары:");

        if (products.isEmpty()) {
            System.out.println("Корзина пуста!");
        } else {
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i+1) + ". " + products.get(i));
            }
        }
        System.out.printf("Итого: %.2f руб.\n", getTotalSum());
    }
}
