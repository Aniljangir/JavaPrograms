package hashmap;

import java.util.HashSet;

public class UnionOfArray {
    
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        int arr1[] = { 3, 4, 5 };

        unionOfArrays(arr, arr1);
    }
    
    static void unionOfArrays(int arr1[], int arr2[]) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }

        System.out.println(set.size());

    }
}
