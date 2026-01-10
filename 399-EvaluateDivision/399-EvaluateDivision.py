# Last updated: 1/9/2026, 4:34:42 PM
1from collections import defaultdict, deque
2class Solution:
3    def calcEquation(
4        self, equations: List[List[str]], values: List[float], queries: List[List[str]]
5    ) -> List[float]:
6        # parent[x] = (root, weight) where x / root = weight
7        parent = {}
8
9        def find(x: str) -> tuple:
10            """Returns (root, weight) where x / root = weight"""
11            if x not in parent:
12                parent[x] = (x, 1.0)
13
14            if parent[x][0] == x:
15                return parent[x]
16
17            # Path compression with weight multiplication
18            root, weight = find(parent[x][0])
19            parent[x] = (root, parent[x][1] * weight)
20            return parent[x]
21
22        def union(a: str, b: str, value: float) -> None:
23            """Union a and b given a / b = value"""
24            root_a, weight_a = find(a)  # a / root_a = weight_a
25            root_b, weight_b = find(b)  # b / root_b = weight_b
26
27            if root_a != root_b:
28                # Connect root_a to root_b
29                # We know: a / b = value
30                # a = weight_a * root_a
31                # b = weight_b * root_b
32                # So: weight_a * root_a / (weight_b * root_b) = value
33                # root_a / root_b = value * weight_b / weight_a
34                parent[root_a] = (root_b, value * weight_b / weight_a)
35
36        # Build union-find structure
37        for i, (a, b) in enumerate(equations):
38            union(a, b, values[i])
39
40        # Answer queries
41        results = []
42        for a, c in queries:
43            if a not in parent or c not in parent:
44                results.append(-1.0)
45            else:
46                root_a, weight_a = find(a)
47                root_c, weight_c = find(c)
48                if root_a != root_c:
49                    results.append(-1.0)
50                else:
51                    # a / c = (a / root) / (c / root) = weight_a / weight_c
52                    results.append(weight_a / weight_c)
53        return results
54