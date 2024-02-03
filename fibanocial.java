/**
 * fibanocial
 */
class fibanocial {

    public static void main(String[] args) {

        int n = 8;
        for (int i = 0; i <= n; i++) {
            System.err.print(fibonacci(i) + ", ");
        }
        System.err.println("fibanacci series is " + fibonacci(n));
    }

    // recrussion method to get series
    static int fibonacci(int n) {

        if (n > 1) {
            return fibonacci(n - 1) + fibonacci(n - 2);

        }
        return n;

    }
}