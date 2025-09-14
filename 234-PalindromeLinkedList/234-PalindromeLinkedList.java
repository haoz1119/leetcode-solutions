// Last updated: 9/14/2025, 12:53:48 PM
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
    public boolean isPalindrome(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while(cur != null){
            cur= cur.next;
            n++;
        }
        if(n==1) return true;
        int mid = n/2;
        ListNode prev = null;
        cur = head;
        ListNode next = null;
        int i = 0;
        while(cur != null){
            if(i >= n/2){
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                i++;
            }else{
                prev = cur;
                cur = cur.next;
                i++;
            }
        }
        cur = head;
        for(int j = 0; j < n/2; j++){
            if(cur.val != prev.val) return false;
            cur = cur.next;
            prev = prev.next;
        }
        return true;
        
        
    }
}