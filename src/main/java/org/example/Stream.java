package org.example;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
public class Stream {
    //1.1
    public static void writeIntegersToBinary(int[] numbers, String filename) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            dos.writeInt(numbers.length);
            for (int num : numbers) {
                dos.writeInt(num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //1.2
    public static int[] readIntegersFromBinary(String filename) {
        int[] result = null;
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            int length = dis.readInt();
            result = new int[length];
            for (int i = 0; i < length; i++) {
                result[i] = dis.readInt();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    //2.1
    public static void writeIntegersToText(int[] numbers, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < numbers.length; i++) {
                bw.write(Integer.toString(numbers[i]));
                if (i < numbers.length - 1) {
                    bw.write(" ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //2.2
    public static int[] readIntegersFromText(String filename) {
        int[] result = null;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            String[] split = line.split(" ");
            result = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                result[i] = Integer.parseInt(split[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    //3
    public static int[] readIntegersClass(String filename, int position) {
        int[] result = null;
        try (RandomAccessFile raf = new RandomAccessFile(filename, "r")) {
            int length = raf.readInt();
            raf.seek(position * Integer.BYTES);
            result = new int[length - position + 1];
            for (int i = 0; i < length - position + 1; i++) {
                result[i] = raf.readInt();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    //4
    public static List<File> fileSearch(String directory, String extension) {
        List<File> result = new ArrayList<>();
        File d = new File(directory);
        File[] arr = d.listFiles();
        if (arr != null) {
            for (File i : arr) {
                if (i.isFile() && i.getName().endsWith(extension)) {
                    result.add(i);
                }
            }
        }
        return result;
    }
}