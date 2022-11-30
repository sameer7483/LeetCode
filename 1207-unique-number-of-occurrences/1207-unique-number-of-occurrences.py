class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        m = Counter(arr)
        return len(m) == len(set(m.values()))
        