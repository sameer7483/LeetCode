class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for(int i=0;i<l.length;i++){
            int lo = l[i];
            int hi = r[i];
            if(hi-lo+1 < 3)
                res.add(true);
            else{
                int[] arr = Arrays.copyOfRange(nums, lo, hi+1);
                Arrays.sort(arr);
                int j=1;
                boolean flag = false;
                while(j < arr.length-1){
                    if(arr[j]-arr[j-1] != arr[j+1]-arr[j]){
                        res.add(false);
                        flag = true;
                        break;
                    }
                    j++;
                } 
                if(!flag)
                    res.add(true);
            }

        }
        return res;
        
    }
}