# Last updated: 10/20/2025, 1:50:23 PM
class MinStack:

    def __init__(self):
        self.stack = []
        self.minstack=[]
    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.minstack:self.minstack.append(val)
        else: 
            if self.minstack[-1]> val:
                self.minstack.append(val)
            else:
                self.minstack.append(self.minstack[-1])
    def pop(self) -> None:
        if self.stack: self.stack.pop()
        if self.minstack: self.minstack.pop()

    def top(self) -> int:
        if self.stack: return self.stack[-1]
        else: return None

    def getMin(self) -> int:
        if self.minstack:return self.minstack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()