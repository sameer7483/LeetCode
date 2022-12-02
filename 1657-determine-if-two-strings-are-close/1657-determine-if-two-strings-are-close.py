class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        if len(word1) != len(word2):
            return False
        c1 = Counter(word1)
        c2 = Counter(word2)
        s1 = Counter(list(c1.values()))
        s2 = Counter(list(c2.values()))
        for k, v in c1.items():
            if k not in c2:
                return False
        for k, v in s1.items():
            if k not in s2 or s2[k] != v:
                return False
        return True
        