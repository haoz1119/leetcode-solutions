# Last updated: 1/13/2026, 6:22:29 PM
1from collections import Counter
2class Solution:
3    def equalFrequency(self, word: str) -> bool:
4        count = Counter(word)
5        
6        for char in count:
7            # Simulate removing one instance of this character
8            count[char] -= 1
9            
10            # Get non-zero frequencies
11            freqs = [f for f in count.values() if f > 0]
12            
13            # Check if all remaining frequencies are equal
14            if len(set(freqs)) <= 1:
15                return True
16            
17            # Restore the count
18            count[char] += 1
19        
20        return False