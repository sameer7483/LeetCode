class Solution {
    public List<Integer> partitionLabels(String s) {
        int last[] = new int[26];
        for(int i=0;i<s.length();i++)
            last[s.charAt(i)-'a'] =i;
        int start = 0;
        int max = 0;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            max = Math.max(max, last[s.charAt(i)-'a']);
            if(i==max){
                res.add(i-start+1);
                start = i+1;
            }
        }
        return res;
    }
}