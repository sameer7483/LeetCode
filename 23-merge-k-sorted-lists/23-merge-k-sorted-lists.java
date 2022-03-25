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
        PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>((a,b)-> a.getKey()-b.getKey());
        for(int i=0;i<k;i++){
            if(lists[i] != null){
                q.add(new Pair(lists[i].val, i));
                lists[i] = lists[i].next;
            }     
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(!q.isEmpty()){
            Pair<Integer,Integer> p = q.poll();
            temp.next = new ListNode(p.getKey());
            temp = temp.next;
            if(lists[p.getValue()] != null){
                q.add(new Pair(lists[p.getValue()].val, p.getValue()));
                lists[p.getValue()] = lists[p.getValue()].next;
            }
        }
        return dummy.next;
    }
}