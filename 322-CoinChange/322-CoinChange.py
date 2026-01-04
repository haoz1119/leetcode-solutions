# Last updated: 1/3/2026, 5:10:43 PM
1class Solution:
2    def exist(self, board: List[List[str]], word: str) -> bool:
3        l = len(word)
4        m = len(board)
5        n = len(board[0])
6        dirs = [(1,0),(-1,0),(0,1),(0,-1)]
7        def inbound(r, c):
8            return 0<=r<m and 0<=c<n
9        def dfs(r, c, i):
10            if i == l:
11                return True
12            for dr, dc in dirs:
13                nr, nc = r+dr, c+dc
14                if inbound(nr, nc) and board[nr][nc] == word[i]:
15                    board[nr][nc] = '#'
16                    if dfs(nr, nc, i+1):
17                        return True
18                    board[nr][nc] = word[i]
19            return False
20        for r in range(m):
21            for c in range(n):
22                if board[r][c] == word[0]:
23                    board[r][c] = '#'
24                    if dfs(r, c, 1):
25                        return True
26                    board[r][c] = word[0]
27        return False