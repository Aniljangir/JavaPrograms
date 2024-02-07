public class problem {

    public static void main(String[] args) {
        int row = 7;
        printResult(row);
    }

    static void printResult(int row) {

        // loop
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if (j < (row - i - 1)) {
                    System.out.print(" ");
                } else {
                    System.out.print("* ");
                }
            }
            System.err.println("");
        }

    }

    static void piramidIterative(int row) {

        for (int i = 0; i < row; i++) {   // iterating to number of rows
            for (int j = 0; j < row - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i + 1; k++) {
                System.out.print("* ");
            }
            System.err.println("");
        }
    }
}

// *
// * *
// * * *
