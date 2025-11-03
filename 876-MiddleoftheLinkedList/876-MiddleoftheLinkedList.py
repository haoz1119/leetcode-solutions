# Last updated: 11/3/2025, 3:09:48 PM
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        s, f = head, head
        while f and f.next:
            s = s.next
            f = f.next.next
        return s