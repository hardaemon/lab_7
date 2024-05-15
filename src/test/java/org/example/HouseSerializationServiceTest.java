package org.example;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class HouseSerializationServiceTest {
    @Test
    public void serializeAndDeserializeHouse() {
        Person person1 = new Person("Иван", "Иванов", "Иванович", 1, 1, 1);
        Person person2 = new Person("Петр", "Петров", "Петрович", 2, 2, 2);

        Flat flat1 = new Flat(1, 100, Arrays.asList(person1));
        Flat flat2 = new Flat(2, 200, Arrays.asList(person2));

        List<Flat> flats = Arrays.asList(flat1, flat2);

        House h = new House("123", "ул. Пушкина, д.10", person1, flats);

        HouseSerializationService HSS = new HouseSerializationService();

        try {
            FileOutputStream FOS = new FileOutputStream("house.ser");
            HSS.serializeHouse(h, FOS);
            FOS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream FIS = new FileInputStream("house.ser");
            House DH = HSS.deserializeHouse(FIS);
            assertEquals(h, DH);
            FIS.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}