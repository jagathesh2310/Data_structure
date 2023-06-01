class StackArray{
    static final int MAX_SIZE=30;
    int arr[]=new int[MAX_SIZE];
    int top;
    StackArray(){
        top=-1;
    }
    public void push(int val){
        if(top==MAX_SIZE-1){
            throw new IndexOutOfBoundsException("Array is full");
        }
        arr[++top]=val;

    }
    public int pop(){
        if(top==-1){
            throw new IndexOutOfBoundsException("Stack underflow");
        }
        return arr[top--];
    }
    public int peek(){
        if(top==-1){
            throw new IndexOutOfBoundsException("Stack underflow");
        }
        return arr[top];
    }
    public boolean isEmpty(){
        if(top==-1){
            return true;
        }
        return false;
    }
}
public class StackDemo {
    public static void main(String[] args) {
        StackArray arr=new StackArray();
        arr.push(8);
        arr.push(9);
        System.out.println(arr.peek());
        System.out.println(arr.pop());
        System.out.println(arr.isEmpty());
    }
}
