class Solution {
    public String pushDominoes(String dominoes) {
        char[] ch = dominoes.toCharArray();
        int R = -1, L=-1;
        for(int i=0;i<=ch.length;i++){
            if(i==ch.length || ch[i] == 'R'){
                if(R > L){ // R....R
                    while(R < i)
                        ch[R++] = 'R';
                }
                R = i;
            }
            else if(ch[i] == 'L'){
                if(L > R || R == -1){ // L...L
                    while(++L < i)
                        ch[L] = 'L';
                }
                else{
                    L = i;
                    int lo = R+1;
                    int hi = L-1;
                    while(lo < hi){
                        ch[lo++] = 'R';
                        ch[hi--] = 'L';
                    }
                }
                
            }
        }
        return String.valueOf(ch);
    }
}