class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        long sum = Arrays.stream(nums).filter(x -> x%2==0).reduce(0,(a, b)->a+b);
        int[] res = new int[queries.length];
        int idx = 0;
        for(int[] q : queries){
            if(nums[q[1]]%2 == 0){
                sum -= nums[q[1]];
                if(q[0]%2 == 0){
                    sum += q[0] + nums[q[1]]; 
                }
            }
            else{
                if(q[0] % 2 != 0){
                    sum += q[0]+nums[q[1]];
                }
            }
            nums[q[1]] = q[0]+nums[q[1]];
            res[idx++] = (int)sum;
        }
        return res;
    }
}