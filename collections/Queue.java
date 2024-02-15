package collections;

/**
 *  Queue by Using Array
 * Queue works in FIFO 
 * Time Complexity
 * Adding -> O(1)
 * Remove -> O(n)
 */
public class Queue {
    int size;

    int rear = -1;// in staring it is -1
    int[] mQueue;

    Queue(int size) {
        this.size = size;
        rear = -1;
        mQueue = new int[size];
    }

    boolean isEmpty() {
        return rear == -1;
    }

    boolean isFull() {
        return rear >= size - 1;
    }

    void add(int data) {
        if (isFull()) {
            System.out.println("queue is full");
            return;
        }
        rear++;
        mQueue[rear] = data;

    }

    int remove() {
        if (isEmpty()) {
            return -1;
        }
        int current = mQueue[0];
        for (int i = 0; i < size - 1; i++) {
            mQueue[i] = mQueue[i + 1];
        }
        rear--;
        return current;

    }

    int peek() {
        if (isEmpty()) {
            return -1;
        }
        return mQueue[0];
    }

    void printQueue() {
        for (int i : mQueue) {
            System.err.print(i + ", ");
        }
        System.err.println();
    }

    public static void main(String[] args) {

        Queue queue = new Queue(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        queue.printQueue();
        queue.remove();
        queue.add(6);
        queue.printQueue();
    }
}