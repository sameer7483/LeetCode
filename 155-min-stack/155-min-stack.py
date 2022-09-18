class MinStack:

    def __init__(self):
        self.st1 = []
        self.st2 = []
        

    def push(self, val: int) -> None:
        if len(self.st2) ==0 or val <= self.st2[-1]:
            self.st2.append(val)
        self.st1.append(val)
        
    def pop(self) -> None:
        if self.st1[-1] == self.st2[-1]:
            self.st2.pop()
        self.st1.pop()

    def top(self) -> int:
        return self.st1[-1]

    def getMin(self) -> int:
        return self.st2[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()