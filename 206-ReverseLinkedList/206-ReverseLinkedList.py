# Last updated: 11/3/2025, 2:59:13 PM
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next: return head
        else:
            next = head.next
            newhead = self.reverseList(next)
            next.next = head
            head.next = None
        return newhead
