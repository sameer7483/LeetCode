class Solution:
    def calculate(self, s: str) -> int:
        st = []
        curr = 0
        res = 0
        sign = 1
        for c in s:
            if c.isdigit():
                curr =10*curr + ord(c)-ord('0')
            elif c == '+':
                res += sign*curr
                sign = 1
                curr = 0
            elif c == '-':
                res += sign*curr
                sign = -1
                curr = 0
            elif c == '(':
                st.append((sign, res))
                sign = 1
                res = 0
            elif c == ')':
                res += sign*curr
                res *= st[-1][0]
                res += st[-1][1]
                st.pop()
                curr = 0
        if curr != 0:
            res += sign*curr
        return res
            
                
        