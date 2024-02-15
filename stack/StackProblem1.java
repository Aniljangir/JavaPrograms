package stack;

import java.util.*;

// Push Data at bottom
public class StackProblem1 {
    
    public static void pushDataAtBottom(int data, Stack<Integer> s) {

        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushDataAtBottom(data, s);
        s.push(top);
    }

    public static void main(String[] args) {
        
        Stack<Integer> s = new Stack<>();
        s.add(1);
        s.add(2);
        s.add(3);

        pushDataAtBottom(4, s);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
