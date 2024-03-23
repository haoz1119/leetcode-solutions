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
// a better solution
/**
intuition

The recursive version is slightly trickier and the key is to work backwards. Assume that the rest of the list had already been reversed, now how do we reverse the front part? Let's assume the list is: n1 → … → nk-1 → nk → nk+1 → … → nm → Ø

Assume from node nk+1 to nm had been reversed and we are at node nk.

n1 → … → nk-1 → nk → nk+1 ← … ← nm

We want nk+1’s next node to point to nk.

So,

nk.next.next = nk;

Be very careful that n1's next must point to Ø. If you forget about this, your linked list will have a cycle in it. This bug could be caught if you test your code with a linked list of size 2.


 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode r = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return r;    
    }
}


// @lc code=end

