# Last updated: 10/20/2025, 2:54:53 PM
class Solution:
    def isValid(self, s: str) -> bool:
        pairs={
            '(':')',
            '{':'}',
            '[':']'
        }
        stack = []
        for ch in s:
            if ch in pairs:
                stack.append(ch)
            else:
                if not stack or pairs[stack.pop()]!= ch:
                    return False
        return not stack