class Solution {
    public int[] sumZero(int n) {
        int res[] = new int[n];
        if(n%2==0){
            int x = n/2;
            for(int i=-x, j=0;i<=x;i++){
                if(i!=0){
                   res[j]= i; 
                 j++;
                }
                    
            }
        }
        else{
            int x = n/2;
            for(int i=-x, j=0;i<=x;i++, j++){
                    res[j]= i;
            }            
        }
        return res;
    }
}