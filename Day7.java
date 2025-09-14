import java.util.Arrays;

public class Day7 {

    public static int linearSearch(int[] arr, int target){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target) return i;
        }
        return -1;
    }

    public static int binarySearchh(int[] arr, int target){
        Arrays.sort(arr);
        int start = 0, end = arr.length -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if( target == arr[mid]) return mid;
            else if( target < arr[mid]) end = mid -1;
            else start = mid + 1;
        }
        return -1;
    }

    public static int squareRoot(int n){
        int start = 0, ans = 0, end =n;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mid == n/mid) return mid;
            else if(n/mid < mid){ end = mid -1; ans = mid;}
            else start = mid + 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {5,3,8,7,2,9,1};
        System.out.println("Answer is at index: " + linearSearch(arr, 7));
        System.out.println("Answer is at index: " + binarySearchh(arr, 2));
        System.out.println(squareRoot(169));
    }
}
