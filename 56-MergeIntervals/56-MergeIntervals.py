# Last updated: 11/5/2025, 6:58:40 PM
class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        def overlap(a1: int, a2: int, b1: int, b2: int)-> bool:
            if a1<=b2 and a2>=b1:
                return True
            return False
        result=[]
        if len(intervals) ==1 : return intervals
        intervals.sort(key=lambda x:(x[0],x[1]))
        i = 1
        while i < len(intervals):
            a1, a2 = intervals[i-1]
            b1, b2 = intervals[i]
            i_cp = i
            while i < len(intervals) and overlap(a1,a2,b1,b2):
                a1 = min(a1,b1)
                a2 = max(a2, b2)
                i+=1
                if i < len(intervals): b1, b2 = intervals[i]
            result.append([a1, a2])
            if i == len(intervals)-1:
                result.append([b1,b2])
            i+=1
        return result