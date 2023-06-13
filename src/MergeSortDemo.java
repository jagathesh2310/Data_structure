import java.util.Arrays;

public class MergeSortDemo {
    public static int[] mergeSort(int arr[]){
        if (arr.length==1){
            return arr;
        }
        int mid=arr.length/2;
        int[] left=mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right=mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(left,right);
    }
    public static int[] merge(int[] first,int[] second){
        int[] joined=new int[first.length+second.length];
        int i=0,j=0,k=0;
        while (i<first.length && j<second.length){
            if(first[i]<second[j]){
                joined[k++]=first[i++];
            }
            else{
                joined[k++]=second[j++];
            }
        }
        while (i<first.length){
            joined[k++]=first[i++];
        }
        while (j<second.length){
            joined[k++]=second[j++];
        }
        return joined;
    }
    public static void mergeSortingPlace(int arr[],int start,int end){
        if (end-start==1){
            return;
        }
        int mid=(start+end)/2;
        mergeSortingPlace(arr,start,mid);
        mergeSortingPlace(arr,mid,end);
        mergeinPlace(arr,start,mid,end);

    }
    public static void mergeinPlace(int[] arr,int start,int mid,int end){
        int[] joined=new int[end-start];
        int i=start,j=mid,k=0;
        while (i<mid && j<end){
            if(arr[i]<arr[j]){
                joined[k++]=arr[i++];
            }
            else{
                joined[k++]=arr[j++];
            }
        }
        while (i<mid){
            joined[k++]=arr[i++];
        }
        while (j<end){
            joined[k++]=arr[j++];
        }
        for (k=0;k<joined.length;k++){
            arr[start+k]=joined[k];
        }
    }
    public static void main(String[] args) {
        int arr[]={5,4,7,1};
        mergeSortingPlace(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));

    }
}