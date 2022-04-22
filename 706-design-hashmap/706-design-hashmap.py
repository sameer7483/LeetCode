class MyHashMap:

    def __init__(self):
        self.myMap = [-1]*1000002
        
    def put(self, key: int, value: int) -> None:
        self.myMap[key] = value
        
    def get(self, key: int) -> int:
        return self.myMap[key]
        
    def remove(self, key: int) -> None:
        self.myMap[key] = -1
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)