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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null && n==1)
            return null;
        ListNode temp = head;
        while(n-- > 0)
            temp = temp.next;
        if(temp == null)
            return head.next;
        ListNode temp2 = head;
        while(temp != null && temp.next != null){
            temp = temp.next;
            temp2 = temp2.next;
        }
        temp2.next = temp2.next.next;
        return head;
        
    }
}