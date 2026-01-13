# Last updated: 1/13/2026, 12:59:55 AM
1# Definition for singly-linked list.
2# class ListNode:
3#     def __init__(self, val=0, next=None):
4#         self.val = val
5#         self.next = next
6class Solution:
7    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
8        stack1 = []
9        stack2 = []
10        while l1:
11            stack1.append(l1.val)
12            l1 = l1.next
13        while l2:
14            stack2.append(l2.val)
15            l2 = l2.next
16        carry = 0
17        prev = None
18        while stack1 and stack2:
19            l = stack1.pop()
20            r = stack2.pop()
21            total = l+r+carry
22            digit = total%10
23            carry = total//10
24            cur = ListNode(digit, prev)
25            prev = cur
26        while stack1:
27            l = stack1.pop()
28            total = l+carry
29            digit = total%10
30            carry = total//10
31            cur = ListNode(digit, prev)
32            prev = cur
33        while stack2:
34            l = stack2.pop()
35            total = l+carry
36            digit = total%10
37            carry = total//10
38            cur = ListNode(digit, prev)
39            prev = cur
40        if carry != 0:
41            prev = ListNode(carry, prev)
42        return prev