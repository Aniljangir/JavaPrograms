class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 1, 9, 8 };
        bubbleSort(arr); // Time Complexity O(n^2)
        for (int i : arr) {
            System.out.print(i + " ,");
        }
    }

    // sorting of given array
    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swaping
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}