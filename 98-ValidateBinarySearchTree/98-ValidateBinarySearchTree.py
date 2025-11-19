# Last updated: 11/18/2025, 9:39:11 PM
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        list1 = []
        def iot(node:Optional[TreeNode]): # in order travelsal and check if prev is always smaller than cur
            if not node:
                return
            if (not node.left) and (not node.right):
                list1.append(node.val)
                return
            iot(node.left)
            list1.append(node.val)
            iot(node.right)
        iot(root)
        for i in range(len(list1)-1):
            if list1[i]>=list1[i+1]:
                return False
        return True
