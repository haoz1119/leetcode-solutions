# Last updated: 1/13/2026, 4:56:33 PM
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
13        cur = head
14        def helper(cur): # return the end node
15            if not cur or (not cur.next and not cur.child):
16                return cur
17            while cur:
18                after = cur.next
19                prev = cur
20                child = cur.child
21                if child:
22                    prev.next = child
23                    child.prev = prev
24                    cur.child = None
25                    nxt = helper(child)
26                    nxt.next = after
27                    if after:
28                        after.prev = nxt
29                    else:
30                        return nxt
31                cur = after
32            return prev
33        helper(cur)       
34        return head
35