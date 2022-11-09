class StockSpanner:

    def __init__(self):
        self.st = []
        self.idx = -1
        

    def next(self, price: int) -> int:
        self.idx += 1
        while len(self.st) > 0 and self.st[-1][0] <= price:
            self.st.pop()
        res = 1
        if len(self.st) == 0:
            res = self.idx+1
        else:
            res = self.idx-self.st[-1][1]
        self.st.append((price, self.idx))
        return res
        
        


# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)