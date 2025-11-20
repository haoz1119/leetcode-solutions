# Last updated: 11/19/2025, 6:26:12 PM
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        prev = -math.inf
        def dfs(root):
            nonlocal prev
            if not root:
                return True
            if not dfs(root.left):
                return False
            if root.val <= prev:
                return False
            prev = root.val
            return dfs(root.right)
        return dfs(root)