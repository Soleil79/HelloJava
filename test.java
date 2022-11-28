import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        
        int[] newArr = createArray(12, -9, 9); 
        printArray(newArr);
    }
    
    public static int[] createArray(int size, int min, int max){
        
        int[] array = new int[size];
        int arrayLen = array.length;
        for (int i = 0; i < arrayLen; i++) {
            array[i] = (int)(Math.random() * (max-(min-1)) + (min-1));
        }
        return array;
    }

    public static void printArray(int[] args){
        String intAString = Arrays.toString(args);
        System.out.println(intAString);
    }
}
