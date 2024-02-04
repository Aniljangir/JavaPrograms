/*
 *  Divide array into partions untill single element in array and after that combine single array
 *  Time Complexity O(logn)
 *  Divide and Conquer
 */
class MergeSort {
    
    public static void main(String[] args) {
        int arr[] = { 2, 1, 6, 5, 9, 8, 3 };
        divide(arr, 0, arr.length-1);

        for (int i : arr) {
            System.err.print(i+", ");
        }
    }
    
    /*
     * Partinioned into single array
     */
    static void divide(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = (si + ei) / 2;
        divide(arr, si, mid);
        divide(arr, mid + 1, ei);
        addAggain(arr, si, mid, ei);
    }
    
    /*
     * Combine single array after compare
     */
    static void addAggain(int[] arr, int si, int mid, int ei) {

        int merged[] = new int[ ei - si + 1];
        int indx1 = si;
        int indx2 = mid + 1;
        int x = 0;
        System.err.println("anil si:- " + si + " mid:- " + mid + " ei:- " + ei);
        
        // compare and adding items of two array
        while (indx1 <= mid && indx2 <= ei) {
            if (arr[indx1] <= arr[indx2]) {
                merged[x] = arr[indx1];
                x++;
                indx1++;
            } else {
                merged[x] = arr[indx2];
                x++;
                indx2++;
            }
        }

        // if first array having items remaining than add those
        while (indx1 <= mid) {
            merged[x] = arr[indx1];
            x++;
            indx1++;
        }
        // if second array having items remaining than add those
        while (indx2 <= ei) {
            merged[x] = arr[indx2];
            x++;
            indx2++;
        }

        // Adding sorted items in original array
        for (int i = 0, j = si; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }
}
