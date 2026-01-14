# Last updated: 1/13/2026, 5:10:01 PM
1"""
2# Definition for a Node.
3class Node:
4    def __init__(self, val, prev, next, child):
5        self.val = val
6        self.prev = prev
7        self.next = next
8        self.child = child
9"""
10
11class Solution:
12    def flatten(self, head: 'Optional[Node]') -> 'Optional[Node]':
13        if not head or (not head.child and not head.next):
14            return head
15        stack = [head]
16        prev = None
17        while stack:
18            cur = stack.pop()
19            if cur.next:
20                stack.append(cur.next)
21            if cur.child:
22                stack.append(cur.child)
23                cur.child = None
24            cur.prev = prev
25            if prev:
26                prev.next = cur
27            prev = cur
28        return head