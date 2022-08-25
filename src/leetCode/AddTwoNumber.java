package leetCode;

public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return plusListNode(l1, l2);
    }

    private ListNode plusListNode(ListNode l1, ListNode l2) {
        int sum = 0;
        int a, b, c = 0;
        ListNode now  = null;
        ListNode head = null;
        ListNode firstListNow  = l1;
        ListNode secondListNow = l2;

        while (true) {
            if (c == 0 && firstListNow == null && secondListNow == null) {
                break;
            }

            if (head == null) {
                head = new ListNode();
                now  = head;
            }
            else {
                now.next = new ListNode();
                now = now.next;
            }

            a = getDigit(firstListNow);
            b = getDigit(secondListNow);

            now.val = (a + b + c) % 10;
            c = (a + b + c) / 10;

            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("c = " + c);
            System.out.println("===============");

            firstListNow = next(firstListNow);
            secondListNow = next(secondListNow);
        }

        return head;
    }

    private ListNode next(ListNode node) {
        if(node == null || node.next == null) {
            return null;
        }
        return node.next;
    }

    private int getDigit(ListNode firstListNow) {
        if(firstListNow == null) return 0;
        return firstListNow.val;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
