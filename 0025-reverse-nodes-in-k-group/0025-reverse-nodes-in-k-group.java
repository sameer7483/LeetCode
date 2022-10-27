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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        int i=0;
        ListNode temp = head;
        while(temp != null && i < k-1){
            temp = temp.next;
            i++;
        }
        if(temp == null)
            return head;
        ListNode nextHead = reverseKGroup(temp.next, k);
        temp.next = null;
        ListNode h = head;
        ListNode newHead = reverse(head);
        h.next = nextHead;
        return newHead;
        
    }
    
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode next = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }
}