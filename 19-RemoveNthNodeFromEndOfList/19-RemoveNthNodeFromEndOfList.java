// Last updated: 9/14/2025, 12:55:15 PM
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        int i = 0;
        while(fast.next != null){
            fast = fast.next;
            i++;
            if(i > n) slow = slow.next;
        }
        i++;
        if(n == i) return head.next;
        else slow.next = slow.next.next;
        return head;
    }
}