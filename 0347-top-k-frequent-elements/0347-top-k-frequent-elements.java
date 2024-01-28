class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> m = new HashMap<>();
        for(int i=0;i<n;i++){
            m.put(nums[i], m.getOrDefault(nums[i], 0) +1);
        }
        List<List<Integer>> count = new ArrayList<>();
        for(int i=0;i<=n;i++){
            count.add(new ArrayList<>());
        }
        for(Map.Entry<Integer, Integer> ent : m.entrySet()){
            count.get(ent.getValue()).add(ent.getKey());
        }
        int[] res = new int[k];
        int idx = 0;
        for(int i=count.size()-1;i>=0;i--){
            for(int j=0;j<count.get(i).size();j++){
                res[idx++] = count.get(i).get(j);
                if(idx == k)
                    return res;
            }
        }
        return res;
        
    }
}