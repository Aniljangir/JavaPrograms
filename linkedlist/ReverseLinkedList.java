package linkedlist;
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

        @Override
        public String toString() {
            return value + " ";
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

    static Node findNodeFromEnd(int n) {
        if (head == null) {
            return head;
        }

        Node nNode = null;
        Node currNode = head;
        int i = -1;
        while (currNode != null) {
            i++;
            if (i == n) {
                nNode = head;
            }
            if (i > n) {
                nNode = nNode.next;
            }
            currNode = currNode.next;
            System.out.println(i + " n= " + n + " c= " + currNode + " nNode= " + nNode);
        }

        return nNode;
    }

    static Node deleteNodeFromEnd(int n) {
        if (head.next == null) {
            return null;
        }

        int size = 0;
        Node curr = head;
        // Calculating size of linkedlist
        while (curr != null) {
            curr = curr.next;
            size++;
        }

        if (size == n) {
            head = head.next;
            return head;
        }

        int indexToSearch = size - n; // getting the index of nth node previous node index from end

        System.out.println("Size- " + size + " indexToSearch:- " + indexToSearch);
        int i = 1;
        curr = head;
        while (i < indexToSearch) {
            curr = curr.next;
            i++;
        }

        curr.next = curr.next.next;
        System.out.println("curr:- " + curr);
        return head;

    }
    
    static Node findNodeFromEndNew(int n) {
        if (head.next == null) {
            return null;
        }

        int size = 0;
        Node curr = head;
        // Calculating size of linkedlist
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        if (n > size) {
            return null;
        }

        int indexToSearch = size - n+1; // getting the index of nth node previous node index from end

        // System.out.println("Size- "+size+" indexToSearch:- "+indexToSearch);
        int i = 1;
        curr = head;
        while (i < indexToSearch) {
            curr = curr.next;
            i++;
        }
        return curr;
    }

    public static void main(String[] args) {
        ReverseLinkedList ll = new ReverseLinkedList();

        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        printList();

        // head = reverseRecursive(head);
        // printList();
        // head = deleteNodeFromEnd(6);
        // printList();

        Node head = findNodeFromEndNew(7);
       System.out.println(head);

    }
}
