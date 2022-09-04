class Solution {
public:
    int characterReplacement(string s, int k) {
        int count[26]={0};
        int n = s.length();
        int max_count = 0;
        int res = 0;
        int i = 0;
        for(int j=0;j<n;j++){
            max_count = max(max_count, ++count[s[j]-'A']);
            while(i < j && (max_count+k) < j-i+1){
                --count[s[i]-'A'];
                i++;
            }
            res = max(res, j-i+1);
        }
        return res;
    }
};