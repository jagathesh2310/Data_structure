import java.util.Arrays;

class LinearSearch {

    public static int find(int[] arr,int target) {
        for(int i=0;i<arr.length;i++)
            if(arr[i]==target)
                return i;

        return -1;

    }


    public static boolean contains(int[] arr,int target) {
        for(int i=0;i<arr.length;i++)
            if(arr[i]==target)
                return true;

        return false;

    }

    public static int find(String str,char target) {
        for(int i=0;i<str.length();i++)
            if(str.charAt(i)==target)
                return i;
        return -1;
    }


    public static boolean contains(String str,char target) {
        for(int i=0;i<str.length();i++)
            if(str.charAt(i)==target)
                return true;
        return false;
    }


    public static int[] find(int[][] arr, int target) {
        for(int row=0;row<arr.length;row++) {
            for(int col=0;col<arr[row].length;col++) {
                if(arr[row][col]==target)
                    return new int[] {row,col};

            }
        }

        return new int[] {-1,-1};
    }
}


public class LinerSearchDemo {
    public static void main(String[] args) {
        int arr[]={2,1,3,4,6,5,10,7};
        System.out.println(LinearSearch.find(arr,5));
        int arr2[][]={{1,2,3},{7,5,7}};
        System.out.println(Arrays.toString(LinearSearch.find(arr2,2)));
    }
}
