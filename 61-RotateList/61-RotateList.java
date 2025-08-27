// Last updated: 8/27/2025, 12:54:24 PM
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // If the list is empty or has only one element, no rotation is needed
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find the length of the list
        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Step 2: Normalize k (avoid unnecessary rotations)
        k = k % length;
        if (k == 0) {
            return head; // No rotation needed
        }

        // Step 3: Find the new tail and new head
        current.next = head; // Make the list circular
        int newTailIndex = length - k;
        ListNode newTail = head;
        for (int i = 1; i < newTailIndex; i++) {
            newTail = newTail.next;
        }

        // Step 4: Set the new head and break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
