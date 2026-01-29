# Last updated: 1/29/2026, 11:36:07 AM
1# Definition for singly-linked list.
2# class ListNode:
3#     def __init__(self, val=0, next=None):
4#         self.val = val
5#         self.next = next
6class Solution:
7    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
8        carry = 0
9        c1 = l1
10        c2 = l2
11        dummy = ListNode()
12        cur = dummy
13        while c1 or c2 or carry:
14          sums = 0
15          if c1:
16            sums += c1.val
17          if c2:
18            sums += c2.val
19          sums+=carry
20          carry = sums // 10
21          remainder = sums % 10
22          cur.next = ListNode(remainder)
23          cur = cur.next
24          if c1:
25            c1 = c1.next
26          if c2:
27            c2 = c2.next
28
29        return dummy.next