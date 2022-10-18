class Solution {
    public String countAndSay(int n) {
        if(n==1)
            return "1";
        StringBuilder sb = new StringBuilder();
        String last = countAndSay(n-1);
        int count = 1;
        int i = 1;
        for(i=1;i<last.length();i++){
            if(last.charAt(i) != last.charAt(i-1)){
                sb.append(count);
                sb.append(last.charAt(i-1));
                count = 0;
            }
            count++;
        }
        sb.append(count);
        sb.append(last.charAt(i-1));
        return sb.toString();
    }
}