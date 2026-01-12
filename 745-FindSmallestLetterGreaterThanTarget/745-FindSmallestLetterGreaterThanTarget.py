# Last updated: 1/12/2026, 12:23:24 AM
class Solution:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        n = len(letters)
        left, right = 0, n - 1
        ans = n  # “no answer yet” sentinel (= wrap)
        while left <= right:
            mid = (left + right) // 2
            if letters[mid] > target:        # looking for first '>'
                ans = mid                    # record candidate
                right = mid - 1              # keep searching left side
            else:
                left = mid + 1               # need a strictly larger letter
        return letters[ans] if ans != n else letters[0]
 # inclusive style [l, r] you want to always have l or r off by 1