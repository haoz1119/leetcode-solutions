# Last updated: 10/26/2025, 6:35:16 PM
class Solution:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        l, r = 0, len(letters)
        # mean idea is the unknown window [l, r), the boundary updates keep the window invariant
        while l < r:
            mid = (l+r)//2
            if letters[mid]>target:
                r = mid
            else:
                l = mid+1
        return letters[l] if l !=len(letters) else letters[0]