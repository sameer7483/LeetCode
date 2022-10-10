class ListNode{
    int key;
    int val;
    ListNode next;
    ListNode prev;
    public ListNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int cap;
    ListNode head;
    ListNode tail;
    Map<Integer, ListNode> m;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        m = new HashMap<>();
    }
    
    public int get(int key) {
        if(!m.containsKey(key))
            return -1;
        ListNode node = m.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;  
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
        return node.val;
    }
    
    public void put(int key, int value) {
        ListNode node = null;
        if(m.containsKey(key)){
            node = m.get(key);
            node.val = value;
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        else{
            node = new ListNode(key, value);
            m.put(key, node);
        }
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
        if(m.size() > cap){
            m.remove(tail.prev.key);
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
            
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */