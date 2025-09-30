import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        while (true) {
            System.out.print("Введите путь к файлу: ");
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();
            if (fileExists && isDirectory) {
                System.out.println("Файл найден, но это папка");
                continue;
            }
            if (!fileExists && !isDirectory) {
                System.out.println("Путь указан неверно, файл не найден");
                continue;
            }
            if (fileExists) {
                System.out.println("Путь указан верно");
                sum++;
                System.out.println("Это файл номер" + " " + sum);
            }
        }
    }
}