package Algorithms.ListRevert;

public class List {
    private Node head;
   
    public List (){
        head = null;
    }  

    private boolean isEmpty(){
        return head == null;
    }

    public void add(int value){
    Node newNode = new Node(value);
    Node currentNode = head;
    if (head == null){
        head = newNode;
    }
    else {
        while (currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
    }
}

    public void print(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }
    
    // разворот односвязного списка 
    public void revert() {
        if (head != null && head.next != null){
            Node temp = head;
            revertOneConectedList(head.next, head);
            temp.next = null;
        }
    }

    public void revertOneConectedList(Node currentNode, Node previousNode){
        if (currentNode.next == null){
            head = currentNode;
        }
        else{
            revertOneConectedList(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;
    }


}
