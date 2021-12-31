class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int j=0;
        int n = nums.length;
        int[] sum = new int[n];
        int res = nums[0];
        while(j<n){
            sum[j] = nums[j];
            while(!dq.isEmpty() && j-dq.peekFirst() >k)
                dq.pollFirst();
            if(!dq.isEmpty())
                sum[j] += sum[dq.peekFirst()];
            while(!dq.isEmpty() && sum[dq.peekLast()] <= sum[j])
                dq.pollLast();
            if(sum[j] >0)
                dq.addLast(j);
            res = Math.max(res, sum[j]);
            j++;
        }
        return res;
    }
}