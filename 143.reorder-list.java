/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
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
    public void reorderList(ListNode head) {
        ListNode cur = head;
        int n = 0;
        while(cur != null){
            cur = cur.next;
            n++;
        }
        ListNode prev = null;
        cur = head;
        ListNode next = null;
        for(int i = 0; i < n; i++){
            if(i >= n/2){
               next = cur.next;
               cur.next = prev;
               prev = cur;
               cur = next; 
            }
            else cur = cur.next;
        }
        cur = head;
        ListNode tail = prev;
        ListNode next2 = null;
        while(tail.next != null){
            next = cur.next;
            cur.next = tail;
            next2 = tail.next;
            tail.next = next;
            tail = next2;
            cur = next;
        }
    }
}
// @lc code=end

