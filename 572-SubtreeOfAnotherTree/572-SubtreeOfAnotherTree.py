# Last updated: 9/14/2025, 12:53:32 PM
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        def isSame(root, subroot):
            if root is None and subroot is None:
                return True
            if not root or not subroot:
                return False
            if root.val != subroot.val:
                return False
            else:
                return isSame(root.left,subroot.left) and isSame(root.right, subroot.right)
        if root is None and subRoot is None:
            return True
        if not root or not subRoot:
            return False
        if root.val == subRoot.val:
            return (isSame(root,subRoot)) or (self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot))
        else:
            return self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)