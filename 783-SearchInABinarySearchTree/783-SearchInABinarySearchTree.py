# Last updated: 1/12/2026, 12:23:27 AM
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def searchBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        while root:
            if val < root. val:
                root = root.left
            elif val > root.val:
                root = root.right
            else:
                return root
        return root