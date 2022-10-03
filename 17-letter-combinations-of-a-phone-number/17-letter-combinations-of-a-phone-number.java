class Solution {
    Map<Character, List<String>> m;
    public List<String> letterCombinations(String digits) {
        m = new HashMap<>();
        m.put('2', Arrays.asList("a", "b", "c"));
        m.put('3', Arrays.asList("d", "e", "f"));
        m.put('4', Arrays.asList("g", "h", "i"));
        m.put('5', Arrays.asList("j", "k", "l"));
        m.put('6', Arrays.asList("m", "n", "o"));
        m.put('7', Arrays.asList("p", "q", "r", "s"));
        m.put('8', Arrays.asList("t", "u", "v"));
        m.put('9', Arrays.asList("w", "x", "y", "z")); 
        List<String> res = new ArrayList<>();
        util(digits, 0, "", res);
        return res;
    }
    
    public void util(String digits, int start,String path, List<String> res){
        if(start == digits.length()){
            if(!path.isEmpty())
                res.add(path);
            return;
        }
        List<String> l = m.get(digits.charAt(start));
        for(int i=0;i<l.size();i++){
            util(digits, start+1, path+l.get(i), res);
        }
    }
}