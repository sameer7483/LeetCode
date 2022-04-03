class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        res= []
        for x in nums:
            res.append(x)
        for x in nums:
            res.append(x)
        return res
        