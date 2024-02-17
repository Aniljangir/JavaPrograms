import java.util.*;

public class ReverseLinkedList {

    static Node head;

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            next = null;
        }

    }

    ReverseLinkedList() {

    }

    void add(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            return;
        }
        Node cNode = head;
        while (cNode.next != null) {
            cNode = cNode.next;
        }

        cNode.next = node;
        // System.out.println(cNode.value+" -> "+cNode.next);
    }

    static void printList() {
        if (head == null) {
            return;
        }
        // System.out.print(head.value + " -> ");
        Node cNode = head;
        while (cNode.next != null) {
            System.out.print(cNode.value + " -> ");
            cNode = cNode.next;
        }
        System.out.print(cNode.value + " -> ");
        System.out.println("NULL");
    }

    static void reverseIterative() {
        if (head == null || head.next == null) {
            return;
        }

        Node prevNode = head;
        Node currNode = head.next;
        while (currNode != null) {
            Node newNode = currNode.next;
            currNode.next = prevNode;

            prevNode = currNode;
            currNode = newNode;
        }
        head.next = null;
        head = prevNode;
    }

    static Node reverseRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        System.out.println(head.value);
        Node newNode = reverseRecursive(head.next);

        head.next.next = head;
        head.next = null;
        return newNode;
    }

    public static void main(String[] args) {
        ReverseLinkedList ll = new ReverseLinkedList();

        ll.add(1);
        ll.add(2);
        ll.add(3);

        printList();

        head = reverseRecursive(head);

        printList();
    }
}
