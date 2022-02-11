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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode nH = new ListNode(0);
        ListNode temp = nH;
        int sum = 0;
        while(l1 != null || l2 != null){
            
            if(l1 != null){
                sum += l1.val;
                l1= l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            
            temp.next = new ListNode(sum%10);
            temp = temp.next;
            sum = sum/10;
        }
        if(sum >=1)
            temp.next = new ListNode(sum);
        return nH.next;        
//        return util(l1, l2, 0);
        
    }
    
    public ListNode util(ListNode l1, ListNode l2, int rem){
        if(l1 == null && rem == 0)
            return l2;
        if(l2 == null && rem == 0)
            return l1;
        if(l1 == null && l2 == null && rem ==1){
            return new ListNode(1);
        }
        if(l1 == null && rem == 1){
            int temp = l2.val;
            l2.val = (temp+rem)%10;
            rem = (temp+rem)/10;
            l2.next = util(l1, l2.next, rem);
            return l2;
        }
        
        if(l2 == null && rem == 1){
            int temp = l1.val;
            l1.val = (temp+rem)%10;
            rem = (temp+rem)/10;
            l1.next = util(l1.next, l2, rem);
            return l1;
        }        
        ListNode head = new ListNode();
        head.val = (l1.val + l2.val + rem)%10;
        rem = (l1.val + l2.val + rem)/10;
        head.next = util(l1.next, l2.next, rem);
        return head;
    }
}