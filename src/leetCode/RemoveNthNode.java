package leetCode;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        return getRemovedNthNodeList(head, n);
    }

    private ListNode getRemovedNthNodeList(ListNode head, int n) {
        return generateRemovedNthNodeList(getElementsOfNodeList(head), n);
    }

    private List<Integer> getElementsOfNodeList(ListNode head) {
        ListNode current = head;
        List<Integer> result = new ArrayList<>();

        while (current != null) {
            result.add(current.val);
            current = current.next;
        }

        return result;
    }

    private ListNode generateRemovedNthNodeList(List<Integer> elements, int n) {
        ListNode head = null;
        ListNode current = null;

        elements.remove(elements.size() - n);

        for (Integer element : elements) {
            if (head == null) {
                current = new ListNode(element);
                head = current;
            }
            else {
                current.next = new ListNode(element);
                current = current.next;
            }
        }

        return head;
    }
}
