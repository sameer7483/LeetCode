class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        m = {}
        for s in strs:
            sorted_s = ''.join(sorted(s))
            if sorted_s in m:
                m[sorted_s].append(s)
            else:
                m[sorted_s] = [s]
        res = []
        for key, val in m.items():
            res.append(val)
        return res
        