class Solution {
    public int distributeCookies(int[] cookies, int k) {
        return util(cookies, 0, new int[k]);
    }
    
    public int util(int[] cookies,int start, int[] child){
        if(start >= cookies.length){
            int max = 0;
            for(int i=0;i<child.length;i++)
                max = Math.max(max, child[i]);
            return max;
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<child.length;i++){
            child[i] += cookies[start];
            res = Math.min(res, util(cookies, start+1, child));
            child[i] -= cookies[start];
        }
        return res;
    }
}