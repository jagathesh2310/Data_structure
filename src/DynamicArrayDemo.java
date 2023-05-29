import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
class DynamicArray<T> implements Iterable<T>{
    private T[] arr;
    private int size,capacity;
    static final int initialCapacity=16;
    DynamicArray(){
        size=0;
        arr=(T[]) new Object[initialCapacity];
        capacity=initialCapacity;
    }
    public void add(T val){
        if(capacity==size){
            expandArray();
        }
        arr[size++]=val;

    }
    public void display(){
        System.out.println("Elements in the array");
        for (int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
    }
    private void expandArray(){
        capacity*=2;
        arr=Arrays.copyOf(arr,capacity);
    }
    public void insertAtPos(int pos,T val){
        System.out.println(size+"size");
        if(capacity==size){
            expandArray();
        }
        for(int i=size-1;i>=pos;i--){
            System.out.println(i+1);

            arr[i+1]=arr[i];
        }
        System.out.println(Arrays.toString(arr));
        arr[pos]=val;
        size++;
    }
    public void deleteAtPos(int pos){
        for (int i=pos+1;i<size;i++){
            arr[i-1]=arr[i];
        }
        size--;
        if(capacity>initialCapacity && capacity>3*size){
            shrinkArray();
        }
    }
    private void shrinkArray(){
        capacity/=2;
        arr=Arrays.copyOf(arr,capacity);
    }
    public int length(){
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index=0;
            @Override
            public boolean hasNext() {
                return index<size;
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }

}
public class DynamicArrayDemo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int val,pos;
        DynamicArray<Integer> list=new DynamicArray();
        while (true){
            System.out.println("\n----------List Menu-----------\n");
            System.out.println("1.Insert at End\n");
            System.out.println("2.Display the List\n");
            System.out.println("3.Insert the specified position \n");
            System.out.println("4.Delete the specified position \n");
            System.out.println("5.Exit\n");
            System.out.println("------------------------------");
            System.out.println("Enter your Choice\n");
            int choice=sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the Data : ");
                    val = sc.nextInt();
                    list.add(val);
                    break;
                case 2:
                    list.display();
                    break;
                case 3:
                    System.out.println("Enter the position : ");
                    pos = sc.nextInt();
                    if (pos < 0) {
                        System.out.println("Invalid Postion");
                        break;
                    }
                    System.out.println("Enter the data : ");
                    val = sc.nextInt();
                    list.insertAtPos(pos, val);
                    break;
                case 4:
                    System.out.println("Enter the position : ");
                    pos = sc.nextInt();
                    if (pos < 0) {
                        System.out.println("Invalid Postion");
                        break;
                    }
                    list.deleteAtPos(pos);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;



            }
        }
    }
}
