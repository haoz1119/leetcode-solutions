# Last updated: 11/5/2025, 9:33:23 PM
class Solution:
    def canAttendMeetings(self, intervals: List[List[int]]) -> bool:
        if len(intervals) <= 1: return True
        intervals.sort(key=lambda x : x[0])
        prev = intervals[0]
        for s, e in intervals[1:]:
            if s < prev[1]:
                return False
            prev = [s,e]
        return True