package Algorithms.ListRevert;

public class Program{
    public static void main (String[] args){
        List list = new List();
        
        
        list.add(15);
        list.add(25);
        list.add(35);
        list.add(45);
        list.add(55);
        System.out.println("Наш односвязный список: ");
        list.print();
        list.revert();
        System.out.println("\nРазвернутый односвязный список:");
        list.print();
      
    }
}

