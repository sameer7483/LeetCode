class Solution:
    def spiralOrder(self, mat: List[List[int]]) -> List[int]:
        res = []
        l, r, u, d = 0, len(mat[0])-1, 0, len(mat)-1
        while l <= r and u <= d:
            for i in range(l, r+1):
                res.append(mat[u][i])
            u += 1
            for i in range(u, d+1):
                res.append(mat[i][r])
            r -= 1
            if l <= r and u <= d:
                for i in range(r, l-1, -1):
                    res.append(mat[d][i])
                d -= 1
                
                for i in range(d, u-1, -1):
                    res.append(mat[i][l])
                l += 1
        return res
                
        