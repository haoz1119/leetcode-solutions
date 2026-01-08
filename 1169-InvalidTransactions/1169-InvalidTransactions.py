# Last updated: 1/7/2026, 4:54:11 PM
1class Solution:
2    def invalidTransactions(self, transactions: List[str]) -> List[str]:
3        d = defaultdict(list)  # Mapping of names to their transaction details.
4        idx = set()  # Set of indices of possibly invalid transactions.
5
6        for i, x in enumerate(transactions):
7            name, time, amount, city = x.split(",")
8            time, amount = int(time), int(amount)
9            d[name].append((time, city, i))
10          
11            # Check if the transaction amount exceeds $1000.
12            if amount > 1000:
13                idx.add(i)
14              
15            # Check for transactions with the same name in different cities within 60 minutes.
16            for t, c, j in d[name]:
17                if c != city and abs(time - t) <= 60:
18                    idx.add(i)
19                    idx.add(j)
20
21        # Generate a list of transactions that are possibly invalid.
22        return [transactions[i] for i in idx]