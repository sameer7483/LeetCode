class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int min = Integer.MAX_VALUE;
        Set<Integer> s = new HashSet<>();
        for(int i=0;i<n;i++){
            int curr = 0;
            int j = 0;
            if(s.contains(tops[i])) continue;
            s.add(tops[i]);
            for(j=0;j<n;j++){
                if(tops[i]==tops[j]) continue;
                else if(tops[i] == bottoms[j])
                    curr++;
                else break;
            }
            if(j==n){
                min = Math.min(min, curr);
            }
        }
        s.clear();
        for(int i=0;i<n;i++){
            int curr = 0;
            int j = 0;
            if(s.contains(bottoms[i])) continue;
            s.add(bottoms[i]);
            for(j=0;j<n;j++){
                if(bottoms[i]==bottoms[j]) continue;
                else if(bottoms[i] == tops[j])
                    curr++;
                else break;
            }
            if(j==n){
                min = Math.min(min, curr);
            }
        }        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}