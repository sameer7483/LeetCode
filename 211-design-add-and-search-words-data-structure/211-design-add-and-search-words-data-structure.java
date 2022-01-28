class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    public TrieNode(){
        children = new TrieNode[26];
    }
}

class Trie{
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    
    public void insert(String word){
        TrieNode ws = root;
        for(int i=0;i<word.length();i++){
            if(ws.children[word.charAt(i)-'a'] == null){
                ws.children[word.charAt(i)-'a'] = new TrieNode();
            }
            ws = ws.children[word.charAt(i)-'a']; 
        }
        ws.isEnd = true;
    }
    
    public boolean search(String word){
        TrieNode ws = root;
        return util(ws, word);
              
    }
    public boolean util(TrieNode ws, String word){
        if(ws == null)
            return false;
        if(ws.isEnd && (word == null || word.isEmpty()))
            return true;
        if(word.isEmpty())
            return false;
        if(word.charAt(0) != '.'){
            if(ws.children[word.charAt(0)-'a'] == null)
                return false;
            return util(ws.children[word.charAt(0)-'a'], word.substring(1));
        }
        else{
            boolean flag = false;
            for(int i=0;i<26;i++){
                if(ws.children[i] != null){
                    flag = flag || util(ws.children[i], word.substring(1));
                }
                if(flag) return true;
            }
            return false;
        }
    }
}


class WordDictionary {
    Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }
    
    public void addWord(String word) {
        trie.insert(word);
    }
    
    public boolean search(String word) {
        return trie.search(word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */