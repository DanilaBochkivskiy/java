// 2. Customer: id, Фамилия, Имя, Отчество, Адрес, Номер кредитной карточки, Номер банковского счета.
//Создать массив объектов. Вывести:
//a) список покупателей в алфавитном порядке;
//b) список покупателей, у которых номер кредитной карточки находится
//в заданном интервале.

public class Main {
    public static void main(String[] args){
        Customers customer = new Customers();
        customer.addCustomers(new Customer(1, "Иванов", "Иван", "Иванович",
                "ул. Ленина, 1", "1234", "40817810000000000001"));
        customer.addCustomers(new Customer(2, "Петров", "Петр", "Петрович",
                "ул. Гагарина, 5", "2345", "40817810000000000002"));
        System.out.println("Список покупателей в алфавитном порядке: ");
        customer.sortName();
        System.out.println("Карты от 1000 до 1500: ");
        customer.CardRange("1000", "1500");
    }
}
