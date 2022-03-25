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
        if(head == null)
            return null;
        int i=0;
        ListNode temp = head;
        while(i < n){
            temp = temp.next;
            i++;
        }
        ListNode temp2 = head;
        while(temp != null && temp.next != null){
            temp = temp.next;
            temp2 = temp2.next;
        }
        if(temp2 == head && temp == null){
            return head.next;
        }
        temp2.next = temp2.next.next;
        return head;
        
    }
}