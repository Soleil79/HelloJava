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
// a: 22 b: 2022 c: 11 d: 56 -> 0   !!!!!!!!!!!
// a: 22 b: 2022 c: 11 d: 10 -> 18   !зеркалит цифры
// a: 22 b: 2022 c: 3 d: 1 -> 763827
// a: 22 b: 20220 c: 3 d: 1 -> 535173226980 
// a: 1 b: 1111 c: 2 d: 1 -> 3990330794  
// a: 1 b: 11111 c: 2 d: 1 -> 606408167570737286  



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class test {
    // public static void main(String[] args) {
    //     MyExecute.ex1();     
    // }

    // class MyExecute {
    //     public static void ex1() {
    //         System.out.println("Программа для определения количества шагов для преобразования числа а в число b, путем либо умножения (в c раз), либо прибавления (на d единиц) ");
    //         Scanner in = new Scanner(System.in);
    //         System.out.print("Введите число а, которое необходимо преобразовать: ");
    //         int a = in.nextInt();
    //         System.out.print("Введите число b, к которому нужно преобразовать число а: ");
    //         int b = in.nextInt();
    //         System.out.print("Введите число с, определяющее шаг умножения: ");
    //         int c = in.nextInt();
    //         System.out.print("Введите число d, определяющее шаг сложения: ");
    //         int d = in.nextInt();
    //         in.close();
    //         long[] myArr = MyLibrary.arrCreate(a, b, c, d);
    //         int pathCount = 0;
           
    //         if (a < b){
    //             Long paths = MyLibrary.steps(a, b, c, d, (long) pathCount, myArr);
                
    //             if (paths != 0){
    //                 MyLibrary.commands(a, b, c, d, myArr);
    //             } 
    //             if (paths == 0){
    //                 System.out.print("Нет решения");  
    //             }                
    //         }
    //         else {
    //             System.out.print("Нет решения");  
    //         }   
    //     }    
    // }

    
    // class MyLibrary {

    //       /** 
    //     * @param steps - метод создания массива      
    //     */
    //     public static long [] arrCreate (int a, int b, int c, int d) {
    //         long[] array = new long[b+1];
    //         int size = array.length;
            
    //         for (int i = 0; i < size; i++ ){
    //             array[i] = i;
                
    //         }
    //         System.out.println(Arrays.toString(array));            
    //         return array;
    //     }

    //     /** 
    //     * @param steps - метод вывода общего количества преобразований числа 'a' в число 'b'       
    //     */
    //     public static Long steps (int a, int b, int c, int d, Long count, long[] array) {        
    //         int size = array.length;            
    //         HashMap<Long, Long> stepHashMap = new HashMap<>();
    //         stepHashMap.put((long) a, (long) 1);        
    //         for (int i = a+1; i < size; i++ ){
    //             if (array[i] % c == 0 && array[i]/c >= a){  
    //                 long division = (array[i] / c);                    
    //                 Long valDiv = stepHashMap.get(division);
                    
    //                 if (array[i-d] >= a){
    //                     long substruct = (array[i] - d);
    //                     long valSubstr = stepHashMap.get(substruct);
    //                     stepHashMap.put(array[i], valSubstr+valDiv); 
    //                 }
    //                 else {                        
    //                     stepHashMap.put(array[i], valDiv);                        
    //                 }                   
    //             } 
    //             if (array[i] % c == 0 && array[i]/c < a){
    //                 if (array[i-d] >= a){
    //                     long substr = (array[i] - d);
    //                     long valSub = stepHashMap.get(substr);
    //                     stepHashMap.put(array[i], valSub);  
    //                 }
    //                 else {
    //                     stepHashMap.put(array[i], (long) 0); 
    //                 }                                     
    //             }

    //             if (array[i] % c != 0 ) {
    //                 if (array[i-d] >= a){
    //                     long temp = (array[i] - d);
    //                     long valOdd = stepHashMap.get(temp);
    //                     stepHashMap.put(array[i], valOdd);
    //                 }
    //                 else {
    //                     stepHashMap.put(array[i], (long) 0);                       
    //                 }                    
    //             }                
    //         }
    //         System.out.println(Arrays.asList(stepHashMap)); 
    //         count = stepHashMap.get((long) b);
    //         System.out.printf("Количество возможных преобразований %s: \n", count);    
    //         return count;    
    //     }

    //     /** 
    //     * @param commands - метод вывода маршрута c наименьшим количеством шагов для преобразования числа 'a' в число 'b'        
    //     */
    //     public static void commands (int a, int b, int c, int d, long[] myArr) { 
    //         String k1 = new String(" ,c*"); // умножение *c
    //         String k2 = new String(" ,d+"); // прибавление +d  
          

    //         Integer size = myArr.length-1;   
    //         Integer count = 0;
    //         ArrayList<Integer> list1 = new ArrayList<Integer>();
    //         String commandStr = "";
    //         int i = size;

            
    //         while (i > a){                
    //             if (myArr[i] %c == 0 && myArr[i] / c >= a){
                   
    //                 i = (int) (myArr[i] / c);
    //                 list1.add((int) myArr[i]);
    //                 commandStr += k1;                   
    //                 count++;
    //             }
    //             else{
    //                 i = (int) (myArr[i] - d);
    //                 list1.add((int) myArr[i]);
    //                 commandStr += k2;                    
    //                 count++;
    //             } 
                
                              
    //         }
            
    //         String reversedStr = new StringBuffer(commandStr).reverse().toString();                  
    //         System.out.printf("Минимальное количество шагов в маршруте: %s \n", count);
    //         ArrayList<Integer> listReversed = new ArrayList<>(list1);
            
    //         Collections.reverse(listReversed);
    //         listReversed.add(b);
    //         // System.out.println(list1);
    //         System.out.printf("%s - этапы преобразования числа 'а' в число 'b' \n", listReversed);
    //         System.out.printf("%s - набор команд, позволяющий число 'a' превратить в число 'b'", reversedStr); 
    //     }
    // }

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
            System.out.print("Введите число с, определяющее шаг умножения: ");
            int c = in.nextInt();
            System.out.print("Введите число d, определяющее шаг сложения: ");
            int d = in.nextInt();
            in.close();
            long[] myArr = MyLibrary.arrCreate(a, b, c, d);
            int pathCount = 0;
           
            if (a < b){
                Long paths = MyLibrary.steps(a, b, c, d, (long) pathCount, myArr);
                
                if (paths != 0){
                    MyLibrary.commands(a, b, c, d, myArr);
                } 
                if (paths == 0){
                    System.out.print("Нет решения");  
                }                
            }
            else {
                System.out.print("Нет решения");  
            }   
        }    
    }

    
    class MyLibrary {

          /** 
        * @param steps - метод создания массива      
        */
        public static long [] arrCreate (int a, int b, int c, int d) {
            long[] array = new long[b+1];
            int size = array.length;
            
            for (int i = 0; i < size; i++ ){
                array[i] = i;
                
            }
            // System.out.println(Arrays.toString(array));            
            return array;
            
   
        }

        /** 
        * @param steps - метод вывода общего количества преобразований числа 'a' в число 'b'       
        */
        public static Long steps (int a, int b, int c, int d, Long count, long[] array) {        
            Long size = (long) array.length;            
            HashMap<Long, Long> stepHashMap = new HashMap<>();
            stepHashMap.put((long) a, (long) 1);        
            for (int i = a+1; i < size; i++ ){
                if (array[i] % c == 0 && array[i]/c >= a){  
                    long division = (array[i] / c);                    
                    Long valDiv = stepHashMap.get(division);
                    
                    
                    if (i-d >= a && i > 0){
                        long substruct = (array[i] - d);
                        long valSubstr = stepHashMap.get(substruct);
                        stepHashMap.put(array[i], valSubstr+valDiv); 
                       
                    }
                    else {                        
                        stepHashMap.put(array[i], valDiv);                        
                    }                   
                } 
                if (array[i] % c == 0 && array[i]/c < a){
                    if (i-d >= a && i > 0){
                        long substr = (array[i] - d);
                        long valSub = stepHashMap.get(substr);
                        stepHashMap.put(array[i], valSub);  
                    }
                    else {
                        stepHashMap.put(array[i], (long) 0); 
                    }                                     
                }

                if (array[i] % c != 0 ) {
                    
                    if (i-d >= a && i > 0){
                        long temp = (array[i]-d);
                        long valOdd = stepHashMap.get(temp);
                        stepHashMap.put(array[i], valOdd);
                    }
                    else {
                        stepHashMap.put(array[i], (long) 0);                       
                    }                    
                }                
            }
            System.out.println(Arrays.asList(stepHashMap)); 
            count = stepHashMap.get((long) b);
            System.out.printf("\n Количество возможных преобразований %s: \n", count);    
            return count;    
        }


        /** 
        * @param commands - метод вывода маршрута c наименьшим количеством шагов для преобразования числа 'a' в число 'b'        
        */
        public static void commands (int a, int b, int c, int d, long[] myArr) { 
            String k1 = new String(" ,c*"); // умножение *c
            String k2 = new String(" ,d+"); // прибавление +d  
                        
            Integer count = 0;
            ArrayList<Long> list1 = new ArrayList<Long>();
            String commandStr = "";
            int i = myArr.length-1;  

            
            while (i > a){            
                // System.out.println(i);

                if (i %c == 0 && i / c >= a){
                    
                    

                    if ((i%c == 0) || (i / c > a && i/c % d == 0) || (i / c > a && (i / c) - d >= a)){                      
                        i = i/c;
                        list1.add((long) i);
                        commandStr += k1;                   
                        count++;
                    }
                                    
                    else {
                        i = i - d;
                        list1.add((long) i);
                        commandStr += k2;                    
                        count++;
                    }
                }

                
                if (i %c != 0 && i - d >= a ){
                    i = i - d;
                    list1.add((long) i);
                    commandStr += k2;                    
                    count++;
                }    

                         
            }
            
            String reversedStr = new StringBuffer(commandStr).reverse().toString();                  
            System.out.printf("Минимальное количество шагов в маршруте: %s \n", count);
            ArrayList<Long> listReversed = new ArrayList<>(list1);
            
            Collections.reverse(listReversed);
            listReversed.add((long) b);
            System.out.println(list1);
            System.out.printf("%s - этапы преобразования числа 'а' в число 'b' \n", listReversed);
            System.out.printf("%s - набор команд, позволяющий число 'a' превратить в число 'b'", reversedStr); 
        }
    }
}

