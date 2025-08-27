// Last updated: 8/27/2025, 12:55:06 PM
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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        
        // Loop until both lists are processed or there is a carry
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            
            // Add values from l1 and l2 if available
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            // Update carry and the current digit
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        
        // Return the resulting linked list
        return dummy.next;   
    }
}