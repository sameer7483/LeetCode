class Solution {
    Map<Character, String> m;
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty())
            return new ArrayList<>();
        m = new HashMap<>();
        m.put('2',"abc");
        m.put('3',"def");
        m.put('4',"ghi");
        m.put('5',"jkl");
        m.put('6',"mno");
        m.put('7',"pqrs");
        m.put('8',"tuv");
        m.put('9',"wxyz");
        List<String> res = new ArrayList<>();
        util(digits, 0, "", res);
        return res;
    }
    
    public void util(String digits, int curr, String path, List<String> res){
        if(curr == digits.length()){
            res.add(path);
            return;
        }
        for(int i=0;i<m.get(digits.charAt(curr)).length(); i++){
            util(digits, curr+1, path+m.get(digits.charAt(curr)).charAt(i), res);
        }
    }
}