class palindrome {
    public static void main(String[] args) {

        System.err.println("is Palindrome " + isPalindrome("eye"));
        isPalindromeNumber(121);
    }
    
    static boolean isPalindrome(String n) {
        boolean result = false;
        StringBuilder rString = new StringBuilder();
        char[] arr = n.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            rString.append(arr[i]);
        }

        System.err.println("Reverse String - " + rString + " " + n);
        if (rString.toString().equals(n)) {
            result = true;
        }
        return result;
    }
    
    static boolean isPalindromeNumber(int number) {

        boolean result = false;
        int rResult = 0;
        int n = number;

        while (n > 0) {
            int remainder = n % 10;
            n = n / 10;
            rResult = (rResult*10)+remainder;
        }
       System.err.println("number is:- "+rResult);

       if (number == rResult) {
           result = true;
       }
        return result;
    }
}
