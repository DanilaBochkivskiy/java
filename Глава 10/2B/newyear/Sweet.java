package newyear;
import java.io.Serializable;

public abstract class Sweet implements Serializable {
    public static String Address = "Центральный склад";

    protected String name;
    protected double weight;
    protected double price;
    protected int sugar;

    protected transient String internalId;

    public Sweet(String name, double weight, double price, int sugar) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.sugar = sugar;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public int getSugar() {
        return sugar;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return getType() + " '" + name + "' | вес: " + weight + "г | цена: " + price + "р | сахар: " + sugar + "%"
                + " | Склад: " + Address + " | ID: " + internalId;
    }
}
