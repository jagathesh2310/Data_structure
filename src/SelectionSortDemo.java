import java.util.Arrays;

public class SelectionSortDemo {
    public static void selectionSort(int[] arr){
       for(int i=0;i<arr.length;i++){
           //int min=arr[i];
           int minIndex=i;
           for(int j=i+1;j<arr.length;j++){
               if(arr[j]<arr[minIndex]){

                   minIndex=j;
               }
           }
           int temp=arr[i];
           arr[i]=arr[minIndex];
           arr[minIndex]=temp;
        }

    }
    public static void main(String[] args) {
        int arr[]={10,5,26,3,15,22};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
