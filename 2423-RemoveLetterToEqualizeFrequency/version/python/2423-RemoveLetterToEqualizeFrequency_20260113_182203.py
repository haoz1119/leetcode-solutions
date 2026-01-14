# Last updated: 1/13/2026, 6:22:03 PM
1from collections import Counter
2class Solution:
3    def equalFrequency(self, word: str) -> bool:
4        # aaabbbc, aaabbcc, abc, aaaa
5        count = Counter(word)
6        if len(count) == 1:
7            return True
8        cc = Counter(count.values())
9        if len(cc) == 1:
10            key = list(cc.keys())
11            if key[0] == 1:
12                return True
13        if len(cc) == 2:
14            if 1 in cc and cc[1] == 1:
15                return True
16            a, b = list(cc.keys())
17            a, b = (b, a) if a < b else (a, b)
18            if a-b ==1 and cc[a] == 1 and cc[a] <= cc[b]:
19                return True
20        return False