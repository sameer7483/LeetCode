class Solution:
    def maximum69Number (self, num: int) -> int:
        t = list(str(num))
        for i in range(len(t)):
            if t[i]== '6':
                t[i] = '9'
                break
        return int(''.join(t))
        