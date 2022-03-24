class Solution {
    int[] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        int res = 1;
        for(int i=0;i<n;i++){
            lis[i] = 1;
            for(int j=i-1;j>=0;j--){
                if(nums[i] > nums[j]){
                    lis[i] = Math.max(lis[i], 1+lis[j]);
                }
            }
            res = Math.max(res, lis[i]);
        }
        return res;
    }
    public int optimal(int nums[]){
        int n= nums.length;
        List<Integer> seq = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(seq.isEmpty() || nums[i] > seq.get(seq.size()-1)){
                seq.add(nums[i]);
            }
            else{
                int idx = binarySearch(seq, nums[i]);
                seq.set(idx, nums[i]);
            }
        }
        return seq.size();
    }
    
    public int binarySearch(List<Integer> seq, int key){
        int lo= 0, hi = seq.size()-1;
        while(lo < hi){
            int mid = lo+(hi-lo)/2;
            if(seq.get(mid) < key){
                lo = mid+1;
            }
            else if(seq.get(mid) > key)
                hi = mid;
            else
                return mid;
            
        }
        return lo;
    }
    
}