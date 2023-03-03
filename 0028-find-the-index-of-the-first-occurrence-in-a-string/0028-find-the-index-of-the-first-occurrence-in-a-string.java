class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length())
            return -1;
        int j=0, i=0;
        while(j<haystack.length()){
            if(j-i+1 < needle.length()){
                j++;
                continue;
            }
            else if(j-i+1 == needle.length()){
                if(haystack.substring(i, j+1).equals(needle))
                    return i;
                i++;
                j++;
            }
        }
        return -1;
    }
}