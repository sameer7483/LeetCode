class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> seq = new ArrayList<>();
        for(int num : nums){
            if(seq.size() == 0 || num > seq.get(seq.size()-1)){
                seq.add(num);
                continue;
            }
            int idx = binarySearch(num, seq);
            if(idx > seq.size()){
                seq.add(num);
            }
            else{
                seq.set(idx, num);
            }
        }
        return seq.size();
    }
    
    public int binarySearch(int key, List<Integer> seq){
        int lo = 0;
        int hi = seq.size()-1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(seq.get(mid) < key)
                lo = mid+1;
            else
                hi = mid-1;
        }
        return lo;
    }
}