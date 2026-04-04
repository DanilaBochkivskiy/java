//2. Абонент мобильного оператора. Возможности: оформить договор; открыть счет и номер;
//редактировать учетную запись абонента; получить всю актуальную информацию по номеру абонента;
//проверить состояние баланса и остаток трафика;
//просмотреть детализацию и информацию о платежах;
//сменить тарифный план, оператора;
//пополнить счет; закрыть счет и номер.
//Добавить специализированные методы для Учетной записи интернет и корпоративного абонента.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите тип учетной записи:");
        System.out.println("1. Интернет-абонент");
        System.out.println("2. Корпоративный клиент");

        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите номер телефона/счета: ");
        String number = scanner.nextLine();

        BaseSub client;

        if (type == 1) {
            client = new InternetClient(number);
        } else {
            client = new CorporateClient(number);
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\n");
            System.out.println("1. Оформить договор      2. Инфо по номеру");
            System.out.println("3. Проверить баланс      4. Пополнить счет");
            System.out.println("5. Сменить тариф         6. Детализация платежей");
            System.out.println("7. Редактировать профиль 8. Закрыть счет");

            if (client instanceof InternetClient) {
                System.out.println("9. [Интернет] Ускорить соединение");
                System.out.println("10. [Интернет] Родительский контроль");
            } else {
                System.out.println("9. [Корп] Управление линиями");
                System.out.println("10. [Корп] Налоговый отчет");
            }
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> client.createContract();
                case 2 -> client.getInfo();
                case 3 -> client.checkBalance();
                case 4 -> {
                    System.out.print("Сумма пополнения: ");
                    double amount = scanner.nextDouble();
                    client.refill(amount);
                }
                case 5 -> {
                    System.out.print("Новый тариф: ");
                    String plan = scanner.nextLine();
                    client.changePlan(plan);
                }
                case 6 -> client.viewPayments();
                case 7 -> {
                    System.out.print("Новые данные: ");
                    String info = scanner.nextLine();
                    client.updateAccount(info);
                }
                case 8 -> client.closeAccount();
                case 9 -> {
                    if (client instanceof InternetClient ic) ic.boostSpeed();
                    else {
                        CorporateClient cc = (CorporateClient) client;
                        cc.manageGroupLines();
                    }
                }
                case 10 -> {
                    if (client instanceof InternetClient ic) ic.setParentalControl(true);
                    else {
                        CorporateClient cc = (CorporateClient) client;
                        cc.getTaxReports();
                    }
                }
                case 0 -> exit = true;
                default -> System.out.println("Неверный ввод.");
            }
        }
        System.out.println("Программа завершена.");
        scanner.close();
    }
}