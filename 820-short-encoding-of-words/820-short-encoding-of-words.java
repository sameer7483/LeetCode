class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    public TrieNode(){
        this.children = new TrieNode[26];
        this.isEnd = false;
    }
}

class Trie{
    TrieNode root;
    public Trie(){
        this.root  = new TrieNode();
    }
    
    public void insert(String word){
        int n = word.length();
        TrieNode ws = root;
        for(int i=n-1;i>=0;i--){
            if(ws.children[word.charAt(i)-'a'] == null){
                ws.children[word.charAt(i)-'a'] = new TrieNode();
            }
            ws = ws.children[word.charAt(i)-'a'];
        }
        ws.isEnd = true;
    }
    
}

class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> s = new HashSet<>(Arrays.asList(words));
        for(String w : words){
           for(int i=1;i<w.length();i++){
               s.remove(w.substring(i));
           } 
        }
        int ans = 0;
        for(String w : s){
            ans += 1+w.length();
        }
        return ans;
        
    }
    
    public int TrieSolution(String[] words){
        Trie trie = new Trie();
        for(String w : words)
            trie.insert(w);
        int ans =0;
        for(int i=0;i<26;i++){
            if(trie.root.children[i] != null) ans += 1;
        }
        return ans+depth(trie.root);        
    }
    
    public int depth(TrieNode root){
        if(root == null)
            return 0;
        int d=0;
        for(int i=0;i<26;i++){
            if(root.children[i] != null){
                d += 1+depth(root.children[i]);
            }
            
        }
        return d;
    }
}