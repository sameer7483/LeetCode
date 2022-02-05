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
class Pair{
    ListNode l;
    int idx;
    public Pair(int idx, ListNode l){
        this.idx = idx;
        this.l = l;
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b)->a.l.val-b.l.val);
        int k = lists.length;
        for(int i=0;i<k;i++){
            if(lists[i] != null){
                q.add(new Pair(i, lists[i]));
                lists[i] = lists[i].next;
            }
        }
        ListNode head = null;
        ListNode temp = new ListNode(-1);
        while(!q.isEmpty()){
            Pair p = q.poll();
            if(lists[p.idx] != null){
                q.add(new Pair(p.idx, lists[p.idx]));
                lists[p.idx] = lists[p.idx].next;
            }
            p.l.next = null;
            if(head == null){
                head = p.l;
            }
            temp.next = p.l;
            temp = temp.next;
            
        }
        return head;
    }
}