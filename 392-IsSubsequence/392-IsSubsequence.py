# Last updated: 9/14/2025, 2:28:10 PM
class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        i = 0
        j = 0
        time = 0
        while j < len(s):
            while i < len(t):
                if t[i] == s[j]:
                    i+=1
                    time += 1
                    break
                i+=1
            j+=1
        return time == len(s)