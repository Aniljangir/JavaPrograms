package sorting;

public class heap_sort {

    void heapSort(int[] arr) {
        int N = arr.length;

        // Build Heap
        for (int i = N / 2 - 1; i >= 0; i--) {
            heapify(arr, N, i);
        }

        // Iterate every element
        for (int i = N - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            /// again heapify
            heapify(arr, i, 0);
        }
    }

    void heapify(int[] arr, int N, int i) {

        int largest = i; // initialize root as largest

        int left = 2 * i + 1; // left = 2 * i + 1
        int right = 2 * i + 2;

        // if left child is grater than root
        if (left < N && arr[left] > arr[largest]) {
            largest = left;
        }

        // if right child is grater than root
        if (right < N && arr[right] > arr[largest]) {
            largest = right;
        }

        // if largest is not the root
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // again heapify the child
            heapify(arr, N, largest);
        }
    }
    
    void heapifyMin(int[] arr, int N, int i) {

        int largest = i;  // initialize root as largest

        int left = 2 * i + 1;  // left = 2 * i + 1
        int right = 2 * i + 2;

        // if left child is grater than root
        if (left < N && arr[left] < arr[largest]) {
            largest = left;
        }

        // if right child is grater than root
        if (right < N && arr[right] < arr[largest]) {
            largest = right;
        }

        // if largest is not the root
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // again heapify the child
            heapify(arr, N, largest);
        }
    }

    void printArray(int[] arr) {

        for (int i : arr) {
            System.err.print(i + ", ");
        }
    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 4, 9, 5, 3, 6 };

        heap_sort obj = new heap_sort();
        obj.heapSort(arr);
        System.out.println("After Sorting:- ");
        obj.printArray(arr);

    }
}
