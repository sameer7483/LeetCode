class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        if(n==1)
            return 1;
        int i=0, j=1;
        int res = 0;
        int count = 1;
        while(j<n){
            if(chars[j]==chars[j-1]){
                j++;
                count++;
            } 
            else{
                if(count ==1){
                    chars[i] = chars[j-1];
                    i++;
                }
                else{
                    chars[i] = chars[j-1];
                    i++;
                    String s= "";
                    while(count > 0){
                        s += String.valueOf(count%10);
                        count = count/10;
                    }
                    for(int k= s.length()-1;k>=0;k--){
                        chars[i] = s.charAt(k);
                        i++;
                    }  
                }
                count = 1;
                j++;
            }
        }
                if(count ==1){
                    chars[i] = chars[j-1];
                    i++;
                    j++;
                }
                else{
                    chars[i] = chars[j-1];
                    i++;
                    String s= "";
                    while(count > 0){
                        s += String.valueOf(count%10);
                        count = count/10;
                    }
                    for(int k= s.length()-1;k>=0;k--){
                        chars[i] = s.charAt(k);
                        i++;
                    }  
                }        
        return i;
    }
}