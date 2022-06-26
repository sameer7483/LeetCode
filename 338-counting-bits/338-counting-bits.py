class Solution:
    def countBits(self, n: int) -> List[int]:
        res = []
        res.append(0)
        if n ==0:
            return res
        res.append(1)
        if n == 1:
            return res
        for i in range(2, n+1):
            if i%2 == 0:
                res.append(res[i//2])
            else:
                res.append(res[i-1]+1)
        return res
        
        
        