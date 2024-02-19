package hashmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Intersection {
    
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        int arr1[] = { 3, 4, 5 };

        interSactionOfArray(arr, arr1);
    }

    static void interSactionOfArray(int arr1[], int[] arr2) {

        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> common = new ArrayList<>();
        for (int i : arr1) {
            set.add(i);
        }

        Iterator<Integer> it = set.iterator();

        while (it.hasNext()) {
            int val = it.next();
            for (int j = 0; j < arr2.length; j++) {
                if ( val == arr2[j]) {
                    common.add(val);
                    break;
                }
            }
        }

       System.out.println("Intersection is:- "+common.size());

    }
}
