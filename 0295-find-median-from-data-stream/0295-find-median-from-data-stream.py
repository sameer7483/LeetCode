class MedianFinder:

    def __init__(self):
        self.minHeap = []
        self.maxHeap = []
        self.even = True
        

    def addNum(self, num: int) -> None:
        if(self.even):
            p = -heapq.heappushpop(self.minHeap, num)
            heapq.heappush(self.maxHeap, p)
        else:
            p = -heapq.heappushpop(self.maxHeap, -num)
            heapq.heappush(self.minHeap, p)   
        self.even = not self.even
    def findMedian(self) -> float:
        if not self.even:
            return -self.maxHeap[0]
        else:
            return (-self.maxHeap[0]+self.minHeap[0])/2
        


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()