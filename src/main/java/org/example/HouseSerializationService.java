package org.example;

import java.io.*;

public class HouseSerializationService {
    public void serializeHouse(House h, OutputStream OS) throws IOException {
        try (ObjectOutputStream OOS = new ObjectOutputStream(OS)) {
            OOS.writeObject(h);
        }
    }

    public House deserializeHouse(InputStream IS) throws IOException, ClassNotFoundException {
        try (ObjectInputStream OIS = new ObjectInputStream(IS)) {
            return (House) OIS.readObject();
        }
    }


}
