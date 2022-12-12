


// LinkedList. Список
// Мотивация.
// LinkedList нужен для небольшого количества 
// элементов, в которых операции добавления\удаления 
// встречаются чаще операций чтения.

// Queue. First in, first out!

// import java.util.*;
// public class Ex002_Queue {
//    public static void main(String[] args) {
//        Queue<Integer> queue = new LinkedList<Integer>();
//        queue.add(1);
//        queue.add(2);
//        queue.add(3);
//        queue.add(4);
//        System.out.println(queue); // [1, 2, 3, 4]
//        int item = queue.remove();
//        System.out.println(queue); // [2, 3, 4]
//        queue.offer(2809);
//        item = queue.remove();
//        System.out.println(queue); // [3, 4, 2809]
//        item = queue.remove();
//        System.out.println(queue); // [4, 2809]
//        item = queue.poll();
//        System.out.println(queue); // [2809]
//    }
// }

// PriorityQueue
// Наивысший приоритет имеет «наименьший» элемент.
// import java.util.*;
// public class sem4 {
//    public static void main(String[] args) {
//        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
//        pq.add(123);
//        pq.add(3);
//        pq.add(13);
//        pq.add(1);
//        System.out.println(pq);
//        System.out.println(pq.poll());
//        System.out.println(pq.poll());
//        System.out.println(pq.poll());
//        System.out.println(pq.poll());
//        System.out.println(pq.poll()); // Элементы для извлечения закончились: null
//    }
// }

// Deque
// Линейная коллекция, которая поддерживает вставку и удаление элементов на обоих концах. 

// import java.util.*;
// public class Sem4 {
//    public static void main(String[] args) {
//        Deque<Integer> deque = new ArrayDeque<>();
//        Deque<Integer> deque = new ArrayDeque<>();
//        deque.addFirst(1);   deque.addLast(2);
//        deque.removeLast();  deque.removeLast();
//        deque.offerFirst(1); deque.offerLast(2);
//        deque.pollFirst();   deque.pollLast();
//        deque.getFirst();    deque.getLast();
//        deque.peekFirst();   deque.peekLast();
//    }
// }


// Stack. First in, last out!
// Stack представляет собой обработку данных по принципу LIFO.Расширяет Vector пятью операциями, которые позволяют рассматривать вектор как стек.
// push(E item)
// pop()
// import java.util.*;
// public class Ex004_Stack {
//    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//        stack.push(12);
//        stack.push(123);
//        System.out.println(stack.pop()); // 123
//        System.out.println(stack.pop()); // 12
//        System.out.println(stack.pop()); // 1
//    }
// }


