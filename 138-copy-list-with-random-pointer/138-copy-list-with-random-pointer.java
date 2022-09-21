/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> m = new HashMap<>();
        if(head == null)
            return head;
        Node temp = head;
        Node newHead;
        while(temp != null){
            Node newNode = new Node(temp.val);
            m.put(temp, newNode);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            Node currNew = m.get(temp);
            currNew.next = m.getOrDefault(temp.next, null);
            currNew.random = m.getOrDefault(temp.random, null);
            temp = temp.next;
        }
        return m.get(head);
    }
}