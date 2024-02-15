package collections;

public class QueueLinkedList {
    
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
   
    Node head = null;
    Node tail = null;
    
    QueueLinkedList() {
       
    }


    boolean isEmpty() {
        return head == null && tail == null;
    }

    void add(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    int remove() {
        if (isEmpty()) {
            return -1;
        }

        Node current = head;
        if (head == tail) {
            tail = null;
        }
        head = current.next;
        return current.data;
    }

    int peek() {
        if (isEmpty()) {
            return -1;
        }
        return head.data;
    }

    public static void main(String[] args) {
        QueueLinkedList q = new QueueLinkedList();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.remove();
        q.add(6);
        // q.printQueue();
        while (!q.isEmpty()) {
        System.out.println(q.peek());
        q.remove();
        }

    }
}
