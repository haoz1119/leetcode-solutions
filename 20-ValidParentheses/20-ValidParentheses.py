# Last updated: 9/14/2025, 12:55:11 PM
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for ch in s:
            if ch == '(' or ch == '[' or ch == '{':
                stack.append(ch)
            else:
                if not stack:
                    return False
                if ch == ')':
                    if stack.pop() != '(':
                        return False
                elif ch == ']':
                    if stack.pop() != '[':
                        return False
                elif ch == '}':
                    if stack.pop() != '{':
                        return False
        return True if not stack else False