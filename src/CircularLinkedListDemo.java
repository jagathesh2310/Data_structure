class CircularLinkedList<T>{
    Node last;
    private class Node{
        Node(T val){
            data=val;
            next=null;
        }
        T data;
        Node next;
    }
    CircularLinkedList(){
        last=null;
    }
    public void insertAtBeginning(T val){
        Node newNode=new Node(val);
        if(last==null){
            newNode.next=newNode;
            last=newNode;
            return;
        }
        newNode.next=last.next;
        last.next=newNode;
    }
    public void insertAtEnd(T val){
        Node newNode=new Node(val);
        if(last==null){
            newNode.next=newNode;
            last=newNode;
            return;
        }
        newNode.next=last.next;
        last.next=newNode;
        last=newNode;
    }
    public void display(){
        Node temp=last.next;
        do{
            System.out.print(temp.data+" ");
            temp=temp.next;
        }while (temp!=last.next);
        System.out.println();

    }
    public T deleteAtBeginning(){
        if (last==null){
            throw new IndexOutOfBoundsException("Deletion attempted in empty list");
        }
        T temp=last.next.data;
        if(last==last.next){
            last=null;
            return temp;
        }
        last.next=last.next.next;
        return temp;
    }
    public void deleteAtEnd(){
        if (last==null){
            throw new IndexOutOfBoundsException("Deletion attempted in empty list");
        }

        if(last==last.next){
            last=null;
            return;
        }
        Node temp=last.next;
        while (temp.next!=last){
            temp=temp.next;
        }
        temp.next=last.next;
        last=temp;

    }
    
}
public class CircularLinkedListDemo{
    public static void main(String[] args) {
        CircularLinkedList<String> list=new CircularLinkedList<>();
        list.insertAtBeginning("A");
        list.insertAtBeginning("B");
        list.display();

        list.insertAtEnd("C");
        list.insertAtEnd("D");
        list.display();
        list.deleteAtBeginning();
        list.display();
        list.deleteAtEnd();
        list.display();


    }
}
