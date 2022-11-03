class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        q = deque()
        word_set = set(wordList)
        alpha = string.ascii_lowercase
        q.append(beginWord)
        vis = set()
        res = 1
        while len(q) > 0:
            size = len(q)
            for i in range(size):
                curr_word = q.popleft()
                if curr_word == endWord:
                    return res
                if curr_word in vis:
                    continue
                vis.add(curr_word)
                for j in range(len(curr_word)):
                    for k in alpha:
                        change = curr_word[:j]+k+curr_word[j+1:]
                        if change not in vis and change in word_set:
                            q.append(change)
            res += 1
        return 0
        
        
        
        