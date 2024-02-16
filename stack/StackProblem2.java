package stack;

import java.util.Stack;

/*
 * Reverse stack data
 */
public class StackProblem2 {
    
    public static void pushDataAtBottom(int data, Stack<Integer> s) {

        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushDataAtBottom(data, s);
        s.push(top);
    }

    public static void reverse(Stack<Integer> s) {       
        if (s.isEmpty()) {

            return;
        }
        int top = s.pop();
        reverse( s);
        pushDataAtBottom(top, s);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.add(1);
        s.add(2);
        s.add(3);

        reverse(s);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
