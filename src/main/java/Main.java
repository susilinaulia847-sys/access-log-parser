import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите первое число: ");
        int firstNumber = new Scanner(System.in).nextInt();
        System.out.print("Введите второе число: ");
        int secondNumber = new Scanner(System.in).nextInt();
        int sum = firstNumber + secondNumber;
        int difference = firstNumber - secondNumber;
        int multiplication = firstNumber * secondNumber;
        double quotient = (double) firstNumber / secondNumber;
        System.out.println("Сумма: " + sum);
        System.out.println("Разность: " + difference);
        System.out.println("Произведение: " + multiplication);
        System.out.println("Частное: " + quotient);
    }
}