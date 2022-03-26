class Solution {
    public boolean isAnagram(String s, String t) {
        char[] schar = s.toCharArray();
        Arrays.sort(schar);
        char[] tchar = t.toCharArray();
        Arrays.sort(tchar);
       return  String.valueOf(schar).equals(String.valueOf(tchar));
    }
}