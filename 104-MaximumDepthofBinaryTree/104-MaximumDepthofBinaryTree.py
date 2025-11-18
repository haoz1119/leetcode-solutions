# Last updated: 11/17/2025, 5:51:41 PM
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        def dfs(node:Optional[TreeNode]) -> int:
            if not node: return 0
            return max(dfs(node.left), dfs(node.right))+1
        return dfs(root)