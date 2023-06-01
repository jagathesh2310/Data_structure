class QueueLinkedList{
    class Node{
        int data;
        Node next;
        Node(){
            next=null;
        }
    }
    Node front,rear;
    QueueLinkedList(){
        front=null;
        rear=null;
    }
    public void enqueue(int val){
        Node newNode=new Node();
        newNode.data=val;
        if(front==null){
            rear=newNode;
            front=newNode;
        }
        newNode.next=rear;
        rear=newNode;

    }
    public int dequeue(){
        if(front==null){
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        int temp=front.data;
        front=front.next;
        if(front==null){
            rear=null;
        }
        return temp;

    }
    public boolean isEmpty(){
        return front==null;
    }
    public int peek(){
        if(front==null){
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        return front.data;
    }
}
public class QueueLinkedListDemo {
    public static void main(String[] args) {
        QueueLinkedList arr=new QueueLinkedList();
        arr.enqueue(10);
        arr.enqueue(11);
        System.out.println(arr.dequeue());
    }
}
