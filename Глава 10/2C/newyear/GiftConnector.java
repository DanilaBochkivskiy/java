package newyear;

import java.io.*;
import java.util.ArrayList;

public class GiftConnector {
    private String filename;

    public GiftConnector(String filename){
        this.filename = filename;
    }

    public void saveGift(Gift gift) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
            oos.writeObject(gift);
            System.out.println("Подарок успешно сохранен!\n");
        } catch (IOException e) {
            System.out.println("Ошибка сохранения: " + e.getMessage());
        }
    }

    public Gift loadGift() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Gift) ois.readObject();
        }catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка загрузки: " + e.getMessage());
            return null;
        }
    }
}