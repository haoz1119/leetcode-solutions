# Last updated: 9/14/2025, 12:53:54 PM
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        ## think of it as two pointers with slow/fast pointers, fast is used to get the one after fast and hook the slow pointer as its next
        if head is None: return head
        slow = head
        fast = head.next
        slow.next = None
        while fast is not None:
            temp = fast.next
            fast.next = slow
            slow = fast
            fast = temp
        
        return slow
            
            
        