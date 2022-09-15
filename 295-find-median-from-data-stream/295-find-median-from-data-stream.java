class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    boolean even;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b)-> b-a);
        minHeap = new PriorityQueue<>();
        even = true;
    }
    
    
    public void addNum(int num) {
        if(even){
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
            
        }
        else{
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
        
        even = !even;
    }
    
    public double findMedian() {
        if(!even)
            return maxHeap.peek();
        else
            return (double)(minHeap.peek() + maxHeap.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */