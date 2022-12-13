// Tn = 1 + 2 + 3 + ... + n

package HW5;

import java.util.Scanner;

public class HW5 {
    public static void main(String[] args) {
        MyExecute.ex1();
    }

    class MyExecute {
        public static void ex1() {
            System.out.println("Вычисление n-ого треугольного числа");
            Scanner in = new Scanner(System.in);
            System.out.print("Введите число: ");
            int n = in.nextInt();
            while (n < 1) {
                System.out.print("Введите число не менее единицы: ");
                n = in.nextInt();
            }
            in.close();
            int Tn = MyLibrary.triangleDigit(n);
            System.out.println("Треугольное число от " + n + " = " + Tn);
            MyLibrary.triangle(n);

        }
    }

    class MyLibrary {

        public static int triangleDigit(int dig) {
            int Tdig = (dig * (dig + 1)) / 2;
            return Tdig;
        }

        public static void triangle(int dig) {

            for (int i = 0; i <= dig; i++) {
                for (int j = i; j > 0; j--) {
                    System.out.print("* ");
                }
                System.out.println();
            }

        }

    }

}
