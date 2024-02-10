import java.util.LinkedList;
import java.util.Queue;

class TreeSample {

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

    static int i = -1;

    static Node makeTree(int[] arr) {
        i++;
        if (i > arr.length - 1) {
            return null;
        }
        if (arr[i] == -1) {
            return null;
        }
        Node mNode = new Node(arr[i]);
        mNode.left = makeTree(arr);
        mNode.right = makeTree(arr);
        return mNode;
    }

    static void preOrder(Node root) {
        if (root == null) {
            // System.err.print("-1 ");
            return;
        }
        System.err.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.err.print(root.data + " ");
    }

    static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.err.print(root.data + " ");
        inOrder(root.right);
    }

    static void printTree(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        printTree(root.left);
        printTree(root.right);
    }

    static void levelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> mQueue = new LinkedList<>();

        mQueue.add(root);
        mQueue.add(null);

        while (!mQueue.isEmpty()) {
            Node current = mQueue.remove();
            if (current != null) {
                System.err.print(current.data + " ");
                if (current.left != null) {
                    mQueue.add(current.left);
                }
                if (current.right != null) {
                    mQueue.add(current.right);
                }
            } else {
                System.out.println();
                if (mQueue.isEmpty()) {
                    break;
                } else {
                    mQueue.add(null);
                }
            }
        }

    }

    static int countOfNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int leftCount = countOfNodes(root.left);
        int rightCount = countOfNodes(root.right);

        return leftCount + rightCount + 1;
    }

    static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int lSum = sumOfNodes(root.left);
        int rSum = sumOfNodes(root.right);

        int sum = lSum + rSum + root.data;
        return sum;
    }

    static int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        int lHeight = heightOfTree(root.left);
        int rHeight = heightOfTree(root.right);

        return Math.max(lHeight, rHeight) + 1;
    }

    static int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        int lDiam = diameter(root.left);
        int rDiam = diameter(root.right);

        int diam = heightOfTree(root.left) + heightOfTree(root.right) + 1;

        return Math.max(diam, Math.max(rDiam, lDiam));
    }

    static class TreeInfo {
        int diam;
        int height;

        TreeInfo(int diam, int height) {
            this.diam = diam;
            this.height = height;
        }

        void print() {
            System.out.println("Diam:- " + this.diam + " Height:- " + this.height);
        }
    }

    public static TreeInfo diameter2(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int myHeight = Math.max(left.height, right.height) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.height + right.height + 1;

        int myDiam = Math.max(diam3, Math.max(diam2, diam1));

        return new TreeInfo(myDiam, myHeight);

    }

    static boolean isIdentical(Node root, Node subRoot) {

        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }

        if (root.data == subRoot.data) {
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        }

        return false;
    }

    static boolean isSubtree(Node root, Node subRoot) {
        if (subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (root.data == subRoot.data) {
             if (isIdentical(root, subRoot)) {
                 return true;
             }
        }
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    static int sumOfNodes(Node root, int level) {

        if (root == null) {
            return 0;
        }

        int cLevel = 0;
        int sum = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node cNode = q.remove();
            if (cNode == null) {
                if (q.isEmpty()) {
                    
                } else {
                    q.add(null);
                    cLevel++;
                }
                
            } else {
                if (cLevel != level) {
                    if (cNode.left != null) {
                        q.add(cNode.left);
                    }
                    if (cNode.right != null) {
                        q.add(cNode.right);
                    }
                } else {
                    sum += cNode.data;
                }
            }

        }
        return sum;

    }
    public static void main(String[] args) {

        int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node mNode = makeTree(arr);
        // preOrder(mNode);
        // System.err.println("\nPost Order:- ");
        // postOrder(mNode);
        // System.err.println("In Order:- ");
        // inOrder(mNode);
        // System.err.println("Level Order:- ");
        // levelOrder(mNode);
        // System.err.println("Count of Nodes:- " + countOfNodes(mNode));
        // System.err.println("Sum of Nodes:- " + sumOfNodes(mNode));
        // System.err.println("Height of tree:- " + heightOfTree(mNode));
        // System.err.println("diameter of tree:- " + diameter2(mNode));
        // diameter2(mNode).print();

        int level = 2;
        System.err.println("sum of "+level+" level:- " + sumOfNodes(mNode,level));
    }
}
