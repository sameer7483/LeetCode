class Solution:
    def diagonalSort(self, mat: List[List[int]]) -> List[List[int]]:
        my_dict = {}
        m = len(mat)
        n = len(mat[0])
        for i in range(m):
            for j in range(n):
                if i-j in my_dict:
                    q = my_dict[i-j]
                    heapq.heappush(q, mat[i][j])
                    my_dict[i-j] = q;
                
                else:
                    q = []
                    q.append(mat[i][j])
                    my_dict[i-j] = q
        for i in range(m):
            for j in range(n):
                mat[i][j] = heappop(my_dict[i-j])
        return mat
                    
        