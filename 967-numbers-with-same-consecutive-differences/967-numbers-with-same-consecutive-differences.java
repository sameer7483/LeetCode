class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<=9;i++){
            dfs(i, n-1, k, res);
        }
        int[] ans = new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
    public void dfs(int num ,int n, int k, List<Integer> res){
        if(n == 0){
            res.add(num);
            return;
        }
        int unit = num %10;
        if(unit + k <= 9){
            dfs(num*10 + unit+k, n-1, k, res);
        }
        if(k != 0 && unit >= k){
            dfs(num*10 + unit-k, n-1, k, res);
        }
    }
}