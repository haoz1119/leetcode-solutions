# Last updated: 1/12/2026, 12:23:09 AM
class UndergroundSystem:

    def __init__(self):
        self.in_travel = {}
        self.stats = {}

    def checkIn(self, id: int, stationName: str, t: int) -> None:
        self.in_travel[id] = (stationName, t)

    def checkOut(self, id: int, stationName: str, t: int) -> None:
        startStation = self.in_travel[id][0]
        startTime = self.in_travel[id][1]
        if (startStation, stationName) not in self.stats:
            self.stats[(startStation, stationName)] = [0, 0]
        self.stats[(startStation, stationName)][0] += t-startTime
        self.stats[(startStation, stationName)][1] += 1

    def getAverageTime(self, startStation: str, endStation: str) -> float:
        time, count = self.stats[(startStation, endStation)]
        return time/count


# Your UndergroundSystem object will be instantiated and called as such:
# obj = UndergroundSystem()
# obj.checkIn(id,stationName,t)
# obj.checkOut(id,stationName,t)
# param_3 = obj.getAverageTime(startStation,endStation)