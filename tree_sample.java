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
        if (i > arr.length-1) {
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

    static void printTree(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {

        int arr[] = { 2, 4, 5, -1, 6, -1, -1, 8, 9, -1 };
        Node mNode = makeTree(arr);
        printTree(mNode);

    }
}
