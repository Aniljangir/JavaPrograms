package collections;

import java.util.*;

/**
 * QueueUsingStack implement a queue using two stacks
 *  Problem:-  Implement a queue by using 2 Stacks
 *   in that case when we are adding element then
 *    1. move items from first stack to second stack
 *    2. add item in first stack
 *    3. Again add second stack items to first stack
 */
public class QueueUsingStack {

    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    void add(int data) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(data);

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    int remove() {
        if (isEmpty()) {
            return -1;
        }
        return s1.pop();
    }

    int peek() {
        if (isEmpty()) {
            return -1;
        }
        return s1.peek();
    }

    void printData() {

        while (!s1.isEmpty()) {
            System.out.println(s1.pop());
        }
    }
    public static void main(String[] args) {
        QueueUsingStack q = new QueueUsingStack();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.printData();
    }
}