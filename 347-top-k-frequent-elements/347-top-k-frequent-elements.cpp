class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        vector<int> res;
        unordered_map<int, int> m;
        for(int i : nums){
            if(m.find(i) != m.end()){
                m[i] += 1;
            }
            else{
                m[i] = 1;
            }
        }
        priority_queue<pair<int,int>, vector<pair<int, int>>, greater<pair<int, int>>> q;
        for(auto i : m){
            if(q.size() < k){
                q.push(make_pair(i.second, i.first));
            }
            else{
                if(i.second > q.top().first){
                    q.pop();
                    q.push(make_pair(i.second, i.first));
                }
            }
        }
        while(!q.empty()){
            res.push_back(q.top().second);
            q.pop();
        }
        return res;
    }
};