class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b-a);
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            if(num % 2 != 0) num = num*2;
            min = Math.min(min, num);
            pq.add(num);
        }
        int res = Integer.MAX_VALUE;
        while(pq.peek()%2 ==0){
            res = Math.min(res, pq.peek()-min);
            min = Math.min(min, pq.peek()/2);
            pq.add(pq.peek()/2);
            pq.poll();
        }
        return Math.min(res, pq.peek()-min);
    }
}