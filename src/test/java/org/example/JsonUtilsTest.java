package org.example;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import static org.junit.Assert.*;

public class JsonUtilsTest {
    @Test
    public void serializeAndDeserializeHouse() {
        Person person1 = new Person("Иван", "Иванов", "Иванович", 1, 1, 1);
        Person person2 = new Person("Петр", "Петров", "Петрович", 2, 2, 2);

        Flat flat1 = new Flat(1, 100, Arrays.asList(person1));
        Flat flat2 = new Flat(2, 200, Arrays.asList(person2));

        List<Flat> flats = Arrays.asList(flat1, flat2);

        House h = new House("123", "ул. Пушкина, д.10", person1, flats);
        try {
            String json = JsonUtils.serializeHouse(h);
            House deserializedHouse = JsonUtils.deserializeHouse(json);
            assertEquals("123", deserializedHouse.getNumber());
            assertEquals("ул. Пушкина, д.10", deserializedHouse.getAddress());
            assertEquals(person1, deserializedHouse.getMainPerson());
            assertEquals(flats, deserializedHouse.getFlats());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}