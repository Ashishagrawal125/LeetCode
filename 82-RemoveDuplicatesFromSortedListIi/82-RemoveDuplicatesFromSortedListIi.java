// Last updated: 8/27/2025, 12:54:04 PM
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
    public ListNode deleteDuplicates(ListNode head) {
        // Create a dummy node which simplifies edge case handling
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Pointer to iterate over the list
        ListNode current = dummy;
        
        while (current.next != null && current.next.next != null) {
            if (current.next.val == current.next.next.val) {
                // Skip all nodes with the same value
                int val = current.next.val;
                while (current.next != null && current.next.val == val) {
                    current.next = current.next.next;
                }
            } else {
                // Move to the next node
                current = current.next;
            }
        }
        
        return dummy.next; // Return the modified list (dummy's next node)
    }
}
