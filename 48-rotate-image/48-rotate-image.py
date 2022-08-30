class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        i = 0
        j = len(matrix)-1
        while(i < j):
            for k in range(len(matrix[0])):
                matrix[i][k], matrix[j][k] = matrix[j][k], matrix[i][k]
            i += 1
            j -= 1
        i = 0
        while i < len(matrix):
            for k in range(i+1, len(matrix[0])):
                matrix[i][k], matrix[k][i] = matrix[k][i], matrix[i][k]
            i += 1
        
        
        