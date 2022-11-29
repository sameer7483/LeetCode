class RandomizedSet:

    def __init__(self):
        self.m = dict()
        self.arr = []
        self.idx = 0

    def insert(self, val: int) -> bool:
        if val in self.m:
            return False
        else:
            self.arr.append(val)
            self.m[val] = self.idx
            self.idx += 1
            return True

    def remove(self, val: int) -> bool:
        if val not in self.m:
            return False
        else:
            idx = self.m[val]
            self.m[self.arr[len(self.arr)-1]] = idx
            if idx < len(self.arr)-1:
                self.arr[idx], self.arr[len(self.arr)-1] = self.arr[len(self.arr)-1], self.arr[idx]
            self.m.pop(val)
            self.arr.pop()
            return True
            
    def getRandom(self) -> int:
        return random.choice(self.arr)
        


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()