package newyear;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Gift implements Serializable{
    private String name;
    private ArrayList<Sweet> sweets;

    public Gift(String name) {
        this.name = name;
        this.sweets = new ArrayList<>();
    }

    public void addSweet(Sweet sweet) {
        sweets.add(sweet);
    }

    public void showGift() {
        System.out.println("Подарок: " + name);
        if (sweets.isEmpty()) {
            System.out.println("  Подарок пуст!");
        } else {
            for (int i = 0; i < sweets.size(); i++) {
                System.out.println("  " + (i+1) + ". " + sweets.get(i));
            }
        }
    }

    public double getTotalWeight() {
        double total = 0;
        for (Sweet s : sweets) {
            total += s.getWeight();
        }
        return total;
    }

    public void sortByPrice() {
        Collections.sort(sweets, new Comparator<Sweet>() {
            @Override
            public int compare(Sweet s1, Sweet s2) {
                return Double.compare(s1.getPrice(), s2.getPrice());
            }
        });
    }

    public void sortByWeight() {
        Collections.sort(sweets, new Comparator<Sweet>() {
            @Override
            public int compare(Sweet s1, Sweet s2) {
                return Double.compare(s1.getWeight(), s2.getWeight());
            }
        });
    }

    public void sortBySugar() {
        Collections.sort(sweets, new Comparator<Sweet>() {
            @Override
            public int compare(Sweet s1, Sweet s2) {
                return Integer.compare(s1.getSugar(), s2.getSugar());
            }
        });
    }

    public void findBySugar(int minSugar, int maxSugar) {
        System.out.println("Конфеты с сахаром от " + minSugar + "% до " + maxSugar + "%:");
        boolean found = false;

        for (Sweet s : sweets) {
            if (s.getSugar() >= minSugar && s.getSugar() <= maxSugar) {
                System.out.println("  " + s);
                found = true;
            }
        }

        if (!found) {
            System.out.println(" Таких конфет нет!");
        }
    }
}
