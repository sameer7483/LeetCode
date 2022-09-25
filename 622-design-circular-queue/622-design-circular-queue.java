class MyCircularQueue {
    int[] queue;
    int cap;
    int front;
    int rear;
    int len;
    public MyCircularQueue(int k) {
        queue = new int[k];
        front = 0;
        rear = -1;
        len = 0;
        cap = k;
    }
    
    public boolean enQueue(int value) {
        if(isFull())
            return false;
        rear = (rear+1)%cap;
        queue[rear] = value;
        len++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty())
            return false;
        front = (front+1)%cap;
        len--;
        return true;
        
    }
    
    public int Front() {
        if(isEmpty())
            return -1;
        return queue[front];
    }
    
    public int Rear() {
        if(isEmpty())
            return -1;
        return queue[rear];
    }
    
    public boolean isEmpty() {
        return len == 0;
    }
    
    public boolean isFull() {
        return len == cap;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */