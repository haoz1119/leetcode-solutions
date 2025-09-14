# Last updated: 9/14/2025, 12:53:41 PM
from collections import Counter

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = Counter(nums)
        key = list(count.keys())
        n = len(key)     

        def partition(key:List[int], low: int, high: int)->int:
            frequency = count[key[high]]
            index = low
            for i in range(low, high):
                if count[key[i]] <= frequency:
                    key[i], key[index] = key[index], key[i]
                    index += 1
            key[index], key[high] = key[high], key[index]
            return index

        def quickselect(key: List[int], low: int, high: int) -> None:
            if low >= high: return
            pivot = partition(key, low, high)
            if pivot == n-k: return
            elif pivot < n-k: quickselect(key, pivot+1, high)
            else: quickselect(key, low, pivot-1)

        quickselect(key, 0, n - 1)
        return key[n-k:]