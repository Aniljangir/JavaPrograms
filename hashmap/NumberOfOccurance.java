package hashmap;

import java.util.ArrayList;

import hashmap.HashMapImp.HashMap;

/*
 * in a given array find a number of occurance of n/3
 */
public class NumberOfOccurance {
    
    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 1, 5, 6, 2, 1, 2, 1 };

        findFrequency(arr, 4);
    }
    
    static void findFrequency(int[] arr, int times) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        
        for (int i : map.keySet()) {
            int value = map.get(i);
            if (value > n/times) {
                System.out.println(i);
            }
        }
    }
}
