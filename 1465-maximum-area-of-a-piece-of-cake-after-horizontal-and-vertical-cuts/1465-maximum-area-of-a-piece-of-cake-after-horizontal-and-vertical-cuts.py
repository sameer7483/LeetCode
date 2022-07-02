class Solution:
    def maxArea(self, h: int, w: int, hC: List[int], vC: List[int]) -> int:
        hC.sort()
        vC.sort()
        hC.insert(0, 0)
        hC.append(h)
        maxV = 0
        for i in range(len(hC)-1):
            maxV = max(maxV, hC[i+1] -hC[i])
        vC.insert(0,0)
        vC.append(w)
        maxH = 0
        for i in range(len(vC)-1):
            maxH = max(maxH, vC[i+1] - vC[i])  
        return (maxH*maxV)%(10 ** 9 + 7)
        