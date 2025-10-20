# Last updated: 10/19/2025, 6:46:03 PM
class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        count = Counter(s1)
        k = len(s1)
        con = Counter()
        for i, ch in enumerate(s2):
            con[ch] +=1
            if i > k-1:
                con[s2[i-k]]-=1
            if i >= k-1 and con == count:
                return True
            
        return False
