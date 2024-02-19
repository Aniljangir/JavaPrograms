package BST;

public class bst {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node insert(Node root, int value) {
        Node newNode = new Node(value);
        if (root == null) {
            return newNode;
        }

        if (root.data > value) {
            /// add left side
            root.left = insert(root.left, value);
        } else {
            // right side
            root.right = insert(root.right, value);
        }
        return root;

    }

    void inOrder(Node root) { // O(H)
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " -> ");
        inOrder(root.right);
    }

    boolean search(Node root, int value) {
        if (root == null) {
            return false;
        }

        if (root.data > value) {
            return search(root.left, value);
        } else if (root.data == value) {
            return true;
        } else {
            return search(root.right, value);
        }
    }

    Node delete(Node root, int value) {
        if (root == null) {
            return root;
        }

        if (root.data > value) {
            /// traverse in left side
            root.left = delete(root.left, value);
        } else if (root.data < value) {
            /// traverse in right side
            root.right = delete(root.right, value);
        } else { // root.data == value

            // case 1
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2  in this case only one child available either left or right
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 3  in this case need to findout inorder successor in right side and replace the values with root and delete

            Node IS = inOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }
    
    Node inOrderSuccessor(Node root) {

        while (root.left != null) {
            root = root.left;
        }
        return root;

    }

    void printInRange(Node root, int x, int y) {
        if (root == null) {
            return;
        }

        if (root.data >= x && root.data <= y) {
            printInRange(root.left, x, y);
            System.out.print(root.data + " ");
            printInRange(root.right, x, y);
        } else if (root.data >= y) {
            printInRange(root.left, x, y);
        } else if (root.data <= x) {
            printInRange(root.right, x, y);
        }
    }

    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        bst obj = new bst();
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = obj.insert(root, values[i]);
        }

        obj.inOrder(root);

        System.err.println();
        System.out.println("search :- " + obj.search(root, 6));

        // obj.delete(root, 4);

        obj.inOrder(root);
System.out.println();
        obj.printInRange(root, 3, 10);
    }
}
