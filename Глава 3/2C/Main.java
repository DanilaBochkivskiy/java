//2. Определить класс Прямая на плоскости (в пространстве), параметры которой задаются с помощью Рациональной Дроби.
// Определить точки пересечения прямой с осями координат.
// Определить координаты пересечения двух прямых.
// Создать массив/список/множество объектов и определить группы параллельных прямых.

public class Main {
    public static void main(String[] args) {
        Pryamaya[] linii = new Pryamaya[4];

        linii[0] = new Pryamaya(2, 3);
        linii[1] = new Pryamaya(2, -1);
        linii[2] = new Pryamaya(-1, 4);
        linii[3] = new Pryamaya(3, 2);

        for (int i = 0; i < linii.length; i++) {
            System.out.println("Прямая " + (i+1) + ": " + linii[i]);
        }

        for (int i = 0; i < linii.length; i++) {
            System.out.println("\nПрямая " + (i+1) + ": " + linii[i]);
            linii[i].printCross();
        }

        System.out.println("Прямая 1 и Прямая 2: " + linii[0].findCross(linii[1]));
        System.out.println("Прямая 1 и Прямая 3: " + linii[0].findCross(linii[2]));
        System.out.println("Прямая 2 и Прямая 4: " + linii[1].findCross(linii[3]));
        findParallel(linii);
    }

    public static void findParallel(Pryamaya[] arr) {
        boolean[] Check = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (!Check[i]) {
                System.out.print("Прямая " + (i+1) + " параллельна: ");
                Check[i] = true;
                boolean found = false;

                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i].isParallel(arr[j])) {
                        System.out.print("Прямая " + (j+1) + " ");
                        Check[j] = true;
                        found = true;
                    }
                }

                if (!found) {
                    System.out.print("нет параллельных");
                }
                System.out.println();
            }
        }
    }
}