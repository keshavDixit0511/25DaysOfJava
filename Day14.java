public class Day14 {
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int[] arr, int si, int ei){
        if(si >= ei) return;

        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(int[] arr, int si, int mid, int ei){
        int temp[] = new int[ei - si + 1];
        int i = si; // left part
        int j = mid + 1; // right part
        int k = 0;  //iterator for temp array

        while (i <= mid && j <= ei) {
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // left part remaining
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // right part remaining
        while (j <= ei) {
            temp[k++] = arr[j++];
        }


        // copy temp to original
        for( k =0, i = si; k < temp.length; k++, i++){
            arr[i] = temp[k];
        }
    }
    public static void main(String[] args) {
        int[] arr = {5,3,8,7,2,9,1};
        System.out.println("Before sorting");
        printArray(arr);
        mergeSort(arr, 0, arr.length -1);
        System.out.println("After merge sort");
        printArray(arr);
    }
}
