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
    int i=0;
    ListNode newHead;
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k==0)
            return head;
        ListNode first = head;
        int n=0;
        while(first != null) {
            first = first.next;
            n++;
        }
        first = head;
        k = k%n;
        while(k-->0)
            first = first.next;
        ListNode second = head;
        while(first.next != null){
            first = first.next;
            second = second.next;
        }
        first.next = head;
        head = second.next;
        second.next = null;
        return head;
    }
    
    public ListNode recur(ListNode head, int k){
        if(head == null || head.next == null || k==0)
            return head;
        newHead = null;
        i=0;
        util(head, head, k, 1);
        return newHead;        
    }
    
    public int util(ListNode head, ListNode tempHead, int k, int n){
        if(tempHead.next == null){
            if(k%n ==0){
                newHead = head;
                return 0;            
            }

            tempHead.next = head;

            return k % (n);
        }  
        k = util(head, tempHead.next, k, n+1);
        i++;
        if(newHead != null)
            return k;
        if(i==k){
            newHead = tempHead.next;
            tempHead.next = null;
        }
        return k;
    }
    
}