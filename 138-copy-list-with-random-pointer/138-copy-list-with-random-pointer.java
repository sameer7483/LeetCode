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
        if(head == null) return null;
        Map<Node, Integer> orig = new HashMap<>();
        Map<Integer, Node> cpy = new HashMap<>();
        Node dummy = new Node(-1);
        Node newTemp = dummy;
        Node temp = head;
        int idx = 0;
        while(temp != null){
            orig.put(temp, idx);
            newTemp.next = new Node(temp.val);
            newTemp=newTemp.next;
            cpy.put(idx, newTemp);
            temp = temp.next;
            idx++;
        }
        temp = head;
        newTemp = dummy.next;
        while(temp != null){
            if(temp.random != null && orig.containsKey(temp.random)){
                int index = orig.get(temp.random);
                newTemp.random = cpy.get(index);
            }
            temp = temp.next;
            newTemp = newTemp.next;
        }
        return dummy.next;
        
    }
}