class Pair{
    double val;
    int idx;
    public Pair(double val,int idx){
        this.val = val;
        this.idx = idx;
    }
}
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        double prod = 1.0;
        PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparingDouble(o -> -o.val));
        for(int i=0;i<n;i++){
            q.add(new Pair(profit(classes[i][0], classes[i][1]), i));
        }
        while(!q.isEmpty() && extraStudents > 0){
            Pair p = q.poll();
            classes[p.idx][0] +=1;
            classes[p.idx][1] +=1;
            extraStudents--;
            q.add(new Pair(profit(classes[p.idx][0],classes[p.idx][1]), p.idx));
        }
        double sum =0;
        for(int i=0;i<classes.length;i++){
            sum += classes[i][0]/(double)classes[i][1];
        }
        return sum/n;
        
    }
    
    public double profit(int a, int b){
        return (a+1)/(double)(b+1) - a/(double)b;
    }
}