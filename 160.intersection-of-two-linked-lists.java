/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        HashSet<ListNode> set = new HashSet<>();
        while(cur1 != null){
            set.add(cur1);
            cur1 = cur1.next;
        }
        while(cur2 != null){
            if(set.contains(cur2)) return cur2;
            cur2 = cur2.next;
        }
        return null;
    }
}
// @lc code=end

