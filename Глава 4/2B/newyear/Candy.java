package newyear;

public class Candy extends Sweet {

    public Candy(String name, double weight, double price, int sugar) {
        super(name, weight, price, sugar);
    }

    @Override
    public String getType() {
        return "Конфета";
    }
}