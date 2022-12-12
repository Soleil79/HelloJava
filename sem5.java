import java.util.*;

public class sem5 {
// hashMap
//     Map – это множество коллекций, работающих с данными 
// по принципу <Ключ / Значение>.

// Ключевые особенности: 
// ускоренная обработка данных;
// порядок добавления не запоминается.

// В HashMap элементы располагаются как угодно и могут 
// менять свое положение.

// Ключевые особенности: 
// допускаются только уникальные ключи, значения 
// могут повторяться;
// помните про null значения*;
// ускоренная обработка данных;
// порядок добавления не запоминается.

  
    // public static void main(String[] args) {
    //     Map<Integer, String> db = new HashMap<>();
    //     db.put(1, "один"); System.out.println(db);
    //     db.put(2, "два"); System.out.println(db);
    //     db.put(3, "три"); System.out.println(db);
    //     db.put(31, "три один"); System.out.println(db);
    //     db.put(13, "один три"); System.out.println(db);
    //     db.put(null, "!null"); System.out.println(db);
    //     db.put(null, null); System.out.println(db);
    // }
    
    // put(K,V) – добавить пару если или изменить значение,если ключ имеется.
    // putIfAbsent(K,V) – произвести добавление если ключ не найден.
    // get(K) - получение значения по указанному ключу.
    // remove(K) – удаляет пару по указанному ключу.
    // containsValue(V) – проверка наличия значения.
    // containsKey(V) – проверка наличия ключа.
    // keySet() – возвращает множество ключей.
    // values() – возвращает набор значений.

//     Работа с парами
// import java.util.*;
    
    // public static void main(String[] args) {
    //     Map<Integer, String> db = new HashMap<>();
    //     db.putIfAbsent(1, "один");
    //     db.put(2, "два");
    //     db.put(3, "три");
    //     System.out.println(db);

    //     for (var item : db.entrySet()) {
    //     System.out.printf("[%d: %s]\n", item.getKey(), item.getValue());
    //     }  
    // }

    //Как ускорить работу
   
    //    public static void main(String[] args) {
    //        Map<Integer,String> map1 = new HashMap<>();
    //        Map<Integer,String> map2 = new HashMap<>(9); // кол-во эл-ов 9
    //        Map<Integer,String> map3 = new HashMap<>(9, 1.0f); // 1.0f - означает что кол-во памяти надо удваивать когда будет 100% заполнено, 0.7f - 70%
    //    }
    
    // HashMap. Любознательным 

    // 1. Хэш-функции и хэш-таблицы
    // 2. Прямое связывание (хэширование с цепочками)
    // 3. Хэширование с открытой адресацией
    // 4. Теория графов:
    //      деревья построенные на списках
    //      бинарные деревья
    //      сбалансированные деревья
    //      *алгоритм балансировки дерева
    //      ** красно-черные деревья, деревья поиска


        // TreeMap!!!

        // public static void main(String[] args) {
        //     TreeMap<Integer,String> tMap = new TreeMap<>();
        //     tMap.put(1,"один"); System.out.println(tMap);
        //     // {1=один}
        //     tMap.put(6,"шесть"); System.out.println(tMap);
        //     // {1=один, 6=шесть}
        //     tMap.put(4,"четыре"); System.out.println(tMap);
        //     // {1=один, 4=четыре, 6=шесть}
        //     tMap.put(3,"три"); System.out.println(tMap);
        //     // {1=один, 3=три, 4=четыре, 6=шесть}
        //     tMap.put(2,"два"); System.out.println(tMap);
        //     // {1=один, 2=два, 3=три, 4=четыре, 6=шесть}
        // }
 
    //  LinkedHashMap!!!

    //“Старший брат”  коллекции HashMap, который всё помнит…
    // Помнит порядок добавления элементов ➜ более  медлительный
    // Map<Integer,String> linkmap = new LinkedHashMap<>();

        public static void main(String[] args) {
            Map<Integer,String> linkmap = new LinkedHashMap<>();
            linkmap.put(11, "один один");
            linkmap.put(1, "два");
            linkmap.put(2, "один");
            System.out.println(linkmap); // {11=один один, 1=два, 2=один}
            Map<Integer,String> map = new HashMap<>();
            map.put(11, "один один");
            map.put(2, "два");
            map.put(1, "один");
            System.out.println(map); // {1=один, 2=два, 11=один один}
        }
 

}






