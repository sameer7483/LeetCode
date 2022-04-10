class Solution:
    def calPoints(self, ops: List[str]) -> int:
        stack = []
        for x in ops:
            if x == "+":
                stack.append(stack[-1]+stack[-2])
            elif x == "C":
                stack.pop()
            elif x == "D":
                stack.append(2*stack[-1])
            else:
                stack.append(int(x))
        return sum(stack)
            
        