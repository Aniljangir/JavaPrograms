/*
 * Pivot and Partion
 *  in this we have to take one pivot and compare with items to arrange sort items before pivot and large after pivot
 * Time Complexity  
 *    Wrost case O(n^2) it happen when array is sorted or last element is always smallest or largest
 *    Average Case O(logn)
 */
class quick_sort {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 8, 6, 5, 10,9};

        quickSort(arr, 0, arr.length - 1);

        printArray(arr);
    }

    static void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            int pidx = partition(arr, low, high);

            quickSort(arr, low, pidx - 1);
            quickSort(arr, pidx + 1, high);
        }

    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        System.out.println("pivot:- "+pivot+" low:- "+low+" high:- "+high);
        
        System.out.println("pivot position:- " + i);
        
        i++;
        swap(arr, i, high);
        printArray(arr);
        return i;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void printArray(int[] arr) {

        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
        System.out.println();
    }
}
