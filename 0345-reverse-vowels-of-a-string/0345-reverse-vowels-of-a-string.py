class Solution:
    def reverseVowels(self, s: str) -> str:
        s_list = list(s)
        i, j = 0, len(s_list)-1
        vowel_set = set(['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'])
        while i < j:
            if s_list[i] not in vowel_set and s_list[j] not in vowel_set:
                i += 1
                j -= 1
            elif s_list[i] in vowel_set and s_list[j] not in vowel_set:
                j -= 1
            elif s_list[i] not in vowel_set and s_list[j] in vowel_set:
                i += 1
            else:
                s_list[i], s_list[j] = s_list[j], s_list[i]
                i +=1
                j -=1
        return ''.join(s_list)
            
        
        