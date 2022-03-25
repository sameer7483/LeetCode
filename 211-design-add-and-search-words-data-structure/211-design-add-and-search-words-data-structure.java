class TrieNode{
    TrieNode children[];
    boolean isEnd;
    public TrieNode(){
        children = new TrieNode[26];
        isEnd = false;
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
            if(ws.children[word.charAt(i)-'a'] == null)
                ws.children[word.charAt(i)-'a'] = new TrieNode();
            ws = ws.children[word.charAt(i)-'a'];
        }
        ws.isEnd = true;
    }
    
    public boolean search(String word) {
       return searchUtil(word, 0, root);
            
    }
    public boolean searchUtil(String word,int start, TrieNode r){
        if(r == null)
            return false;
        if(start == word.length() && r.isEnd)
            return true;
        if(start == word.length())
            return false;

        if(word.charAt(start) != '.'){
            return searchUtil(word, start+1, r.children[word.charAt(start)-'a']);
        }
        else{
            for(int i=0;i<26;i++){
                if(searchUtil(word, start+1, r.children[i])){
                    return true;
                }
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */