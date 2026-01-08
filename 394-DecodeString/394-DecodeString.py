# Last updated: 1/7/2026, 6:58:11 PM
1class Solution:
2    def decodeString(self, s: str) -> str:
3        num = []
4        letter = []
5        cur_str = ""
6        cur_num = 0
7        for ch in s:
8            if ch.isalpha():
9                cur_str += ch
10            if ch.isdigit():
11                cur_num = cur_num * 10 + int(ch)
12            if ch == "[":
13                num.append(cur_num)
14                cur_num = 0
15                letter.append(cur_str)
16                cur_str = ""
17            if ch == "]":
18                prev_str = letter.pop()
19                n = num.pop()
20                cur_str = prev_str + n * cur_str
21        return cur_str