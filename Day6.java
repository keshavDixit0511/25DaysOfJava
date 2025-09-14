
public class Day6 {

  public static void printArr(int[] arr){
    for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + ",");
    }
  }

  public static void bubbleSort(int[] arr){
    boolean isSwap = false;
    for (int i = 0; i < arr.length-1; i++) {
        for (int j = 0; j < arr.length-i-1; j++) {
            if (arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                isSwap = true;
            }
        }
        if (!isSwap) {
            return;
        }
    }
  }

  public static void selectionSort(int[] arr){
    for (int i = 0; i < arr.length; i++) {
        int minIndex = i;
        for (int j = i+1; j < arr.length; j++) {
            if (arr[minIndex] > arr[j]) {
                minIndex = j;
            }
        }
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
  }

  public static void insertionSort(int[] arr){
    for (int i = 0; i < arr.length; i++) {
        int current = arr[i];
        int j = i-1;

        while(j>=0 && arr[j] > current){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = current;
    }
  }
        
    public static void main(String[] args) {
        int[] arr = {5,3,8,7,2,9,1};
        System.out.println("Before sorting");
        printArr(arr);
        System.out.println();
        // bubbleSort(arr);
        // System.out.println("After bubble sort");
        // printArr(arr);

        // selectionSort(arr);
        // System.out.println("After Selection SORT");
        // printArr(arr);

        // insertionSort(arr);
        // System.out.println("After Insertion SORT");
        // printArr(arr);
       
    }
}
