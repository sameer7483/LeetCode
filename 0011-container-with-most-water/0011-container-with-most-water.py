class Solution:
    def maxArea(self, height: List[int]) -> int:
        res = 0
        n = len(height)
        lt = 0
        rt = n-1
        while lt < rt:
            res = max(res, min(height[lt], height[rt])*(rt-lt))
            if height[lt] < height[rt]:
                lt += 1
            else:
                rt -= 1
        return res
            
        
        