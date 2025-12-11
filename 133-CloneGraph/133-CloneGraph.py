# Last updated: 12/10/2025, 4:00:21 PM
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
16        discset = set()
17        while discovered:
18            cur_node = discovered.popleft()
19            discset.discard(cur_node)
20            visited[cur_node] = Node(cur_node.val)
21            for nei in cur_node.neighbors:
22                if nei not in visited:
23                    if nei not in discset:
24                        discovered.append(nei)
25                        discset.add(nei)
26                else:
27                    visited[nei].neighbors.append(visited[cur_node])
28                    visited[cur_node].neighbors.append(visited[nei])
29
30        return visited[node]