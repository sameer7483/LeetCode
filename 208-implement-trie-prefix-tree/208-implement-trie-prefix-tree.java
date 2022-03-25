class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    public TrieNode(){
        children = new TrieNode[26];
        isEnd = false;
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
            if(ws.children[word.charAt(i)-'a'] == null){
                ws.children[word.charAt(i)-'a'] = new TrieNode();
            }
            ws = ws.children[word.charAt(i)-'a'];
        }
        ws.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode ws = root;
        for(int i=0;i<word.length();i++){
            if(ws.children[word.charAt(i)-'a'] == null)
                return false;
            ws = ws.children[word.charAt(i)-'a'];
        }
        return ws.isEnd;
    }
    
    public boolean startsWith(String word) {
        TrieNode ws = root;
        for(int i=0;i<word.length();i++){
            if(ws.children[word.charAt(i)-'a'] == null)
                return false;
            ws = ws.children[word.charAt(i)-'a'];
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