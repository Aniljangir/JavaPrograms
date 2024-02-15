package sorting;
/*
 *  in this we divide array into two partiotion sorted array and unsorted array
 *  Time Complexity O(n^2)
 */
public class insertion_sort {
    public static void main(String[] args) {

        int arr[] = { 2, 6, 5, 4, 9, 8 };
        insertionSort(arr);
    }
    
    static void insertionSort(int[] arr) {

        System.err.println("starting array is:- ");
        printArray(arr);
        for (int i = 1; i < arr.length; i++) {

            int current = arr[i];
            int j = i - 1;

            System.err.println(current+" < "+ arr[j] + " j = "+j);
            while (current < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j + 1] = current;
            printArray(arr);

        }
        printArray(arr);
    }

    static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        
        System.err.println();
        System.err.println();
    }
}
