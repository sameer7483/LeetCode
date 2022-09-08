class Solution {
public:
    int climbStairs(int n) {
        int first = 1;
        if(n==1)
            return first;
        int second = 2;
        if(n==2)
            return second;
        for(int i=3;i<=n;i++){
            int curr = first+second;
            first = second;
            second = curr;
            
        }
        return second;
    }
};