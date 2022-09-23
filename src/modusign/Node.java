package modusign;

public class Node {
    private Node leftChild, rightChild;

    public Node(Node leftChild, Node rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Node getLeftChild() {
        return this.leftChild;
    }

    public Node getRightChild() {
        return this.rightChild;
    }

    public int height() {
        return getHeight(this);
    }

    public int getHeight(Node root) {
        if(root == null) return -1;

        int leftHeight = getHeight(root.leftChild) + 1;
        int rightHeight = getHeight(root.rightChild) + 1;

        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }

    public static void main(String[] args) {
        Node leaf1 = new Node(null, null);
        Node leaf2 = new Node(null, null);
        Node node = new Node(leaf1, null);
        Node root = new Node(node, leaf2);

        System.out.println(root.height());
    }
}
