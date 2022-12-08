// Инициализация

// Пометить стартовую ячейку 
// d := 0 
// Распространение волны

// ЦИКЛ
//   ДЛЯ каждой ячейки loc, помеченной числом d
//     пометить все соседние свободные непомеченные ячейки числом d + 1
//   КЦ
//   d := d + 1
// ПОКА (финишная ячейка не помечена) И (есть возможность распространения волны) 
// Восстановление пути

// ЕСЛИ финишная ячейка помечена
// ТО
//   перейти в финишную ячейку
//   ЦИКЛ
//     выбрать среди соседних ячейку, помеченную числом на 1 меньше числа в текущей ячейке
//     перейти в выбранную ячейку и добавить её к пути
//   ПОКА текущая ячейка — не стартовая
//   ВОЗВРАТ путь найден
// ИНАЧЕ
//   ВОЗВРАТ путь не найден

// Реализовать волновой алгоритм и подготовиться к его решению.
// 1. Описать логику получения карты
// 2. Описать логику заполнения карты
// 3. Описать как установить точку начала получения маршрута
// 4. Будет ли отличаться решение, если на карте будет несколько выходов
// Теория
// +ГИТ. readme.md


package HW4;

import java.util.Arrays;
import java.util.Scanner;

public class HW4 {
    public static void main(String[] args) {
        MyExecute.ex1();     
    }

    class MyExecute {
        public static void ex1() {
            System.out.println("Реализация волнового алгоритма \n");
            Scanner in = new Scanner(System.in);
            // System.out.print("Введите координаты точки начала маршрута по оси х: ");
            // int inX = in.nextInt();
            // System.out.print("Введите координаты точки начала маршрута по оси y: ");
            // int inY = in.nextInt();
            // System.out.print("Введите координаты точки конца маршрута по оси х: ");
            // int outX = in.nextInt();
            // System.out.print("Введите координаты точки конца маршрута по оси y: ");
            // int outY = in.nextInt();
            System.out.print("Введите величину карты: ");
            int dim = in.nextInt();
            System.out.print("\n");
            // in.close();

            int[][] array = new int[dim][dim];
           
            MyLibrary.arrCreate(array, dim);
            MyLibrary.printArr(array, dim);

            
            System.out.print("Введите координаты точки начала маршрута по оси х: ");
            int inX = in.nextInt();
            System.out.print("Введите координаты точки начала маршрута по оси y: ");
            int inY = in.nextInt();
            System.out.print("Введите координаты точки конца маршрута по оси х: ");
            int outX = in.nextInt();
            System.out.print("Введите координаты точки конца маршрута по оси y: ");
            int outY = in.nextInt();       
            in.close();
           
           
        
        }    
    }

    
    class MyLibrary {

          /** 
        * @param steps - метод создания массива      
        */
        public static int [][] arrCreate (int [][] array, int size) {
            
                
         
        //         // array[0][0] = 1; первая скобка - строка, вторая столбец
        //         // array[0][1] = 2;
        //         // array[1][0] = 3;
        //         // array[1][1] = 4;

            for (int [] row : array){
                Arrays.fill(row, -1); 
            }

            // Заполняем карту препятствиями:
           for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                int obstacle = (int) ((Math.random() * ((size)-1)) + 1);                
                if (j == obstacle || i+1 == obstacle){
                    array[i][j] = 99;
                }
                if ((i == 0 || j == 0) || (i == size-1 || j == size-1)){
                    array[i][j] = 99;
                }                             
              
            }          
        }
        return array;
    }               

        
        public static void printArr  (int [][] array, int size) {
            
                String [] xString = new String[size];
                xString[0] = " ";
                System.out.printf("%s\t", xString[0]);
                xString[1] = "0";
                System.out.printf("%s\t", xString[1]);
                for (int el = 1; el < size; el++) {
                    xString[el] = Integer.toString(el);
                    System.out.printf("%s\t", xString[el]);
                }
                
                System.out.print("\n\n");
                int count = 0;
                for (int i = 0; i < array.length; i++) {
                    System.out.print(count + "\t");
                                    
                    for (int j = 0; j < array[i].length; j++) {                        
                        System.out.print(array[i][j] + "\t");
                    }
                    
                    count++;
                    System.out.println("\n\n");
                }
               
            }
        

        }
}
        
    
