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
// best solution:
/**
 * since cur 1 and cur2 has the same speed traversing each list
 * thus if two list has an intesection, cur1 and cur2 will meet at the 
 * intersection, which is a + c + b = b + c + a
 * if there is no intersection between two list, the while loop will end 
 * when both cur1 and cur2 are null, that's when each one has traversed both 
 * list once
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while(cur1 != cur2){
            cur1 = cur1 == null ? cur1 = headB : cur1.next;
            cur2 = cur2 == null ? cur2 = headA : cur2.next;
        }
        return cur1;
    }
}
// @lc code=end

