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
            System.out.println("Условные обозначеия: 99 - препятствие, -1 - свободные ячейки, 0 - точка начала маршрута \n");
            Scanner in = new Scanner(System.in);            
            System.out.print("Введите величину карты: ");
            int dim = in.nextInt();
            System.out.print("\n");
            // in.close();

            int[][] intarray = new int[dim][dim];
           
            MyLibrary.arrCreate(intarray, dim);
            MyLibrary.printArr(intarray, dim);

            
            System.out.print("Введите координаты точки начала маршрута по оси х: ");
            int inX = in.nextInt();
            System.out.print("Введите координаты точки начала маршрута по оси y: ");
            int inY = in.nextInt();
            System.out.print("Введите координаты точки конца маршрута по оси х: ");
            int outX = in.nextInt();
            System.out.print("Введите координаты точки конца маршрута по оси y: ");
            int outY = in.nextInt();       
            
           
            intarray = MyLibrary.startPoint(intarray, inX, inY); // Копия массива с точкой начала маршрута - 0
            MyLibrary.printArr(intarray, dim);
            in.close();

            MyLibrary.wavesCreate(intarray, 0); 

            System.out.println("Визуализация распространения волн по массиву. 100 - путь в эту точку не найден \n");
            MyLibrary.printArr(intarray, dim);
            
            //Поиск маршрута 
            MyLibrary.findPath(intarray, outX, outY, inX, inY); 
            MyLibrary.printArr(intarray, dim);

        }    
    }

    
    class MyLibrary {

          /** 
        * @param steps - метод создания массива      
        */
        public static int [][] arrCreate (int [][] array, int size) {
        

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

        public static int[][]startPoint (int [][] myarray, int x, int y) {
            
                                
            if ( myarray[x][y] == -1){
                myarray[x][y] = 0;
            }
            else{
                System.out.println("\n!Введите коректные координаты точки начала маршрута!\n");
                Scanner in = new Scanner(System.in);
                System.out.print("Введите координаты точки начала маршрута по оси х: ");
                int newX = in.nextInt();
                System.out.print("Введите координаты точки начала маршрута по оси y: ");
                int newY = in.nextInt();

                startPoint(myarray, newX, newY);
                in.close();
            } 
             
            
            return myarray;                

        }

        public static int [][] wavesCreate (int [][] array, int count) { 

                
            for (int i = 1; i < array.length-1; i++) { 
        
                for (int j = 1; j < array[i].length-1; j++) {      
                    
                    
                    if ((array[i][j] == -1) && (array[i][j-1] == count || array[i][j+1] == count || array[i-1][j] == count || array[i+1][j] == count)){
                        array[i][j] = count+1;                               

                    }                           
                    
                }
                
            }

            for (int i = 1; i < array.length-1; i++) {         
                for (int j = 1; j < array[i].length-1; j++) 
                if (array[i][j] == (-1)){
                    wavesCreate(array, count+1); 
                }                              
                 
            }    
            return array;
        }  
    

        public static int [][] findPath (int [][] myarray, int x, int y, int inx, int iny) { 
            // Проверка конечной точки маршрута
            if ( myarray[x][y] <= 0 && myarray[x][y] >= 99 ){
             
                System.out.println("\n!Введите коректные координаты конечной точки маршрута!\n");
                Scanner in = new Scanner(System.in);
                System.out.print("Введите координаты конечной точки маршрута по оси х: ");
                int newX = in.nextInt();
                System.out.print("Введите координаты конечной точки маршрута по оси y: ");
                int newY = in.nextInt();

                findPath(myarray, newX, newY, inx, iny);
                in.close();
            }              
           
            // ArrayList<String> mylist = new ArrayList<>();
           

            System.out.println("Визуализация маршрута от начальной до конечной точки (путь показан нулями): \n");

            if (x > inx || x == inx && x > inx){
                while (myarray[x][y] != 0){
                    int temp = myarray[x][y];

                    for (int i = x; i < myarray.length-1; i++) { 
                
                        for (int j = y; j < myarray[i].length-1; j++) {     
                                                    
                            if (myarray[i][j-1] == temp - 1){
                                temp = myarray[i][j-1];                             
                                myarray[i][j] = 888; // Пока взяла 888 для визуализации пути
                                // mylist.add("x : " + i + " y : " + j);
                                y = j-1;
                                break;
                            }                     
                            if (myarray[i][j+1] == temp-1){
                                temp = myarray[i][j+1];                            
                                myarray[i][j] = 888;
                                // mylist.add("x : " + i + " y : " + j);
                                y = j+1;  
                                break;
                            }
                            if (myarray[i-1][j] == temp - 1 ){
                                temp = myarray[i-1][j];
                                myarray[i][j] = 888;
                                // mylist.add("x : " + i + " y : " + j);
                                x = i-1; 
                                break;
                            } 
                            if (myarray[i+1][j] == temp - 1){
                                temp = myarray[i+1][j];                             
                                myarray[i][j] = 888;
                                // mylist.add("x : " + i + " y : " + j);
                                x = i+1;  
                                break;
                            
                            }                           
                            
                        }
                        
                    }
                }
            }
            else{
                while (myarray[x][y] != 0){
                    int temp = myarray[x][y];

                    for (int i = x; i > 0; i--) { 
                
                        for (int j = y; j > 0; j--) {     
                                                    
                            if (myarray[i][j-1] == temp - 1){
                                temp = myarray[i][j-1];                             
                                myarray[i][j] = 888; // Пока взяла 888 для визуализации пути
                                // mylist.add("x : " + i + " y : " + j);
                                y = j-1;
                                break;
                            }                     
                            if (myarray[i][j+1] == temp-1){
                                temp = myarray[i][j+1];                            
                                myarray[i][j] = 888;
                                // mylist.add("x : " + i + " y : " + j);
                                y = j+1;  
                                break;
                            }
                            if (myarray[i-1][j] == temp - 1 ){
                                temp = myarray[i-1][j];
                                myarray[i][j] = 888;
                                // mylist.add("x : " + i + " y : " + j);
                                x = i-1; 
                                break;
                            } 
                            if (myarray[i+1][j] == temp - 1){
                                temp = myarray[i+1][j];                             
                                myarray[i][j] = 888;
                                // mylist.add("x : " + i + " y : " + j);
                                x = i+1;  
                                break;
                            
                            }                           
                            
                        }
                        
                    }
                }
            }
            for (int i = 1; i < myarray.length-1; i++) {         
                for (int j = 1; j < myarray[i].length-1; j++) 
                {
                    if (myarray[i][j] == 888){
                        myarray[i][j] = 0;
                    }
                    if (myarray[i][j] > 0 && myarray[i][j] < 99){
                        myarray[i][j] = (-1);
                    }
                }
            }

            // System.out.println(mylist);   
            return myarray;
        }
    

    }

}
        
   