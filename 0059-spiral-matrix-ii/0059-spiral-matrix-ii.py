class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        res = [[0]*n for i in range(n)]
        l, r, u, d = 0, n-1, 0, n-1
        curr =1
        while l <= r and u <= d:
            for i in range(l, r+1):
                res[u][i] = curr
                curr += 1
            u += 1
            for i in range(u, d+1):
                res[i][r] = curr
                curr+=1
            r -= 1
            if l <= r and u <= d:
                for i in range(r, l-1, -1):
                    res[d][i] = curr
                    curr += 1
                d -= 1
                for i in range(d, u-1, -1):
                    res[i][l] = curr
                    curr += 1
                l += 1
        return res
        