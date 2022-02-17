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
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = sortList(slow.next);
        slow.next = null;
        ListNode first = sortList(head);
        return merge(first, second);
            
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null)
            return l2;
        if(l2== null)
            return l1;
        ListNode res = new ListNode(0);
        ListNode l = res;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                l.next = l1;
                l = l.next;
                l1 = l1.next;
            }
            else{
                l.next = l2;
                l= l.next;
                l2 = l2.next;
            }
        }
        while(l1 != null){
            l.next = l1;
            l = l.next;
            l1 = l1.next;
        }
        while(l2 != null){
            l.next = l2;
            l = l.next;
            l2 = l2.next;
        }  
        return res.next;
    }
}