# Last updated: 1/7/2026, 4:57:10 PM
1from collections import defaultdict
2class Solution:
3    def invalidTransactions(self, transactions: List[str]) -> List[str]:
4        trnx = []
5        result = []
6        for x in transactions:
7            tx = x.split(",")
8            trnx.append((tx[0], int(tx[1]), int(tx[2]), tx[3]))
9        trnx_dict = defaultdict(list)
10        for name, t, amount, city in trnx:
11            trnx_dict[name].append([t, amount, city])
12        
13        for name, value in trnx_dict.items():
14            l = len(value)
15            for i in range(l):
16                if value[i][1] > 1000 and len(value[i]) <= 3:
17                    value[i].append(0)
18                for j in range(i+1, l):
19                    if (abs(value[i][0] - value[j][0]) <= 60 and value[i][2] != value[j][2]):
20                        if len(value[i]) <= 3: value[i].append(0)
21                        if len(value[j]) <= 3: value[j].append(0)
22        for name, value in trnx_dict.items():
23            for x in value:
24                if len(x) == 4:
25                    result.append(f"{name},{x[0]},{x[1]},{x[2]}")
26        return result
27