package test;

import leetCode.ListNode;
import leetCode.RemoveNthNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RemoveNthNodeTest {

    RemoveNthNode solution = new RemoveNthNode();

    @Test
    void test1() {
        ListNode head = new ListNode(1);
        ListNode current = head;

        current.next = new ListNode(2);
        current = current.next;

        current.next = new ListNode(3);
        current = current.next;

        current.next = new ListNode(4);
        current = current.next;

        current.next = new ListNode(5);
        current = current.next;

        ListNode result = solution.removeNthFromEnd(head, 2);

        while (result != null) {
            System.out.println("result.val = " + result.val);
            result = result.next;
        }
    }

}