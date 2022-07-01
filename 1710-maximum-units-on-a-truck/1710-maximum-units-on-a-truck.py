class Solution:
    def maximumUnits(self, boxTypes: List[List[int]], truckSize: int) -> int:
        boxTypes = sorted(boxTypes, key = lambda x : (-x[1], x[0]))
        units = 0
        i = 0
        while truckSize > 0 and i < len(boxTypes):
            if truckSize - boxTypes[i][0] < 0:
                units += truckSize*boxTypes[i][1]
                truckSize = 0
            else:
                units += boxTypes[i][0]*boxTypes[i][1]
                truckSize -= boxTypes[i][0]
            i += 1
        return units
        