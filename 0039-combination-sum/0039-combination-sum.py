

class Solution:
    def combinationSum(self, can: List[int], t: int) -> List[List[int]]:
        res = []
        self.backtrack(0, [], t, res, can)
        return res
    
    def backtrack(self, curr, path, target, res, can):
        if curr == len(can) and target < 0:
            return
        if target == 0:
            res.append(path)
        for i in range(curr, len(can)):
            if can[i] <= target:
                self.backtrack(i, path + [can[i]], target - can[i], res, can)
            
        
        