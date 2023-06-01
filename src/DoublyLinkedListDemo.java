import java.util.Iterator;

class DoublyLinkedList<T> implements Iterable<T>{
    private Node head;
    private Node tail;

    @Override
    public Iterator iterator() {
        return new Iterator() {
            Node temp=head;
            @Override
            public boolean hasNext() {
                if(temp==null){
                    return false;
                }
                return true;
            }

            @Override
            public T next() {
                T val=temp.data;
                temp=temp.next;
                return val;
            }
        };
    }

    private class Node{
        Node(T val){
            data=val;
            next=null;
            prev=null;
        }
        T data;
        Node next;
        Node prev;
    }
    DoublyLinkedList(){
        head=null;
        tail=null;
    }
    public void insertAtBeginning(T val){
        Node newNode=new Node(val);
        if(head==null){
            head=newNode;
            tail=newNode;
        }
        else{
            head.prev=newNode;
            newNode.next=head;
            head=newNode;
        }

    }
    public void insertAtPos(int pos,T val){
        if (pos==0){
            insertAtBeginning(val);
            return;
        }
        Node newNode=new Node(val);
        Node temp=head;
        for (int i=1;i<pos;i++){
            temp=temp.next;
            if(temp==null){
                throw new IllegalArgumentException("Invalid position");
            }
        }

        newNode.next=temp.next;
        newNode.prev=temp;
        if(temp==tail){
            tail=newNode;
        }
        else {
            temp.next.prev = newNode;
        }
        temp.next=newNode;
    }
    public void deleteAtBeginning(){
        head=head.next;
        if(head!=null){
            head.prev=null;
            return;
        }
        tail=null;
    }
    public void deleteAtPos(int pos){
        if(pos==0){
            deleteAtBeginning();
            return;
        }
        Node temp=head;
        Node prev=null;
        for (int i=1;i<=pos;i++){
            prev=temp;
            temp=temp.next;
        }
        prev.next=temp.next;
        if(temp==tail){
            tail=prev;
            return;
        }
        temp.next.prev=prev.next;

    }
    public void display(){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public void displayReverse(){
        //System.out.println(tail.data);
        Node temp=tail;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.prev;
        }
        System.out.println();
    }
    public void updateAtPos(int pos,T val){
        Node temp=head;
        for (int i=1;i<=pos;i++){
            temp=temp.next;
        }
        temp.data=val;
    }
    public T get(int pos){
        Node temp=head;
        for (int i=1;i<=pos;i++){
            temp=temp.next;
        }
        return temp.data;
    }
    public void reverseList(){
        Node next;
        Node current=head;
        Node previous=null;
        while (current!=null){
            next=current.next;
            current.next=previous;//reverse main
            previous=current;
            current=next;
        }
        head=previous;
    }
}

public class DoublyLinkedListDemo {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list=new DoublyLinkedList<Integer>();
        list.insertAtBeginning(9);
        list.insertAtBeginning(8);
        list.insertAtBeginning(10);
        list.insertAtBeginning(11);
        list.display();
        list.insertAtPos(4,19);
        //list.display();
        //list.displayReverse();
        list.display();
        list.deleteAtPos(4);
        list.display();
        list.displayReverse();


//        list.updateAtPos(0,90);
//        list.display();
//        System.out.println(list.get(2));
//        for (int i:list) {
//            System.out.println(i);
//        }
//        list.reverseList();
//        list.display();


    }
}