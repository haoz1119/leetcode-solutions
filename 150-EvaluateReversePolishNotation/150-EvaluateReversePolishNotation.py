# Last updated: 1/12/2026, 10:26:08 PM
1class Solution:
2    def evalRPN(self, tokens: List[str]) -> int:
3        stack = []
4        op_set= {'+','-','*','/'}
5        for ch in tokens:
6            if ch not in op_set:
7                stack.append(int(ch))
8            else:
9                right = stack.pop()
10                left = stack.pop()
11                if ch == '+':
12                    tmp = left + right
13                if ch == "-":
14                    tmp = left - right
15                if ch == "*":
16                    tmp = left*right
17                if ch == "/":
18                    if (left < 0 and right > 0) or (left > 0 and right < 0):
19                        tmp = abs(left)//abs(right) * (-1)
20                    else:
21                        tmp = left //right
22                stack.append(tmp)
23        return stack[-1]