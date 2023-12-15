class Solution:
    def movesToMakeZigzag(self, nums: List[int]) -> int:
        #[2, 3, 1, 4, 2, 5]
        if(len(nums) == 1):
            return 0
        moveEven = 0
        for i in range(0, len(nums), 2):
            if i==0:
                moveEven += max(nums[i]-nums[i+1]+1, 0)
            elif i==len(nums)-1:
                moveEven += max(nums[i]-nums[i-1]+1, 0)                
            else:
                moveEven += max(nums[i] - min(nums[i-1], nums[i+1])+1, 0)
        moveOdd = 0
        for i in range(1, len(nums), 2):
            if i==len(nums)-1:
                moveOdd += max(nums[i]-nums[i-1]+1, 0)
            else:
                moveOdd += max(nums[i] - min(nums[i-1], nums[i+1])+1, 0)
        return min(moveEven, moveOdd)
            
            