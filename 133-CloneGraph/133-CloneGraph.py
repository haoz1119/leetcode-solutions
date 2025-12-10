# Last updated: 12/10/2025, 3:56:50 PM
1"""
2# Definition for a Node.
3class Node:
4    def __init__(self, val = 0, neighbors = None):
5        self.val = val
6        self.neighbors = neighbors if neighbors is not None else []
7"""
8
9from typing import Optional
10from collections import deque
11class Solution:
12    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
13        if not node: return None
14        visited = {}
15        discovered = deque([node])
16        while discovered:
17            cur_node = discovered.popleft()
18            visited[cur_node] = Node(cur_node.val)
19            for nei in cur_node.neighbors:
20                if nei not in visited:
21                    if nei not in discovered:
22                        discovered.append(nei)
23                else:
24                    visited[nei].neighbors.append(visited[cur_node])
25                    visited[cur_node].neighbors.append(visited[nei])
26
27        return visited[node]