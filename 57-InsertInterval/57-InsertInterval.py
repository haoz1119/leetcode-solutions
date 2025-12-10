# Last updated: 12/9/2025, 5:47:58 PM
1# Definition for a binary tree node.
2# class TreeNode:
3#     def __init__(self, val=0, left=None, right=None):
4#         self.val = val
5#         self.left = left
6#         self.right = right
7from collections import deque
8
9class Solution:
10    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
11        if not root:
12            return []
13        queue = deque([root])
14        left_to_right = True
15        result = []
16
17        while queue:
18            level_size = len(queue)
19            level = deque()
20            for _ in range(level_size):
21                node = queue.popleft()
22                if left_to_right:
23                    level.append(node.val)
24                else:
25                    level.appendleft(node.val)
26                if node.left:
27                    queue.append(node.left)
28                if node.right:
29                    queue.append(node.right)
30
31            result.append(list(level))
32            left_to_right = not left_to_right
33
34        return result
35