class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        m = Counter(nums)
        minHeap = []
        for num, v in m.items():
            if len(minHeap) < k:
                heapq.heappush(minHeap, (v,num))
            elif v > minHeap[0][0]:
                heapq.heappop(minHeap)
                heapq.heappush(minHeap, (v,  num))
        res = []
        while(minHeap):
            res.append(minHeap[0][1])
            heapq.heappop(minHeap)
        return res
        