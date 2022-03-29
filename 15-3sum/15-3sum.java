class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0)
                break;
            if(i != 0 && nums[i]==nums[i-1]) continue;
            util(nums, i, res);
        }
        return res;    
    }
        public void util(int[] nums, int i, List<List<Integer>> res){
        int lo = i+1;
        int hi = nums.length-1;
        while(lo < hi){
            if(nums[i]+nums[lo] + nums[hi] < 0)
                lo++;
            else if(nums[i]+nums[lo] + nums[hi] > 0)
                hi--;
            else{
                res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                lo++;
                hi--;
                while(lo < hi && nums[lo] == nums[lo-1])
                    lo++;
            }
                
        }
    }
    //Map soln
    public List<List<Integer>> mapSoln(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            res.addAll(twoSum(nums, i));
        }
        return res.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList());
                
    }
    
    public List<List<Integer>> twoSum(int[] nums, int idx){
        int target = 0-nums[idx];
        Set<Integer> s = new HashSet<>();
        List<List<Integer>> l = new ArrayList<>();
        for(int i=idx+1;i<nums.length;i++){
            if(s.contains(target-nums[i])){
                List<Integer> ll = new ArrayList<>();
                ll.add(nums[i]);
                ll.add(target-nums[i]);
                ll.add(nums[idx]);
                l.add(ll);
            }
            s.add(nums[i]);
        }
        return l;
    }
}