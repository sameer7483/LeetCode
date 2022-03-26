class MedianFinder {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;
    boolean even;
    public MedianFinder() {
        max = new PriorityQueue<>((a, b) -> b-a);
        min = new PriorityQueue<>();
        even = true;
    }

    public void addNum(int num) {
        if(even){
            min.add(num);
            max.add(min.poll());
        }
        else{
            max.add(num);
            min.add(max.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if(!even)
            return (double)max.peek();
        else
            return (min.peek() + max.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */