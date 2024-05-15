package org.example;
import java.io.RandomAccessFile;
import java.io.IOException;
import org.junit.Test;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class StreamTest {
    @Test
    public void writeAndReadIntegersBinary() {
        int[] numbers = {1, 2, 3, 4, 5};
        String filename = "numbers.bin";
        Stream.writeIntegersToBinary(numbers, filename);
        int[] result = Stream.readIntegersFromBinary(filename);
        assertArrayEquals(numbers, result);
    }
    @Test
    public void writeAndReadIntegersText() {
        int[] numbers = {1, 2, 3, 4, 5};
        String filename = "numbers.bin";
        Stream.writeIntegersToText(numbers, filename);
        int[] result = Stream.readIntegersFromText(filename);
        assertArrayEquals(numbers, result);
    }
    @Test
    public void readIntegersClass() {
        int[] numbers = {5, 1, 2, 3, 4, 5};
        int[] expected = {3, 4, 5};
        String filename = "numbers.bin";
        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            for (int i : numbers) {
                raf.writeInt(i);
            }
        } catch (IOException e) {
            fail(e.getMessage());
        }
        int[] result = Stream.readIntegersClass(filename, 3);
        assertArrayEquals(expected, result);
    }
    @Test
    public void fileSearch() {
        String directory = "C:\\Users\\harda\\Documents\\files";
        String extension = ".txt";
        List<File> expected = new ArrayList<>();
        File one = new File("C:\\Users\\harda\\Documents\\files\\one.txt");
        File two = new File("C:\\Users\\harda\\Documents\\files\\two.txt");
        expected.add(one);
        expected.add(two);
        List<File> result = Stream.fileSearch(directory, extension);
        assertEquals(expected, result);
    }
}