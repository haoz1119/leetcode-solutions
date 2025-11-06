# Last updated: 11/5/2025, 7:50:39 PM
class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if len(intervals) == 1: return intervals
        intervals.sort(key=lambda x:(x[0]))
        start = intervals[0][0]
        end = intervals[0][1]
        prev = [start, end]
        merged = []
        for interval in intervals[1:]:
            if prev[1] >=interval[0]:
                prev[1] = max(prev[1], interval[1])
            else:
                merged.append(prev)
                prev = interval
        merged.append(prev)
        return merged
                
