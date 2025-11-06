# Last updated: 11/5/2025, 9:30:14 PM
class Solution:
    def canAttendMeetings(self, intervals: List[List[int]]) -> bool:
        intervals.sort(key=lambda x : (x[0]))
        if len(intervals) <= 1: return True
        prev = intervals[0]
        for s, e in intervals[1:]:
            if s < prev[1]:
                return False
            prev = [s,e]
        return True