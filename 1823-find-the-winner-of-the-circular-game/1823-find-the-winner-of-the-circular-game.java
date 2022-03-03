class Solution {
    public int findTheWinner(int n, int k) {
        if(n==1) return 1;
        List<Integer> arr = new ArrayList<>();
        for(int i=1;i<=n;i++) 
            arr.add(i);
        return util(arr, 0, k);
    }
    public int util(List<Integer> arr,int curr, int k){
        int n = arr.size();
        arr.remove((curr+k-1)%n);
        if(arr.size()==1) return arr.get(0);
        return util(arr, (curr+k-1)%n, k);
    }
}