import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static class TooLongLineException extends Exception {
        public TooLongLineException(String message) {
            super(message);
        }
    }
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

                int countLines = 0;
                int longestLength = 0;
                int shortestLength = Integer.MAX_VALUE;

                try (FileReader fileReader = new FileReader(file);
                     BufferedReader reader = new BufferedReader(fileReader)) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        countLines++;
                        int len = line.length();

                        if (len > 1024) {
                            throw new TooLongLineException("Длина строки (" + len + ") превышает максимальный размер (1024)");
                        }

                        if (len > longestLength) {
                            longestLength = len;
                        }
                        if (len < shortestLength) {
                            shortestLength = len;
                        }
                    }

                    System.out.println("Общее количество строк в файле: " + countLines);
                    System.out.println("Длина самой длинной строки в файле: " + longestLength + " символов");
                    System.out.println("Длина самой короткой строки в файле: " + shortestLength + " символов");

                } catch (FileNotFoundException fnfe) {
                    System.err.println("Файл не найден: " + fnfe.getMessage());
                } catch (TooLongLineException tlle) {
                    System.err.println(tlle.getMessage());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}