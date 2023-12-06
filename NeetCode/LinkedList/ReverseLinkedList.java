package LinkedList;

import java.util.Stack;

public class ReverseLinkedList {
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

    public static ListNode reverseList(ListNode head) {

        ListNode current = head;
        ListNode previous = null;


        while (current != null) {
            ListNode tempNext = current.next;
            current.next = previous;
            previous = current;
            current = tempNext;
        }


        return previous;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(reverseList(head));
    }
}
