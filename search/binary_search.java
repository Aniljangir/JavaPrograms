class binary_search {

    static int binarySearchIterative(int[] arr, int value) {
        int high = arr.length - 1;
        int low = 0;
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else if (arr[mid] == value) {
                index = mid;
                break;
            }
        }
        return index;
    }

    static int binarySearchRecursive(int[] arr, int value, int low, int high) {

        while (high < low) {
            return -1;
        }

        int middle = (low + high) / 2;
        if (arr[middle] == value) {
            return middle;
        } else if (arr[middle] < value) {
            return binarySearchRecursive(arr, value, middle + 1, high);
        } else {
            return binarySearchRecursive(arr, value, low, middle - 1);
        }

    }

    public static void main(String[] args) {
        int[] integers = { 1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 9, 9, 9, 0 };
        // the element that should be found
        int shouldBeFound = 2;
        System.err.println("index of " + shouldBeFound + " is " + binarySearchIterative(integers, shouldBeFound));
        System.err.println("index of " + shouldBeFound + " is "
                + binarySearchRecursive(integers, shouldBeFound, 0, integers.length - 1));
    }
}
