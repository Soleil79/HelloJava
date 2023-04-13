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

// public static void main(String[] args) throws IOException {
//     Db db = new Db();
//     WriteFile writeFile = new WriteFile(db);
//     ChangeData changeData = new ChangeData(db, writeFile);
//     StaffController staffController = new StaffController(db, writeFile, changeData);
//     View view = new View(staffController);

//     ReadFile ReadFile = new ReadFile();
//     List<String> list = ReadFile.readAllLines();
//     db.employees = ReadFile.readList(list);

//     view.choices();
    
//     view.intScanClose();
//     view.strScanClose();