class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    
    public TrieNode(){
        this.children = new TrieNode[26];
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
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word : words)
            trie.insert(word);
        int m = board.length;
        int n = board[0].length;
        List<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dfs(board, i, j,trie.root, visited,"", res);
            }
        }
        return res;
    }
    
    public void dfs(char[][] board, int x, int y, TrieNode root, boolean[][] visited,String word, List<String> res){
        int m = board.length;
        int n = board[0].length;
        if(x < 0 || x >= m || y < 0 || y>=n || root.children[board[x][y]-'a'] == null)
            return;
        if(visited[x][y]) return;
        visited[x][y] = true;
        word += board[x][y];
        TrieNode next = root.children[board[x][y]-'a'];
        if(next.isEnd){
            res.add(word);
            next.isEnd = false;
        }
            
        dfs(board, x+1, y, next, visited, word, res);
        dfs(board, x-1, y, next, visited, word, res);
        dfs(board, x, y+1, next, visited, word, res);
        dfs(board, x, y-1, next, visited, word, res);
        visited[x][y] = false;
    }
    
    public List<String> backtrackingSoln(char[][] board, String[] words){
        Map<Character,List<Pair<Integer, Integer>>> map = new HashMap<>();
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                List<Pair<Integer, Integer>> l = map.getOrDefault(board[i][j], new ArrayList<>());
                l.add(new Pair(i, j));
                map.put(board[i][j], l);
            }
        }
        List<String> res = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            if(map.containsKey(words[i].charAt(0))){
                List<Pair<Integer, Integer>> l  = map.get(words[i].charAt(0));
                for(int j=0;j<l.size();j++){
                    if(util(board, l.get(j).getKey(), l.get(j).getValue(), 0, words[i], new boolean[m][n])){
                        res.add(words[i]);
                        break;
                    }
                        
                }
                
            }
        }
        return res;        
    }
    
    public boolean util(char[][] board, int x, int y, int start, String word, boolean[][] visited){
        if(start == word.length())
            return true;        
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length)
            return false;
        if(visited[x][y])
            return false;
        visited[x][y] = true;
        if(word.charAt(start) == board[x][y]){
           boolean up =  util(board, x-1, y, start+1, word, visited);
           boolean down = util(board, x+1, y, start+1, word, visited);
           boolean right = util(board, x, y+1, start+1, word, visited);
           boolean left = util(board, x, y-1, start+1, word, visited);  
            visited[x][y] = false;
            return up || down|| right|| left;
        }
        visited[x][y] = false;
        return false; 
    }
}