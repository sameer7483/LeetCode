class Solution:
    def computeArea(self, ax1: int, ay1: int, ax2: int, ay2: int, bx1: int, by1: int, bx2: int, by2: int) -> int:
        left = max(ax1, bx1)
        right = min(ax2, bx2)
        bottom = max(by1, ay1)
        top  = min(by2, ay2)
        area = 0 if right < left or bottom > top else (right-left)*(top-bottom)
        return (ax2-ax1)*(ay2-ay1) + (bx2-bx1)*(by2-by1) - area
        