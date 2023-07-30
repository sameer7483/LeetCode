class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        for(int i=0;i<=k;i++){
            int[] temp = Arrays.copyOf(cost, n);
            for(int j=0;j<flights.length;j++){
                if(cost[flights[j][0]] == Integer.MAX_VALUE)
                    continue;
                temp[flights[j][1]] = Math.min(temp[flights[j][1]],cost[flights[j][0]] +flights[j][2]);
            }
            cost = temp;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}