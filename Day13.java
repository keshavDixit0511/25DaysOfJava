import java.util.ArrayList;
import java.util.List;

public class Day13 {
    public static void findSubsetsOfString(String str, int i, String ans){

        //base case
        if(i == str.length()){
            if (ans.length() == 0) {
                System.out.println("{}");
            }else{
                System.out.println(ans);
            }
            return;
        }

        //recursion
        //yes choice
        findSubsetsOfString(str, i + 1, ans+str.charAt(i));

        //no choice
        findSubsetsOfString(str, i+1, ans);
    }

    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currntSubset = new ArrayList<>();
        generateSubsets(nums, 0, result, currntSubset);
        return result;

    }
    public static void generateSubsets(int arr[], int i, List<List<Integer>> result, List<Integer> currntSubset){
        //base case
        if (i == arr.length) {
            result.add(new ArrayList<>(currntSubset));
            return;
        }
        //recursion

        //yes choice
        currntSubset.add(arr[i]);
        generateSubsets(arr, i+1, result, currntSubset);

        currntSubset.remove(currntSubset.size()-1);
        //no choice
        generateSubsets(arr, i+1, result, currntSubset);

        
    }
    public static void main(String[] args) {
        String str = "abc";
        findSubsetsOfString(str, 0, "");

        int arr[] = {1,2,3};
        System.out.println(subsets(arr));
    }
}
