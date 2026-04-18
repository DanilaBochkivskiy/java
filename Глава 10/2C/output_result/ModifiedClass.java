package newyear;
import java.io.Serializable;

private abstract class Sweet implements Serializable {
    private static String Address = "Центральный склад";

    protected String name;
    protected double weight;
    protected double price;
    protected int sugar;

    protected transient String internalId;

    private Sweet(String name, double weight, double price, int sugar) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.sugar = sugar;
    }

    private String getName() {
        return name;
    }

    private double getWeight() {
        return weight;
    }

    private double getPrice() {
        return price;
    }

    private int getSugar() {
        return sugar;
    }

    private abstract String getType();

    @Override
    private String toString() {
        return getType() + " '" + name + "' | вес: " + weight + "г | цена: " + price + "р | сахар: " + sugar + "%"
                + " | Склад: " + Address + " | ID: " + internalId;
    }
}
