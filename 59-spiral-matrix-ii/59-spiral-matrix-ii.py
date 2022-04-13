class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        res = [[0]*n for i in range(n)]
        l = 0
        r = n-1
        u = 0
        d = n-1
        curr = 1
        while(l <= r ):
            for i in range(l, r+1):
                res[u][i] = curr
                curr+=1
            u +=1
            for i in range(u, d+1):
                res[i][r] = curr
                curr+=1
            r -=1
            for i in range(r, l-1, -1):
                res[d][i] = curr
                curr +=1
            d -=1
            for i in range(d, u-1, -1):
                res[i][l] = curr
                curr+=1
            l +=1
        return res
            
            

        