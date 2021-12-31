class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> q = new PriorityQueue<>((x, y) -> y-x);
        int score = 0;
        q.add(a);
        q.add(b);
        q.add(c);
        while(q.size()>1){
            int max1 = q.poll();
            int max2 = q.poll();
            max1--;
            max2--;
            score++;
            if(max1 > 0)
                q.add(max1);
            if(max2 > 0)
                q.add(max2);
        }
        return score;
    }
}