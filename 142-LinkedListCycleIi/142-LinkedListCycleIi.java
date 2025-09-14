// Last updated: 9/14/2025, 12:54:08 PM
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        // for empty list return null
        // for one element list without self cycling, return null
        while(fast!=null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode i1, i2;
                i1 = head;
                i2 = slow;
                while(i1 != i2){
                    i1 = i1.next;
                    i2 = i2.next;
                }
                return i1;
            }
        }
        return null;

    }
}