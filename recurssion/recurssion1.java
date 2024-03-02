package recurssion;

/**
 * recurssion1
 */
public class recurssion1 {

    // Print numbers from 5 to 1.
    public static void printNumber(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printNumber(n - 1);
    }

    // Print numbers from 1 to 5.
    public static void printNumber1(int n) {

        if (n == 0) {
            return;
        }
        printNumber1(n - 1);
        System.out.println(n);
    }

    // Print the sum of first n natural numbers.
    public static void printSum(int n, int sum) {

        if (n == 0) {
            System.out.println(sum);
            return;
        }
        printSum(n - 1, sum + n);
    }

    // Print factorial of a number n.
    public static void factorial(int n, int result) {
        if (n == 0) {
            System.out.println(result);
            return;
        }
        factorial(n - 1, result * n);
    }

    // Print the fibonacci sequence till nth term. 0, 1, 1, 2, 3, 5, 8, 13
    public static void fibonacci(int n, int a, int b) {
        if (n == 0) {

            return;
        }
        System.out.print(a + " , ");
        int c = a + b;

        fibonacci(n - 1, b, c);
        // if (n == 0 || n == 1) {
        // System.out.print(b+ " , ");
        // return;
        // }
        // int c = a + b;

        // fibonacci(n - 1, b, c);
    }

    // Print x^n (with stack height = n)
    public static int powerOf(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        int res = x * powerOf(x, n - 1);

        return res;
    }

    // Print x^n (with stack height = logn)
    public static int powerOfOptimized(int x, int n) {

        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }

        if (n % 2 == 0) { // is even number
            return powerOfOptimized(x, n / 2) * powerOfOptimized(x, n / 2);
        } else {
            return powerOfOptimized(x, n / 2) * powerOfOptimized(x, n / 2) * x;
        }
    }

    public static void main(String[] args) {
        // printNumber(5);
        // printNumber1(5);

        // printSum(5, 0);
        // factorial(4, 1);
        // fibonacci(7, 0, 1);

        // System.out.println(powerOf(2, 2));
        System.out.println(powerOfOptimized(2, 5));

    }
}