class TrieNode{
    boolean isEnd;
    TrieNode[] children;
    public TrieNode(){
        children = new TrieNode[26];
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode ws = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ws.children[ch-'a'] == null){
                ws.children[ch-'a'] = new TrieNode();
            }
            ws = ws.children[ch-'a'];
        }
        ws.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode ws = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ws.children[ch-'a'] == null){
                return false;
            }
            ws = ws.children[ch-'a'];
        }
        return ws.isEnd;    
    }
    
    public boolean startsWith(String word) {
        TrieNode ws = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ws.children[ch-'a'] == null){
                return false;
            }
            ws = ws.children[ch-'a'];
        }
        return true;       
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */