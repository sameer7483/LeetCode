class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int i =0;
        int n = strs.length;
        String first = strs[0];
        String last = strs[n-1];
        while(i<first.length()){
            if(first.charAt(i) == last.charAt(i))
                i++;
            else
                break;
        }
        return i==0 ? "" : first.substring(0,i);
    }
}