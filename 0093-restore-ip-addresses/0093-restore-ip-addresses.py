class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        res = []
        def backtrack(start, k, curr):
            if start >= len(s):
                return
            if k == 0 and int(s[start:]) < 256 and len(s)-start == len(str(int(s[start:]))):
                res.append(curr+s[start:])
                return
            if k == 0:
                return
            for i in range(start, start+3):
                num = int(s[start:i+1])
                if num < 256 and i+1-start == len(str(num)):
                    backtrack(i+1, k-1, curr+s[start:i+1]+'.')
        backtrack(0, 3, '')
        return res
        