/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
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
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode r = reverseList(head.next);
        ListNode tail = getTail(r);
        tail.next = new ListNode(head.val);
        return r;    
    }
    public static ListNode getTail(ListNode head){
        ListNode cur = head;
        while(cur.next != null){
            cur = cur.next;
        }
        return cur;
    }
}
// @lc code=end

