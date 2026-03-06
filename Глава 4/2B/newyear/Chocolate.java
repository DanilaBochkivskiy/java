package newyear;

public class Chocolate extends Sweet {

    public Chocolate(String name, double weight, double price, int sugar) {
        super(name, weight, price, sugar);
    }

    @Override
    public String getType() {
        return "Шоколад";
    }
}