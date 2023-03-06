class Solution {
    public int findKthPositive(int[] arr, int k) {
        Set<Integer> s = new HashSet<>();
        for(int a : arr)
            s.add(a);
        int idx = 0;
        int curr = 1;
        while(true){
            if(!s.contains(curr))
                idx++;
            if(idx == k)
                break;
            curr++;
        }
        return curr;
    }
}