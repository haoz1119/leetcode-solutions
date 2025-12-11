# Last updated: 12/10/2025, 4:29:48 PM
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
15        def dfs(node):
16            for nei in node.neighbors:
17                if nei not in visited:
18                    visited[nei] = Node(nei.val)
19                    dfs(nei)
20                visited[node].neighbors.append(visited[nei])
21        visited[node] = Node(node.val)
22        dfs(node)
23        return visited[node]