# Last updated: 9/14/2025, 12:53:50 PM
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root: return root
        stack = []
        stack.append(root)
        while stack:
            curr = stack.pop()
            curr.left, curr.right = curr.right, curr.left
            if curr.left:stack.append(curr.left)
            if curr.right:stack.append(curr.right)
        return root