package LinkedList;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {


        ListNode mergedListHead = new ListNode(0);
        ListNode currentNode = mergedListHead;
        ListNode nextNode = new ListNode(0);


        while (list1 != null && list2 != null) {

            int value;

            if (list1.val < list2.val) {
                value = list1.val;
                list1 = list1.next;
            } else {
                value = list2.val;
                list2 = list2.next;
            }

            nextNode.val = value;
            currentNode.next = nextNode;

            currentNode = nextNode;
            nextNode = new ListNode(0);
        }

        if (list1 != null) {
            currentNode.next = list1;
        } else {
            currentNode.next = list2;
        }

        return mergedListHead.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);


        mergeTwoLists(list1, list2);
    }
}
