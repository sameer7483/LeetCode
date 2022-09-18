class ListNode{
    int val;
    int min;
    ListNode next;
    public ListNode(int val, int min, ListNode next){
        this.val = val;
        this.min = min;
        this.next = next;
    }
}
class MinStack {
    ListNode head;
    public MinStack() {
        head = new ListNode(Integer.MAX_VALUE, Integer.MAX_VALUE, null);
    }
    
    public void push(int val) {
        head = new ListNode(val, Math.min(head.min, val), head);
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */