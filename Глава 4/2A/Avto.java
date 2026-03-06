import java.util.Objects;

class Avto {
    private String marka;
    private String model;
    private String color;
    private Dvigatel dvigatel;
    private Koleso[] wheels; // массив из 4 колес

    // Конструктор
    public Avto(String marka, String model, String color,
                Dvigatel dvigatel, Koleso[] wheels) {
        this.marka = marka;
        this.model = model;
        this.color = color;
        this.dvigatel = dvigatel;
        this.wheels = wheels;
    }

    // Метод "ехать"
    public void exat() {
        System.out.println(marka + " " + model + " поехала!");
    }

    // Метод "заправляться"
    public void zapravlyatsya(int benzin) {
        System.out.println(marka + " " + model + " заправилась " + benzin + "-м бензином");
    }

    // Метод "менять колесо"
    public void menjatKoleso(int index, Koleso novoeKoleso) {
        if (index >= 0 && index < wheels.length) {
            System.out.println("Меняем " + (index+1) + "-е колесо");
            System.out.println("Было: " + wheels[index]);
            wheels[index] = novoeKoleso;
            System.out.println("Стало: " + wheels[index]);
        } else {
            System.out.println("Нет такого колеса!");
        }
    }

    // Метод "вывести марку"
    public void printMarka() {
        System.out.println("Марка автомобиля: " + marka);
    }

    // Геттеры
    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public Dvigatel getDvigatel() {
        return dvigatel;
    }

    public Koleso[] getWheels() {
        return wheels;
    }

    // Сеттеры
    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDvigatel(Dvigatel dvigatel) {
        this.dvigatel = dvigatel;
    }

    public void setWheels(Koleso[] wheels) {
        this.wheels = wheels;
    }

    // toString
    @Override
    public String toString() {
        String result = "Автомобиль{" +
                "марка='" + marka + '\'' +
                ", модель='" + model + '\'' +
                ", цвет='" + color + '\'' +
                ", двигатель=" + dvigatel;

        result += ", колеса=[";
        for (int i = 0; i < wheels.length; i++) {
            result += wheels[i];
            if (i < wheels.length - 1) {
                result += ", ";
            }
        }
        result += "]}";

        return result;
    }

    // equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Avto that = (Avto) obj;

        if (!Objects.equals(marka, that.marka) ||
                !Objects.equals(model, that.model) ||
                !Objects.equals(color, that.color) ||
                !Objects.equals(dvigatel, that.dvigatel)) {
            return false;
        }

        if (wheels.length != that.wheels.length) return false;
        for (int i = 0; i < wheels.length; i++) {
            if (!Objects.equals(wheels[i], that.wheels[i])) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(marka, model, color, dvigatel);
        for (Koleso w : wheels) {
            result = 31 * result + (w == null ? 0 : w.hashCode());
        }
        return result;
    }
}
