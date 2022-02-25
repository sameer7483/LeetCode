class Solution {
    public int compareVersion(String v1, String v2) {
        String[] str1 = v1.split("\\.");
        String[] str2 = v2.split("\\.");
        int m = str1.length;
        int n = str2.length;
        int i=0, j=0;
        while(i<m && j < n){
            if(Integer.parseInt(str1[i]) > Integer.parseInt(str2[j]))
                return 1;
            if(Integer.parseInt(str1[i]) < Integer.parseInt(str2[j]))
                return -1;
            i++;
            j++;
        }
        if(i==m && j==n)
            return 0;
        if(i==m){
            while(j<n && Integer.parseInt(str2[j]) == 0)j++;
            if(j==n) return 0;
            else return -1;
        }
        if(j==n){
            while(i<m && Integer.parseInt(str1[i]) == 0)i++;
            if(i==m) return 0;
            else return 1;            
        }
        return 0;
    }
}