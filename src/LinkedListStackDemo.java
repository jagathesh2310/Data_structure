class StackLinkedList{
    class Node{
        int data;
        Node next;
        Node(){
            next=null;
        }
    }
    Node top;
    StackLinkedList(){
        top=null;
    }
    public void push(int val){
        Node newNode=new Node();
        newNode.data=val;
        if(top==null){
            top=newNode;
            return;
        }
        newNode.next=top;
        top=newNode;

    }
    public int pop(){
        if(top==null){
            throw new IndexOutOfBoundsException("Stack is underflow");
        }
        //top.next=top.next.next;
        int temp=top.data;
        top=top.next;
        return temp;

    }
    public boolean isEmpty(){
        return top==null;
    }
    public int peek(){
        if(top==null){
            throw new IndexOutOfBoundsException("Stack is underflow");
        }
        return top.data;
    }
}
public class LinkedListStackDemo {
    public static void main(String[] args) {
        StackLinkedList arr=new StackLinkedList();
        arr.push(8);
        arr.push(9);
        arr.push(19);
        arr.push(29);
        System.out.println(arr.peek());
        System.out.println(arr.pop());
        System.out.println(arr.pop());
        System.out.println(arr.pop());

       // System.out.println(arr.isEmpty());
    }
}
