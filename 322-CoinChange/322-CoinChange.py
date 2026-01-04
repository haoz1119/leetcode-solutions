# Last updated: 1/3/2026, 5:07:33 PM
1class Solution:
2    def exist(self, board: List[List[str]], word: str) -> bool:
3        m = len(board)
4        n = len(board[0])
5        l = len(word)
6        dirs = [(1,0),(-1,0),(0,1),(0,-1)]
7        def inbound(r, c):
8            return 0<=r<m and 0<=c<n
9        def dfs(r, c, i):
10            if board[r][c] != word[i]:
11                return False
12            if i == l-1:
13                return True
14            tmp = board[r][c]
15            board[r][c] = '#'
16            for dr, dc in dirs:
17                nr, nc = r+dr, c+dc
18                if inbound(nr, nc) and board[nr][nc] != '#':
19                    if dfs(nr, nc, i+1):
20                        board[r][c] = tmp
21                        return True
22            board[r][c] = tmp
23            return False
24        for r in range(m):
25            for c in range(n):
26                if dfs(r, c, 0):
27                    return True
28        return False
29
30