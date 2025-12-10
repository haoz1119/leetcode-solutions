# Last updated: 12/9/2025, 5:32:39 PM
1# Definition for a binary tree node.
2# class TreeNode:
3#     def __init__(self, val=0, left=None, right=None):
4#         self.val = val
5#         self.left = left
6#         self.right = right
7class Solution:
8    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
9        if not root: return []
10        from collections import deque
11        queue = deque([root])
12        lv_idx = 0
13        result = []
14        while queue:
15            lv_size = len(queue)
16            level = []
17            for i in range(lv_size):
18                cur_node = queue.popleft()
19                if lv_idx % 2:
20                    level.insert(0, cur_node.val)
21                else:
22                    level.append(cur_node.val) 
23                if cur_node.left:
24                    queue.append(cur_node.left)
25                if cur_node.right:
26                    queue.append(cur_node.right)
27            result.append(level)  
28            lv_idx += 1
29        return result