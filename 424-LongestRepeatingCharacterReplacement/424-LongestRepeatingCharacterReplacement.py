# Last updated: 9/14/2025, 12:53:38 PM
class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        left = right = 0
        maxL = 0
        n = len(s)-1
        count = Counter()
        maxFreq = 0
        while right <= n:
            count[s[right]]+=1
            maxFreq = max(maxFreq, count[s[right]])

            if right - left + 1 - maxFreq > k:
                count[s[left]]-=1
                left+=1
            maxL = max(maxL, right-left+1)
            right+=1
        return maxL
