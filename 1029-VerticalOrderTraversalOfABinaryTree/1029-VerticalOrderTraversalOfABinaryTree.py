# Last updated: 1/12/2026, 12:23:15 AM
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import defaultdict, deque
class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        dic = defaultdict(list)
        queue = deque([(root, 0)])
        while queue:
            size = len(queue)
            i = 0
            tmp = defaultdict(list)
            while i < size:
                node, col = queue.popleft()
                tmp[col].append(node.val)
                if node.left:
                    queue.append((node.left, col-1))
                if node.right:
                    queue.append((node.right, col+1))
                i += 1
            for col, vals in tmp.items():
                vals.sort()
                dic[col].extend(vals)
        dic_sorted = sorted(dic.items())
        return [v for _, v in dic_sorted]