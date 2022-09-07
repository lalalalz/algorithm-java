package test;

import leetCode.ListNode;
import leetCode.MergedTwoSortedList;
import org.junit.jupiter.api.Test;

import static leetCode.MergedTwoSortedList.*;

class MergedTwoSortedListTest {

    MergedTwoSortedList solution = new MergedTwoSortedList();

    @Test
    void test1() {

        ListNode firstHead = null;
        ListNode firstNow  = null;

        ListNode secondHead = null;
        ListNode secondNow  = null;

        firstHead = new ListNode(1);
        firstNow  = firstHead;

        firstNow.next = new ListNode(2);
        firstNow = firstNow.next;

        firstNow.next = new ListNode(4);
        firstNow = firstNow.next;

        secondHead = new ListNode(1);
        secondNow  = secondHead;

        secondNow.next = new ListNode(3);
        secondNow = secondNow.next;

        secondNow.next = new ListNode(4);
        secondNow = secondNow.next;


        ListNode mergedHead = solution.mergeTwoLists(firstHead, secondHead);

        while (mergedHead != null) {
            System.out.println("mergedHead.val = " + mergedHead.val);
            mergedHead = mergedHead.next;
        }
    }

}