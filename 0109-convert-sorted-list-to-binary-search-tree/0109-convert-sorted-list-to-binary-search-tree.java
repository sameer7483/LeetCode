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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return util(head);
    }
    
    public TreeNode util(ListNode head){
        if(head == null)
            return null;
        ListNode temp = head;
        int n = 0;
        while(temp != null){
            temp = temp.next;
            n++;
        }
        if(n == 1)
            return new TreeNode(head.val);
        int mid = n/2;
        ListNode prev = null;
        temp = head;
        while(mid-- > 0){
            prev = temp;
            temp = temp.next;
        }
        if(prev.next != null)
            prev.next = null;
        TreeNode root = new TreeNode(temp.val);
        root.left = util(head);
        root.right = util(temp.next);
        return root;
        
    }
}