class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        List<String> l = new ArrayList<>();
        for(String str : strs){
            l.add(reverse(str));
        }
        return String.join(" ", l);
    }
    
    public String reverse(String s){
        char[] charArr = s.toCharArray();
        int i=0;
        int j = charArr.length-1;
        while(i < j){
            char temp = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(charArr); 
    }
}