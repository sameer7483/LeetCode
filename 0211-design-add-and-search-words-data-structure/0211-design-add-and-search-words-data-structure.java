class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    public TrieNode(){
        this.children = new TrieNode[26];
        this.isEnd = false;
    }
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode wb = root;
        for(int i=0;i<word.length();i++){
            if(wb.children[word.charAt(i)-'a'] == null){
                wb.children[word.charAt(i)-'a'] = new TrieNode();
            }
            wb = wb.children[word.charAt(i)-'a'];
        }
        wb.isEnd = true;
    }
    
    public boolean search(String word) {
        return util(word, 0, root);
    }
    
    public boolean util(String word, int idx, TrieNode curr){
        if(idx >= word.length())
            return curr.isEnd;
        if(word.charAt(idx) == '.'){
            boolean res = false;
            for(int i=0;i<26;i++){
                if(curr.children[i] != null)
                    res = res || util(word, idx+1, curr.children[i]);
            }
            return res;
        }
        else{
            if(curr.children[word.charAt(idx)-'a'] == null)
                return false;
            return util(word, idx+1, curr.children[word.charAt(idx)-'a']);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */