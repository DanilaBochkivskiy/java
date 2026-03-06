//2. Создать класс Payment с внутренним классом, с помощью объектов кото-рого можно сформировать покупку из нескольких товаров.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Имя: ");
        String name = scanner.nextLine();
        System.out.println("Дата (пр: 23.02.2026): ");
        String date = scanner.nextLine();
        Payment payment = new Payment(name, date);
        while (true) {
            System.out.println("1. Добавить товар");
            System.out.println("2. Удалить товар");
            System.out.println("3. Показать чек");
            System.out.println("0. Выход");
            System.out.print("Выбери: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            switch (choice) {
                case 1:
                    System.out.print("Название товара: ");
                    String productName = scanner.nextLine();

                    System.out.print("Цена за штуку: ");
                    double price = scanner.nextDouble();

                    System.out.print("Количество: ");
                    int quantity = scanner.nextInt();

                    payment.addProd(productName, price, quantity);
                    break;

                case 2:
                    payment.Check();
                    System.out.print("Введи номер товара для удаления: ");
                    int index = scanner.nextInt();
                    payment.removeProduct(index - 1);
                    break;

                case 3:
                    payment.Check();
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