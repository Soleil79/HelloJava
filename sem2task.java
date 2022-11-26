import java.util.Arrays;

// Задача 1: Задайте массив из 12 элементов,
// заполненный случайными числами из промежутка [-9, 9].
// Найдите сумму отрицательных и положительных
// элементов массива.


public class sem2task {
    public static void main(String[] args){
        
        Exercise.Ex1();

    }
}

class Exercise {
    public static void Ex1() {
        int[] newArray = Library.createArray(12, -9, 9);
        Library.printArray(newArray);
        Library.sum(newArray);
    }
}

class Library {

    public static int[] createArray(int size, int min, int max){
        
        int[] array = new int[size];
        int arrayLen = array.length;
        for (int i = 0; i < arrayLen; i++) {
            array[i] = (int)(Math.random() * (max-(min-1)) + (min-1));
        }
        return array;
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

    public static void printArray(int[] args){
        String intAString = Arrays.toString(args);
        System.out.println(intAString);
    }
}

