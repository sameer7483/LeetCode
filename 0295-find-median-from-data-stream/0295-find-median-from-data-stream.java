class MedianFinder {
    PriorityQueue<Integer> minH;
    PriorityQueue<Integer> maxH;
    boolean isEven;
    public MedianFinder() {
        minH = new PriorityQueue<>();
        maxH = new PriorityQueue<>((a, b)->b-a);
        isEven = true;
    }
    
    public void addNum(int num) {
        if(isEven){
            minH.add(num);
            maxH.add(minH.poll());
            
        }
        else{
            maxH.add(num);
            minH.add(maxH.poll());
        }
        isEven = !isEven;
        
    }
    
    public double findMedian() {
        if(isEven){
            return (minH.peek()+maxH.peek())/2.0;
        }
        else{
            return (double)maxH.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */