// На вход
// некоторому исполнителю
// подаётся четыре числа (a, b, c, d).

// У исполнителя есть две команды
// - команда 1 (к1): увеличить в с раз, а умножается на c
// - команда 2 (к2): увеличить на d , к a прибавляется d
// написать программу, которая выдаёт общее количество
// возможных преобразований a в b
// набор команд, позволяющий число a превратить в число b или сообщить, что это
// невозможно

// Пример 1: а = 1, b = 7, c = 2, d = 1
// ответ: к1, к1, к1, к1, к1, к1 или к1, к2, к1, к1, к1 или к1, к1, к2, к1.
// Пример 2: а = 11, b = 7, c = 2, d = 1
// ответ: нет решения.
// *Подумать над тем, как сделать минимальное количество маршрутов / вывод маршрута (хотя бы одного)

// Тестовые данные

// a: 2 b: 7 c: 2 d: 1 -> 3
// a: 3 b: 27 c: 3 d: 2 -> 6
// a: 30 b: 345 c: 5 d: 6 -> 0
// a: 30 b: 345 c: 2 d: 1 -> 7047
// a: 22 b: 333 c: 3 d: 1 -> 467
// a: 55 b: 555 c: 5 d: 2 -> 30
// a: 22 b: 2022 c: 11 d: 56 -> 0
// a: 22 b: 2022 c: 11 d: 10 -> 18
// a: 22 b: 2022 c: 3 d: 1 -> 763827
// a: 22 b: 20220 c: 3 d: 1 -> 535173226980
// a: 1 b: 1111 c: 2 d: 1 -> 3990330794
// a: 1 b: 11111 c: 2 d: 1 -> 606408167570737286

package HW3;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class HW3 {
    public static void main(String[] args) {
        MyExecute.ex1();       

    }

    class MyExecute {
        public static void ex1() {
            System.out.println("Программа для определения количества шагов для преобразования числа а в число b, путем либо умножения (в c раз), либо прибавления (на d единиц) ");
            Scanner in = new Scanner(System.in);
            System.out.print("Введите число а, которое необходимо преобразовать: ");
            int a = in.nextInt();
            System.out.print("Введите число b, к которому нужно преобразовать число а: ");
            int b = in.nextInt();
            System.out.print("Введите число с, определяющего шаг умножения: ");
            int c = in.nextInt();
            System.out.print("Введите число d, определяющее шаг сложения: ");
            int d = in.nextInt();
            in.close();
            MyLibrary.Steps(a, b, c, d);
            }    
    }

    
    class MyLibrary {

        public static void Steps (int a, int b, int c, int d) {
           
            int[] array = new int[b+1];
            int size = array.length;
            for (int i = a; i < size; i++ ){
                array[i] = i;
                // System.out.println(array[i]);
            }
            
            HashMap<Integer, Integer> stepHashMap = new HashMap<>();
            stepHashMap.put(a, 1);           
            
            for (int i = a+1; i < size; i++ ){
                if (array[i] % c == 0 && array[i]/c >= a){
                    int division = array[i] / c;                    
                    int valDiv = stepHashMap.get(division);
                    
                    if (array[i-d] >= a){
                        int substruct = array[i] - d;
                        int valSubstr = stepHashMap.get(substruct);
                        stepHashMap.put(array[i], valSubstr+valDiv);
                    }
                    else {                        
                        stepHashMap.put(array[i], valDiv);                        
                    }                   
                } 
                if (array[i] % c == 0 && array[i]/c < a){
                    if (array[i-d] >= a){
                        int substr = array[i] - d;
                        int valSub = stepHashMap.get(substr);
                        stepHashMap.put(array[i], valSub);  
                    }
                    else {
                        stepHashMap.put(array[i], 0); 
                    }
                                     
                }

                if (array[i] % c != 0) {
                    if (array[i-d] >= a){
                        int temp = array[i-d];
                        int valOdd = stepHashMap.get(temp);
                        stepHashMap.put(array[i], valOdd);
                    }
                    else {
                        stepHashMap.put(array[i], 0);                       
                    }                    
                }
                
            }
            System.out.println(Arrays.asList(stepHashMap)); 
          
            // return array;
        }
        
    }

}


