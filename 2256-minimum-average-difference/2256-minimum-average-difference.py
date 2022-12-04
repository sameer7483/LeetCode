class Solution:
    def minimumAverageDifference(self, nums: List[int]) -> int:
        n = len(nums)
        total = sum(nums)
        curr_sum = 0
        res = -1
        min_avg_diff = 100005 
        for i in range(n):
            curr_sum += nums[i]
            avg_diff= 100006
            if n-i-1 != 0:
                avg_diff = abs((curr_sum //(i+1)) - ((total-curr_sum)//(n-i-1)))
            else:
                avg_diff = total/n
            if avg_diff < min_avg_diff:
                min_avg_diff = avg_diff
                res = i
        return res
        