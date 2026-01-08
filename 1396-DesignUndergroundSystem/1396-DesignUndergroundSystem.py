# Last updated: 1/7/2026, 5:43:02 PM
1class UndergroundSystem:
2
3    def __init__(self):
4        self.in_travel = {}
5        self.stats = {}
6
7    def checkIn(self, id: int, stationName: str, t: int) -> None:
8        self.in_travel[id] = (stationName, t)
9
10    def checkOut(self, id: int, stationName: str, t: int) -> None:
11        startStation = self.in_travel[id][0]
12        startTime = self.in_travel[id][1]
13        if (startStation, stationName) not in self.stats:
14            self.stats[(startStation, stationName)] = [0, 0]
15        self.stats[(startStation, stationName)][0] += t-startTime
16        self.stats[(startStation, stationName)][1] += 1
17
18    def getAverageTime(self, startStation: str, endStation: str) -> float:
19        time, count = self.stats[(startStation, endStation)]
20        return time/count
21
22
23# Your UndergroundSystem object will be instantiated and called as such:
24# obj = UndergroundSystem()
25# obj.checkIn(id,stationName,t)
26# obj.checkOut(id,stationName,t)
27# param_3 = obj.getAverageTime(startStation,endStation)