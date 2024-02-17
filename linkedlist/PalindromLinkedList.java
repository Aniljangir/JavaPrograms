package linkedlist;

public class PalindromLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }

    }

    Node head;

    PalindromLinkedList() {
    }

    void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        head.next = newNode;
    }

    Node findMiddle() {
        Node hare = head;
        Node turtle = head;

        while (hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            turtle = hare.next;
        }
        return turtle;
    }

    Node reverse(Node head) {
        if (head.next == null) {
            return head;
        }

        Node prev = null;
        Node currNode = head;
        while (currNode.next!= null) {
            Node newNode = currNode.next;
            newNode.next = currNode;

            prev = currNode;
            currNode = newNode;
        }
        return prev;
    }

    boolean isPlaindrome() {
        if (head == null || head.next == null) {
            return true;
        }

        Node middle = findMiddle();
        Node secondHalfStart = reverse(middle.next);

        Node firstNode = head;
        while (secondHalfStart != null) {
            if (firstNode.data != secondHalfStart.data) {
                return false;
            }
            firstNode = firstNode.next;
            secondHalfStart = secondHalfStart.next;
        }

        return true;

    }

    public static void main(String[] args) {
        PalindromLinkedList ll = new PalindromLinkedList();

        ll.add(1);
        ll.add(2);
        ll.add(1);
        ll.add(3);

        System.out.println("Is Palindrome:- " + ll.isPlaindrome());
    }
}
