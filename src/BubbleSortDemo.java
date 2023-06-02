import java.util.Arrays;

public class BubbleSortDemo {
    public static void main(String[] args) {
        int arr[]={10,5,26,3,15,22};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int arr[]){
        for(int i=1;i<arr.length;i++){
            boolean swapped=false;
            for(int j=0;j<arr.length-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapped=true;
                }
            }
            if(swapped){
                return;
            }
        }
    }
}
