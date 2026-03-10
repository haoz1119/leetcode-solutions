# Last updated: 3/10/2026, 3:15:00 PM
1# Definition for singly-linked list.
2# class ListNode:
3#     def __init__(self, val=0, next=None):
4#         self.val = val
5#         self.next = next
6class Solution:
7    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
8        cur = res = ListNode(0)
9        carry = 0
10        total = 0
11        while l1 or l2 or carry:
12            if l1:
13                total += l1.val
14                l1 = l1.next
15            if l2:
16                total += l2.val
17                l2 = l2.next
18            if carry:
19                total += carry
20            carry = total // 10
21            val = total % 10
22            cur.next = ListNode(val)
23            cur = cur.next
24            total = 0
25
26        return res.next