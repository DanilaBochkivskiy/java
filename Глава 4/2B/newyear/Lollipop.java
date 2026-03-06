package newyear;

public class Lollipop extends Sweet {

    public Lollipop(String name, double weight, double price, int sugar) {
        super(name, weight, price, sugar);
    }

    @Override
    public String getType() {
        return "Леденец";
    }
}
