class Solution:
    def movesToMakeZigzag(self, nums: List[int]) -> int:
        #[2, 3, 1, 4, 2, 5]
        if(len(nums) == 1):
            return 0
        move = [0, 0]
        for i in range(len(nums)):
            if i==0:
                move[i%2] += max(nums[i]-nums[i+1]+1, 0)
            elif i==len(nums)-1:
                move[i%2] += max(nums[i]-nums[i-1]+1, 0)                
            else:
                move[i%2] += max(nums[i] - min(nums[i-1], nums[i+1])+1, 0)
        return min(move)
            
            