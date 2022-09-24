package leetCode;

import java.util.ArrayList;
import java.util.List;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        List<Integer> elementsList = getElementOfListNode(head);
        return generateListNodes(elementsList);
    }

    private List<Integer> getElementOfListNode(ListNode head) {
        ListNode current = head;
        List<Integer> elements = new ArrayList<>();

        while (current != null) {
            elements.add(current.val);
            current = current.next;
        }

        return elements;
    }

    private ListNode generateListNodes(List<Integer> elements) {
        ListNode newList = null;
        ListNode current = null;

        swapElements(elements);

        for (Integer element : elements) {
            if (newList == null) {
                newList = new ListNode(element.intValue());
                current = newList;
            }
            else {
                current.next = new ListNode(element.intValue());
                current = current.next;
            }
        }

        return newList;
    }

    private void swapElements(List<Integer> elementsList) {
        for (int i = 0; i < elementsList.size(); i+=2) {
            if (i + 1 < elementsList.size()) {
                int temp = elementsList.get(i);
                elementsList.set(i, elementsList.get(i + 1));
                elementsList.set(i + 1, temp);
            }
        }
    }

//    public static class ListNode {
//        int val;
//        ListNode next;
//        ListNode() {}
//        ListNode(int val) { this.val = val; }
//        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//    }
}
