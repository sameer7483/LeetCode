class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        int m = accounts.length;
        for(int i=0;i<m;i++){
            max = Math.max(max, Arrays.stream(accounts[i]).sum());
        }
        return max;
    }
}