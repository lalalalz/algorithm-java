package leetCode;

import java.util.List;

public class MergedTwoSortedList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return getMergedList(list1, list2);
    }

    private ListNode getMergedList(ListNode firstListNow, ListNode secondListNow) {

        ListNode mergedListHead = null;
        ListNode mergedListNow  = null;

        while (firstListNow != null && secondListNow != null) {
            if (firstListNow.val < secondListNow.val) {
                mergedListNow = connectNode(mergedListNow, firstListNow.val);
                firstListNow = firstListNow.next;
            }
            else {
                mergedListNow = connectNode(mergedListNow, secondListNow.val);
                secondListNow = secondListNow.next;
            }

            if (mergedListHead == null) {
                mergedListHead = mergedListNow;
            }
        }

        while (firstListNow != null) {
            mergedListNow = connectNode(mergedListNow, firstListNow.val);
            firstListNow = firstListNow.next;

            if (mergedListHead == null) {
                mergedListHead = mergedListNow;
            }
        }

        while (secondListNow != null) {
            mergedListNow = connectNode(mergedListNow, secondListNow.val);
            secondListNow = secondListNow.next;

            if (mergedListHead == null) {
                mergedListHead = mergedListNow;
            }
        }

        return mergedListHead;
    }

    private ListNode connectNode(ListNode now, int value) {
        if (now == null) {
            now  = new ListNode(value);
        }
        else {
            now.next = new ListNode(value);
            now = now.next;
        }
        return now;
    }
}

