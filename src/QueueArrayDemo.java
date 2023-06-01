
class QueueArray{
    final static int MAX_SIZE=30;
    int arr[];
    int front,rear;
    QueueArray(){
        arr=new int[MAX_SIZE];
        front=-1;
        rear=-1;
    }
    public void enqueue(int val){
        if(rear==MAX_SIZE-1){
            throw new IndexOutOfBoundsException("Queue is Full");
        }
        if (front==-1){
            front++;
        }
        arr[++rear]=val;
    }
    public int dequeue(){
        if(rear==-1){
            throw new IndexOutOfBoundsException("Queue is Empty");
        }
        int temp=arr[0];
        for (int i=1;i<=rear;i++){
            arr[i-1]=arr[i];
        }
        rear--;
        return temp;
    }

}
public class QueueArrayDemo {
    public static void main(String[] args) {
        QueueArray arr=new QueueArray();
        arr.enqueue(10);
        arr.enqueue(11);
        System.out.println(arr.dequeue());

    }
}
