import java.io.*;

public class Task2 {
    public static void main(String[] args) {
        String filename = "data.txt";
        File file = new File(filename);

        if (!file.exists()) {
            try (FileWriter fw = new FileWriter(file)) {
                fw.write("Hello, world!\nJava is fun.");
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        try (FileInputStream fis = new FileInputStream(filename)) {
            byte[] data = fis.readAllBytes();
            System.out.println("Количество байт: " + data.length);
            String content = new String(data);
            System.out.println("Количество символов: " + content.length());
            if (content.length() > 0) {
                System.out.println("Первый символ: " + content.charAt(0));
                System.out.println("Последний символ: " + content.charAt(content.length() - 1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
