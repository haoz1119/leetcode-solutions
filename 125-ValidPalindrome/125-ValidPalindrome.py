# Last updated: 9/14/2025, 12:54:14 PM
class Solution:
    def isPalindrome(self, s: str) -> bool:
        s_r = [ch.lower() for ch in s if ch.isalnum()]
        return s_r == s_r[::-1]