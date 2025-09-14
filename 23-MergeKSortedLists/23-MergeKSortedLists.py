# Last updated: 9/14/2025, 12:55:10 PM
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        def merge2Lists(l1, l2)->Optional[ListNode]:
            dummy = ListNode(0)
            head = dummy
            while l1 and l2:
                if l1.val < l2.val:
                    dummy.next = l1
                    dummy = dummy.next
                    l1 = l1.next
                else:
                    dummy.next = l2
                    dummy = dummy.next
                    l2 = l2.next
            dummy.next = l1 if l1 else l2
            return head.next
        if len(lists) == 0: return None
        interval = 1
        while interval < len(lists):
            for i in range(0, len(lists)-interval, interval*2):
                lists[i] = merge2Lists(lists[i], lists[i+interval])
            interval *= 2
        return lists[0]