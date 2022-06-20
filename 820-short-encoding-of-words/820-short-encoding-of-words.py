class Solution:
    def minimumLengthEncoding(self, words: List[str]) -> int:
        wordset = set(words)
        for word in words:
            for i in range(1,len(word)):
                if word[i:] in wordset:
                    wordset.remove(word[i:])
        res = 0
        for x in wordset:
            res += len(x)+1
        return res
            
                
                    
                
            
        