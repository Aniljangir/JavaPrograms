package sorting;
/*
 *  In this while iterate find out the smallest item index and swap that into start of the array
 *  Time Complexity is O(n^2)
 */
class SelectionSort {

    public static void main(String[] args) {

        int[] arr = { 1, 3, 5, 3, 4, 2, 9, 8 };
        selectionSort(arr);   // O(n^2)
        for (int i : arr) {
            System.err.print(i+ ", ");
        }
    }
    
    /*
     *  in selection sort needs to find smallest value and swap that into first
     */
    static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            
            // Swaping
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
}