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
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b)-> a.val - b.val);
        for(int i=0;i<k;i++){
            if(lists[i] != null)
                q.add(lists[i]);
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(!q.isEmpty()){
            ListNode curr = q.poll();
            temp.next = curr;
            temp = curr;
            if(curr.next != null){
                q.add(curr.next);
            }
        }
        return dummy.next;
    }
}