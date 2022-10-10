class Solution {
    public String breakPalindrome(String pal) {
        if(pal.length() == 1)
            return "";
        char[] ch = pal.toCharArray();
        int i=0;
        int n = ch.length;
        for(i=0;i<ch.length/2;i++){
            if(ch[i] != 'a'){
                ch[i] = 'a';
                return String.valueOf(ch);
            }
        }
        ch[n-1] = 'b';
        return String.valueOf(ch);
    }
}