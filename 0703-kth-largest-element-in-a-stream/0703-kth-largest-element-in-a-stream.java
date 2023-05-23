class KthLargest {
    PriorityQueue<Integer> q;
    int size;
    public KthLargest(int k, int[] nums) {
        q = new PriorityQueue<>();
        size = k;
        for(int i= 0;i<nums.length;i++){
            q.add(nums[i]);
            if(q.size() > k){
                q.poll();
            }
        }
    }
    
    public int add(int val) {
        q.add(val);
        if(q.size() > size){
                q.poll();
        }   
        return q.peek();
    }
}