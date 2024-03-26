/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 */

// @lc code=start
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
/**
 * fast and slow pointers
 * the hard part is to notice the scenario to remove the head node
 * and fast node goes two nodes ahead of the slow node
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
// @lc code=end

