class Solution {
    char[] parent;
    public char find(char ch){
        if(parent[ch-'a'] == ch)
            return ch;
        return find(parent[ch-'a']);
    }
    public void union(char a, char b){
        char pa = find(a);
        char pb = find(b);
        if(pa != pb)
            parent[pa-'a'] = pb;
    }
    public boolean equationsPossible(String[] equations) {
        parent = new char[26];
        for(char i = 'a';i<='z';i++){
            parent[i-'a'] = i;
        }
    
        for(String eq : equations){
            if(eq.substring(1, 3).equals("==")){
                union(eq.charAt(0), eq.charAt(3));
            }
        }
        
        for(String eq : equations){
            if(eq.substring(1, 3).equals("!=")){
                if(find(eq.charAt(0)) == find(eq.charAt(3)))
                    return false;
            }
        }
        return true;
    }
}