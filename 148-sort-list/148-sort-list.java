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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode rest = sortList(head.next);
        head.next = null;
        ListNode temp = rest;
        ListNode prev = null;
        while(temp != null && temp.val < head.val){
            prev = temp;
            temp = temp.next;
        }
        if(prev == null){
            head.next = temp;
            return head;
        }
        else{
            head.next = prev.next;
            prev.next = head;
        }
        return rest;
            
    }
}