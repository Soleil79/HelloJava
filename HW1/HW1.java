// Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых действий к минимуму.
// Пример 1: а = 3, b = 2, ответ: 9
// Пример 2: а = 2, b = -2, ответ: 0.25
// Пример 3: а = 3, b = 0, ответ: 1
// Пример 4: а = 0, b = 0, ответ: не определено
// Пример 5
// входные данные находятся в файле input.txt в виде
// b 3
// a 10
// Результат нужно сохранить в файле output.txt
// 1000

import java.io.*;
import java.lang.String;
import java.io.FileWriter;
import java.lang.Exception;


public class HW1 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        FileWriter fw = new FileWriter("output.txt", false);
        
        String str;
        Integer a = null;
        Integer b = null;
        double result;
        while ((str = br.readLine()) != null) {
            if (str.contains("a")) {
                // System.out.printf("%s\n", str);
                String[] wordsA = str.split("\\s");
                a = Integer.parseInt(wordsA[1]);
                System.out.printf("Число а: %s\n", a);                              
            }
            else if  (str.contains("b")) {
                // System.out.printf("%s\n", str);
                String[] wordsB = str.split("\\s");
                b = Integer.parseInt(wordsB[1]);
                System.out.printf("Возвести в степень b: %s\n", b);
            }  
        }
        
        result = Math.pow(a, b);
        if (a != 0){
            System.out.printf("Результат: %s\n", result);
            String fwResult = Double.toString(result);
            fw.write(fwResult); 
        }
        else{
            String nullPow = "не определено";
            System.out.println(nullPow);
            fw.write(nullPow); 
        }

        
        br.close();
        fw.close();
    }

}