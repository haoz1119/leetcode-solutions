# Last updated: 9/14/2025, 12:54:09 PM
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        fast = slow.next
        slow.next = None
        while fast:
            fast.next, slow, fast = slow, fast, fast.next
        
        l1 = head
        l2 = slow
        while l2.next:
            l1.next, l1 = l2, l1.next
            l2.next, l2 = l1, l2.next

        