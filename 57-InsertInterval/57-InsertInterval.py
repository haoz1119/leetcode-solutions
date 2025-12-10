# Last updated: 12/9/2025, 4:18:45 PM
1class Solution:
2    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
3        # skip non overlap intervals
4        ns, ne = newInterval
5        merged = []
6        idx = 0
7        for s, e in intervals:
8            if e >= ns:
9                break
10            merged.append([s, e])
11            idx += 1
12        # merge overlapping intervals
13        while idx < len(intervals) and intervals[idx][0] <= ne:
14            min_s = min(ns, intervals[idx][0])
15            max_e = max(ne, intervals[idx][1])
16            ns = min_s
17            ne = max_e
18            idx += 1
19        merged.append([ns, ne])
20        merged.extend(intervals[idx:])
21        return merged