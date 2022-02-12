class TrieNode{
    Map<Character, TrieNode> children;
    boolean isEnd;
    public TrieNode(){
        this.children = new HashMap<>();
        this.isEnd = false;
        
    }
}
class Trie{
    TrieNode root;
    public Trie(){
        this.root = new TrieNode();
    }
    
    public void insert(String word){
        TrieNode ws = root;
        for(int i=0;i<word.length();i++){
            if(!ws.children.containsKey(word.charAt(i))){
                ws.children.put(word.charAt(i), new TrieNode());
            }
            ws = ws.children.get(word.charAt(i));  
        }
        ws.isEnd = true;
    }
    
    public boolean search(String word){
        TrieNode ws = root;
        for(int i=0;i<word.length();i++){
            if(!ws.children.containsKey(word.charAt(i)) && Character.isUpperCase(word.charAt(i))) return false;
            if(ws.children.containsKey(word.charAt(i)))
                ws = ws.children.get(word.charAt(i));  
        }
        if(ws.isEnd)
            return true;
        return false;
    }    
}

class Solution {
    public List<Boolean> camelMatch(String[] queries, String p) {
        Trie trie = new Trie();
        trie.insert(p);
        List<Boolean> res = new ArrayList<>();
        for(String word : queries){
            res.add(trie.search(word));
        }
        return res;
    }
    
    
    public List<Boolean> traversal(String[] queries, String p){
        List<Boolean> res = new ArrayList<>();
    
        for(String str : queries){
            int i=0, j=0;
            while(i< str.length()){
                if(j< p.length() && p.charAt(j)==str.charAt(i)){
                    i++;
                    j++;
                }
                else if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                    break;
                }
                else
                    i++;
                    
            }
            if(i==str.length() && j==p.length())
                res.add(true);
            else res.add(false);
                
        }
        return res;
                
    }
}