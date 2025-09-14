# Last updated: 9/14/2025, 12:54:29 PM
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        minL = float("inf")
        left = right = 0
        sett = set(t)
        settc = set(t)
        countt = Counter(t)
        minss = []
        while right < len(s):
            countt[s[right]]-=1
            if countt[s[right]] == 0:
                sett.remove(s[right])
            
            while len(sett)==0:
                if right-left+1 < minL:
                    minss = [left, right]
                    minL = min(minL, right-left+1)
                countt[s[left]]+=1
                if s[left] in settc and countt[s[left]]>0:
                    sett.add(s[left])
                left+=1
            right+=1
        return s[minss[0]:minss[1]+1] if minL != float("inf") else ""