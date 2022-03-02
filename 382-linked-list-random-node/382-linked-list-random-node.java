/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    Map<Integer, ListNode> m;
    int n;
    public Solution(ListNode head) {
        m = new HashMap<>();
        n=0;
        ListNode temp = head;
        while(temp != null){
            m.put(n, temp);
            n++;
            temp = temp.next;
        }
    }
    
    public int getRandom() {
        Random rand = new Random();
        int r = rand.nextInt(n);
        return m.get(r).val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */