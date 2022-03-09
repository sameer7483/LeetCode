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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        
        if(head.val == head.next.val){
            int val = head.val;
            while(head != null && head.val == val) head = head.next;
            head = deleteDuplicates(head);
        }
        else{
            head.next = deleteDuplicates(head.next);
        }
        return head;
        
    }
}