// Last updated: 9/14/2025, 12:54:02 PM
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
        int l1 = 0;
        int l2 = 0;
        while(cur1 != null){
            cur1 = cur1.next;
            l1++;
        }
        while(cur2 != null){
            cur2 = cur2.next;
            l2++;
        }
        int dif = l1 > l2 ? l1 - l2 : l2 - l1;
        cur1 = headA;
        cur2 = headB;
        int i = 0;
        while(cur1 != null && cur2 != null){
            if(l1 > l2){
                if(i >= dif){
                    if(cur1 == cur2) return cur1;
                    cur2 = cur2.next;
                }
                cur1 = cur1.next;
                i++;
            }
            else {
                if(i >= dif){
                    if(cur1 == cur2) return cur1;
                    cur1 = cur1.next;
                }
                cur2 = cur2.next;
                i++;
            }   
        }
        return null;
    }
}