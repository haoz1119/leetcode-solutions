# Last updated: 1/9/2026, 9:24:08 PM
1class Node:
2        def __init__(self, key: int = -1, val: int = -1, prev: 'Node | None' = None, nxt: 'Node | None' = None):
3            self.key= key
4            self.val = val
5            self.prev = prev
6            self.nxt = nxt
7class LRUCache:
8    
9    def __init__(self, capacity: int):
10        self.head = Node() # easier and more uniform instructions across the list
11        self.tail = Node()
12        self.tail.prev = self.head
13        self.head.next = self.tail
14        self.index = {}
15        self.capacity = capacity
16        self.size = 0
17
18    def get(self, key: int) -> int:
19        if key not in self.index:
20            return -1
21        node = self.index[key]
22        prev = node.prev
23        nxt = node.nxt
24        prev.nxt, nxt.prev = nxt, prev
25        node.prev, node.nxt = self.tail.prev, self.tail
26        self.tail.prev.nxt = node
27        self.tail.prev = node
28        
29        return node.val
30
31    def put(self, key: int, value: int) -> None:
32        if key not in self.index:
33            if self.size == self.capacity:
34                # evict
35                self.index.pop(self.head.nxt.key)
36                self.head.nxt = self.head.nxt.nxt
37                self.head.nxt.prev = self.head
38                self.size -= 1
39            self.tail.prev.nxt = Node(key, value, self.tail.prev, self.tail)
40            self.tail.prev = self.tail.prev.nxt
41            self.index[key] = self.tail.prev
42            self.size += 1 
43        else:
44            self.get(key)
45            self.tail.prev.val = value
46
47
48# Your LRUCache object will be instantiated and called as such:
49# obj = LRUCache(capacity)
50# param_1 = obj.get(key)
51# obj.put(key,value)