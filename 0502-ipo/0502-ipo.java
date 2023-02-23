class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> qCap = new PriorityQueue<>((a, b)->(a[0]-b[0]));
        PriorityQueue<int[]> qProf = new PriorityQueue<>((a, b)->(b[1]-a[1]));
        int n = profits.length;
        for(int i=0;i<n;i++){
            qCap.add(new int[]{capital[i], profits[i]});
        }
        
        for(int i=0;i<k;i++){
            while(!qCap.isEmpty() && qCap.peek()[0] <= w){
                qProf.add(qCap.poll());
            }
            if(qProf.isEmpty())
                break;
            w += qProf.poll()[1];
        }
        return w;
    }
   
}