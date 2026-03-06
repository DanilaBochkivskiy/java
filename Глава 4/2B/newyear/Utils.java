package newyear;

import java.io.*;
import java.util.ArrayList;

public class Utils {

    public static ArrayList<Sweet> loadFromFile(String filename) {
        ArrayList<Sweet> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String type = parts[0].trim();
                    String name = parts[1].trim();
                    double weight = Double.parseDouble(parts[2].trim());
                    double price = Double.parseDouble(parts[3].trim());
                    int sugar = Integer.parseInt(parts[4].trim());

                    switch (type.toLowerCase()) {
                        case "конфета":
                            list.add(new Candy(name, weight, price, sugar));
                            break;
                        case "шоколад":
                            list.add(new Chocolate(name, weight, price, sugar));
                            break;
                        case "леденец":
                            list.add(new Lollipop(name, weight, price, sugar));
                            break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }

        return list;
    }
}