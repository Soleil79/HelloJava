
import java.util.Arrays;

// Реализовать алгоритм сортировки массива слиянием

// За основу взят массив из задания на семинаре. (метод с нахождением суммы полож. и отрицательных элементов закомментирован)


public class HW2 {
    public static void main(String[] args) {
        MyExecute.ex1();       

    }
}

class MyExecute {
    public static void ex1() {
        int[] newArray = MyLibrary.createArray(12, -9, 9);
        MyLibrary.printArray(newArray);
        // MyLibrary.sumArr(newArray);
        int[] sortArr = MyLibrary.mergeSort(newArray);              
        MyLibrary.printArray(sortArr);
        }    
}

class MyLibrary {

    public static int[] createArray(int size, int min, int max) {

        int[] array = new int[size];
        int arrayLen = array.length;
        for (int i = 0; i < arrayLen; i++) {
            array[i] = (int) (Math.random() * (max - (min - 1)) + (min - 1));
        }
        return array;
    }

    // Метод нахождения суммы положительных и отрицательных элементов массива
    // public static void sumArr(int[] args) {
    //     int SumNeg = 0;
    //     int SumPos = 0;
    //     for (int i = 0; i < args.length; i++) {
    //         if (args[i] < 0) {
    //             SumNeg += args[i];
    //         } else {
    //             SumPos += args[i];
    //         }
    //     }
    //     System.out.printf("Сумма отрицательных элементов массива равна: %s\n", SumNeg);
    //     System.out.printf("Сумма отрицательных элементов массива равна: %s\n", SumPos);
    // }

    public static void printArray(int[] args) {
        String intAString = Arrays.toString(args);
        System.out.println(intAString);
    }
   

    public static int[] mergeSort(int[] sortArr) {
        int[] buffer1 = Arrays.copyOf(sortArr, sortArr.length);
        int[] buffer2 = new int[sortArr.length];
        int[] result = mergeSortInner(buffer1, buffer2, 0, sortArr.length);
        return result;
    }

    public static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        //уже отсортирован
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);

        //слияние 
        // ? : Альтернатива if/else. Если условие истино, то присваивается значение до двоеточия, если ложно - после двоеточия.
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
    
}