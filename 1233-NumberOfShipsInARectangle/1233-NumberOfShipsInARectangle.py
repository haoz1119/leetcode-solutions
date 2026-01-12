# Last updated: 1/12/2026, 12:23:12 AM
# """
# This is Sea's API interface.
# You should not implement it, or speculate about its implementation
# """
#class Sea:
#    def hasShips(self, topRight: 'Point', bottomLeft: 'Point') -> bool:
#
#class Point:
#	def __init__(self, x: int, y: int):
#		self.x = x
#		self.y = y

class Solution:
    def countShips(self, sea: 'Sea', topRight: 'Point', bottomLeft: 'Point') -> int:
        tx, ty = topRight.x, topRight.y
        bx, by = bottomLeft.x, bottomLeft.y
        if not sea.hasShips(topRight, bottomLeft):
            return 0
        if tx == bx and by == ty:
            return 1
        if ty-by > tx-bx:
            mid = (ty+by+1)//2
            return self.countShips(sea, Point(tx, ty), Point(bx, mid))+self.countShips(sea, Point(tx, mid-1), Point(bx, by))
        else:
            mid = (tx+bx+1)//2
            return self.countShips(sea, Point(tx, ty), Point(mid, by))+self.countShips(sea, Point(mid-1, ty), Point(bx, by))

        