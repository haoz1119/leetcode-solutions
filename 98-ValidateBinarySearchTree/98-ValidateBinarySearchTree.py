# Last updated: 11/19/2025, 5:43:20 PM
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def dfs(root, low = -math.inf, high = math.inf)->bool:
            if not root:
                return True
            if root.left and (root.left.val >= root.val or root.left.val <= low):
                return False
            if root.right and (root.right.val <= root.val or root.right.val >= high):
                return False
            return dfs(root.left, low, root.val) and dfs(root.right, root.val, high)
        return dfs(root)