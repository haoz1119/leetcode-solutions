# Last updated: 1/7/2026, 4:47:44 PM
1class Solution:
2    def invalidTransactions(self, transactions: List[str]) -> List[str]:
3        invalid = []
4        
5        for i, t1 in enumerate(transactions):
6            name1, time1, amount1, city1 = t1.split(',')
7            if int(amount1) > 1000:
8                invalid.append(t1)
9                continue
10            for j, t2 in enumerate(transactions):
11                if i != j: 
12                    name2, time2, amount2, city2 = t2.split(',')
13                    if name1 == name2 and city1 != city2 and abs(int(time1) - int(time2)) <= 60:
14                        invalid.append(t1)
15                        break
16        
17        return invalid