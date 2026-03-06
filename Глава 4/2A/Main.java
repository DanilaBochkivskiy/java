//2. Создать объект класса Автомобиль, используя классы Колесо, Двигатель.
//Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля.

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Dvigatel motor = new Dvigatel("Бензиновый", 150);

        Koleso[] kolesa = new Koleso[4];
        kolesa[0] = new Koleso("Michelin", 17);
        kolesa[1] = new Koleso("Michelin", 17);
        kolesa[2] = new Koleso("Michelin", 17);
        kolesa[3] = new Koleso("Michelin", 17);

        Avto myCar = new Avto("Toyota", "Camry", "Красный", motor, kolesa);

        System.out.println("Создали авто");
        System.out.println(myCar);

        System.out.println("\nТест методы");
        myCar.exat();
        myCar.zapravlyatsya(92);

        System.out.println("\nМеняем колеса");
        Koleso novoeKoleso = new Koleso("Bridgestone", 17);
        myCar.menjatKoleso(2, novoeKoleso);

        System.out.println("\nПосле замены");
        System.out.println(myCar);

        System.out.println("\nМарка авто");
        myCar.printMarka();

        System.out.println("\nТест equals и hashCode");

        Avto sameCar = new Avto("Toyota", "Camry", "Красный", motor, kolesa);

        Dvigatel drugoyMotor = new Dvigatel("Дизельный", 200);
        Avto otherCar = new Avto("BMW", "X5", "Черный", drugoyMotor, kolesa);

        System.out.println("myCar equals sameCar: " + myCar.equals(sameCar));
        System.out.println("myCar equals otherCar: " + myCar.equals(otherCar));
        System.out.println("myCar hashCode: " + myCar.hashCode());
        System.out.println("sameCar hashCode: " + sameCar.hashCode());
        System.out.println("otherCar hashCode: " + otherCar.hashCode());
    }
}
