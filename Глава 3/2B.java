//2. Определить класс Комплекс. Создать массив/список/множество размерности n из комплексных координат.
//Передать его в метод, который выполнит сложение/умножение его элементов.

public class Main {
    public static void main(String[] args) {
        Komplex[] numbers = new Komplex[3];

        numbers[0] = new Komplex(2, 3);
        numbers[1] = new Komplex(1, 4);
        numbers[2] = new Komplex(3, 1);

        System.out.println("Числа:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        Komplex summa = new Komplex(0, 0);
        for (int i = 0; i < numbers.length; i++) {
            summa = summa.plus(numbers[i]);
        }
        System.out.println("Сумма = " + summa);

        Komplex proizv = new Komplex(1, 0);
        for (int i = 0; i < numbers.length; i++) {
            proizv = proizv.umnogit(numbers[i]);
        }
        System.out.println("Произведение = " + proizv);

        System.out.println("Проверка:");
        Komplex a = new Komplex(5, 2);
        Komplex b = new Komplex(3, -1);
        System.out.println(a + " + " + b + " = " + a.plus(b));
        System.out.println(a + " - " + b + " = " + a.minus(b));
    }
}

