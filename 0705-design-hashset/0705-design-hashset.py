class MyHashSet:

    def __init__(self):
        self.myset = [-1]*1000002
    def add(self, key: int) -> None:
        self.myset[key] = 1
    def remove(self, key: int) -> None:
        self.myset[key] = -1
    def contains(self, key: int) -> bool:
        return self.myset[key] == 1