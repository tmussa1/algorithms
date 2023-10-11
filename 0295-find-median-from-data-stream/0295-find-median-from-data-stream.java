class MedianFinder {
    
    int count = 0;
    
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<Integer>((a, b) -> a - b);
        this.maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        
        if(minHeap.isEmpty() || num >= minHeap.peek()){
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }
        
        while(!minHeap.isEmpty() && minHeap.size() > maxHeap.size() + 1){
            maxHeap.offer(minHeap.poll());
        }
        
        while(!maxHeap.isEmpty() && maxHeap.size() > minHeap.size()){
            minHeap.offer(maxHeap.poll());
        }
        
        count++;
    }
    
    public double findMedian() {
        if(count % 2 == 1){
            return minHeap.peek() * 1.0;
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */