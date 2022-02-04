class Solution {
    public boolean arrayStringsAreEqual(String[] w1, String[] w2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i=0;i<w1.length;i++){
            sb1.append(w1[i]);
        }
        for(int i=0;i<w2.length;i++){
            sb2.append(w2[i]);
        }
        if(sb1.toString().equals(sb2.toString()))
            return true;
        return false;
    }
}