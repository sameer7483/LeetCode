class Solution:
    def flipAndInvertImage(self, image: List[List[int]]) -> List[List[int]]:
        res = [[]]
        k=0
        while(k < len(image)):
            i=0
            j=len(image[k])-1
            while(i < j):
                image[k][i], image[k][j] = image[k][j], image[k][i]
                i +=1
                j -=1
            k +=1  
        k=0    
        while(k < len(image)):
            for idx, val in enumerate(image[k]):
                if(val == 0):
                    image[k][idx] = 1
                else:
                    image[k][idx] = 0
            k +=1        
        return image
            
            
        