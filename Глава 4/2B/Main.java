//2. Новогодний подарок. Определить иерархию конфет и прочих сладостей.
//Создать несколько объектов конфет. Собрать детский подарок с определением его веса.
//Провести сортировку конфет в подарке на основе одного из параметров.
//Найти конфету в подарке, соответствующую заданному диапазону содержания сахара.

import newyear.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Gift gift = new Gift("Подарок");

        gift.addSweet(new Chocolate("Аленка", 100, 150, 55));
        gift.addSweet(new Chocolate("Альпенгольд", 150, 200, 60));
        gift.addSweet(new Candy("Карамелька", 50, 80, 90));
        gift.addSweet(new Lollipop("Чупа-чупс", 30, 50, 95));
        gift.addSweet(new Candy("Барбарис", 40, 70, 85));
        gift.addSweet(new Chocolate("Бабаевский", 200, 250, 50));

        while (true) {
            System.out.println("1. Показать все сладости");
            System.out.println("2. Показать вес подарка");
            System.out.println("3. Сортировать по цене");
            System.out.println("4. Сортировать по весу");
            System.out.println("5. Сортировать по сахару");
            System.out.println("6. Найти конфету по сахару");
            System.out.println("0. Выход");
            System.out.print("Выбери: ");

            int choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    gift.showGift();
                    break;
                case 2:
                    System.out.println("Вес подарка: " + gift.getTotalWeight() + " г");
                    break;
                case 3:
                    gift.sortByPrice();
                    System.out.println("Сортировка по цене:");
                    gift.showGift();
                    break;
                case 4:
                    gift.sortByWeight();
                    System.out.println("Сортировка по весу:");
                    gift.showGift();
                    break;
                case 5:
                    gift.sortBySugar();
                    System.out.println("Сортировка по сахару:");
                    gift.showGift();
                    break;
                case 6:
                    System.out.print("Введи мин.сахар: ");
                    int min = scanner.nextInt();
                    System.out.print("Введи макс.сахар: ");
                    int max = scanner.nextInt();
                    gift.findBySugar(min, max);
                    break;
                case 0:
                    System.out.println("Покеда!");
                    return;
                default:
                    System.out.println("Ошибка!");
            }
        }
    }
}