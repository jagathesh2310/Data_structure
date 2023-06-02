import java.util.Arrays;

public class InsertionSortDemo  {
    public static void main(String[] args) {
        int arr[]={10,5,26,3,15,22};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void  insertionSort(int[] arr){
        for (int i=1;i<arr.length;i++){
            for (int j=i;j>0;j++){
                if(arr[j-1]>arr[j]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
                else{
                    break;
                }
            }
        }
    }
}
