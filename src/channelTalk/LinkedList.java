package channelTalk;


public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.print();

        linkedList.delete(2);
        linkedList.print();

        linkedList.delete(1);
        linkedList.print();

    }

    public LinkedList() {
        size = 0;
    }

    public void append(int value) {
        Node node = new Node(value);

        if (size == 0) {
            head = node;
        }
        else {
            tail.setNext(node);
        }
        tail = node;
        size++;
    }

    public boolean delete(int value) {
        if (size == 0) {
            return false;
        }

        Node current = head;
        Node prev = null;

        while (current != null && current.getValue() != value) {
            prev = current;
            current = current.getNext();
        }

        if (current == null) {
            return false;
        }

        if (current == head) {
            head = current.getNext();
        }
        else {
            prev.setNext(current.getNext());
        }

        if (current == tail) {
            tail = prev;
        }

        current.setNext(null);
        size--;
        return true;
    }

    public void print() {
        if (size == 0) {
            System.out.println("리스트가 비어있습니다.");
            return;
        }

        Node current = head;

        StringBuilder sb = new StringBuilder();
        while (current != null) {
            if (!sb.isEmpty()) {
                sb.append(", ");
            }
            sb.append(current.getValue());
            current = current.getNext();
        }
        System.out.println(sb);
    }

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
