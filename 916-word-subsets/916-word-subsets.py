class Solution:
    def wordSubsets(self, words1: List[str], words2: List[str]) -> List[str]:
        global_counter = {}
        res = []
        for word in words2:
            count = collections.Counter(word)
            for key in count.elements():
                if key not in global_counter:
                    global_counter[key] = 0
                global_counter[key]=max(global_counter[key], count[key])
        for word in words1:
            count = collections.Counter(word)
            flag = True
            for key, val in global_counter.items():
                if key not in count.elements() or count[key] < val:
                    flag = False
                    break
            if flag:
                res.append(word)
        return res
                
                
            
        