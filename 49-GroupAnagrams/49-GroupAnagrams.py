# Last updated: 9/14/2025, 12:54:34 PM
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        if not strs: return [[]]
        li=[]
        d=defaultdict(list)
        for s in strs:
            d[tuple(sorted(s))].append(s)
        for k in d.keys():
            li.append(d.get(k))
        return li