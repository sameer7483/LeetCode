class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i=0, j=0;
        while(i < word1.length || j < word2.length){
            if(i < word1.length  )
                sb1.append(word1[i]);
            if(j < word2.length)
                sb2.append(word2[i]);
            i++;
            j++;
        }
        return sb1.toString().equals(sb2.toString());
    }
}