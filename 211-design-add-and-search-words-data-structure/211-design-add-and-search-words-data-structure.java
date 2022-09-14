class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    public TrieNode(){
        children = new TrieNode[26];
    }
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode ws = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(ws.children[c-'a']== null){
                ws.children[c-'a'] = new TrieNode();
            }
            ws = ws.children[c-'a'];
        }
        ws.isEnd = true;
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    
    public boolean dfs(String word, int start, TrieNode root){
        if(root == null)
            return false;
        if(start == word.length())
            return root.isEnd;
        if(word.charAt(start) == '.'){
            for(int i=0;i<26;i++){
                if(dfs(word, start+1, root.children[i]))
                    return true;
            }
        }
        else{
            if(root.children[word.charAt(start)-'a'] != null)
                return dfs(word, start+1, root.children[word.charAt(start)-'a']);
                
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */