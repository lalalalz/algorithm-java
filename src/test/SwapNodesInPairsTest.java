package test;

import leetCode.ListNode;
import leetCode.SwapNodesInPairs;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwapNodesInPairsTest {
    SwapNodesInPairs solution = new SwapNodesInPairs();

    @Test
    void test1() {

        ListNode head = new ListNode(5);
        ListNode current = head;

        current.next = new ListNode(6);
        current = current.next;

        current.next = new ListNode(1);
        current = current.next;

        current.next = new ListNode(3);
        current = current.next;

        current.next = new ListNode(2);
        current = current.next;

        current.next = new ListNode(4);
        current = current.next;

        ListNode listNode = solution.swapPairs(head);

        while (listNode != null) {
            System.out.println("listNode.val = " + listNode.val);
            listNode = listNode.next;
        }
    }
}