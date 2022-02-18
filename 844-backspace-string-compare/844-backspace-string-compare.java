class Solution {
    public boolean backspaceCompare(String s, String t) {
        int n = s.length();
        int count =0;
        StringBuilder sb = new StringBuilder();
        for(int i=n-1;i>=0;i--){
            if(Character.isLetter(s.charAt(i))&& count ==0){
                sb.append(s.charAt(i));
                continue;
            } 
            if(s.charAt(i) == '#') count++;
            else if(Character.isLetter(s.charAt(i)) && count >0){
                count--;
            }
        }
        String newS = sb.toString();
        sb  = new StringBuilder();
        n = t.length();
        count=0;
        for(int i=n-1;i>=0;i--){
            if(Character.isLetter(t.charAt(i))&& count ==0){
                sb.append(t.charAt(i));
                continue;
            } 
            if(t.charAt(i) == '#') count++;
            else if(Character.isLetter(t.charAt(i)) && count >0){
                count--;
            }
        } 
        if(newS.equals(sb.toString())) return true;
        return false;
    }
}