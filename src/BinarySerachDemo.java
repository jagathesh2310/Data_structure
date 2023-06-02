public class BinarySerachDemo {
    public static int binarySearch(int arr[],int target){
        int start=0,end=arr.length-1,mid;
        while (start<=end){
            mid=(start+end)/2;
            //System.out.println(start+" "+end);
            //System.out.println(mid);
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }

        }
        return -1;

    }
    public static int binarySearchRecursion(int[] arr,int start,int end,int target){
        int mid=(start+end)/2;
        if(start>end){
            return -1;
        }
        else if(arr[mid]==target){
            return mid;
        }
        else if(arr[mid]<target){
            return binarySearchRecursion(arr,mid+1,end,target);
        }
        else{
            return binarySearchRecursion(arr,start,mid-1,target);
        }

    }
    public static void main(String[] args) {
        int arr[]={1,3,5,6,10,12,15,21,28};
        int ar2[]={0,1,2,3, 4, 5, 6, 7, 8};
        System.out.println(binarySearch(arr,0));
        System.out.println(binarySearchRecursion(arr,0,arr.length-1,0));
    }
}