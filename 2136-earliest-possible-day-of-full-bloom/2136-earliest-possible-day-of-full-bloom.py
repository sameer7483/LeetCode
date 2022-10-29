class Solution:
    def earliestFullBloom(self, pt: List[int], gt: List[int]) -> int:
        zipped = zip(gt, pt)
        res = 0
        curr = 0
        sorted_plant = sorted(zipped)
        for grow, plant in sorted_plant:
            res = max(res, grow)+plant
        return res
        
        