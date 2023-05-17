class Solution {
    public int pairSum(ListNode head) {
        List<Integer> f= new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        util(head, f, b);
        int n = f.size();
        int max = 0;
        for(int i=0;i<n/2;i++){
            max = Math.max(max, f.get(i)+b.get(i));
        }
        return max;
    }
    
    public void util(ListNode head, List<Integer> f, List<Integer> b){
        if(head == null)
            return;
        f.add(head.val);
        util(head.next, f, b);
        b.add(head.val);
    }
    
    
}