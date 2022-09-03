class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int res = 0;
        int n = s.length();
        unordered_map<char, int> m;
        int i=0;
        for(int j=0;j<n;j++){
            if(m.find(s[j]) == m.end()){
                m[s[j]] =1;
            }
            else{
                m[s[j]] += 1;
            }
            while(i < j && j-i+1 > m.size()){
                m[s[i]] -= 1;
                if(m[s[i]]==0)
                    m.erase(s[i]);
                i++;
            }
            res = max(res, j-i+1);
        }
        return res;
    }
};