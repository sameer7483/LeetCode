class Solution:
    def diagonalSum(self, mat: List[List[int]]) -> int:
        r = len(mat)
        res = 0
        for i in range(r):
            res += mat[i][i]
            if r-i-1 != i:
                res += mat[i][r-i-1]
        return res
            