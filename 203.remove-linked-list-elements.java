/*
 * @lc app=leetcode id=203 lang=java
 *
 * [203] Remove Linked List Elements
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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        ListNode cur = head;
        // easier when head is taken, we just connect it to the dummy
        ListNode dummy = new ListNode(0, head);
        // to connect the prev node to the next node so we maintain a prev 
        ListNode prev = dummy;
        while(cur != null){
            if(cur.val==val){
                prev.next=cur.next;
                cur = cur.next;
            }
            else {
                prev = cur;
                cur = cur.next; 
            }
        }
        return dummy.next;
    }
}
// @lc code=end

