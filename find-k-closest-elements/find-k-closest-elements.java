class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int idx = Arrays.binarySearch(arr, x);
        int n = arr.length;
//        System.out.println(idx);
        if(idx < 0)
            idx = -idx -1;
        int i = idx-1, j=idx;
        if(i<0)
            j=0;
        if(j>=n)
            i=n-1;
        List<Integer> res = new ArrayList<>();
        while(i>=0 && j < n){
            if(Math.abs(arr[i]-x) <= Math.abs(arr[j] -x) && res.size()<k){
                res.add(arr[i]);
                i--;
            }
            else if(Math.abs(arr[i]-x) > Math.abs(arr[j] -x) && res.size()<k){
                res.add(arr[j]);
                j++;
            }
            else 
                break;
        }
        while(res.size() < k && i==-1 && j<n){
            res.add(arr[j]);j++;
        }
        while(res.size() < k && j==n && i>=0){
            res.add(arr[i]);i--;
        }  
        Collections.sort(res);
        return res;
        
    }
}