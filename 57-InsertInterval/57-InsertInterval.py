# Last updated: 11/6/2025, 10:11:36 PM
class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        out = []
        if not intervals: return [newInterval]
        s, e = newInterval
        i = 0
        n = len(intervals)
        # append all intervals with no overlap
        while i < n and s > intervals[i][1]:
            out.append(intervals[i])
            i+=1
        while i < n and e >= intervals[i][0]:
            s = min(intervals[i][0], s)
            e = max(intervals[i][1], e)
            i+=1
        out.append([s, e])
        out.extend(intervals[i:])
        return out