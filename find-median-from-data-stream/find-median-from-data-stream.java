class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;    
    Double median;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();  
    }
    
    public void addNum(int num) {
        if(maxHeap.size() == minHeap.size() && median == null){
            maxHeap.add(num);
            median =(double) maxHeap.peek();
        }
        else if(maxHeap.size() == minHeap.size()){
            if(num > median){
                minHeap.add(num);
                median =(double)  minHeap.peek();
            }
            else{
                maxHeap.add(num);
                median =(double)  maxHeap.peek();
            }
        }
        else if(maxHeap.size() > minHeap.size()){
            if(num >= median){
                minHeap.add(num);
            }
            else{
                int maxTop = maxHeap.poll();
                maxHeap.add(num);
                minHeap.add(maxTop);
            }
            median = (double)(minHeap.peek() + maxHeap.peek())/2.0;
        }
        else{
            if(num > median){
                int minTop = minHeap.poll();
                minHeap.add(num);
                maxHeap.add(minTop);
            }
            else{
                maxHeap.add(num);
            }
            median = (double)(minHeap.peek() + maxHeap.peek())/2.0;
        }
    }
    
    public double findMedian() {
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */