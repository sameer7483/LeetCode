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
    Random rand;
    ListNode head;
    public Solution(ListNode h) {
        rand = new Random();
        head = h;
    }
    
    public int getRandom() {
        int res = head.val;
        ListNode temp = head;
        for(int i=1;temp.next != null ; i++){
            temp = temp.next;
            if(rand.nextInt(i+1) == i)
                res = temp.val;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */