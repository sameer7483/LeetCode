class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] a= new int[n];
        int count = 0;
        for(int i = n-1;i>=0;i--){
            a[i] = count;
            if(s.charAt(i) == 'a')
                count++;
        }
        int[] b= new int[n];
        count = 0;
        for(int i = 0;i<n;i++){
            b[i] = count;
            if(s.charAt(i) == 'b')
                count++;
        } 
        int min = n;
        for(int i=0;i<n;i++){
            min = Math.min(min, a[i]+b[i]);
        }
        return min;
    }
}