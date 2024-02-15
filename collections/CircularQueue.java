package collections;

/*
 * Queue using circular array
 *  Time Complexity
 *   Add -> O(1)
 *   Remove -> O(1)
 */
public class CircularQueue {

    int size;
    int arr[];
    int front = -1;
    int rear = -1;

    CircularQueue(int n) {
        this.size = n;
        arr = new int[size];
    }

    boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    boolean isFull() {
        return (rear + 1) % size == front;
    }

    void add(int data) {
        if (isFull()) {
            System.out.println("queue is full");
            return;
        }

        // 1st element
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % size;
        arr[rear] = data;
        System.out.println(rear + " data:- " + data);
    }

    int remove() {
        if (isEmpty()) {
            return -1;
        }
        int current = arr[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }
        return current;
    }

    int peek() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    void printQueue() {
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        CircularQueue q = new CircularQueue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.printQueue();
        q.remove();
        q.add(3);
        q.printQueue();
        while (!q.isEmpty()) {
        System.out.println(q.peek());
        q.remove();
        }
    }
}