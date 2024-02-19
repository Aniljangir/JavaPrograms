package linkedlist;

public class LinkedListCycle {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }

    }

    Node head;

    LinkedListCycle() {
    }

    void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        head.next = newNode;
    }

    boolean isCycle() {
        if (head == null || head.next == null) {
            return false;
        }

        Node hare = head;
        Node turtle = head;

        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
            if (hare == turtle) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle ll = new LinkedListCycle();

        ll.add(1);
        ll.add(2);
        ll.add(1);
        ll.add(3);

        System.out.println("Is Cyclic:- " + ll.isCycle());
    }
}
