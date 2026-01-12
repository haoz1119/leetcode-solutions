# Last updated: 1/12/2026, 12:23:11 AM
from collections import defaultdict
class Solution:
    def invalidTransactions(self, transactions: List[str]) -> List[str]:
        trnx = []
        result = []
        for x in transactions:
            tx = x.split(",")
            trnx.append((tx[0], int(tx[1]), int(tx[2]), tx[3]))
        trnx_dict = defaultdict(list)
        for name, t, amount, city in trnx:
            trnx_dict[name].append([t, amount, city])
        
        for name, value in trnx_dict.items():
            l = len(value)
            for i in range(l):
                if value[i][1] > 1000 and len(value[i]) <= 3:
                    value[i].append(0)
                for j in range(i+1, l):
                    if (abs(value[i][0] - value[j][0]) <= 60 and value[i][2] != value[j][2]):
                        if len(value[i]) <= 3: value[i].append(0)
                        if len(value[j]) <= 3: value[j].append(0)
        for name, value in trnx_dict.items():
            for x in value:
                if len(x) == 4:
                    result.append(f"{name},{x[0]},{x[1]},{x[2]}")
        return result
