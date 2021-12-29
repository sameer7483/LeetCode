class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        int[] temp;
        cost[src] = 0;
        int m = flights.length;
        for(int i=0;i<=k;i++){
            temp = Arrays.copyOf(cost, n);
            for(int j=0;j<m;j++){
                if(cost[flights[j][0]] == Integer.MAX_VALUE)
                    continue;
                if(cost[flights[j][0]] + flights[j][2] < temp[flights[j][1]]){
                    temp[flights[j][1]] = cost[flights[j][0]] + flights[j][2];
                }
            }
            cost = temp;
        }
        return cost[dst]== Integer.MAX_VALUE ? -1 : cost[dst];
    }
}