# Last updated: 1/8/2026, 11:32:35 PM
1class MinStack:
2    # we want a stack that is non increasing
3    """
4    we can simply use a min var, cus once we pop the min, we will not have the knowledge of the next min
5    hence we need a heap like structure, but it would not be O(1), so we need min stack, which is non increasing stack
6    once we pop the smallest, the next one in min stack will be the next smallest element, the order of the elements in the minstack
7    is the same as them in the stack as they appear
8    """
9    def __init__(self):
10        self.stack = []
11        self.minstack = [] 
12
13    def push(self, val: int) -> None:
14        self.stack.append(val)
15        if len(self.minstack) == 0:
16            self.minstack.append(val)
17        else:
18            if val <= self.minstack[-1]:
19                self.minstack.append(val)
20
21    def pop(self) -> None:
22        val = self.stack.pop()
23        if val == self.minstack[-1]:
24            self.minstack.pop()
25
26    def top(self) -> int:
27        return self.stack[-1]
28
29    def getMin(self) -> int:
30        return self.minstack[-1]
31
32
33# Your MinStack object will be instantiated and called as such:
34# obj = MinStack()
35# obj.push(val)
36# obj.pop()
37# param_3 = obj.top()
38# param_4 = obj.getMin()