public class Solution {
    int count = 0;
    
    public int countArrangement(int N) {
        helper(N, 1, new HashSet<>());
        return count;
    }
    
    private void helper(int N, int pos, Set<Integer> used) {
        if (pos > N) {
            count++;
            return;
        }
        
        for (int i = 1; i <= N; i++) {
            if (!used.contains(i) && (i % pos == 0 || pos % i == 0)) {
                used.add(i);
                helper(N, pos + 1, used);
                used.remove(i);
            }
        }
    }
}