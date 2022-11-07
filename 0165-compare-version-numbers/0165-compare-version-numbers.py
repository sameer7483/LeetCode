class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        l1 = version1.split('.')
        l2 = version2.split('.')
        for i in range(max(len(l1), len(l2))):
            x = int(l1[i] if i < len(l1) else '0')
            y = int(l2[i] if i < len(l2) else '0')
            if x > y:
                return 1
            elif y > x:
                return -1;
        return 0
        