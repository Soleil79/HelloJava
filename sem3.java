import java.util.Arrays;

// Задача 1: Задайте массив из 12 элементов,
// заполненный случайными числами из промежутка [-9, 9].
// Найдите сумму отрицательных и положительных
// элементов массива.

public class sem3 {
    public static void main(String[] args) {
        int[] array = new int[12];
        int min = -9;
        int max = 9;

        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * (max-(min-1)) + (min-1));
        }
        
        String intAString = Arrays.toString(array);
        System.out.println(intAString);
        sum(array);

    }

    public static void sum(int[] args){
        int SumNeg = 0;
        int SumPos = 0;
        for (int i = 0; i < args.length; i++) {
            if (args[i] < 0){
                SumNeg += args[i];
            }
            else {
                SumPos += args[i];
            }            
        }
        System.out.printf("Сумма отрицательных элементов массива равна: %s\n", SumNeg);
        System.out.printf("Сумма отрицательных элементов массива равна: %s\n", SumPos);
    }
}
