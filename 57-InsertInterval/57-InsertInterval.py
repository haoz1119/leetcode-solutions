# Last updated: 11/6/2025, 9:45:31 PM
class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        def overlap(a1:int, a2:int, b1:int, b2:int)->bool:
            return a1<=b2 and a2>=b1
        if not intervals: return [newInterval]
        out = []
        ns, ne = newInterval
        found = False
        i = 0
        if ne < intervals[0][0]:
            intervals.insert(0, newInterval)
            return intervals
        if ns > intervals[-1][1]: 
            intervals.append(newInterval)
            return intervals
        for s, e in intervals:
            if overlap(s,e,ns,ne) and not found:
                found = True
                out.append([min(s,ns), max(e, ne)])
                i+=1
                continue
            if found and out[-1][1]>=s: # we found the overlap and there are more
                out[-1][1] = max(out[-1][1], e)
                i+=1
                continue
            if found and out[-1][1]< s: # we found the overlap and no overlap anymore so we break
                out.extend(intervals[i:])
                break
            if out and ns>out[-1][1] and ne < s:
                out.append([ns,ne])
                out.extend(intervals[i:])
                break
            out.append([s,e])
            i+=1
        return out