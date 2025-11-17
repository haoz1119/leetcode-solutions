# Last updated: 11/16/2025, 9:32:44 PM
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root: return []
        queue = deque([root])
        res = []
        while queue:
            level_size = len(queue)
            node = queue.popleft()
            res.append(node.val)
            if node.right:
                queue.append(node.right)
            if node.left:
                queue.append(node.left)
            for _ in range(level_size - 1):
                node = queue.popleft()
                if node.right:
                    queue.append(node.right)
                if node.left:
                    queue.append(node.left)
        return res
