# Last updated: 9/14/2025, 12:54:20 PM
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if not root: return 0
        stack = [(root,1)]
        maxD = 1
        while stack:
            (cur, l) = stack.pop()
            maxD = max(maxD, l)
            if cur.left:
                stack.append((cur.left, l+1))
            if cur.right:
                stack.append((cur.right, l+1))

        return maxD