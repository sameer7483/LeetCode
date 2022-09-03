class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> res;
        unordered_map<string, vector<string>> m;
        for(int i=0;i<strs.size();i++){
            string sorted_s = strs[i];
            sort(sorted_s.begin(), sorted_s.end());
            if(m.find(sorted_s) != m.end()){
                (m.find(sorted_s)->second).push_back(strs[i]);
            }
            else{
                vector<string> v;
                v.push_back(strs[i]);
                m[sorted_s] = v;
            }
        }
        for(auto it : m){
            res.push_back(it.second);
        }
        return res;
        
    }
};