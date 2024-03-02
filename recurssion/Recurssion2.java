package recurssion;

import java.util.HashSet;
import java.util.Map;

import hashmap.HashMapImp.HashMap;

public class Recurssion2 {

    // Tower of Hanoi - Transfer n disks from source to destination over 3 towers.
    public static void towerOfHanoi(int n, String src, String helper, String dest) {
        if (n == 1) {
            System.out.println("Transfer " + n + " From " + src + " -> " + dest);
            return;
        }
        towerOfHanoi(n - 1, src, dest, helper);
        System.out.println("Transfer " + n + " From " + src + " -> " + dest);
        towerOfHanoi(n - 1, helper, src, dest);
    }

    // Print a string in reverse.
    public static void reverseString(String str, int idx) {
        if (idx == str.length()) {
            return;
        }

        reverseString(str, idx + 1);
        System.out.print(str.charAt(idx));
    }

    public static String reverseString1(String str) {
        if (str.length() == 1) {
            return str;
        }
        char currentChar = str.charAt(0);
        String nextString = reverseString1(str.substring(1));
        return nextString + currentChar;
    }

    // Find the occurrence of the first and last occurrence of an element using
    // recursion.
    public static int first = -1;
    public static int last = -1;

    public static void findOccurance(String str, int idx, char element) {
        if (idx == str.length()) {
            System.out.println("First " + first + " Last " + last);
            return;
        }
        char currentChar = str.charAt(idx);
        if (currentChar == element) {
            if (first == -1) {
                first = idx;
            } else {
                last = idx;
            }
        }
        findOccurance(str, idx + 1, element);
    }

    // Check if an array is sorted (strictly increasing). - O(n)
    public static boolean checkArraySorted(int[] arr, int idx) {
        if (idx == arr.length - 1) {
            return true;
        }

        if (arr[idx] >= arr[idx + 1]) {
            return false;
        } else {
            return checkArraySorted(arr, idx + 1);
        }

        // if (arr[idx] < arr[idx + 1]) {
        // return checkArraySorted(arr, idx + 1);
        // } else {
        // return false;
        // }
    }

    // Move all ‘x’ to the end of the string. - O(n)
    public static void moveCharacterToEnd(String str, char element, int count, String newString) {
        if (str.length() == 0) {
            for (int i = 0; i < count; i++) {
                newString += element;
            }
            System.out.println(newString);
            return;
        }
        char currentChar = str.charAt(0);
        if (currentChar == element) {
            count++;
        } else {
            newString += currentChar;
        }
        moveCharacterToEnd(str.substring(1), element, count, newString);
    }

    public static boolean[] map = new boolean[26];

    // Remove duplicates in a string.
    public static void removeDuplicates(String str, int idx, String newString) {

        if (idx == str.length()) {
            System.out.println(newString);
            return;
        }
        char currentChar = str.charAt(idx);
        if (map[currentChar - 'a']) {
            removeDuplicates(str, idx + 1, newString);
        } else {
            newString += currentChar;
            map[currentChar - 'a'] = true;
            removeDuplicates(str, idx + 1, newString);
        }
    }

    // Q7. Print all the subsequences of a string. O(2^n)
    public static void subsequences(String str, int idx, String res) {

        if (idx == str.length()) {
            System.out.println(res);
            return;
        }
        // choose to come
        subsequences(str, idx + 1, res + str.charAt(idx));

        // not to come
        subsequences(str, idx + 1, res);
    }

    // Print all unique subsequences of a string.
    public static void uniqueSubsequences(String str, int idx, String res, HashSet<String> set) {

        if (idx == str.length()) {
            if (set.contains(res)) {
                
            } else {
                System.out.println(res);
                set.add(res);
            }
            return;
        }

        char currentChar = str.charAt(idx);

        // to be
        uniqueSubsequences(str, idx + 1, res + currentChar, set);
        
        // not to be
        uniqueSubsequences(str, idx+1, res, set);

    }


    // Print keypad combination
    public static String[] keypad = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vw", "xyz"};
    public static void keypadCombinations(String str, int idx, String res) {

        if (idx == str.length()) {
            System.out.println(res);
            return;
        }
        char currentChar = str.charAt(idx);
        String keyString = keypad[currentChar - '0'];
        
        for (int i = 0; i < keyString.length(); i++) {
            char val = keyString.charAt(i);
            keypadCombinations(str, idx+1, res+val);
        }
    }


    public static void main(String[] args) {
        // towerOfHanoi(3, "S", "H", "D");
        // reverseString("abcd", 0);
        // System.out.println(reverseString1("abcd"));

        // findOccurance("abaacdab", 0, 'c');

        // int[] arr = { 1, 2, 3, 4 };
        // System.out.println("check array is sorted " + checkArraySorted(arr, 0));

        // moveCharacterToEnd("abxabxd", 'a', 0, "");

        // removeDuplicates("abcab", 0, "");

        // subsequences("abc", 0, "");

        // HashSet<String> set = new HashSet<>();
        // uniqueSubsequences("aaa", 0, "", set);

        keypadCombinations("01", 0, "");

    }
}
