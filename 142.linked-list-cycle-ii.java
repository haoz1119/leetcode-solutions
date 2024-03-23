/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 */

// @lc code=start
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
        if(head == null || head.next == null) return null;
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode cur = head;
        while(cur!= null){
            map.put(cur, map.getOrDefault(cur, 0)+1);
            if(map.get(cur)>1) return cur;
            cur = cur.next;
        }
        return null;
    }
}
// @lc code=end

