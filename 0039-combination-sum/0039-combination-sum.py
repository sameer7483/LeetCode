class Solution:
    def combinationSum(self, can: List[int], t: int) -> List[List[int]]:
        res = []
        
        def backtrack(curr, path, target):
            if curr == len(can):
                return
            if target == 0:
                res.append(path.copy())
            for i in range(curr, len(can)):
                if can[i] <= target:
                    path.append(can[i])
                    backtrack(i, path, target - can[i])
                    path.pop()
        backtrack(0, [], t)
        return res
                    
            
            
        
        