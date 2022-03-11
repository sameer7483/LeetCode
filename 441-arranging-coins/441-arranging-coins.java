class Solution {
    public int arrangeCoins(int n) {
        return ((int)Math.sqrt(8*(long)n+1L) - 1)/2;
    }
}